package app;
import service.PecaService_Cadastro;
import service.PecaService_Compatibilidade;
import service.PecaService_Comparacao;
import service.Template;


import static spark.Spark.*;

import java.io.File;
import java.util.Scanner;



public class Aplicacao {
	private static PecaService_Cadastro Psc= new PecaService_Cadastro();
	private static PecaService_Compatibilidade PsC1= new PecaService_Compatibilidade();
	private static PecaService_Comparacao PsC2= new PecaService_Comparacao();
	private static Template template= new Template();
	
	public  static void main(String args[]) {
		port(6789);
		staticFiles.location("/public");
		get("/inicio", (request, response) -> template.update(request, response));
		get("/produto/list/:orderby/:category", (request, response) -> Psc.getCategory(request, response));
		get("/produto/update/:id", (request, response) -> Psc.getToUpdate(request, response));
		get("/produto/:id", (request, response) -> Psc.get(request, response));
		post("/produto/update/:id", (request, response) -> Psc.update(request, response));
		post("/produto/insert", (request, response) -> Psc.insert(request, response));
		get("/produto/delete/:id", (request, response) -> Psc.delete(request, response));
		get("/compatibilidade", (request, response) -> PsC1.update(request, response));
		get("/compatibilidade/:idFonte/:idMemoria/:idPlacaVideo/:idPlacaMae/:idProcessador", (request, response) -> PsC1.test(request, response) );
		get("/comparacao", (request, response) -> PsC2.update(request, response));
		get("/comparacao/:id1/:id2", (request, response) -> PsC2.test(request, response));
	}
}

