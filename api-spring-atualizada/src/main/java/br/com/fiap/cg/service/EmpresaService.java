package br.com.fiap.cg.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.fiap.cg.dto.EmpresaLoginDTO;
import br.com.fiap.cg.model.Empresa;
import br.com.fiap.cg.repository.EmpresaRepository;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Page<Empresa> findAll() {
        Pageable pageable = PageRequest.of(0, 10);
        return empresaRepository.findAll(pageable);
    }

    public Empresa login(EmpresaLoginDTO loginDto) {
        Empresa empresa = empresaRepository.findByEmail(loginDto.getEmail());
        if (empresa != null && empresa.checkSenha(loginDto.getSenha())) {
            return empresa;
        }
        return null;
    }
}
