package br.com.fiap.cg.model;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.fiap.cg.dto.EmpresaUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Classe modelo para representar uma Empresa no sistema.
 */
@Entity(name = "EMPRESA")
@Table(name = "TB_EMPRESA")
public class Empresa extends Auditavel {

	@Id
	@SequenceGenerator(name = "SQ_EMPRESA", sequenceName = "SQ_EMPRESA", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EMPRESA")
	private Long id;

	@NotNull
	@Column(name = "EMPRESA")
	private String nome;

	@NotNull
	@Column(name = "ENDERECO")
	private String endereco;

	@NotNull
	@Column(name = "TELEFONE")
	private String telefone;

    @NotNull
    @Pattern(regexp = "^[0-9]{14}$", message = "CNPJ deve conter exatamente 14 dígitos.")
    @Column(name = "CNPJ")
    private String CNPJ;

	@NotNull
	@Email
	@Column(name = "EMAIL")
	private String email;

	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Produto> produtos;

	// ---------------------------------------- //
	
	@Column(name = "SENHA")
	private String senha;

	public void setSenha(String senha) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.senha = passwordEncoder.encode(senha);
	}

	public boolean checkSenha(String senha) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(senha, this.senha);
	}
	
	// ---------------------------------------- //

	public void atualizarInfo(EmpresaUpdateDTO dados) {
		if(dados.getNome() != null) {
			this.nome = dados.getNome();
		}
		if(dados.getTelefone() != null) {
			this.telefone = dados.getTelefone();
		}
		if(dados.getEndereco() != null) {
			this.endereco = dados.getEndereco();
		}
		if(dados.getCNPJ() != null) {
			this.CNPJ = dados.getCNPJ();
		}
		if(dados.getEmail() != null) {
			this.email = dados.getEmail();
		}
	}
	
	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getSenha() {
		return senha;
	}

	public Long getId() {
		return id;
	}

	public Empresa setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Empresa setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getEndereco() {
		return endereco;
	}

	public Empresa setEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	public String getTelefone() {
		return telefone;
	}

	public Empresa setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Empresa setEmail(String email) {
		this.email = email;
		return this;
	}

}
