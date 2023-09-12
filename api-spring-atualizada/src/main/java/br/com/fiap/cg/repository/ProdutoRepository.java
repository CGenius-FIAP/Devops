package br.com.fiap.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cg.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
