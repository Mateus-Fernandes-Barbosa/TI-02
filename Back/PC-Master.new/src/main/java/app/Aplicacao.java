package app;
import service.PecaService;
import service.inicioService;

import static spark.Spark.*;

import java.io.File;
import java.util.Scanner;



public class Aplicacao {
	private static PecaService Ps= new PecaService();
	private static inicioService Is= new inicioService();
	
	public  static void main(String args[]) {
		port(6789);
		staticFiles.location("/public");
		get("/inicio", (request, response) -> Is.update(request, response));
		get("/produto/list/:orderby/:category", (request, response) -> Ps.getCategory(request, response));
		get("/produto/update/:id", (request, response) -> Ps.getToUpdate(request, response));
		get("/produto/:id", (request, response) -> Ps.get(request, response));
		post("/produto/update/:id", (request, response) -> Ps.update(request, response));
		post("/produto/insert", (request, response) -> Ps.insert(request, response));
		get("/produto/delete/:id", (request, response) -> Ps.delete(request, response));
	}
}
