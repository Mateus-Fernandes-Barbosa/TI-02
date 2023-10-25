
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO extends DAO {

    public UsuarioDAO() {
        super();
        conectar();
    }

    public void finalize() {
        close();
    }


    public boolean insert(Usuario usuario) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "INSERT INTO usuario (id, nome_usuario, senha, lista_favorito, historico_buscas) "
                    + "VALUES ("+usuario.getId() +", '" + usuario.getNome_usuario() + "', '"
                    + usuario.getSenha() + "'," + usuario.getArrayInt(usuario.getLista_favoritos()) + ","
                    + usuario.getArrayInt(usuario.getHistorico_buscas()) + ");";
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


    public Usuario get(int id) {
        Usuario usuario = null;

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM produto WHERE id=" + id;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                int codigo = rs.getInt("id");
                String senha = rs.getString("senha");
                String nome = rs.getString("nome");
                Array temp = rs.getArray("lista_favoritos");
                int [] lista_favoritos = (int [])temp.getArray();
                temp = rs.getArray("historico_buscas");
                int [] historico_buscas = (int [])temp.getArray();
                Usuario u = new Usuario();
                usuario = u.criaUsuario(codigo, senha, nome, lista_favoritos, historico_buscas);

                /*Preencher com as devidas informações do BD*/;
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return usuario;
    }


    public List<Usuario> get() {
        return get("");
    }


    public List<Usuario> getOrderById() {
        return get("id");
    }


    public List<Usuario> getOrderByNomeUsuario() {
        return get("nome_usuario");
    }


    private List<Usuario> get(String orderBy) {

        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM usuario" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                int codigo = rs.getInt("id");
                String senha = rs.getString("senha");
                String nome = rs.getString("nome");
                Array temp = rs.getArray("lista_favoritos");
                int [] lista_favoritos = (int [])temp.getArray();
                temp = rs.getArray("historico_buscas");
                int [] historico_buscas = (int[])temp.getArray();
                Usuario u = new Usuario();
                u = u.criaUsuario(codigo, senha, nome, lista_favoritos, historico_buscas);
                /*Preencher com as devidas informações do BD*/
                usuarios.add(u);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return usuarios;
    }


    public boolean update(Usuario usuario) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "UPDATE usuario SET nome = '" + usuario.getNome_usuario() + "', senha = '"
                    + usuario.getSenha() + "', lista_historico = '"
                    + usuario.getArrayInt(usuario.getLista_favoritos())
                    + "', historico_buscas = '" + usuario.getArrayInt(usuario.getHistorico_buscas()) + "'"
                    + " WHERE id = " + usuario.getId();
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