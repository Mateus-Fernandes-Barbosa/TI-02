package app;
import service.PecaService;

import static spark.Spark.*;

import java.io.File;
import java.util.Scanner;



public class Aplicacao {
	private static PecaService Ps= new PecaService();
	
	public  static void main(String args[]) {
		port(6789);
		staticFiles.location("/public");
		

		get("produto/list/:orderby/:category", (request, response) -> Ps.getCategory(request, response));
		get("/produto/update/:id", (request, response) -> Ps.getToUpdate(request, response));
		//post("/produto/update/:id", (request, response) -> produtoService.update(request, response));
	}
}
