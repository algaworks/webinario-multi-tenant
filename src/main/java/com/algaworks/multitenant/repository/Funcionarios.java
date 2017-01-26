package com.algaworks.multitenant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.algaworks.multitenant.model.Funcionario;

public interface Funcionarios extends JpaRepository<Funcionario, Long> {

	@Query("select f from Funcionario f where f.nome like ?1%")
	public List<Funcionario> findByNome(String nome);
	
}
