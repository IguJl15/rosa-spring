package com.nebraska.hello_world.config

import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.DotenvException
import io.github.cdimascio.dotenv.dotenv
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
@ConfigurationProperties("spring.datasource")
class JpaConfig {
    @Bean
    @Primary
    fun getDataSource(): DataSource {
        var dotEnv: Dotenv;
        try {
            dotEnv = dotenv {
                ignoreIfMissing = false
                filename = ".env"
            }
        } catch (e: DotenvException) {
            println("Env file not found. Trying to load env file from secrets folder (/etc/secrets)")
            dotEnv = dotenv {
                ignoreIfMissing = false
                directory = "/etc/secrets/"
                filename = ".env"
            }
        }



        val host = dotEnv.get("DB_HOST")
        val dbName = dotEnv.get("DB_NAME")

        return DataSourceBuilder.create()
            .driverClassName("org.postgresql.Driver")
            .url("jdbc:postgresql://$host/$dbName")
            .username(dotEnv.get("DB_USERNAME"))
            .password(dotEnv.get("DB_PASSWORD"))
            .build()
    }
}