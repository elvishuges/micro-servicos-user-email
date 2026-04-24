# Email Service

Este é um projeto de demonstração de um serviço de email construído com Spring Boot. A aplicação utiliza RabbitMQ para mensageria assíncrona, PostgreSQL como banco de dados e está containerizada com Docker para facilitar o desenvolvimento e deployment.

## Funcionalidades

- **API REST**: Endpoints para gerenciamento de usuários (localizado no subprojeto `email/`).
- **Consumidor de Email**: Processa mensagens de email recebidas via fila RabbitMQ.
- **Persistência**: Utiliza JPA com Hibernate para interagir com PostgreSQL.
- **Validação**: Suporte a validação de dados com Bean Validation.
- **Containerização**: Configurado com Docker e Docker Compose para execução em containers.

## Tecnologias Utilizadas

- **Spring Boot 4.0.3**: Framework principal.
- **Java 21**: Versão do JDK.
- **RabbitMQ**: Para mensageria assíncrona.
- **PostgreSQL**: Banco de dados relacional.
- **Maven**: Gerenciamento de dependências e build.
- **Docker**: Containerização da aplicação.
- **Docker Compose**: Orquestração de serviços (app + banco de dados).

## Pré-requisitos

- Java 21 ou superior
- Maven 3.6+
- Docker e Docker Compose

## Instalação e Execução

### Clonando o Repositório

```bash
git clone <url-do-repositorio>
cd email
```

### Executando com Docker Compose

1. Certifique-se de que o Docker e Docker Compose estão instalados e em execução.

2. Execute o comando para construir e iniciar os serviços:

```bash
docker-compose up --build
```

Isso irá:
- Construir a imagem Docker da aplicação.
- Iniciar o container PostgreSQL.
- Iniciar a aplicação Spring Boot na porta 8082 (configurada em `application.properties`).

### Executando Localmente (Sem Docker)

1. Instale e configure PostgreSQL localmente, criando um banco de dados `ms-email` com usuário `postgres` e senha `postgres`.

2. Configure RabbitMQ localmente ou use o serviço CloudAMQP configurado em `application.properties`.

3. Execute o build do projeto:

```bash
mvn clean install
```

4. Execute a aplicação:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8082`.

## Configuração

As configurações principais estão no arquivo `src/main/resources/application.properties`:

- **Porta do Servidor**: 8082
- **Banco de Dados**: PostgreSQL (localhost ou via Docker)
- **RabbitMQ**: Configurado para usar CloudAMQP (pode ser alterado para local)
- **JPA**: DDL auto-update habilitado

Para ambientes de produção, ajuste as configurações conforme necessário (ex: credenciais de banco, URLs do RabbitMQ).

## Estrutura do Projeto

```
src/
├── main/
│   ├── docker/          # Arquivos Docker adicionais
│   ├── java/
│   │   └── com/ms/email/
│   │       ├── EmailApplication.java    # Classe principal
│   │       ├── configs/                 # Configurações (RabbitMQ)
│   │       ├── consumers/               # Consumidores (EmailConsumer)
│   │       └── dtos/                    # DTOs (EmailRecordDto)
│   └── resources/
│       └── application.properties       # Configurações da aplicação
└── test/
    └── java/
        └── com/ms/email/
            └── EmailApplicationTests.java  # Testes unitários
email/                     # Subprojeto para gerenciamento de usuários
├── src/
│   ├── main/java/com/ms/email/
│   │   ├── controllers/  # Controladores REST (UserController)
│   │   ├── dtos/         # DTOs (UserRecordDto)
│   │   ├── models/       # Modelos (UserModel)
│   │   ├── repositories/ # Repositórios (UserRepository)
│   │   └── services/     # Serviços (UserService)
│   └── resources/
│       └── application.properties
Dockerfile                 # Dockerfile para containerização
docker-compose.yml         # Orquestração Docker
pom.xml                    # Arquivo Maven
```

## Uso

### Enviando Mensagens para a Fila

A aplicação consome mensagens da fila RabbitMQ configurada. Para testar, envie uma mensagem JSON no formato `EmailRecordDto` para a fila `default.name`.

Exemplo de payload:
```json
{
  "emailTo": "exemplo@email.com"
}
```

### API de Usuários

O subprojeto `email/` fornece uma API REST para gerenciamento de usuários. Execute-o separadamente se necessário.

## Testes

Execute os testes com:

```bash
mvn test
```

## Contribuição

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

## Licença

Este projeto é distribuído sob a licença [MIT](LICENSE). Consulte o arquivo LICENSE para mais detalhes.