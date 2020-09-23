package com.web.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.modelo.Noticia;

@Controller
public class HomeController {
	
	private final static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home(Model model) {
		
		String ruta = "src/main/resources/noticias.txt";
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();
		
		try {
			FileReader fr = new FileReader(ruta);
			logger.info("Archivo leído correctamente");
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();
			while (data != null) {
				String[] arreglo = data.split("@@");
				if (arreglo.length > 1) {
					Noticia noticia = new Noticia(arreglo[0], arreglo[1], arreglo[2]);
					noticias.add(noticia);
					logger.info("Noticia agregada correctamente: " + noticia.getTitulo());
				}
				data = br.readLine();
			}
			br.close();
			fr.close();
			logger.info("Proceso Terminado");
			
		} catch (Exception e) {
			logger.error("Error leyendo el fichero "+ ruta + ": "  + e);
		}
		
		model.addAttribute("noticias", noticias);
		logger.info("Redirigiendo a vista");
		return "index";
	}

}
