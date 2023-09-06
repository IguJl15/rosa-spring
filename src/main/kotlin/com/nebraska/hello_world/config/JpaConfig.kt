package com.nebraska.hello_world.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
@ConfigurationProperties("spring.datasource")
class JpaConfig {
    val dbHostEnv = "DB_HOST"
    val dbNameEnv = "DB_NAME"
    val dbUsernameEnv = "DB_USERNAME"
    val dbPasswordEnv = "DB_PASSWORD"

    @Bean
    @Primary
    fun getDataSource(): DataSource {
        val host = System.getenv(dbHostEnv) ?: "localhost"
        val dbName = System.getenv(dbNameEnv) ?: "rosa_db"
        val username = System.getenv(dbUsernameEnv) ?: "postgres"
        val password = System.getenv(dbPasswordEnv) ?: "postgres"

        return DataSourceBuilder.create()
            .driverClassName("org.postgresql.Driver")
            .url("jdbc:postgresql://$host/$dbName")
            .username(username)
            .password(password)
            .build()
    }
}