package com.project.resource;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jakarta.annotation.sql.DataSourceDefinition;

@DataSourceDefinition(
    name = "jdbc/projectDS",
    className = "org.postgresql.xa.PGXADataSource",
    serverName = "project_db",       // <-- Corrigé selon ton container_name
    portNumber = 5432,
    databaseName = "project_university", // <-- Corrigé selon ton POSTGRES_DB
    user = "admin",                  // <-- Corrigé selon ton POSTGRES_USER
    password = "password"            // <-- Corrigé selon ton POSTGRES_PASSWORD
)
@ApplicationPath("/v1")
public class RestApplication extends Application {
}