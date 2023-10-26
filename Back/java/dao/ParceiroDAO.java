
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Parceiro;
import model.Peca;

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
            String sql = "INSERT INTO parceiro (id_parceiro, nome_usuario, senha, peca_vinculada) "
                    + "VALUES ("+parceiro.getId_parceiro()+ ", '" + parceiro.getNome_usuario() + "', '"
                    + parceiro.getSenha() + "', '" + parceiro.getArrayInt(parceiro.getPecas_vinculadas()) + ");";
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
                int codigo = rs.getInt("id_parceiro");
                String nome = rs.getString("nome_usuario");
                String senha = rs.getString("senha");
                Array temp = rs.getArray("peca_vinculada");
                int [] pecas_vinculadas_int = (int[]) temp.getArray();
                List<Peca> pecas_vinculadas = parceiro.encontraPecas(pecas_vinculadas_int);
                parceiro = new Parceiro(codigo, nome, senha, pecas_vinculadas);
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
                Parceiro parceiro = new Parceiro();
                int codigo = rs.getInt("id_parceiro");
                String nome = rs.getString("nome_usuario");
                String senha = rs.getString("senha");
                Array temp = rs.getArray("peca_vinculada");
                int [] pecas_vinculadas_int = (int[]) temp.getArray();
                List<Peca> pecas_vinculadas = parceiro.encontraPecas(pecas_vinculadas_int);
                parceiro = new Parceiro(codigo, nome, senha, pecas_vinculadas);
                /*Preencher com as devidas informações do BD*/
                parceiros.add(parceiro);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return parceiros;
    }


    public boolean update(Parceiro parceiro) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "UPDATE usuario SET nome = '" + parceiro.getNome_usuario() + "', senha = '"
                    + parceiro.getSenha() + "', peca_vinculada = '" + parceiro.getArrayInt(parceiro.getPecas_vinculadas()) + "'"
                    + " WHERE codigo = " + parceiro.getId_parceiro();
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
        	ParceiroDAO parceiroDAO = new ParceiroDAO();
            Statement st = conexao.createStatement();
            String sql = "DELETE FROM usuario WHERE codigo = " + id;
            parceiroDAO.organizaDados(id);
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
    
    /*Função Acessória*/
    
    private void organizaDados(int id) {
    	ParceiroDAO parceiroDAO = new ParceiroDAO();
    	int n = id;
    	if(parceiroDAO.get(n + 1) != null) {
    		Parceiro parceiro;
    		parceiroDAO.organizaDados(n + 1);
    		parceiro = parceiroDAO.get(n + 1);
    		parceiro.setId(n);
    		parceiroDAO.update(parceiro);
    	}
    }
}