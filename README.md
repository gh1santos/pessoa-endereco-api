# Pessoa Endereço API

API REST desenvolvida com **Java e Spring Boot** para gerenciamento de **Pessoas e seus Endereços**, implementando operações completas de **CRUD**.

Este projeto foi desenvolvido como teste técnico para avaliar organização de código, boas práticas de desenvolvimento e uso de tecnologias do ecossistema Spring.

---

# Tecnologias utilizadas

* Java 21+
* Spring Boot
* Spring Data JPA
* H2 Database
* Swagger / OpenAPI
* Maven
* Lombok

---

# Estrutura do Projeto

```
src/main/java
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 └── exception
```

A aplicação segue uma arquitetura em camadas, separando responsabilidades entre **Controller, Service, Repository e DTOs**.

---

# Entidades

## Pessoa

* id
* nome (obrigatório)
* cpf (obrigatório e único)
* email
* dataNascimento
* telefones
* enderecos

## Endereço

* id
* logradouro
* numero
* complemento
* bairro
* cidade
* estado
* cep
* principal

---

# Endpoints da API

## Pessoa

| Método | Endpoint      | Descrição            |
| ------ | ------------- | -------------------- |
| POST   | /pessoas      | Criar pessoa         |
| GET    | /pessoas      | Listar pessoas       |
| GET    | /pessoas/{id} | Buscar pessoa por id |
| PUT    | /pessoas/{id} | Atualizar pessoa     |
| DELETE | /pessoas/{id} | Remover pessoa       |

---

## Endereços

| Método | Endpoint                             | Descrição          |
| ------ | ------------------------------------ | ------------------ |
| POST   | /pessoas/{id}/enderecos              | Adicionar endereço |
| PUT    | /pessoas/{id}/enderecos/{enderecoId} | Atualizar endereço |
| DELETE | /pessoas/{id}/enderecos/{enderecoId} | Remover endereço   |

---

# Como executar o projeto

Clone o repositório:

```
git clone https://github.com/seu-usuario/pessoa-endereco-api.git
```

Entre na pasta do projeto:

```
cd pessoa-endereco-api
```

Execute a aplicação:

```
./mvnw spring-boot:run
```

ou execute a classe:

```
PessoaApiApplication
```

---

# Documentação da API

A documentação da API pode ser acessada via Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

---

# Banco de Dados

O projeto utiliza **H2 Database em memória**.

Console H2 disponível em:

```
http://localhost:8080/h2-console
```

Configuração de acesso:

```
JDBC URL: jdbc:h2:mem:pessoa-db
User: sa
Password:
```

---

# Funcionalidades implementadas

* CRUD completo de Pessoas
* CRUD de Endereços
* Relacionamento Pessoa → Endereços
* CPF único
* Validação de campos obrigatórios
* Documentação da API com Swagger
* Arquitetura em camadas
* Tratamento básico de exceções

---

# Autor

Guilherme Santos
Desenvolvedor em formação focado em backend com Java e Spring Boot.
