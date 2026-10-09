package com.joaosevergnini.ecommerce.infrastructure.pesistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ignored) {
        }
    }

    // Configuracoes padrao para MySQL local
    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/ecommerce_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&allowMultiQueries=true";
    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASSWORD = "root";

    private DatabaseConnection() {
        // Construtor privado para evitar instanciacao
    }

    public static Connection getConnection() {
        // Le variaveis de ambiente se disponiveis (util para Docker / producao)
        String url = System.getenv().getOrDefault("DB_URL", DEFAULT_URL);
        String user = System.getenv().getOrDefault("DB_USER", DEFAULT_USER);
        String password = System.getenv().getOrDefault("DB_PASSWORD", DEFAULT_PASSWORD);

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to database at " + url + ". Verifique se o MySQL esta rodando.", e);
        }
    }
}
