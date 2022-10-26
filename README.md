<p align="center">
  <img alt="License" src="https://img.shields.io/badge/License-MIT-ED8B00?style=for-the-badge">
  <img alt="Java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
  <img alt="MySQl" src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white">
</p>

# Sobre a aplicação

Aplicação CRUD de um sistema de ouvidoria desenvolvida em Java, fazendo a implementação de categorias (reclamação, elogio e ideia/sugestão) e armazenando as informações em um banco de dados MySQL em conexão local.

Desenvolvido a fim de ser utilizado como avaliação da disciplina de POO do curso de Sistemas de Informação da Unifacisa.

## Getting Started ▶️

Para rodar a aplicação, clone o repositório com:

```bash
$ git clone https://github.com/darllinsonazvd/unifacisa-poo.git
```

Abra o projeto na sua iDE de preferência (Eclipse é o recomendado)

Se estiver usando o Eclipse, clique com o botão direito na pasta do projeto, navegue até a opção de "Build Path" e clique em "Add external archives..."

Logo após, navegue até a pasta onde o seu MySQL está instalado, abra a pasta Connector J (se não estiver disponível, faça a instalação através [clicando aqui](https://dev.mysql.com/downloads/connector/j/)) e selecione o arquivo com final _.jar_ .

No MySQL Workbench crie uma nova conexão com o user _root_ e o password _root_, depois, crie as tabelas com os seguintes comandos:

```sql
CREATE DATABASE db_ouvidoria;

USE db_ouvidoria;

CREATE TABLE feedbacks (
    id int not null auto_increment primary key,
    type varchar(20) not null,
    author varchar(45) not null,
    feedback varchar(250) not null
);
```

Depois é só rodar o arquivo _Main.java_ .

## Tecnologias 🚀

- Java
- MySQL
