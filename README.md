# Maria da Penha Backend

Backend do servico desenvolvido para disciplina de sistemas distribuidos 2019.1 CIN-UFPE

## Começando os trabalhos

Ao seguir as instruções abaixo descritas, será possível obter uma cópia desse projeto e rodar os serviços abaixo definidos na sua máquina local.

Veja as notas de deploy sobre como executar o projeto num ambiente de produção.

### Pré-requisitos

Para configuração e execução desse projeto localmente você irá precisar:
 
 - Java IDE (Eclipse, IntelliJ)
 - JAVA 8+
 - Maven 3+
 - Git Client (i.e. Git Bash)
 - MongoDB

### Instalação

#### Baixando Git Bash 

```
Windows: https://gitforwindows.org/
```

#### Clonando repositorio no github:

```
git clone https://github.com/sdpos20191/mariadapenhabackend.git
```

#### Baixando JDK 8

```
https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html
```

#### Maven
```
https://maven.apache.org/download.cgi
```

#### Instalação do MongoDB
```
https://docs.mongodb.com/manual/installation/
```

#### Executando o servidor de configuracoes via CLI
```
java -jar mpback-config-server.jar
```

#### Executando o service discovery via CLI
```
java -jar mpback-eureka-server.jar
```

#### Executando o gateway service via CLI
```
java -jar mpback-eureka-server.jar
```

#### Executando o servidor de ocorrencia via CLI
```
java -jar mpback-ocorrencia-server.jar
```

Ao acessar o endereço http://localhost:9093/info será exibido o seguinte JSON
```
{
    "app":
       {
        "name":"Ocorrencia Server",
        "description":"Backend do servidor de ocorrencias",
        "version":"1.0.0"
        }
      }
```

### Acesso a documentação

A documentação está disponível no Swagger da [aplicação](http://localhost:9093/swagger-ui.html).

## Rodando testes

O processo de testes pode ser feito através do Maven com plugin maven-surefire. Basta executar o comando:

```
mvn test
```

## Local Deployment

O processo de deploy dos aplicativos por ser feito de 2 formas:

 - Executando os jars executáveis gerados num ambiente com Java instalado conforme descrito acima;
 - Via Docker através do Docker Compose.
 
 ### Docker Compose
 
 ```
 docker-compose up -d
 ```
 
Em ambientes de produção é recomendado o uso do Docker Swarm ou Kubernetes.

## Construído com

* [Spring Boot](https://spring.io/projects/spring-boot) - Framework Open Source Java
* [Maven](https://maven.apache.org/) - Gerenciamento de dependencias
* [Swagger](https://swagger.io/) - Documentacao API REST
* [MongoDB](https://docs.mongodb.com/manual/installation/) - Banco de Dados NoSQL

## Contribuição

Por favor leia [CONTRIBUTING.md](https://github.com/sdpos20191/mariadapenhabackend) para mais detalhes do nosso código de conduta e processo de submissão de pull requests.

## Versioning

Nós utilizamos [Github](http://github.com/) para versionamento. Para visualizar as versões disponíveis, veja as tags em For the versions available, see the [tags nesse repositorio](https://github.com/sdpos20191/mariadapenhabackend/tags). 

## Authors

* **Daniel Brandao**
* **Elisa Soares**
* **Fagner Fernandes**
* **Leandro Costa**

## License

Esse processo está licenciado com MIT License - veja o arquivo [LICENSE.md](LICENSE.md) para mais detakhes.

## Agradecimentos

* Ao professor Carlos Ferraz pela experiencia.
* A Rafael pela integracao com Kumo.

