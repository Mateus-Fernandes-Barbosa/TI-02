package service;

import java.io.File;
import java.lang.String;
import java.util.List;
import java.util.Scanner;

import dao.PecaDAO;
import model.Peca;
import spark.Request;
import spark.Response;

public class PecaService {
	PecaDAO pecaDao = new PecaDAO();
	private String form;
	private String category = "";
	private final int FORM_INSERT = 1;
	private final int FORM_DETAIL = 2;
	private final int FORM_UPDATE = 3;
	private final int FORM_ORDERBY_ID = 1;
	private final int FORM_ORDERBY_NOME = 2;
	private final int FORM_ORDERBY_CATEGORIA = 3;
	private final int FORM_ORDERBY_FABRICANTE = 4;

	
	public PecaService() {
		makeForm();
	}
	
	public void makeForm() {
		makeForm(FORM_INSERT, new Peca(), FORM_ORDERBY_NOME);
	}

	
	public void makeForm(int orderBy) {
		makeForm(FORM_INSERT, new Peca(), orderBy);
	}
	
	public void makeForm(int tipo, Peca peca, int orderBy) {
		String nomeArquivo = "pecas.html";
		form = "";
		try{
			Scanner entrada = new Scanner(new File(nomeArquivo));
		    while(entrada.hasNext()){
		    	form += (entrada.nextLine() + "\n");
		    }
		    entrada.close();
		}  catch (Exception e) { System.out.println(e.getMessage()); }
		String umaPeca = "";
		if(tipo != FORM_INSERT) {
			umaPeca += "\t<table width=\"90%\" bgcolor=\"#c0e0f7\" align=\"center\">";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;<a href=\"/produto/list/1\">Nova Peca</a></b></font></td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t</table>";
			umaPeca += "\t<br>";			
		}
		
		if(tipo == FORM_INSERT || tipo == FORM_UPDATE) {
			String action = "/produto/";
			String name, buttonLabel;
			if (tipo == FORM_INSERT){
				action += "insert";
				name = "Inserir Produto";
				buttonLabel = "Inserir";
			} else {
				action += "update/" + peca.getId();
				name = "Atualizar Produto (ID " + peca.getId() + ")";
				buttonLabel = "Atualizar";
			}
			umaPeca += "\t<form class=\"form--register\" action=\"" + action + "\" method=\"post\" id=\"form-add\">";
			umaPeca += "\t<table width=\"90%\" bgcolor=\"#9cbbd6\" align=\"center\">";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td colspan=\"3\" align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;" + name + "</b></font></td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td colspan=\"3\" align=\"left\">&nbsp;</td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td>&nbsp;Nome: <input class=\"input--register\" type=\"text\" name=\"descricao\" value=\""+ peca.getNome_componente() +"\" width=\"90%\"></td>";
			umaPeca += "\t\t\t<td>&nbsp;Fabricante: <input class=\"input--register\" type=\"text\" name=\"descricao\" value=\""+ peca.getFabricante() +"\" width=\"90%\"></td>";
			umaPeca += "\t\t\t<td>Distribuidor: <input class=\"input--register\" type=\"text\" name=\"preco\" value=\""+ peca.getDistribuidor() +"\" width=\"90%\"></td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td>Categoria: <input class=\"input--register\" type=\"text\" name=\"quantidade\" value=\""+ peca.getCategoria() +"\"></td>";
			umaPeca += "\t\t\t<td>Categoria: <input class=\"input--register\" type=\"text\" name=\"quantidade\" value=\""+ peca.getCategoria() +"\"></td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td align=\"center\"><input type=\"submit\" value=\""+ buttonLabel +"\" class=\"input--main__style input--button\"></td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t</table>";
			umaPeca += "\t</form>";		
		} else if (tipo == FORM_DETAIL){
			umaPeca += "\t<table width=\"90%\" bgcolor=\"#9cbbd6\" align=\"center\">";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td colspan=\"3\" align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;Detalhar Produto (ID " + peca.getId() + ")</b></font></td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td colspan=\"3\" align=\"left\">&nbsp;</td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td>&nbsp;Descrição: "+ peca.getNome_componente() +"</td>";
			umaPeca += "\t\t\t<td>Quantidade: "+ peca.getFabricante() +"</td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td>&nbsp;</td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t</table>";		
		} else {
			System.out.println("ERRO! Tipo não identificado " + tipo);
		}
		form = form.replaceFirst("<UM-PRODUTO>", umaPeca);
		
		String list = new String("<table width=\"90%\" align=\"center\" bgcolor=\"#9cbbd6\">");
		list += "\n<td colspan=\"6\" align=\"left\"><font size=\"+1\"><b>&nbsp;&nbsp;&nbsp;Relação de Produtos</b></font></td>\n" +
				"\n<tr><td colspan=\"6\">&nbsp;</td></tr>\n" +
    			"\n<tr>\n" + 
        		"\t<td><a href=\"/produto/list/" + FORM_ORDERBY_ID + "\"><b>ID</b></a></td>\n" +
        		"\t<td><a href=\"/produto/list/" + FORM_ORDERBY_NOME + "\"><b>Nome</b></a></td>\n" +
        		"\t<td><a href=\"/produto/list/" + FORM_ORDERBY_FABRICANTE + "\"><b>Fabricante</b></a></td>\n" +
        		"\t<td><a href=\"/produto/list/" + FORM_ORDERBY_CATEGORIA + "\"><b>Categoria</b></a></td>\n" +
        		"\t<td width=\"100\" align=\"center\"><b>Detalhar</b></td>\n" +
        		"\t<td width=\"100\" align=\"center\"><b>Atualizar</b></td>\n" +
        		"\t<td width=\"100\" align=\"center\"><b>Excluir</b></td>\n" +
        		"</tr>\n";
		
		List<Peca> produtos;
		if (orderBy == FORM_ORDERBY_ID) {                 	produtos = pecaDao.getOrderById();
		} else if (orderBy == FORM_ORDERBY_NOME) {		produtos = pecaDao.getOrderByNome();
		} else if (orderBy == FORM_ORDERBY_CATEGORIA) {			produtos = pecaDao.getOrderByCategoria();
		} else if (orderBy == FORM_ORDERBY_FABRICANTE) {			produtos = pecaDao.getOrderByFabricante();
		} else {											produtos = pecaDao.get();
		}

		int i = 0;
		String bgcolor = "";
		if(category.equals("all")) {
			for (Peca p : produtos) {
				bgcolor = (i++ % 2 == 0) ? "#bce0f9" : "#78b7e3";
				list += "\n<tr bgcolor=\""+ bgcolor +"\">\n" + 
	            		  "\t<td>" + p.getId() + "</td>\n" +
	            		  "\t<td>" + (p.getNome_componente()) + "</td>\n" +
	            		  "\t<td>" + (p.getFabricante()) + "</td>\n" +
	            		  "\t<td>" + (p.getCategoria()) + "</td>\n" +
	            		  "\t<td align=\"center\" valign=\"middle\"><a href=\"/produto/" + p.getId() + "\"><img src=\"/image/detail.png\" width=\"20\" height=\"20\"/></a></td>\n" +
	            		  "\t<td align=\"center\" valign=\"middle\"><a href=\"/produto/update/" + p.getId() + "\"><img src=\"/image/update.png\" width=\"20\" height=\"20\"/></a></td>\n" +
	            		  "\t<td align=\"center\" valign=\"middle\"><a href=\"javascript:confirmarDeleteProduto('" + p.getId() + "', '" + p.getNome_componente() + "', '" + p.getFabricante() + "');\"><img src=\"/image/delete.png\" width=\"20\" height=\"20\"/></a></td>\n" +
	            		  "</tr>\n";
			}
			list += "</table>";		
		} else {
			for (Peca p : produtos) {
				System.out.println((p.getCategoria()) + " - " + category);
				if((p.getCategoria()).contains(category)){
					bgcolor = (i++ % 2 == 0) ? "#bce0f9" : "#78b7e3";
					list += "\n<tr bgcolor=\""+ bgcolor +"\">\n" + 
		            		  "\t<td>" + p.getId() + "</td>\n" +
		            		  "\t<td>" + (p.getNome_componente()) + "</td>\n" +
		            		  "\t<td>" + (p.getFabricante()) + "</td>\n" +
		            		  "\t<td>" + (p.getCategoria()) + "</td>\n" +
		            		  "\t<td align=\"center\" valign=\"middle\"><a href=\"/produto/" + p.getId() + "\"><img src=\"/image/detail.png\" width=\"20\" height=\"20\"/></a></td>\n" +
		            		  "\t<td align=\"center\" valign=\"middle\"><a href=\"/produto/update/" + p.getId() + "\"><img src=\"/image/update.png\" width=\"20\" height=\"20\"/></a></td>\n" +
		            		  "\t<td align=\"center\" valign=\"middle\"><a href=\"javascript:confirmarDeleteProduto('" + p.getId() + "', '" + p.getNome_componente() + "', '" + p.getFabricante() + "');\"><img src=\"/image/delete.png\" width=\"20\" height=\"20\"/></a></td>\n" +
		            		  "</tr>\n";
				}
			}
			list += "</table>";	
			category = "";
		}
		form = form.replaceFirst("<LISTAR-PRODUTO>", list);	
	}
	
