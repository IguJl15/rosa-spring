package com.nebraska.hello_world.config

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
    val dotEnv = dotenv()

    @Bean
    @Primary
    fun getDataSource(): DataSource {
        return DataSourceBuilder.create()
            .driverClassName("org.postgresql.Driver")
            .url(getDataSourceUrl())
            .username(dotEnv.get("DB_USERNAME"))
            .password(dotEnv.get("DB_PASSWORD"))
            .build()
    }

    private fun getDataSourceUrl(): String {
        val host = dotEnv.get("DB_HOST")
        val dbName = dotEnv.get("DB_NAME")

        return "jdbc:postgresql://$host/$dbName"
    }
}