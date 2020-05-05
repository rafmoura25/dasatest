# Teste Dasa - Rafael

### Tecnologias e Frameworks/libs utilizados
```bash
JAVA 11

Springboot

Gradle

MySQL

Swagger

Docker-compose
```

### Rodar localmente, utilizando docker

```bash
Para os comandos abaixo, verificar se é necessário utilizado sudo
```

```bash
# Para subir o banco de dados MySQL
$ docker-compose up --build
# Caso seja a primeira execução e criação do volume, execute o compose uma segunda vez.
```

```bash
# Acessar o banco de dados via terminal
$ docker exec -ti mysql_local sh
$ mysql -u root -p
# digitar a senha test
$ show databases;
$ use dasa;
$ show tables;
```