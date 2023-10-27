package app;
import service.PecaComp;
import service.PecaService;
import service.Template;


import static spark.Spark.*;

import java.io.File;
import java.util.Scanner;



public class Aplicacao {
	private static PecaService Ps= new PecaService();
	private static Template template= new Template();
	
	private static PecaComp pecaComp = new PecaComp();
	
	public  static void main(String args[]) {
		port(6789);
		staticFiles.location("/public");
		get("/inicio", (request, response) -> template.update(request, response));
		get("/produto/list/:orderby/:category", (request, response) -> Ps.getCategory(request, response));
		get("/produto/update/:id", (request, response) -> Ps.getToUpdate(request, response));
		get("/produto/:id", (request, response) -> Ps.get(request, response));
		post("/produto/update/:id", (request, response) -> Ps.update(request, response));
		post("/produto/insert", (request, response) -> Ps.insert(request, response));
		get("/produto/delete/:id", (request, response) -> Ps.delete(request, response));
		
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

