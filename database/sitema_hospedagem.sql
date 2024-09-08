create database sistema_hospedagem;

use sistema_hospedagem;

create table Cliente (
	codCliente INT AUTO_INCREMENT PRIMARY KEY,
    nomeCliente VARCHAR(255),
    rgCliente VARCHAR(20),
    enderecoCliente VARCHAR(255),
    bairroCliente VARCHAR(100),
    cidadeCliente VARCHAR(100),
    estadoCliente VARCHAR(2),
    CEPCliente VARCHAR(8),
    nascimentoCliente DATE
);

create table Chale (
	codChale INT AUTO_INCREMENT PRIMARY KEY,
    localizacao VARCHAR(255),
    capacidade INT,
    valorAltaEstacao DECIMAL(10, 2),
    valorBaixaEstacao DECIMAL(10, 2)
);

create table Hospedagem (
	codHospedagem INT AUTO_INCREMENT PRIMARY KEY,
    codCliente INT,
    codChale INT,
    dataInicio DATE,
    dataFim DATE,
    qtdPessoas INT,
    desconto DECIMAL(10, 2),
    valorFinal DECIMAL(10, 2),
    FOREIGN KEY (codCliente) REFERENCES Cliente(codCliente),
    FOREIGN KEY (codChale) REFERENCES Chale(codChale)
);

USE sistema_hospedagem;
SELECT * FROM Cliente;
SELECT * FROM Chale;
SELECT * FROM Hospedagem;

ALTER TABLE Cliente DROP COLUMN nascimentoCliente;

ALTER TABLE Cliente MODIFY COLUMN CEPCliente VARCHAR(15);


DESCRIBE Hospedagem;

