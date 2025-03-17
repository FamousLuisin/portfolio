# Portfolio Project - `CONSTRUÇÃO`

## Descrição do Projeto

Este é um projeto de portfólio pessoal desenvolvido utilizando **Spring Boot**, **Java 21** e **MySQL**. O objetivo principal é criar uma plataforma onde eu possa exibir meus projetos, habilidades e experiências de forma organizada e acessível. O projeto ainda está em construção, mas já conta com sua api.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Java 21**: Versão mais recente do Java, trazendo novas funcionalidades e melhorias de desempenho.
- **MySQL**: Banco de dados relacional para armazenamento de dados.
- **Gradle**: Gerenciador de dependências e build do projeto.

## Funcionalidades Planejadas - Front End

- **Página Inicial**: Apresentação breve sobre mim e links para outras seções.
- **Sobre Mim**: Detalhes sobre minha trajetória profissional, habilidades e interesses.
- **Projetos**: Listagem dos projetos que já desenvolvi, com descrições e links para repositórios ou demos.
- **Skills**: Seção para postagens as tecnologias que domino.
- **Contato**: Formulário para envio de mensagens diretamente para mim.

## Como Executar o Projeto

### Pré-requisitos

- **Java 21**: Certifique-se de ter o JDK 21 instalado.

### Configuração do Banco de Dados

1. Vá na pasta root do projeto.
2. Vá até o aquivo compose e aplica suas configurações.
3. Abra um terminal e execute o comando docker-compose up -d.
4. Configure as credenciais do banco de dados no arquivo `application.properties`.
5. Navegue até a pasta api.
6. Abra o terminal e rode o programa usando o wrapper do gradlew.
7. Em linux `./gradlew run`
8. Em windows `.\gradlew.bat run`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/portfolio_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
