# Rosa Spring

Application for manage investment products from both Web and REST APIs.

## Requirements

From `./gradlew --version`

```plain
------------------------------------------------------------
Gradle 8.2.1
------------------------------------------------------------

Kotlin:       1.8.20
Groovy:       3.0.17
Ant:          Apache Ant(TM) version 1.10.13 compiled on January 4 2023
JVM:          17.0.8 (Homebrew 17.0.8+0)
```

## Build and Run

### Database

To run the application locally you need an instance of PostgreSql running.
For this, we have a pre made Docker Compose file to start a pre-configured
database

To run a docker with PostgreSql:

- Uncomment the first part of [compose.yaml] up to the line with `# SPRING INSTANCE` comment

> Pay attention to the environment values (`DB_HOST`, `DB_NAME`, etc.), it should match the configuration of
> yours environment variables or the default values set on [JpaConfig.kt](src/main/kotlin/com/nebraska/hello_world/config/JpaConfig.kt)

### Start

To start your application you can look for a "Run" button on your preferred IDE
or start the application executing the next command on the terminal:

```shell
./gradlew bootRun
```

Both will start your application.

> **Spring Boot will build and start your database docker instance 
> automatically**

---

Thank you!