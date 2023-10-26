package model;

public class Peca {
    private int id;
    private String nome_componente;
    private String fabricante;
    private String distribuidor;
    private String categoria;
    private String info_especifica;
    private int contId = 0;

    /*Métodos Set*/

    public void setId(int id){
        this.id = id;
    }

    public void setNome_componente(String nome_componente){
        this.nome_componente = nome_componente;
    }

    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }

    public void setDistribuidor(String distribuidor){
        this.distribuidor = distribuidor;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public void setInfo_especifica(String info_especifica){
        this.info_especifica = info_especifica;
    }

    /*Métodos Get*/

    public int getId(){
        return this.id;
    }

    public String getNome_componente(){
        return this.nome_componente;
    }

    public String getDistribuidor(){
        return this.distribuidor;
    }

    public String getFabricante(){
        return this.fabricante;
    }

    public String getCategoria(){
        return  this.categoria;
    }

    public String getInfo_especifica(){
        return  this.info_especifica;
    }

    /*Métodos Construtores*/

    public Peca(){
        this.id = -1;
        this.nome_componente = "nao_informado";
        this.fabricante = "nao_informado";
        this.distribuidor = "nao_informado";
        this.categoria = "nao_informado";
        this.info_especifica = "nao_informado";
    }

    public Peca(int id, String nome_componente, String fabricante, String distribuidor, String categoria, String info_especifica){
        this.id = contId;
        this.nome_componente = nome_componente;
        this.fabricante = fabricante;
        this.distribuidor = distribuidor;
        this.categoria = categoria;
        this.info_especifica = info_especifica;
        contId++;
    }
}
