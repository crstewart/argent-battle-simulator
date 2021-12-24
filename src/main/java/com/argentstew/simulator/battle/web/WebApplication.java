package com.argentstew.simulator.battle.web;

import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * com.argentstew.simulator.battle.web
 * 4/16/2020
 *
 * @author argen
 */
@SpringBootApplication(
        scanBasePackages = {"com.argentstew.simulator.battle.web"},
        exclude = {ErrorMvcAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "com.argentstew.simulator.battle.web.repository")
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    private final Environment env;

    @Autowired
    public WebApplication(Environment env) {
        this.env = env;
    }

    @Bean
    public VgFighterFactory fighterFactory() {
        return new VgFighterFactory();
    }

    @Bean
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("argent.simulator.database.url"));
        config.setUsername(env.getProperty("argent.simulator.database.username"));
        config.setPassword(env.getProperty("argent.simulator.database.pass"));
        config.setSchema(env.getProperty("argent.simulator.database.schema"));
        config.addDataSourceProperty("cachePrepStmts", Boolean.TRUE.toString());
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }

}
