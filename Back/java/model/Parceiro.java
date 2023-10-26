package model;

import java.util.List;

public class Parceiro extends Usuario{

    /*Variáveis*/
    private int id_parceiro;
    private List<Peca> pecas_vinculadas;
    private int contId = 0;

    public Parceiro(int codigo, String nome, String senha, List<Peca> pecas_vinculadas) {
    }

    /*Métodos Sets e Gets*/
    public void setId_parceiro(int id_parceiro){
        this.id_parceiro = id_parceiro;
    }

    public void setPecas_vinculadas(List<Peca> pecas_vinculadas){
        this.pecas_vinculadas = pecas_vinculadas;
    }

    public int getId_parceiro(){
        return this.id_parceiro;
    }

    public List<Peca> getPecas_vinculadas(){
        return this.pecas_vinculadas;
    }

    /*Método Construtor*/

    public Parceiro(){
        super();
        this.id_parceiro = -1;
        this.pecas_vinculadas = null;
    }

    public Parceiro(int id, String nome_usuario, String senha, List<Peca> lista_favoritos,
                    List<Peca> historico_buscas,int id_parceiro, List<Peca> pecas_vinculadas){
        super(id, senha, nome_usuario, lista_favoritos, historico_buscas);
        this.id_parceiro = contId;
        this.pecas_vinculadas = pecas_vinculadas;
        contId++;
    }
}
