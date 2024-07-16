# ForumHub API REST com SpringBoot

<div align="center">
  
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

</div>



## Proposta do projeto
Desafio da formação OracleOneNextEducatuib, da plataforma [Alura](https://www.alura.com.br).<br>
OBJETIVO: Desenvolver uma API REST utilizando SpringBoot e MYSQL para simular o back-end de um forum

Mapeamentos necessários:

1 - Login (/"login")
  * `POST: RealizarLogin(email: "email", senha:"senha")`

2 - Topico("/topicos")
  * `POST: criarTopico(TOPICO)`
  * `GET: listarTopicos()`
  * `POST: atualizarTopico(/topicos/{id})`
  * `DELETE: deletarTopico(/topicos/{id})`

3 - Usuarios("/usuarios")
  * `POST: criarAutor(Autor)`
    
4 - Curso("/cursos")
  * `POST: criarCurso(Curso)` 

# Status do projeto
✅Concluido✅
 * Em breve: Melhorias no código e README.md

# Tecnologias
- Linguagem
  - [Java](https://www.oracle.com/br/java/)
    
- FrameWork e bibliotecas:
  - [SpringBoot](https://spring.io/projects/spring-boot)
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
  - [Jackson Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
  - [MYSQL Driver](https://mvnrepository.com/artifact/mysql/mysql-connector-java)
  - [Spring Security](https://spring.io/projects/spring-security)
  - [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
  - [Spring Web](https://mvnrepository.com/artifact/org.springframework/spring-web)
  - [Spring Boot DevTools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
  - [Flyway Migration](https://flywaydb.org)
  - [Validation](https://github.com/spring-guides/gs-validating-form-input)
    
- Banco de dados
  - [MYSQL](https://www.mysql.com) 

- Gerenciador de dependencias
  - [Maven](https://maven.apache.org)
 
- JSON Web Token (JWK)
  - [TokenJWK: Auth0](https://github.com/auth0/java-jwt)   

## Agradecimentos
Agradeço a Oracle. Alura e todos os professores da formação por todo o aprendizado passado e desafios propostos.

## Autor

<div align="center">
<a href="https://www.linkedin.com/in/thiago-antenor/">
<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/99970279?v=4" width="100px;" alt="foto do autor"/>
 <br />
 <sub><b>Thiago Silva Antenor</b></sub></a> <a href="https://www.linkedin.com/in/thiago-antenor/" title="Linkedin"> 🧑🏾‍💻</a>


Feito por Thiago Silva Antenor 👨🏾‍💻 Entre em contato!

[![Linkedin Badge](https://img.shields.io/badge/-Thiago-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/thiago-antenor/)](https://www.linkedin.com/in/thiago-antenor/) 
[![Gmail Badge](https://img.shields.io/badge/-thiagoantenor31@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:thiagoantenor31.com)](mailto:thiagoantenor31.com)
</div>
