# Projeto TodoList com Spring Boot

![Rocketseat](https://img.shields.io/badge/Curso%20de%20Java-Rocketseat-blue)
![Snarloff](https://img.shields.io/badge/Aluno-Alvesz-white)

![ToDoList](https://github.com/DevAlvesz/ToDoList/blob/main/To-doList%20java%20png.png)

## Visão Geral

Este é um projeto de API para gerenciamento de tarefas (To-Do List) desenvolvido com Java e Spring Boot. Ele permite criar, listar, atualizar e excluir tarefas de maneira simples e eficiente. O banco de dados utilizado é o H2, que roda em memória para facilitar o desenvolvimento e testes.

- Criação, visualização e atualização de tarefas.
- Armazenamento dos dados em um banco de dados H2 em memória.
- Exposição de endpoints RESTful para manipulação de tarefas.

## Tecnologias Utilizadas

- [Spring Boot](https://spring.io/projects/spring-boot): Framework para desenvolvimento de aplicativos Java.
- [Maven](https://maven.apache.org/): Gerenciador de dependências e construção de projetos.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa): Parte do projeto Spring Data que facilita o acesso a bancos de dados relacionais.
- [H2 Database](https://www.h2database.com/): Banco de dados em memória para desenvolvimento e testes.

## Execução do Projeto

Certifique-se de ter o [Java](https://www.oracle.com/java/technologies/javase-downloads.html) e o [Maven](https://maven.apache.org/download.cgi) instalados em sua máquina. Em seguida, siga os passos abaixo:

1. Clone este repositório:

   ```shell
   git clone https://github.com/DevAlvesz/todolist-java.git
   ```

2. Navegue até o diretório do projeto:

   ```shell
   cd nome-do-repositorio
   ```

3. Execute a aplicação com Maven:

   ```shell
   mvn spring-boot:run
   ```

A aplicação estará disponível em `http://localhost:8080`

Para acessar o banco H2, utilize: `http://localhost:8080/h2-console`
- JDBC URL: jdbc:h2:mem:testdb
- Usuário: admin
- Senha: admin

## Exemplos de Endpoints

- Cadastrar usuário
```shell
   POST localhost:8080/users/
   ```
Body
```shell
    {
      "name": "name",
      "username": "username",
      "password": "12345"
    }
   ```

- Criar uma nova tarefa
```shell
   POST localhost:8080/tasks/
   ```
Body
```shell
    {
      "description":"Description",
      "title":"title",
      "priority":"ALTA",
      "startAt":"2025-06-19T12:30:00",
      "endAt":"2025-07-12T16:30:00"
    }
   ```

- Listar tarefas
```shell
   GET localhost:8080/tasks/
   ```

- Atualizar tarefas
```shell
    PUT localhost:8080/tasks/{id}
```
Body
```shell
   {
    "description": "Atualizando tarefa"
   }
```

## Contribuições

Contribuições são bem-vindas! Se você deseja contribuir para este projeto, siga as diretrizes de contribuição e envie um pull request.

## Problemas e Sugestões

Se você encontrar algum problema ou tiver sugestões para melhorar este projeto, por favor, abra uma issue neste repositório.
