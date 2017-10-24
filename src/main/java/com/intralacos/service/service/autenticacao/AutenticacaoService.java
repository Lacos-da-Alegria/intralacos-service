package com.intralacos.service.service.autenticacao;

import com.intralacos.service.model.usuario.UsuarioLogadoModel;
import com.intralacos.service.model.usuario.UsuarioAutenticacaoModel;
import com.intralacos.service.model.usuario.UsuarioModel;
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

@Service
public class AutenticacaoService {

    @Autowired
    private Usuarios usuarios;

    public UsuarioLogadoModel autenticar(UsuarioAutenticacaoModel usuario) {
        UsuarioModel usuarioModel = this.usuarios.findByEmail(usuario.getEmail());
        UsuarioLogadoModel usuarioLogadoModelLogado = null;

        if(usuarioModel != null) {
            String mdPass = this.getMD5Password(usuario.getSenha());

            if(mdPass != null && mdPass.equals(usuarioModel.getSenha())) {

                String token = this.getUsuarioToken(usuarioModel, Long.valueOf("1200000"));
                usuarioLogadoModelLogado = new UsuarioLogadoModel(usuarioModel, token);
            }
        }

        return usuarioLogadoModelLogado;
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

    private String getUsuarioToken(UsuarioModel usuario, long ttlMillis) {
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(usuario.getEmail() + usuario.getCpf().toString());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // Map<String, Object> headerClaims = new HashMap();
        // headerClaims.put("usuario", usuario);

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(usuario.getEmail().toString())
                .setIssuedAt(now)
                .setSubject(usuario.getEmail())
                .setIssuer("api.intralacos.com")
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
