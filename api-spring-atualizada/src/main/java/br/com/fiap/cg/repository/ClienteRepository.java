package br.com.fiap.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cg.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByEmail(String email);
	
}
