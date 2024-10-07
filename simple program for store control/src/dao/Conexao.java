package dao;

import java.sql.*;



public class Conexao {
    
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Projeto A3", "postgres", "silvia22");
        return conexao;
    }
    
}
