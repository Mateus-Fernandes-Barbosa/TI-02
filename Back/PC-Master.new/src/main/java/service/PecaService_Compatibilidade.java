package service;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import dao.PecaDAO;
import service.PecaComp;
import model.Peca;
import spark.Request;
import spark.Response;

public class PecaService_Compatibilidade {
	PecaDAO pecaDao = new PecaDAO();
	List<Peca> pecasComp = null;
	private String form;
	private final int FORM_UPDATE = 1;
	private final int FORM_TEST = 2;
	
	//---Funcao para montar os botões com as peças que podem ser escolhidas---//
	public void makeForm(int tipo, Request request) {
		String dropdowns = "";
		String category = "", category_ = "";
		String textoExtra = "";
		
		List<Peca> tmp = pecaDao.getOrderByCategoria();
		//texto a ser removido posteriormente 
		textoExtra += "\n\t\t\t\t\t\t<input type='hidden' id='in_"+ category_ +"' name='in_"+ category_ +"' value=''>"
				  +  "\n\t\t\t\t\t</div>"
				  +  "\n\t\t\t\t</div>";
		
		
		if(tipo == FORM_UPDATE) {
			//----preencher com cada peça nos dropdowns----//
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
			
			//excluir texto que sobrar no início inutilizado 
			dropdowns = dropdowns.replaceFirst(textoExtra, "");
		} else if(tipo == FORM_TEST) {
			//----preencher com cada peça nos dropdowns----//
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
			
			//excluir texto que sobrar no início inutilizado 
			dropdowns = dropdowns.replaceFirst(textoExtra, "");
			
			//----alterar os resultados do teste----//
			
			//Armazenar parametros da url
			String idFonte = request.params(":idFonte");
			String idMemoria = request.params(":idMemoria");
			String idPlacaVideo = request.params(":idPlacaVideo");
			String idProcessador = request.params(":idProcessador");
			String idPlacaMae = request.params(":idPlacaMae");
			//Executar os testes e atualizar o form
			String test = "";
			PecaComp pc = new PecaComp();
			System.out.println(idProcessador);
			System.out.println(idPlacaMae);
			
			test += "<br>";
			if(idProcessador.contains("O") || idPlacaMae.contains("O")) {
				test += "<p>Não possivel verificar compatibilidade entre processador e Placa Mãe devido à"+
						" uma das peças informadas estar incorreto. <br>Escolha peças válidas e realize o teste novamente </p>";
			} else {
				test += pc.CompatibilidadeProcessadorMotherBoard(Integer.parseInt(idProcessador), Integer.parseInt(idPlacaMae));
			}
			test += "<p><b>---------------------------------------------------------------------------------------------------------------</b></p>";
			
			if(idProcessador.contains("O") || idPlacaVideo.contains("O") || idPlacaMae.contains("O")) {
				test += "<p>Não possivel verificar compatibilidade entre processador, Placa de Vídeo e Placa Mãe devido à"+
						" uma das peças informadas estar incorreto. <br>Escolha peças válidas e realize o teste novamente </p>";
			} else {
				test += pc.Compatibilidade(Integer.parseInt(idProcessador), Integer.parseInt(idPlacaVideo), Integer.parseInt(idPlacaMae));
			}
			test += "<p><b>---------------------------------------------------------------------------------------------------------------</b></p>";
			
			if(idProcessador.contains("O") || idMemoria.contains("O") || idPlacaMae.contains("O")) {
				test += "<p>Não possivel verificar compatibilidade entre processador, Memória RAM e Placa Mãe devido à"+
						" uma das peças informadas estar incorreto. <br>Escolha peças válidas e realize o teste novamente </p>";
			} else {
				test += pc.Compatibilidade(Integer.parseInt(idProcessador), Integer.parseInt(idMemoria), Integer.parseInt(idPlacaMae));
			}
			test += "<p><b>---------------------------------------------------------------------------------------------------------------</b></p>";
			
			if(idProcessador.contains("O") || idPlacaVideo.contains("O") || idFonte.contains("O")) {
				test += "<p>Não possivel verificar compatibilidade entre processador, Placa de Vídeo e Fonte devido à"+
						" uma das peças informadas estar incorreto. <br>Escolha peças válidas e realize o teste novamente </p>";
			} else {
				test += pc.Compatibilidade(Integer.parseInt(idProcessador), Integer.parseInt(idPlacaVideo), Integer.parseInt(idFonte));
			}
			test += "<p><b>---------------------------------------------------------------------------------------------------------------</b></p>";
			form = form.replaceFirst("<TEST>", test);
		}
		
		//Substituir pelos dropdowns montados anteriormente
		form = form.replaceFirst("<DROPDOWN-PECA>", dropdowns);
	}
	
	public Object update(Request request, Response response) {
		String nomeArquivo = "compatibilidade.html";
		
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
		String nomeArquivo = "compatibilidade.html";
		
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
