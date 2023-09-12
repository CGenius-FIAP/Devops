package br.com.fiap.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cg.dto.EmpresaLoginDTO;
import br.com.fiap.cg.dto.EmpresaUpdateDTO;
import br.com.fiap.cg.exceptions.ResourceNotFoundException;
import br.com.fiap.cg.model.Empresa;
import br.com.fiap.cg.repository.EmpresaRepository;
import br.com.fiap.cg.service.EmpresaService;

//EmpresaController.java
@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;

	private final EmpresaService empresaService;

	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	@GetMapping("/")
	public List<Empresa> getAllEmpresas() {
		return empresaService.findAll().getContent();
	}

	@PostMapping("/")
	public Empresa createEmpresa(@RequestBody Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@GetMapping("/{id}")
	public Empresa getEmpresaById(@PathVariable Long id) {
		return empresaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empresa", "id", id));
	}

	@PutMapping("/{id}")
	public Empresa updateEmpresa(@PathVariable Long id, @RequestBody EmpresaUpdateDTO empresaDetails) {
		Empresa empresa = empresaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empresa", "id", id));

		empresa.atualizarInfo(empresaDetails);

		return empresaRepository.save(empresa);
	}

	@GetMapping("/page")
	public List<Empresa> listEmpresas() {
		Page<Empresa> page = empresaService.findAll();
		return page.getContent();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmpresa(@PathVariable Long id) {
		Empresa empresa = empresaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empresa", "id", id));
		empresaRepository.delete(empresa);
		return ResponseEntity.ok().build();
	}
	
    @PostMapping("/login")
    public ResponseEntity<Empresa> login(@RequestBody EmpresaLoginDTO loginDto) {
        Empresa empresa = empresaService.login(loginDto);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        }
        return ResponseEntity.status(401).body(null);
    }
}
