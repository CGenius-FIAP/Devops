package br.com.fiap.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cg.exceptions.ResourceNotFoundException;
import br.com.fiap.cg.model.Produto;
import br.com.fiap.cg.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/")
	public List<Produto> getAllProdutos() {
		return produtoRepository.findAll();
	}

	@PostMapping("/")
	public Produto createProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@GetMapping("/{id}")
	public Produto getProdutoById(@PathVariable Long id) {
		return produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto", "id", id));
	}

	@PutMapping("/{id}")
	public Produto updateProduto(@PathVariable Long id, @RequestBody Produto produtoDetails) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto", "id", id));

		produto.setNome(produtoDetails.getNome());

		return produtoRepository.save(produto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduto(@PathVariable Long id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto", "id", id));

		produtoRepository.delete(produto);

		return ResponseEntity.ok().build();
	}
}
