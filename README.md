
<kbd width="100">
  <img src="https://upload.wikimedia.org/wikipedia/commons/5/5e/PicPay_Logogrande.png" style="width:100%;"/>
</kbd>

# Spring API

## Descrição
Esta API foi desenvolvida usando Spring Boot e proporciona a funcionalidade de criação de usuários e criação de transações entre eles, consumindo um serviço autorizador de transaões por meio do mock da PicPay. Ela implementa padrões como Repository, Inversão de Dependências, Strategy, princípios SOLID, Clean Archiecteture e usa MySQL containerizado pelo docker para persistência de dados.

## Tecnologias
![Java](https://img.shields.io/badge/java-red.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-green.svg?style=for-the-badge&logo=spring&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-0D1117.svg?style=for-the-badge&logo=mysql&logoColor=white) ![Docker](https://img.shields.io/badge/docker-blue.svg?style=for-the-badge&logo=docker&logoColor=white)

## Requisitos
- Java 17 ou superior
- Maven 3.6 ou superior
- Docker (Responsável pela containerização do MySQL)

## Instalação
Clone o repositório:
```sh
git clone https://github.com/ViniHGV/PicPaySimplified
cd PicPaySimplified
```

## Configuração
### Banco de Dados
A aplicação está configurada para usar MySQL. Certifique-se de ter um banco de dados MySQL rodando e configure as seguintes propriedades no arquivo \`application.properties\`:

```properties
spring.application.name=picpay-simplified  
  
spring.jpa.hibernate.ddl-auto=update  
spring.datasource.url=jdbc:mysql://localhost:3306/picpaysimplified  
spring.datasource.username=admin  
spring.datasource.password=admin  
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver  
spring.jpa.show-sql: true  
  
springdoc.api-docs.path=/api-docs
```

## Execução
Para rodar a aplicação localmente, use o Maven para compilar e executar:

```sh
mvn clean install
mvn spring-boot:run
```

## Porta da aplicação
- A aplicação estará disponível em `http://localhost:8080`
- O Swagger para documentação da aplicação está disponível em `http://localhost:8080/swagger-ui/index.html#/`

## Endpoints

### Usuários
- **Criar Usuário**
  - `POST /users`
  - Request Body:
   ```json
	{
		  "name": "ViniHGV",
		  "identification": "123.542.275-98",
		  "email": "vinihgv@gmail.com",
		  "password": "password@.",
		  "valueInWallet": 1700,
		  "userType": "comum"
	}
   ```
   
  - Response:
  ```json
    {
		  "id": 1,
		  "name": "ViniHGV",
		  "identification": "123.542.275-98",
		  "email": "vinihgv@gmail.com",
		  "password": "password@.",
		  "valueInWallet": 1700,
		  "userType": "comum"
    }
   ```

- **Listar Usuários**
  - `GET /users`
  - Response:
   ```json
	[
	  {
		  "id": 1,
		  "name": "ViniHGV",
		  "identification": "123.542.275-98",
		  "email": "vinihgv@gmail.com",
		  "password": "password@.",
		  "valueInWallet": 1700,
		  "userType": "comum"
	  }
	]
	```
### Transações
- **Criar Transação**
  - `POST /transactions`
  - Request Body:
  ```json
		{
		  "payer": 0,
		  "receiver": 0,
		  "value": 0
		}
  ```
   
  - Response:
  ```json
	 {
		   "id": 0,
		   "payer": {
		      "id": 0,
		      "name": "string",
		      "identification": "string",
		      "email": "string",
		      "password": "string",
		      "valueInWallet": 0,
		      "userType": "comum"
		    },
		    "receiver": {
		      "id": 0,
		      "name": "string",
		      "identification": "string",
		      "email": "string",
		      "password": "string",
		      "valueInWallet": 0,
		      "userType": "comum"
		    },
		    "value": 0,
		    "realizedAt": "2024-07-01T20:22:03.788Z"
	 }
   ```

- **Listar Transações**
  - `GET /transactions`
  - Response:
  ```json
	[
	  {
	    "id": 0,
	    "payer": {
	      "id": 0,
	      "name": "string",
	      "identification": "string",
	      "email": "string",
	      "password": "string",
	      "valueInWallet": 0,
	      "userType": "comum"
	    },
	    "receiver": {
	      "id": 0,
	      "name": "string",
	      "identification": "string",
	      "email": "string",
	      "password": "string",
	      "valueInWallet": 0,
	      "userType": "comum"
	    },
	    "value": 0,
	    "realizedAt": "2024-07-01T20:22:03.788Z"
	  }
	]
  ```


## Docker
Para rodar o banco de dados aplicação usando Docker, utilize o seguinte comando:

```sh
docker-compose up -d
```
## Autor
Desenvolvido por [ViniHGV](https://github.com/ViniHGV)
