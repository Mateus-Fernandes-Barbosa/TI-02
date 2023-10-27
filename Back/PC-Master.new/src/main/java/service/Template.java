package service;

import java.io.File;
import java.util.Scanner;

import spark.Request;
import spark.Response;

public class Template {
	public Object update(Request request, Response response) {
		String nomeArquivo = "inicio.html";
		String form = "";
		try{
			Scanner entrada = new Scanner(new File(nomeArquivo));
		    while(entrada.hasNext()){
		    	form += (entrada.nextLine() + "\n");
		    }
		    entrada.close();
		}  catch (Exception e) { System.out.println(e.getMessage()); }
		return form;
	}
}
