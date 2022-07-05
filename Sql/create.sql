CREATE TABLE IF NOT EXISTS 'Funcionarios'(
'id' int not null auto_increment, 'nome_funcionario' varchar(50) not null,
'cargo' varchar(60) not null,'salario' double not null,
Primary Key('id'));

CREATE TABLE IF NOT EXISTS 'Filiacao'(
'id' int not auto_increment, 'nome_filiação' varchar(50) not null, 
'cnpj' int not null, Primary Key('id'));
                                                    
CREATE TABLE IF NOT EXISTS 'Compras'(
'id' int not null auto_increment, 'nome_cliente' varchar(50) not null,
'cpf' int not null, 'email' varchar(60) not null,
'nacionalidade' varchar(50) not null, 'destino' varchar(50) not null,
Primary Key('id')
);

CREATE TABLE IF NOT EXISTS 'Aeronaves'(
'id' int not null auto_increment, 'nome_Aeronave' varchar(50) not null, 'numero_de_passageiros' int not null, 
'Capacidade_Combustivel' double not null,'nome_filiação' varchar(50) not null, 
Primary Key('id'), FOREIGN KEY('nome_filiação') references Filiacao('nome_filiação'),
FOREIGN KEY ('nome_equipe') references Equipe('nome_equipe'));

CREATE TABLE IF NOT EXISTS 'Destinos'(
'id' int not null auto_increment,'nome_destino' varchar(50) not null,
'descrição' varchar(100) not null, 'valor' double not null
Primary Key('id'));

CREATE TABLE IF NOT EXISTS 'Voos'(
'id' int not null auto_increment, 'horario' int not null,
'nome_Aeronave' varchar(50) not null, 'nome_Destinos' varchar(50) not null,
Primary Key('id'), FOREIGN KEY('nome_Aeronava') references Aeronaves('nome_Aeronaves'),
FOREIGN Key('nome_destino') references Destinos('nome_destino')    
);
