package app;
import service.PecaComp_old;
import service.PecaService_Cadastro;
import service.PecaService_Compatibilidade;
import service.Template;


import static spark.Spark.*;

import java.io.File;
import java.util.Scanner;



public class Aplicacao {
	private static PecaService_Cadastro Psc= new PecaService_Cadastro();
	private static PecaService_Compatibilidade PsC1= new PecaService_Compatibilidade();
	private static Template template= new Template();
	
	private static PecaComp_old pecaComp = new PecaComp_old();
	
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
		
		 // Substitua 1 e 2 pelos idsde peças válidos no seu banco de dados
	       pecaComp.Comparacao(1, 2);
	       System.out.println("\n---------");
	       pecaComp.Comparacao(6, 7);
	       System.out.println("\n---------");
	       pecaComp.Comparacao(19, 20);
	       System.out.println("\n---------");
	       pecaComp.CompatibilidadeProcessadorMotherBoard(1, 11);
	       System.out.println("\n---------");
	       pecaComp.CompatibilidadeProcessadorMotherBoard(2, 11);
	       System.out.println("\n---------");
	       pecaComp.Compatibilidade(1, 7, 11);
	       System.out.println("\n---------");
	       pecaComp.Compatibilidade(2, 6, 13);
	       System.out.println("\n---------");
	       pecaComp.Compatibilidade(1, 16, 11);
	       System.out.println("\n---------");
	       pecaComp.Compatibilidade(1, 7, 24);
	}
}

