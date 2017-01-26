package com.algaworks.multitenant.init;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.multitenant.model.Funcionario;
import com.algaworks.multitenant.repository.Funcionarios;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InicializarFuncionario {

	@Autowired
	private Funcionarios funcionarios;
	
	@EventListener
	public void inicializar(ApplicationReadyEvent event) {
		Funcionario mariaSilva = new Funcionario("Maria Silva", "apple");
		Funcionario pedroRicardo = new Funcionario("Pedro Ricardo", "apple");
		
		Funcionario joaoSantos = new Funcionario("João Santos", "samsung");
		Funcionario mariaPereira = new Funcionario("Maria Pereira", "samsung");
		
		funcionarios.save(Arrays.asList(mariaSilva, pedroRicardo, joaoSantos, mariaPereira));
	}
	
}
