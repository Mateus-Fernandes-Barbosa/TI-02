package dao;

import java.sql.*;
import java.security.*;
import java.math.*;

public class DAO {
    protected Connection conexao;

    public DAO() {
    	conexao = null;
    }

    public boolean conectar() {
        String driverName = "org.postgresql.Driver";
        String serverName = "localhost";
        String mydatabase = "PC_MASTER"; //<---- Alterar Nome do Banco de Dados
        int porta = 5432;
        String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
        String username = "postgres"; //<----- Alterar usuário do banco de dados 
        // Arthur: postgres  -   Luís - ti2cc
		String password = "1768"; //<----- Alterar senha do banco de dados 
        // Arthur: 1768   -   Luís - ti@cc
		boolean status = false;

        try {
            Class.forName(driverName);
            conexao = DriverManager.getConnection(url, username, password);
            status = true;
            System.out.println("Conexão efetuada com o postgres!");
        } catch (ClassNotFoundException e) {
            System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
        }

        return status;
    }

    public boolean close() {
        boolean status = false;

        try {
            conexao.close();
            status = true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return status;
    }


    public static String toMD5(String senha) throws Exception {
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(senha.getBytes(),0, senha.length());
        return new BigInteger(1,m.digest()).toString(16);
    }
}