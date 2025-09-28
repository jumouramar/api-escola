# Desenvolvimento - API Escola

#### ✅ 0: Pré-requisitos

- Extensão do VS Code: `Java Extension Pack`
- Java (JDK)
- Maven: https://maven.apache.org/download.cgi

#### ✅ 1: Gerar Projeto com Spring Initializr

Projeto inicializado em https://start.spring.io/ com as configurações:
- Project: Maven
- Language: Java
- Spring Boot: 3.5.0
- Group: com.api
- Artifact: escola
- Name: escola
- Package name: com.api.escola
- Packaging: Jar
- Java: 21
- Dependencies: Spring Data JPA

#### ✅ 2: Estrutura de Pastas

```
escola/
├── src/
│   ├── main/
│   │   ├── java/com/api/escola/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── exception/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── EscolaApplication.java
│   │   └── resources/
│   │       └── application.properties
```

#### ✅ 3: Configurações do arquivo pom.xml

#### ✅ 4: Configurações do arquivo application.properties

#### ✅ 5: Classe principal

`EscolaApplication.java` é a classe principal.

#### ✅ 6: Compilar o projeto

```
mvn clean install
```

#### ✅ 7: Rodar o projeto

```
mvn spring-boot:run
```

#### ✅ 8: Configurações do Git

```
git init
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/jumouramar/antofagica-api.git
git push -u origin main
```