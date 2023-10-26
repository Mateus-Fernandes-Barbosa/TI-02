package model;
import java.util.List;
import model.Peca;
import dao.PecaDAO;
public class Usuario {

    /*Variáveis Privadas*/
    private int admin_id;
    private String nome_usuario;
    private String senha;
    private List<Peca> lista_favoritos;
    private List<Peca> historico_buscas;
    private int id;
    private int contId = 0;

    /*Funções Sets*/

    public void setId(int id){
        this.id = id;
    }

    public void setNome_usuario(String nome_usuario){
        this.nome_usuario = nome_usuario;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setLista_favoritos(List<Peca> lista_favoritos){
        this.lista_favoritos = lista_favoritos;
    }

    public void setHistorico_buscas(List<Peca> historico_buscas){
        this.historico_buscas = historico_buscas;
    }

    public void setAdmin_id(int admin_id){
        this.admin_id = admin_id;
    }

    /*Métodos Get*/

    public int getId(){
        return this.id;
    }

    public String getNome_usuario(){
        return nome_usuario;
    }

    public String getSenha(){
        return senha;
    }

    public List<Peca> getLista_favoritos(){
        return this.lista_favoritos;
    }

    public List<Peca> getHistorico_buscas(){
        return this.historico_buscas;
    }

    public int getAdmin_id(){
        return this.admin_id;
    }

    /*Método Construtor*/

    public Usuario(){
        this.id = -1;
        this.senha = "nao_informado";
        this.nome_usuario = "nao_informado";
        this.lista_favoritos = null;
        this.historico_buscas = null;
    }

    public Usuario criaUsuario(int id, String senha, String nome_usuario, int [] lista_favoritos_ids, int [] historico_buscas_ids){
        List<Peca> lista_favoritos = null;
        List<Peca> historico_buscas = null;
        lista_favoritos = encontraPecas(lista_favoritos_ids);
        historico_buscas = encontraPecas(historico_buscas_ids);
        Usuario u = new Usuario(id, senha, nome_usuario, lista_favoritos, historico_buscas);
        return u;
    }
    public Usuario(int id, String senha, String nome_usuario, List<Peca> lista_favoritos, List<Peca> historico_buscas){
        this.id = contId;
        this.senha = senha;
        this.nome_usuario = nome_usuario;
        this.lista_favoritos = lista_favoritos;
        this.historico_buscas = historico_buscas;
        contId++;
    }

    /*Método Acessório*/
    public List<Peca> encontraPecas(int[] listaPecas){ //Método utilizado para converter um array de int, retirado do BD, em um array de pecas
        List<Peca> lista = null;
        int n = listaPecas.length;
        for(int i = 0; i < n; i++){
            PecaDAO pecaDAO = new PecaDAO();
            Peca peca = pecaDAO.get(listaPecas[i]);
            lista.add(peca);
        }
        return lista;
    }

    public int [] getArrayInt(List<Peca> pecas){ //Método acessório utilizado para transformar um array de ids em um array de ints a ser armazenado no BD
        Peca [] pecasArray = (Peca[])pecas.toArray();
        int [] intIds = new int[pecasArray.length];
        for(int i = 0; i < pecasArray.length; i++){
            intIds[i] = pecasArray[i].getId();
        }
        return intIds;
    }

}
