package service;

import java.util.List;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import spark.Request;
import spark.Response;

import service.PecaComp;
import dao.PecaDAO;
import model.Peca;

public class PecaService_Comparacao {
	PecaDAO pecaDao = new PecaDAO();
	private String form;
	private final int FORM_UPDATE = 1;
	private final int FORM_TEST = 2;
	
	public void makeForm(int tipo, Request request) {
		String escolhaPeca = "";
		String dropdowns = "";
		String textoExtra = "";
		String category = "", category_ = "";	
		
		escolhaPeca += "\n\t\t\t<div id='conteudo' class='container-fluid align-items-center m-2'>" 
					+  "\n\t\t\t\t<select class='form-select form-select-lg mb-3' id='Tipo_peca' aria-label='.form-select-lg example'>"
					+  "\n\t\t\t\t\t<option selected value='none'>Escolha o tipo de peça para comparar</option>";

		List<Peca> tmp = pecaDao.getOrderByCategoria();
		//texto a ser removido posteriormente 
		textoExtra += "\n\t\t\t\t\t\t<input type='hidden' id='in_"+ category_ +"' name='in_"+ category_ +"' value=''>"
				  +  "\n\t\t\t\t\t</div>"
				  +  "\n\t\t\t\t</div>";
		
			//----preencher com cada peça nos dropdowns----//
			for (Peca p : tmp) {
				if(! p.getCategoria().equals(category)) {
					dropdowns += "\n\t\t\t\t\t\t<input type='hidden' id='in_"+ category_ +"' name='in_"+ category_ +"' value=''>"
							  +  "\n\t\t\t\t\t</div>"
							  +  "\n\t\t\t\t</div>";
					category = p.getCategoria();
					category_ = category.replaceAll(" ", "_");
					
					
					
					dropdowns += "\n\t\t\t\t<div class='dropdown' id = 'conteiner_"+ category_ +"' style='display: none;'>"
							   + "\n\t\t\t\t\t<button onclick=\"showDropdown(`dwn_"+ category_ +"`)\" class='dropbtn' id='btn_"+ category_ +"'>"+ category +"</button>"
							   + "\n\t\t\t\t\t<div id='dwn_"+ category_ +"' class='dropdown-content'>"
							   + "\n\t\t\t\t\t\t<input type='text' placeholder='Pesquise " + category + "..' id='campo_pesquisa' class='pesquisa' onkeyup=\"filterFunction(`dwn_"+ category_ +"`)\">";
					
					dropdowns += "\n\t\t\t\t\t\t<a href='#' onclick=\"addVal(" + p.getId() + ",'" + category + ": " + p.getNome_componente() + "', 'in_"+ category_ +"', 'btn_"+ category_ +"', 'dwn_"+ category_ +"')\">" + p.getNome_componente() + "</a>";
					
					escolhaPeca +=  "\n\t\t\t\t\t <option value='" + category_ + "'>" + category + "</option>";
				} else {
					dropdowns += "\n\t\t\t\t\t\t<a href='#' onclick=\"addVal(" + p.getId() + ",`" + category + ": " + p.getNome_componente() + "`, 'in_"+ category_ +"', 'btn_"+ category_ +"', 'dwn_"+ category_ +"')\">" + p.getNome_componente() + "</a>";
				}

				
			}
			dropdowns += "\n\t\t\t\t\t\t<input type='hidden' id='in_"+ category_ +"' name='in_"+ category_ +"' value=''>"
					  +  "\n\t\t\t\t\t</div>"
					  +  "\n\t\t\t\t</div>";
			
			escolhaPeca += "\n\t\t\t\t</select>"
						+  "\n\t\t\t</div>"; 
			
		
		
		if(tipo == FORM_TEST) {
			String test = "";
			int id1 = Integer.parseInt(request.params(":id1"));
			int id2 = Integer.parseInt(request.params(":id2"));
			PecaComp cp = new PecaComp();
			test += cp.Comparacao(id1, id2);
			form = form.replaceFirst("<TESTE>", test);
		}
		
		//excluir texto que sobrar no início inutilizado 
		dropdowns = dropdowns.replaceFirst(textoExtra, "");
		form = form.replaceFirst("<ESCOLHA>", escolhaPeca);
		String dropdowns1 = dropdowns.replaceAll("conteiner_", "conteiner1_").replaceAll("dwn_", "dwn1_").replaceAll("in_", "in1_").replaceAll("btn_", "btn1_");
		form = form.replaceFirst("<DROPDOWNS>", dropdowns + dropdowns1);
	}
	
	public Object update(Request request, Response response) {
		String nomeArquivo = "comparacao.html";
		
		//leitura do html inicial
		form = "";
		try{
			Scanner entrada = new Scanner(new File(nomeArquivo));
		    while(entrada.hasNext()){
		    	form += (entrada.nextLine() + "\n");
		    }
		    entrada.close();
		}  catch (Exception e) { System.out.println(e.getMessage()); }
		
		//modificação da string que possui o html
		makeForm(FORM_UPDATE, request);
		
		return form;
	}
	
	public Object test(Request request, Response response) {
		String nomeArquivo = "comparacao.html";
		
		//leitura do html inicial
		form = "";
		try{
			Scanner entrada = new Scanner(new File(nomeArquivo));
		    while(entrada.hasNext()){
		    	form += (entrada.nextLine() + "\n");
		    }
		    entrada.close();
		}  catch (Exception e) { System.out.println(e.getMessage()); }
		
		//modificação da string que possui o html
		makeForm(FORM_TEST, request);
		
		return form;
	}
	
}
