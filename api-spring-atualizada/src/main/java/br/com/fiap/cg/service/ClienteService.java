package br.com.fiap.cg.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.cg.dto.ClienteLoginDTO;
import br.com.fiap.cg.model.Cliente;
import br.com.fiap.cg.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    
    public ClienteService(ClienteRepository clienteRepository) {
    	this.clienteRepository = clienteRepository;
    }
    
    public Page<Cliente> findAll(){
    	Pageable pageable = PageRequest.of(0, 10);
    	return clienteRepository.findAll(pageable);
    }
    
    
    public Cliente login(ClienteLoginDTO loginDto) {
        Cliente cliente = clienteRepository.findByEmail(loginDto.getEmail());
        if (cliente != null && cliente.checkSenha(loginDto.getSenha())) {
            return cliente;
        }
        return null;
    }
}
