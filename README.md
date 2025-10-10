# ⚽Cadastro de Times de Futebol⚽

Este é meu primeiro projeto de desenvolvimento de uma API Rest simples, para cadastrar e gerenciar clubes e ligas de futebol, usando um CRUD completo.

## ⚙️Recursos:
- Java 25
- Spring Boot 3.5.6
- Maven
- Spring Web
- Spring Data JPA
- Lombok
- H2 Database
- Bean Validation

## ▶️Para executar: 
Você deve:
- Baixar ou clonar a aplicação
- Executar a classe MainApplication.java </br>

`Lembrando que deve ter ao menos o Java JDK 25 instalado na máquina`

## 🎲Entidades:
Localizadas em scr/main/java/dev/brites/CadastroDeClubes/infrascructure/models
- League:
```
Long id
String name
String country
List<ClubModel> clubs
```
- Club:
```
Long id
String name
Integer titles
String stadium
LeagueModel league
```
`A relação entre as tabelas é de um Club para uma League, e uma League para vários Club`

## 🌐Ajustes do H2 Console e Datasource
Configurações feitas em scr/main/resources/application.properties
```
spring.application.name=ClubsCRUD

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

## 🎯Endpoints
Com auxílio da ferramenta Postman, é possível executar os métodos. </br>
`A base path do projeto varia entre '/club' para clubes, e '/league' para ligas`

- CADASTRAR </br>
[método POST] </br>

Para cada path, é necessário adicionar o endpoint '/single' caso queira cadastras apenas uma entidade, e '/multiple' para adicionar vários de uma vez. </br>
`Lembrando que Club é dependente de League, por isso, é necessário criar liga antes do clube` </br>
Exemplos de corpo JSON:

`POST /league/single`
```
{
  "name" : "Crud League",
  "country" : "Brazil",
}
```
`POST /club/multiple`
```
[
  {
    "name" : "Java FC",
    "titles" : "91",
    "stadium" : "James Gosling Stadium",
    "league" : {
      "id" : "1"
    }
  },
  {
    "name" : "Athletic C",
    "titles" : "72",
    "stadium" : "Arena Dennis Ritchie",
    "league" : {
      "id" : "1"
    }
  }
]
```

- BUSCAR </br>
[método GET] </br>

É possível buscar tanto por ID, quando pelo nome. </br>
Para ID, inserir o endpoint '/id/{id}' substituindo a chaves pelo id que quiser. </br>
Já para nome é necessário só adicionar '/{name}' substituindo a chave pelo nome exato. </br>
Exemplo: </br>

`GET /league/id/1`
```Resposta
{
  "id" : 1
  "name" : "Crud League"
  "country" : "Brazil"
  "clubs" : [
    {
      "name" : "Java FC",
      "titles" : "91",
      "stadium" : "James Gosling Stadium"
    },
    {
      "name" : "Athletic C",
      "titles" : "72",
      "stadium" : "Arena Dennis Ritchie"
    }
  ]
}
```
`GET /club/Java FC`
```
{
  "name" : "Java FC",
  "titles" : "91",
  "stadium" : "James Gosling Stadium",
  "league" : {
    "id" : "1"
  }
}
```

- ATUALIZAR </br>
[método PUT] </br>

É necessário parâmetros, isso pode ser passado na aba "Param" no postman ou inserir o path manualmente: </br>
`Só é possível atualizar uma entidade buscando pelo ID` </br>
Exemplo de corpo JSON: </br>

`PUT /league/?id=1`
```
{
  "country" : "United States"
}
```
Não retorna corpo algum, apenas atualiza a entidade com a resposta 200 OK.

- EXCLUIR </br>
[método DELETE] </br>

Assim como no método de atualizar, para deletar requer um parâmetro, que neste caso é somente 'name'. </br>
Exemplo: </br>

`DELETE /club?name=Athletic C` </br>
Não retorno corpo algum, apena deleta a entidade com a resposta 200 OK.

## ❌Tratamento de exceções
O projeto conta com uma classe de tratamento de exceções global, o GlobalExceptionHandler. </br>
ApiError é uma classe modelo para a amostragem das mensagens de erros. </br>
Por exemplo, caso seja procurado um clube por um ID que nao exista, o corpo JSON retorna com a resposta: 
```
{
  "timestamp": "2025-10-10T12:05:18",
  "status": 404,
  "error": "Not Found",
  "message": "Liga com id 10 não encontrada."
}

```
Além disso, nos controllers existem anotações do Bean Validation (como o `@Valid`) para conferir se o cadastro da entidade é válido. </br>
Concluindo, a API reconhece erros de:
- Recursos não encontrados;
- Campos obrigatórios;
- Erro de validação;
- Parâmetro inválido.

## 🏛️Estrutura do Projeto
```
.CadastroDeClubes
├─ scr/
|   ├─ main/
|   |   ├─ java 
|   |   |    └─ dev
|   |   |        └─ brites  
|   |   |             └─ CadastroDeClubes
|   |   |                  ├─ business
|   |   |                  |   ├─ exceptions
|   |   |                  |   |   ├─ ApiError.java
|   |   |                  |   |   ├─ ClubNotFoundExecption.java
|   |   |                  |   |   ├─ GlobalExceptionHandler.java
|   |   |                  |   |   ├─ LeagueNotFound.java
|   |   |                  |   |   └─ MissingFieldException.java
|   |   |                  |   └─ services
|   |   |                  |       ├─ ClubService.java
|   |   |                  |       └─ LeagueService.java
|   |   |                  ├─ controllers
|   |   |                  |   ├─ ClubController.java
|   |   |                  |   └─ LeagueController.java
|   |   |                  ├─ infrasctructure
|   |   |                  |   ├─ models
|   |   |                  |   |   ├─ ClubModel.java
|   |   |                  |   |   └─ LeagueModel.java
|   |   |                  |   └─ repositories
|   |   |                  |       ├─ ClubRepository.java
|   |   |                  |       └─ LeagueRepository.java
|   |   |                  └─ MainApplication.java
|   |   └─ resources
|   |        └─ application.properties
|   └─ teste
|       └─ java
└─ pom.xml
```

