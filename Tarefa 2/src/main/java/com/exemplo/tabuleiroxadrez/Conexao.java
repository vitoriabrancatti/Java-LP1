package com.exemplo.tabuleiroxadrez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConexao() {
        try {
            String url = "jdbc:mysql://localhost:3306/xadrez";
            String usuario = "root";
            String senha = "senha";
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}
