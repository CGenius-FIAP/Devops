package br.com.fiap.cg.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.fiap.cg.dto.ClienteUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


/**
 * Classe modelo para representar um Cliente no sistema.
 */
@Entity(name = "CLIENTE")
@Table(name = "TB_CLIENTE")
public class Cliente extends Auditavel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CLIENTE")
	@SequenceGenerator(name = "SQ_CLIENTE", sequenceName = "SQ_CLIENTE", allocationSize = 1, initialValue = 1)
	@Column(name = "ID_PESSOA")
	private Long id;

	@NotNull
	@Size(min = 2, max = 50)
	@Column(name = "NOME")
	private String nome;

	@NotNull
	@Column(name = "ENDERECO")
	private String endereco;

	@NotNull
	@Column(name = "TELEFONE")
	private String telefone;

	@NotNull
	@Email
	@Column(name = "EMAIL")
	private String email;
	
    @NotNull
    @Pattern(regexp = "^[0-9]{11}$", message = "CPF deve conter exatamente 11 dígitos.")
    @Column(name = "CPF")
    private String CPF;

	// ---------------------------------------- //
	
	@NotNull
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

	public void atualizarInfo(ClienteUpdateDTO dados) {
	    if (dados.getNome() != null) {
	        this.nome = dados.getNome();
	    }
	    if (dados.getEndereco() != null) {
	        this.endereco = dados.getEndereco();
	    }
	    if (dados.getTelefone() != null) {
	        this.telefone = dados.getTelefone();
	    }
	    if (dados.getEmail() != null) {
	        this.email = dados.getEmail();
	    }
	    if (dados.getCPF() != null) {
	        this.CPF = dados.getCPF();
	    }
	}

	

	

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getSenha() {
		return senha;
	}

	public Long getId() {
		return id;
	}

	public Cliente setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Cliente setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getEndereco() {
		return endereco;
	}

	public Cliente setEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	public String getTelefone() {
		return telefone;
	}

	public Cliente setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Cliente setEmail(String email) {
		this.email = email;
		return this;
	}

}
