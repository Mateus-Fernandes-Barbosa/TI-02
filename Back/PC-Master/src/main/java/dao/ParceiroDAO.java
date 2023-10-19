
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Parceiro;
import model.Peca;
import model.Usuario;

public class ParceiroDAO extends DAO {

    public ParceiroDAO() {
        super();
        conectar();
    }

    public void finalize() {
        close();
    }


    public boolean insert(Parceiro parceiro) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "";/*"INSERT INTO usuario (codigo, login, senha, sexo) "
                    + "VALUES ("+peca.getId()+ ", '" + peca.getCategoria() + "', '"
                    + peca.getDistribuidor() + "', '" + peca.getFabricante() + "', '"
                    + peca.getNome_componente() + "','" + peca.getInfo_especifica() + ");";*/
            /*--------------------------PREENCHER COM INFORMAÇÕES DO BD------------------------------*/
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }


    public Parceiro get(int id) {
        Parceiro parceiro = null;

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM produto WHERE id=" + id;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                parceiro = new Parceiro(/*rs.getInt("codigo"), rs.getString("login"), rs.getString("senha"), rs.getString("sexo").charAt(0)*/);
                /*Preencher com as devidas informações do BD*/;
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return parceiro;
    }


    public List<Parceiro> get() {
        return get("");
    }


    public List<Parceiro> getOrderById() {
        return get("id");
    }


    public List<Parceiro> getOrderByNomeUsuario() {
        return get("nome_usuario");
    }

    public List<Parceiro> getOrderByFabricante() {
        return get("fabricante");
    }


    public List<Parceiro> getOrderByDistribuidor() {
        return get("distribuidor");
    }


    private List<Parceiro> get(String orderBy) {

        List<Parceiro> parceiros = new ArrayList<Parceiro>();

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM usuario" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                Parceiro u = new Parceiro(/*rs.getInt("codigo"), rs.getString("login"), rs.getString("senha"), rs.getString("sexo").charAt(0)*/);
                /*Preencher com as devidas informações do BD*/
                parceiros.add(u);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return parceiros;
    }


    public boolean update(Usuario usuario) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "";/*"UPDATE usuario SET login = '" + usuario.getLogin() + "', senha = '"
                    + usuario.getSenha() + "', sexo = '" + usuario.getSexo() + "'"
                    + " WHERE codigo = " + usuario.getCodigo();*/
                    /*------------Inserir as alterações do BD-----------*/
                    System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    public boolean delete(int id) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "DELETE FROM usuario WHERE codigo = " + id;
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }


    public boolean autenticar(String nome_usuario, String senha) {
        boolean resp = false;

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM usuario WHERE login LIKE '" + nome_usuario + "' AND senha LIKE '" + senha  + "'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            resp = rs.next();
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return resp;
    }
}