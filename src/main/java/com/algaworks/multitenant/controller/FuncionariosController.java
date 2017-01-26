package com.algaworks.multitenant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.multitenant.model.Funcionario;
import com.algaworks.multitenant.repository.Funcionarios;

@Controller
@RequestMapping("/{tenantid}/funcionarios")
public class FuncionariosController {
	
	@Autowired
	private Funcionarios funcionarios;
	
	@GetMapping
	public @ResponseBody ResponseEntity<?> filtrar(String nome) {
		return ResponseEntity.ok(funcionarios.findByNome(nome != null ? nome : "%"));
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody String nome) {
		funcionarios.save(new Funcionario(nome));
		return ResponseEntity.ok().build();
	}
	
}
