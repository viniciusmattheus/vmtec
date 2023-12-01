CREATE DATABASE vmtec;

use vmtec;

CREATE TABLE login(
usuarioID INT PRIMARY KEY AUTO_INCREMENT,
usuarioNome VARCHAR(45) NOT NULL,
usuarioEmail VARCHAR(35) NOT NULL,
usuarioSenha VARCHAR(10) NOT NULL
);

CREATE TABLE cliente(
clienteID INT PRIMARY KEY AUTO_INCREMENT,
clienteNome VARCHAR(45) NOT NULL,
clienteEmail VARCHAR(35) NOT NULL,
clienteNascimento Date NOT NULL,
clienteCPF VARCHAR(14) NOT NULL,
clienteCelular VARCHAR(11) NOT NULL
);

CREATE TABLE produto(
produtoID INT PRIMARY KEY AUTO_INCREMENT,
produtoNome VARCHAR(45) NOT NULL,
produtoPreco FLOAT NOT NULL,
produtoQtdEstoque INT NOT NULL
);

CREATE TABLE venda(
vendaID INT PRIMARY KEY AUTO_INCREMENT,
vendaData Date NOT NULL,
vendaTotal FLOAT NOT NULL,
cliente_clienteID INT NOT NULL,
FOREIGN KEY (cliente_clienteID) REFERENCES cliente(clienteID)
);

ALTER TABLE venda
ADD COLUMN
produto_produtoID INT NOT NULL,
ADD
FOREIGN KEY (produto_produtoID) REFERENCES produto(produtoID);


CREATE TABLE compra(
compraID INT PRIMARY KEY AUTO_INCREMENT,
compraProduto VARCHAR(45) NOT NULL,
compraQtd INT NOT NULL,
compraFornecedor VARCHAR(35) NOT NULL,
compraDate Date NOT NULL,
compraValorProduto FLOAT NOT NULL,
produto_produtoID INT NOT NULL,
FOREIGN KEY (produto_produtoID) REFERENCES produto(produtoID)
);

SELECT *
FROM produto;

INSERT INTO produto(produtoNome, produtoTipo, produtoPreco, produtoQtdEstoque)
VALUES('Monitor Gamer AooOC Hero 27', 'carro', 1.11, 0);

INSERT INTO cliente(clienteNome, clienteEmail, clienteNascimento, clienteCPF, clienteCelular)
VALUES('Maria', 'maria@gmail.com', '2005-07-20', '7896542583','11984849355');

INSERT compra(compraProduto, compraQtd, compraFornecedor, compraDate, compraValorProduto, produto_ProdutoID)
VALUES('Monitor Gamer AOC Hero 27', 2, 'AOC', '2023-10-11', 1.850, 1);

INSERT venda(vendaData, vendaTotal, cliente_clienteID, produto_produtoID)
VALUES('2023-12-11', 1.049, 2, 1);

SELECT c.clienteNome as 'Nome',
	   c.clienteCelular as 'Celular',
       p.produtoNome as 'Produto Comprado',
       v.vendaData as 'Data da Compra',
       v.vendaTotal as 'Total da Compra'
FROM cliente c
INNER JOIN venda v ON c.clienteID = v.cliente_clienteID
INNER JOIN produto p ON v.produto_produtoID = p.produtoID
WHERE vendaID = 4;

UPDATE produto SET produtoNome = 'AOC Hero 27' WHERE produtoID = 1;

ALTER TABLE usuario RENAME login;

select *
from venda;

DELETE FROM login WHERE usuarioID = 2