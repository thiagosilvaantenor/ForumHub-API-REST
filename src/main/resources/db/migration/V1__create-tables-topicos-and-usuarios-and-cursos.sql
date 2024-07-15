create table usuarios(

                        id bigint not null auto_increment,
                        nome varchar(100) not null unique,
                        email varchar(100) not null unique,
                        senha varchar(255) not null,

                        primary key(id)

);

create table cursos(

                        id bigint not null auto_increment,
                        nome varchar(100) not null unique,
                        categoria varchar(100) not null,

                        primary key(id)

);

create table topicos(

                        id bigint not null auto_increment,
                        titulo varchar(100) not null,
                        mensagem varchar(200) not null,
                        dataCriacao dateTime not null ,
                        ativo tinyint not null,
                        curso_id bigint not null,
                        usuario_id bigint not null,

                        primary key(id)
);

ALTER TABLE topicos ADD CONSTRAINT fk_topicos_curso_id foreign key(curso_id) references cursos(id);
ALTER TABLE topicos add constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id);
