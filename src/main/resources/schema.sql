CREATE TABLE USUARIO (
    cpf BIGINT PRIMARY KEY auto_increment,
    nome VARCHAR(128),
    data_nascimento DATE,
    email VARCHAR(128) UNIQUE,
    celular BIGINT,
    endereco VARCHAR(128),
    nome_doutor VARCHAR(128),
    novato BOOL,
    observacao VARCHAR(128),
    senha VARCHAR(256),
    sexo VARCHAR(1),
    ativo BOOL,
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into usuario (cpf, nome, data_nascimento, email, celular, endereco, nome_doutor, novato, observacao, senha, sexo, ativo)
             values (12914972261, 'Vitor Nere', date '1994-11-26', 'email@email.com', 61999999999, 'Quadra 1 Conj 1 Casa 1', 'Creuzinha', false, '', '698dc19d489c4e4db73e28a713eab07b', 'M', true);