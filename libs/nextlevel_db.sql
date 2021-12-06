CREATE DATABASE nextlevel_db;
USE nextlevel_db;

CREATE TABLE Cliente(
    Id_Cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Nome_Cliente VARCHAR(100),
    Email VARCHAR(100),
    Cpf_Cliente VARCHAR(14),
    Telefone_Cliente VARCHAR(16)
);

CREATE TABLE Endereco(
    Id_Endereco INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Rua VARCHAR(255),
    Numero INT,
    Complemento VARCHAR(200),
    Bairro VARCHAR(100),
    Cidade VARCHAR(100),
    UF VARCHAR(2),
    CEP VARCHAR(10),
    Id_Cliente int,
    FOREIGN KEY(Id_Cliente) REFERENCES Cliente(Id_Cliente)
);

ALTER TABLE Endereco
    ADD CONSTRAINT Id_Cliente
        FOREIGN KEY (Id_Cliente) 
        REFERENCES Cliente(Id_Cliente)
        ON DELETE CASCADE;