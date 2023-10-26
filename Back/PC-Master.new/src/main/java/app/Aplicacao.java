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
		get("produto", (request, response) -> Ps.basic(request, response));
		get("produto/list/:orderby", (request, response) -> Ps.getAll(request, response));
		get("produto/list/:orderby/:category", (request, response) -> Ps.getAll(request, response));
		
		
	}
}
