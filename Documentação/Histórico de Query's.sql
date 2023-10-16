/* QUERY'S BANCO DE DADOS VIDRACARIA */

create table USUARIO (

id int primary key not null auto_increment,
usuario varchar(30) not null,
senha varchar(100) not null

);

create table COR (

id int primary key not null auto_increment,
descricao varchar(10) not null

);

create table KIT (

id int primary key not null auto_increment,
descricao varchar(40) not null

);

create table TIPO (

id int primary key not null auto_increment,
descricao varchar(20) not null

);

create table FERRAGEM(

id int primary key not null auto_increment,
referencia varchar(10) not null,
descricao varchar(40) not null,
valor double not null,
id_cor int not null,

constraint fk_ferragem_n1 foreign key (id_cor) references COR (id)

);

create table ORCAMENTO (

id int primary key not null auto_increment,
margem double not null

);

create table FERRAGEM_KIT (

id int primary key not null auto_increment,
id_ferragem int,
id_kit int not null,

constraint fk_ferragem_kit_n1 foreign key (id_ferragem) references FERRAGEM (id),
constraint fk_ferragem_kit_n2 foreign key (id_kit) references KIT (id)

);

create table PELICULA (

id int primary key not null auto_increment,
descricao varchar(20) not null,
id_tipo int not null,
id_cor int not null,

constraint fk_pelicula_n1 foreign key (id_tipo) references TIPO (id),
constraint fk_pelicula_n2 foreign key (id_cor) references COR (id)

);

create table VIDRO (

id int primary key not null auto_increment,
espessura char(2) not null,
valor_metro_quadrado double not null,
id_tipo int not null,
id_cor int not null,

constraint fk_vidro_n1 foreign key (id_tipo) references TIPO (id),
constraint fk_vidro_n2 foreign key (id_cor) references COR (id)

);

create table PECA (

id int primary key not null auto_increment,
descricao varchar(40) not null,
id_vidro int not null,
id_kit int not null,

constraint fk_peca_n1 foreign key (id_vidro) references VIDRO (id),
constraint fk_peca_n2 foreign key (id_kit) references KIT (id)

);

create table PECA_ORCAMENTO (

id int primary key not null auto_increment,
largura double not null,
altura double not null,
id_orcamento int not null,
id_peca int not null,
id_pelicula int,

constraint fk_peca_orcamento_n1 foreign key (id_orcamento) references ORCAMENTO (id),
constraint fk_peca_orcamento_n2 foreign key (id_peca) references PECA (id),
constraint fk_peca_orcamento_n3 foreign key (id_pelicula) references PELICULA (id)

);