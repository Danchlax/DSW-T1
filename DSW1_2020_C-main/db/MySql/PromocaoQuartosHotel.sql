create database PromocaoQuartosHotel;
use PromocaoQuartosHotel;

CREATE TABLE Estado (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    sigla VARCHAR(3) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Cidade (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    estado_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (estado_id)
        REFERENCES Estado (id)
);

CREATE TABLE Site (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    url VARCHAR(256) NOT NULL,
    email VARCHAR(35) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE Hotel (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(256) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    email VARCHAR(35) NOT NULL UNIQUE,
    cidade_id BIGINT NOT NULL,
    FOREIGN KEY (cidade_id)
        REFERENCES Cidade (id),
    PRIMARY KEY (id)
);

CREATE TABLE Promocao (
    id BIGINT NOT NULL AUTO_INCREMENT,
    hotel_id BIGINT NOT NULL,
    site_id BIGINT NOT NULL,
    dataInicial DATE NOT NULL,
    dataFinal DATE NOT NULL,
    valor FLOAT NOT NULL,
    FOREIGN KEY (hotel_id)
        REFERENCES Hotel (id),
    FOREIGN KEY (site_id)
        REFERENCES Site (id),
    PRIMARY KEY (id)
);

CREATE TABLE Usuario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(35) NOT NULL UNIQUE,
    senha VARCHAR(64) NOT NULL,
    papel VARCHAR(10),
    PRIMARY KEY (id)
);
