CREATE DATABASE bd_empresa;
USE bd_empresa;

CREATE TABLE tb_empregados(
codigo_empregado int primary key auto_increment, 
nome varchar(50), 
fone varchar(50), 
email varchar(50) 
);
select * from tb_empregados;

INSERT INTO tb_empregados(nome, fone, email) VALUES('José', '11223344', 'jose@email.com');
INSERT INTO tb_empregados(nome, fone, email) VALUES('João', '22334455', 'joao@email.com');
INSERT INTO tb_empregados(nome, fone, email) VALUES('Maria', '00117788', 'maria@email.com');
INSERT INTO tb_empregados(nome, fone, email) VALUES('Luis', '12312312', 'luis@email.com');
INSERT INTO tb_empregados(nome, fone, email) VALUES('Marina', '21321321', 'marina@email.com');
INSERT INTO tb_empregados(nome, fone, email) VALUES('Letícia', '32132132', 'leticia@email.com');
INSERT INTO tb_empregados(nome, fone, email) VALUES('Gustavo', '45645645', 'gustavo@email.com');
INSERT INTO tb_empregados(nome, fone, email) VALUES('Mateus', '87987987', 'mateus@email.com');

select * from tb_empregados;

UPDATE tb_empregados SET nome='José da Silva' WHERE codigo_empregado=1;
DELETE FROM tb_empregados WHERE codigo=3;
INSERT INTO tb_empregados(codigo_empregado, nome, fone, email) 
VALUES(3, 'Maria', '00117788', 'maria@email.com');

CREATE TABLE tb_pagamentos( 
codigo_pagto int primary key auto_increment, 
codigo_empregado int, 
valor decimal(10,2)
);
INSERT INTO tb_pagamentos(codigo_empregado,valor) VALUES(1,100);
INSERT INTO tb_pagamentos(codigo_empregado,valor) VALUES(2,200);
INSERT INTO tb_pagamentos(codigo_empregado,valor) VALUES(3,300);
INSERT INTO tb_pagamentos(codigo_empregado,valor) VALUES(3,400);
INSERT INTO tb_pagamentos(codigo_empregado,valor) VALUES(5,500);
INSERT INTO tb_pagamentos(codigo_empregado,valor) VALUES(7,800);
