package service;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import dao.PecaDAO;
import model.Peca;
import spark.Request;
import spark.Response;
import dao.PecaDAO;
import model.Peca;

public class PecaService_Compatibilidade {
	PecaDAO pecaDao = new PecaDAO();
	List<Peca> pecasComp = null;
	private String form;
	private final int FORM_UPDATE = 1;
	private final int FORM_TEST = 2;
	
	
	public void makeForm(int tipo) {
		String dropdowns = "";
		String category = "", category_ = "";
		String textoExtra = "";
		
		List<Peca> tmp = pecaDao.getOrderByCategoria();
		//texto a ser removido posteriormente
		textoExtra += "\n\t\t\t\t\t\t<input type='hidden' id='in_"+ category_ +"' name='in_"+ category_ +"' value=''>"
				  +  "\n\t\t\t\t\t</div>"
				  +  "\n\t\t\t\t</div>";
		
		
		if(tipo == FORM_UPDATE) {
			for (Peca p : tmp) {
				if(! p.getCategoria().equals(category)) {
					dropdowns += "\n\t\t\t\t\t\t<input type='hidden' id='in_"+ category_ +"' name='in_"+ category_ +"' value=''>"
							  +  "\n\t\t\t\t\t</div>"
							  +  "\n\t\t\t\t</div>";
					category = p.getCategoria();
					category_ = category.replaceAll(" ", "_");
					
					
					
					dropdowns += "\n\t\t\t\t<div class='dropdown' id = 'conteiner_"+ category_ +"'>"
							   + "\n\t\t\t\t\t<button onclick=\"showDropdown(`dwn_"+ category_ +"`)\" class='dropbtn' id='btn_"+ category_ +"'>"+ category +"</button>"
							   + "\n\t\t\t\t\t<div id='dwn_"+ category_ +"' class='dropdown-content'>"
							   + "\n\t\t\t\t\t\t<input type='text' placeholder='Pesquise " + category + "..' id='campo_pesquisa' onkeyup=\"filterFunction(`dwn_"+ category_ +"`)\">";
					
					dropdowns += "\n\t\t\t\t\t\t<a href='#' onclick=\"addVal(" + p.getId() + ",'" + category + ": " + p.getNome_componente() + "', 'in_"+ category_ +"', 'btn_"+ category_ +"', 'dwn_"+ category_ +"')\">" + p.getNome_componente() + "</a>";
					
					
				} else {
					dropdowns += "\n\t\t\t\t\t\t<a href='#' onclick=\"addVal(" + p.getId() + ",`" + category + ": " + p.getNome_componente() + "`, 'in_"+ category_ +"', 'btn_"+ category_ +"', 'dwn_"+ category_ +"')\">" + p.getNome_componente() + "</a>";
				}

				
			}
			dropdowns += "\n\t\t\t\t\t\t<input type='hidden' id='in_"+ category_ +"' name='in_"+ category_ +"' value=''>"
					  +  "\n\t\t\t\t\t</div>"
					  +  "\n\t\t\t\t</div>";
			
			dropdowns = dropdowns.replaceFirst(textoExtra, "");
		} else if(tipo == FORM_TEST) {
			for (Peca p : tmp) {
				if(! p.getCategoria().equals(category)) {
					dropdowns += "\n\t\t\t\t\t\t<input type='hidden' id='in_"+ category_ +"' name='in_"+ category_ +"' value=''>"
							  +  "\n\t\t\t\t\t</div>"
							  +  "\n\t\t\t\t</div>";
					category = p.getCategoria();
					category_ = category.replaceAll(" ", "_");
					
					
					
					dropdowns += "\n\t\t\t\t<div class='dropdown' id = 'conteiner_"+ category_ +"'>"
							   + "\n\t\t\t\t\t<button onclick=\"showDropdown(`dwn_"+ category_ +"`)\" class='dropbtn' id='btn_"+ category_ +"'>"+ category +"</button>"
							   + "\n\t\t\t\t\t<div id='dwn_"+ category_ +"' class='dropdown-content'>"
							   + "\n\t\t\t\t\t\t<input type='text' placeholder='Pesquise " + category + "..' id='campo_pesquisa' onkeyup=\"filterFunction(`dwn_"+ category_ +"`)\">";
					
					dropdowns += "\n\t\t\t\t\t\t<a href='#' onclick=\"addVal(" + p.getId() + ",'"+ p.getNome_componente() + "', 'in_"+ category_ +"', 'btn_"+ category_ +"', 'dwn_"+ category_ +"')\">" + p.getNome_componente() + "</a>";
					
					
				} else {
					dropdowns += "\n\t\t\t\t\t\t<a href='#' onclick=\"addVal(" + p.getId() + ",`"+ p.getNome_componente() + "`, 'in_"+ category_ +"', 'btn_"+ category_ +"', 'dwn_"+ category_ +"')\">" + p.getNome_componente() + "</a>";
				}

				
			}
			dropdowns += "\n\t\t\t\t\t\t<input type='hidden' id='in_"+ category_ +"' name='in_"+ category_ +"' value=''>"
					  +  "\n\t\t\t\t\t</div>"
					  +  "\n\t\t\t\t</div>";
			
			dropdowns = dropdowns.replaceFirst(textoExtra, "");
			form = form.replaceFirst("flex-direction: column;", "flex-direction: row;");
		}
		
		form = form.replaceFirst("<DROPDOWN-PECA>", dropdowns);
	}

	public String doTest(String idFonte, String idMemoria, String idPlacaVideo, String idProcessador) {
		String test = "";
		
		
		
		return test;
	}
	
	public Object update(Request request, Response response) {
		String nomeArquivo = "compatibilidade.html";
		form = "";
		try{
			Scanner entrada = new Scanner(new File(nomeArquivo));
		    while(entrada.hasNext()){
		    	form += (entrada.nextLine() + "\n");
		    }
		    entrada.close();
		}  catch (Exception e) { System.out.println(e.getMessage()); }
		makeForm(FORM_TEST);
		
		return form;
	}
	public Object test(Request request, Response response) {
		String nomeArquivo = "compatibilidade.html";
		//:idFonte/:idMemoria/:idPlacaVideo/:idPlacaMae/:idProcessador
		String idFonte = request.params(":idFonte");
		String idMemoria = request.params(":idMemoria");
		String idPlacaVideo = request.params(":idPlacaVideo");
		String idProcessador = request.params(":idProcessador");
		
		form = "";
		try{
			Scanner entrada = new Scanner(new File(nomeArquivo));
		    while(entrada.hasNext()){
		    	form += (entrada.nextLine() + "\n");
		    }
		    entrada.close();
		}  catch (Exception e) { System.out.println(e.getMessage()); }
		makeForm(FORM_TEST);
		form = form.replaceFirst("<TEST>", doTest(idFonte, idMemoria, idPlacaVideo, idProcessador));
		return form;
	}
}
