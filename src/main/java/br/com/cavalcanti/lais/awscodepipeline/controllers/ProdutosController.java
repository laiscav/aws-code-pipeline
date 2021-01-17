package br.com.cavalcanti.lais.awscodepipeline.controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller()
@RequestMapping("/produtos")
public class ProdutosController {

	private List<String> produtos = Arrays.asList("Secador com cone", "Batom", "Maquiagem", "Mina", "Loucura");

	@GetMapping()
	public String helloWorld(Model model, @Param("nome") String nome) {
		if(nome != null && !nome.equals("")) {
			model.addAttribute("produtos", produtos.stream().filter(prod -> prod.toLowerCase(Locale.ROOT).contains(nome.toLowerCase(Locale.ROOT))).collect(Collectors.toList()));
			model.addAttribute("nome", nome);
		} else {
			model.addAttribute("produtos", produtos);
		}
		return "produtos";
	}
	
}