	public Object getAll(Request request, Response response) {
		int orderBy = Integer.parseInt(request.params(":orderby"));
		makeForm(orderBy);
	
	    response.header("Content-Type", "text/html");
	    response.header("Content-Encoding", "UTF-8");
		return form;
	}	
	
	public Object getCategory(Request request, Response response) {
		int orderBy = Integer.parseInt(request.params(":orderby"));
		category = request.params(":category");
		category = category.replace("_", " ");
		makeForm(orderBy);
	
	    response.header("Content-Type", "text/html");
	    response.header("Content-Encoding", "UTF-8");
		return form;
	}	
	
	public Object getToUpdate(Request request, Response response) {
		int id = Integer.parseInt(request.params(":id"));		
		//int orderBy = Integer.parseInt(request.params(":orderby"));
		Peca peca = (Peca) pecaDao.get(id);
		
		if (peca != null) {
			response.status(200); // success
			makeForm(FORM_UPDATE, peca, FORM_ORDERBY_ID);
        } else {
            response.status(404); // 404 Not found
            String resp = "peca " + id + " não encontrado.";
    		makeForm(FORM_ORDERBY_CATEGORIA);
    		form.replaceFirst("<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"\">", "<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\""+ resp +"\">");     
        }

		return form;
	}
	
	
}
