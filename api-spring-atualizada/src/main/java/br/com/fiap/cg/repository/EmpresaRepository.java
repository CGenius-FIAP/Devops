package br.com.fiap.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cg.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	Empresa findByEmail(String email);
}
