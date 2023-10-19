package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Peca;

public class PecaDAO extends DAO {

    public PecaDAO() {
        super();
        conectar();
    }

    public void finalize() {
        close();
    }


    public boolean insert(Peca peca) {
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


    public Peca get(int id) {
        Peca peca = null;

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM produto WHERE id=" + id;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                peca = new Peca(/*rs.getInt("codigo"), rs.getString("login"), rs.getString("senha"), rs.getString("sexo").charAt(0)*/);
                                                /*Preencher com as devidas informações do BD*/
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return peca;
    }


    public List<Peca> get() {
        return get("");
    }


    public List<Peca> getOrderById() {
        return get("id");
    }


    public List<Peca> getOrderByFabricante() {
        return get("fabricante");
    }


    public List<Peca> getOrderByDistribuidor() {
        return get("distribuidor");
    }


    private List<Peca> get(String orderBy) {

        List<Peca> pecas = new ArrayList<Peca>();

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM usuario" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                Peca u = new Peca(/*rs.getInt("codigo"), rs.getString("login"), rs.getString("senha"), rs.getString("sexo").charAt(0)*/);
                /*Preencher com as devidas informações do BD*/
                pecas.add(u);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        pecas = OrganizaOrganizado(pecas, orderBy);
        return pecas;
    }
private List<Peca> OrganizaOrganizado(List<Peca> pecas, String opcao){
        switch (opcao){
            case "fabricante":
                for(int i = 0; i < pecas.size() - 1; i++){
                    for(int j = 0; j < pecas.size(); j++){
                        if(pecas.get(i).getFabricante().equals(pecas.get(j).getFabricante())){
                            if(pecas.get(i).getCategoria().compareTo(pecas.get(j).getCategoria()) > 0){
                                Peca temp = pecas.get(i);
                                pecas.set(i, pecas.get(j));
                                pecas.set(j, temp);
                            }
                        }
                    }
                }
                break;

            case "distribuidor":
                for(int i = 0; i < pecas.size() - 1; i++){
                    for(int j = 0; j < pecas.size(); j++){
                        if(pecas.get(i).getDistribuidor().equals(pecas.get(j).getDistribuidor())){
                            if(pecas.get(i).getCategoria().compareTo(pecas.get(j).getCategoria()) > 0){
                                Peca temp = pecas.get(i);
                                pecas.set(i, pecas.get(j));
                                pecas.set(j, temp);
                            }
                        }
                    }
                }
                break;
        }
        return pecas;
}
    public boolean update(Peca peca) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = ""/*"UPDATE usuario SET login = '" + usuario.getLogin() + "', senha = '"
                    + usuario.getSenha() + "', sexo = '" + usuario.getSexo() + "'"
                    + " WHERE codigo = " + usuario.getCodigo();*/;
                    /*Preencher com as devidas informações do BD*/
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
            String sql = "DELETE FROM usuario WHERE id = " + id;
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
}