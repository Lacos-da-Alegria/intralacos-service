package com.intralacos.service.autenticacao;

import com.intralacos.service.model.EntUsuario;
import com.intralacos.service.repository.Usuarios;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AutenticacaoService {

    @Autowired
    private Usuarios usuarios;

    public String autenticar(UsuarioAutenticacao usuario) {
        EntUsuario entUsuario = this.usuarios.findByEmail(usuario.getEmail());

        if(entUsuario != null) {
            String mdPass = this.getMD5Password(usuario.getPassword());

            if(mdPass != null && mdPass.equals(entUsuario.getSenha())) {
                Usuario usuarioLogado = new Usuario(entUsuario);
                String token = this.getUsuarioToken(usuarioLogado, Long.valueOf("1200000"));

                return token;
            }
        }

        return "Usuario e/ou senha não encontrado.";
    }


    private String getMD5Password(String password) {
        String pass = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
            pass = hash.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return pass;
    }

    private String getUsuarioToken(Usuario usuario, long ttlMillis) {
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(usuario.getEmail() + usuario.getCpf().toString());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Map<String, Object> headerClaims = new HashMap();
        headerClaims.put("usuario", usuario);

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(usuario.getCpf().toString())
                .setIssuedAt(now)
                .setSubject(usuario.getEmail())
                .setIssuer("api.intralacos.com")
                .setHeader(headerClaims)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }
}
