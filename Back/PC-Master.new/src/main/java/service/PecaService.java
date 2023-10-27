package service;

import java.io.File;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	private String[] legenda_info;
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
	
	public int legendaInfoEspecifica(String categoria) {
		int qtde = 0;
		if(categoria.equals("Processador") || category.equals("Processador")) {
			qtde = 10;
			String[] legenda_info = {
				    "Geração", 
				    "Socket", 
				    "Tipo RAM Compatível", 
				    "Tamanho Máximo de RAM", 
				    "TDP", 
				    "Possui GPU Integrada", 
				    "Quantidade de Núcleos", 
				    "Quantidade de Threads", 
				    "Frequência Base", 
				    "Frequência Máxima"
			};
			this.legenda_info = legenda_info;
		} else if(categoria.equals("Placa Mãe") || category.equals("Placa Mãe")) {
			qtde = 9;
			
			String[] legenda_info = {
				    "Geração Processador",
				    "Socket",
				    "Tipo RAM Compatível",
				    "Frequência RAM (Máxima Base)",
				    "Frequência RAM",
				    "Tecnologia PCI Express x16",
				    "Quantidade Conectores SATA",
				    "Quantidade Conectores M.2",
				    "Quantidade Máxima de RAM"
			};
			this.legenda_info = legenda_info;
		} else if(categoria.equals("Memória RAM") || category.equals("Memória RAM")) {
			qtde = 4;
			String[] legenda_info = {
				    "Tipo de RAM",
				    "Frequência (Mhz)",
				    "Tamanho (gb)",
				    "Latência (cl)",
			};
			this.legenda_info = legenda_info;
		} else if(categoria.equals("Placa de Vídeo") || category.equals("Placa de Vídeo")) {
			qtde = 8;
			String[] legenda_info = {
				    "TDP",
				    "Tecnologia PCI Express x16",
				    "Quantidade de VRAM",
				    "Tecnologia de VRAM",
				    "Clock Base",
				    "Clock de Boost",
				    "Clock de Memória",
				    "Quantidade de Núcleos"
				};
			this.legenda_info = legenda_info;
		} else if(categoria.equals("Fontes") || category.equals("Fontes")) {
			qtde = 2;
			String[] legenda_info = {
				    "Potência",
				    "Selo 80 plus",
				};
			this.legenda_info = legenda_info;
		}
		return qtde;
	}
	
	public void makeForm() {
		makeForm(FORM_INSERT, new Peca(), FORM_ORDERBY_NOME);
	}

	
	public void makeForm(int orderBy) {
		makeForm(FORM_INSERT, new Peca(), orderBy);
	}
	
	public void makeForm(int tipo, Peca peca, int orderBy) {
		String[] info = peca.getInfo_especifica().split(";");
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
			umaPeca += "\t<table width=\"90%\"  align=\"center\">";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;<a href=\"/produto/list/1/all\">Nova Peca</a></b></font></td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t</table>";
			umaPeca += "\t<br>";			
		}
		
		if(tipo == FORM_INSERT || tipo == FORM_UPDATE) {
			String action = "/peca/";
			String name, buttonLabel;
			if (tipo == FORM_INSERT){
				action += "insert";
				name = "Inserir "+ category;
				buttonLabel = "Inserir";
			} else {
				action += "update/" + peca.getId();
				name = "Atualizar peca (ID " + peca.getId() + ")";
				buttonLabel = "Atualizar";
				System.out.println(!category.equals("all"));
				
			}
			if (tipo == FORM_UPDATE) {
				umaPeca += "\t<form class=\"form--register\" action=\"" + action + "\" method=\"post\" id=\"form-add\">";
				umaPeca += "\t<table width=\"100%\" bgcolor=\"#9cbbd6\" align=\"center\">";
				umaPeca += "\t\t<tr>";
				umaPeca += "\t\t\t<td colspan=\"3\" align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;" + name + "</b></font></td>";
				umaPeca += "\t\t</tr>";
				umaPeca += "\t\t<tr>";
				umaPeca += "\t\t\t<td colspan=\"3\" align=\"left\">&nbsp;</td>";
				umaPeca += "\t\t</tr>";
				umaPeca += "\t\t<tr>";
				umaPeca += "\t\t\t<td>&nbsp;Nome: <br><input class=\"input--register\" type=\"text\" name=\"Nome\" value=\" " + peca.getNome_componente() + " \" width=\"90%\"></td>";
				umaPeca += "\t\t\t<td>&nbsp;Fabricante: <br><input class=\"input--register\" type=\"text\" name=\"Fabricante\" value=\" " + peca.getFabricante() +"\" width=\"90%\"></td>";
				umaPeca += "\t\t\t<td>Distribuidor: <br><input class=\"input--register\" type=\"text\" name=\"Distribuidor\" value=\" " + peca.getDistribuidor() + " \" width=\"90%\"></td>";
				umaPeca += "\t\t</tr>";
				umaPeca += "\t\t<tr>";
				umaPeca += "\t\t\t<td>Categoria: <br><input class=\"input--register\" type=\"text\" name=\"Categoria\" value=\" " + peca.getCategoria() + "\"></td>";
				String[] infos = peca.getInfo_especifica().split(";");
				for(int i = 0, tam = legendaInfoEspecifica(peca.getCategoria()); i<tam; i++ ) {
					if((i+1)%3 == 0) {
						umaPeca += "\t\t</tr>";
						umaPeca += "\t\t<tr>";
						umaPeca += "\t\t\t<td>&nbsp;"+ legenda_info[i] +": <br><input class=\"input--register\" type=\"text\" name=\"" + i + "\" value=\" "+ infos[i] +"\" width=\"100%\"></td>";
					} else {
						umaPeca += "\t\t\t<td>&nbsp;"+ legenda_info[i] +": <br> <input class=\"input--register\" type=\"text\" name=\"" + i + "\" value=\"" + infos[i] +"\" width=\"90%\"></td>";
					}
				}
				umaPeca += "\t\t</tr>";
				umaPeca += "\t\t<tr>";
				umaPeca += "\t\t<td> </td>";
				umaPeca += "\t\t\t<br><td align=\"center\"><input type=\"submit\" value=\""+ buttonLabel +"\" class=\"input--main__style input--button\" width = \"100%\"></td>";
				umaPeca += "\t\t</tr>";
				umaPeca += "\t</table>";
				umaPeca += "\t</form>";		
			} else if(!category.equals("all")) {
				umaPeca += "\t<form class=\"form--register\" action=\"" + action + "\" method=\"post\" id=\"form-add\">";
				umaPeca += "\t<table width=\"100%\" bgcolor=\"#9cbbd6\" align=\"center\">";
				umaPeca += "\t\t<tr>";
				umaPeca += "\t\t\t<td colspan=\"3\" align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;" + name + "</b></font></td>";
				umaPeca += "\t\t</tr>";
				umaPeca += "\t\t<tr>";
				umaPeca += "\t\t\t<td colspan=\"3\" align=\"left\">&nbsp;</td>";
				umaPeca += "\t\t</tr>";
				umaPeca += "\t\t<tr>";
				umaPeca += "\t\t\t<td>&nbsp;Nome: <br><input class=\"input--register\" type=\"text\" name=\"Nome\" value=\"\" width=\"90%\"></td>";
				umaPeca += "\t\t\t<td>&nbsp;Fabricante: <br><input class=\"input--register\" type=\"text\" name=\"Fabricante\" value=\"\" width=\"90%\"></td>";
				umaPeca += "\t\t\t<td>Distribuidor: <br><input class=\"input--register\" type=\"text\" name=\"Distribuidor\" value=\"\" width=\"90%\"></td>";
				umaPeca += "\t\t</tr>";
				umaPeca += "\t\t<tr>";
				umaPeca += "\t\t\t<td>Categoria: <br><input class=\"input--register\" type=\"text\" name=\"Categoria\" value=\"\"></td>";
				for(int i = 0, tam = legendaInfoEspecifica(peca.getCategoria()); i<tam; i++ ) {
					if((i+1)%3 == 0) {
						umaPeca += "\t\t</tr>";
						umaPeca += "\t\t<tr>";
						umaPeca += "\t\t\t<td>&nbsp;"+ legenda_info[i] +": <br><input class=\"input--register\" type=\"text\" name=\"" + i + "\" value=\"\" width=\"100%\"></td>";
					} else {
						umaPeca += "\t\t\t<td>&nbsp;"+ legenda_info[i] +": <br> <input class=\"input--register\" type=\"text\" name=\"" + i + "\" value=\"\" width=\"90%\"></td>";
					}
				}
				umaPeca += "\t\t</tr>";
				umaPeca += "\t\t<tr>";
				umaPeca += "\t\t<td> </td>";
				umaPeca += "\t\t\t<br><td align=\"center\"><input type=\"submit\" value=\""+ buttonLabel +"\" class=\"input--main__style input--button\" width = \"100%\"></td>";
				umaPeca += "\t\t</tr>";
				umaPeca += "\t</table>";
				umaPeca += "\t</form>";		
			}
		} else if (tipo == FORM_DETAIL){
			umaPeca += "\t<table width=\"100%\" bgcolor=\"#9cbbd6\" align=\"center\">";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td colspan=\"3\" align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;Detalhar peca (ID " + peca.getId() + ", " + peca.getNome_componente() +")</b></font></td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td colspan=\"3\" align=\"left\">&nbsp;</td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td>&nbsp;Nome: "+ peca.getNome_componente() +"</td>";
			umaPeca += "\t\t\t<td>Fabricante: "+ peca.getFabricante() +"</td>";
			if(peca.getDistribuidor().length() < 2) {
				umaPeca += "\t\t\t<td>Distribuidor: Não informado</td>";
			} else {
				umaPeca += "\t\t\t<td>Distribuidor: "+ peca.getDistribuidor() +"</td>";
			}
			umaPeca += "\t\t</tr>";
			umaPeca += "\t\t<tr>";
			for(int i = 0, tam = legendaInfoEspecifica(peca.getCategoria()); i<tam; i++ ) {
				if(i%3 == 0) {
					umaPeca += "\t\t</tr>";
					umaPeca += "\t\t<tr>";
					umaPeca += "\t\t\t<td>" + legenda_info[i] +": " + info[i] +"</td>";
				} else {
					umaPeca += "\t\t\t<td>" + legenda_info[i] +": " + info[i] +"</td>";
				}
			}
			
			umaPeca += "\t\t</tr>";
			umaPeca += "\t\t<tr>";
			umaPeca += "\t\t\t<td>&nbsp;</td>";
			umaPeca += "\t\t</tr>";
			umaPeca += "\t</table>";		
		} else {
			System.out.println("ERRO! Tipo não identificado " + tipo);
		}
		form = form.replaceFirst("<UM-PRODUTO>", umaPeca);
		
		String list = new String("<table width=\"100%\" align=\"center\" bgcolor=\"#9cbbd6\" >");
		if (category == "") {
			category = "all";
		}
		list += "\n<tr><td colspan=\"6\">&nbsp;</td></tr>\n" +
    			"\n<tr>\n" + 
        		"\t<td><a href=\"/produto/list/" + FORM_ORDERBY_ID + "/" + category +"\"><b>ID</b></a></td>\n" +
        		"\t<td><a href=\"/produto/list/" + FORM_ORDERBY_NOME + "/" + category +"\"><b>Nome</b></a></td>\n" +
        		"\t<td><a href=\"/produto/list/" + FORM_ORDERBY_FABRICANTE + "/" + category +"\"><b>Fabricante</b></a></td>\n" +
        		"\t<td><a href=\"/produto/list/" + FORM_ORDERBY_CATEGORIA + "/" + category +"\"><b>Categoria</b></a></td>\n" +
        		"\t<td width=\"100\" align=\"center\"><b>Detalhar</b></td>\n" +
        		"\t<td width=\"100\" align=\"center\"><b>Atualizar</b></td>\n" +
        		"\t<td width=\"100\" align=\"center\"><b>Excluir</b></td>\n" +
        		"</tr>\n";
		
		List<Peca> pecas;
		if (orderBy == FORM_ORDERBY_ID) {                 	pecas = pecaDao.getOrderById();
		} else if (orderBy == FORM_ORDERBY_NOME) {		pecas = pecaDao.getOrderByNome();
		} else if (orderBy == FORM_ORDERBY_CATEGORIA) {			pecas = pecaDao.getOrderByCategoria();
		} else if (orderBy == FORM_ORDERBY_FABRICANTE) {			pecas = pecaDao.getOrderByFabricante();
		} else {											pecas = pecaDao.get();
		}

		int i = 0;
		String bgcolor = "";
		if(category.equals("all")) {
			for (Peca p : pecas) {
				bgcolor = (i++ % 2 == 0) ? "#bce0f9" : "#78b7e3";
				list += "\n<tr bgcolor=\""+ bgcolor +"\">\n" + 
	            		  "\t<td>" + p.getId() + "</td>\n" +
	            		  "\t<td>" + (p.getNome_componente()) + "</td>\n" +
	            		  "\t<td>" + (p.getFabricante()) + "</td>\n" +
	            		  "\t<td>" + (p.getCategoria()) + "</td>\n" +
	            		  "\t<td align=\"center\" valign=\"middle\"><a href=\"/produto/" + p.getId() + "\"><img src=\"/image/detail.png\" width=\"20\" height=\"20\"/></a></td>\n" +
	            		  "\t<td align=\"center\" valign=\"middle\"><a href=\"/produto/update/" + p.getId() + "\"><img src=\"/image/update.png\" width=\"20\" height=\"20\"/></a></td>\n" +
	            		  "\t<td align=\"center\" valign=\"middle\"><a href=\"javascript:confirmarDeletepeca('" + p.getId() + "', '" + p.getNome_componente() + "', '" + p.getFabricante() + "');\"><img src=\"/image/delete.png\" width=\"20\" height=\"20\"/></a></td>\n" +
	            		  "</tr>\n";
			}
			list += "</table>";		
		} else {
			for (Peca p : pecas) {
				
				if((p.getCategoria()).contains(category)){
					bgcolor = (i++ % 2 == 0) ? "#bce0f9" : "#78b7e3";
					list += "\n<tr bgcolor=\""+ bgcolor +"\">\n" + 
		            		  "\t<td>" + p.getId() + "</td>\n" +
		            		  "\t<td>" + (p.getNome_componente()) + "</td>\n" +
		            		  "\t<td>" + (p.getFabricante()) + "</td>\n" +
		            		  "\t<td>" + (p.getCategoria()) + "</td>\n" +
		            		  "\t<td align=\"center\" valign=\"middle\"><a href=\"/produto/" + p.getId() + "\"><img src=\"/image/detail.png\" width=\"20\" height=\"20\"/></a></td>\n" +
		            		  "\t<td align=\"center\" valign=\"middle\"><a href=\"/produto/update/" + p.getId() + "\"><img src=\"/image/update.png\" width=\"20\" height=\"20\"/></a></td>\n" +
		            		  "\t<td align=\"center\" valign=\"middle\"><a href=\"javascript:confirmarDeletepeca('" + p.getId() + "', '" + p.getNome_componente() + "', '" + p.getFabricante() + "');\"><img src=\"/image/delete.png\" width=\"20\" height=\"20\"/></a></td>\n" +
		            		  "</tr>\n";
				}
			}
			list += "</table>";	
			category = "";
		}
		form = form.replaceFirst("<LISTAR-PRODUTO>", list);	
	}
	
	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.params(":id"));
		Peca peca = (Peca) pecaDao.get(id);
		makeForm(FORM_DETAIL, peca, FORM_ORDERBY_ID);
	
	    response.header("Content-Type", "text/html");
	    response.header("Content-Encoding", "UTF-8");
		return form;
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
	
	public Object update(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
		Peca peca = pecaDao.get(id);
        String resp = "";       

        if (peca != null) {
        	int qtde = legendaInfoEspecifica(peca.getCategoria());
        	peca.setNome_componente(request.queryParams("Nome"));
        	peca.setFabricante(request.queryParams("Fabricante"));
        	peca.setDistribuidor(request.queryParams("Distribuidor"));
        	peca.setCategoria(request.queryParams("Categoria"));
        	String infEspecifica = "";
        	infEspecifica += legenda_info[0];
        	for(int i = 1; i<qtde; i++) {
        		infEspecifica += ";" + legenda_info[0];
        	}
        	pecaDao.update(peca);
        	response.status(200); // success
            resp = "peca (ID " + peca.getId() + ") atualizado!";
        } else {
            response.status(404); // 404 Not found
            resp = "peca (ID \" + peca.getId() + \") não encontrado!";
        }
		makeForm();
		return form.replaceFirst("<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"\">", "<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\""+ resp +"\">");
	}
	
	
}
