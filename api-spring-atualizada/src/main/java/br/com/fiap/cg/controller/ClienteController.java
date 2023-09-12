package br.com.fiap.cg.controller;

import br.com.fiap.cg.dto.ClienteLoginDTO;
import br.com.fiap.cg.dto.ClienteUpdateDTO;
import br.com.fiap.cg.exceptions.ResourceNotFoundException;
import br.com.fiap.cg.model.Cliente;
import br.com.fiap.cg.repository.ClienteRepository;
import br.com.fiap.cg.service.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//ClienteController.java
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping("/")
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@PostMapping("/")
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@GetMapping("/{id}")
	public Cliente getClienteById(@PathVariable Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));
	}

	@PutMapping("/{id}")
	public Cliente updateCliente(@PathVariable Long id, @RequestBody ClienteUpdateDTO clienteDetails) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));

		cliente.atualizarInfo(clienteDetails);

		return clienteRepository.save(cliente);
	}

	@GetMapping("/page")
	public List<Cliente> listClientes() {
		Page<Cliente> page = clienteService.findAll();
		return page.getContent();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));

		clienteRepository.delete(cliente);

		return ResponseEntity.ok().build();
	}
	
    @PostMapping("/login")
    public ResponseEntity<Cliente> login(@RequestBody ClienteLoginDTO loginDto) {
        Cliente cliente = clienteService.login(loginDto);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.status(401).body(null);
    }
}
