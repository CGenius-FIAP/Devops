package br.com.fiap.cg.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmpresaUpdateDTO {

	@Size(min = 2, max = 200, message = "O nome deve ter entre 2 e 200 caracteres")
	private String nome;

	@Size(max = 200, message = "O endereço não deve exceder 200 caracteres")
	private String endereco;

	private String telefone;

	@Pattern(regexp = "^[0-9]{14}$", message = "CNPJ deve conter exatamente 14 dígitos.")
	private String CNPJ;

	@Email(message = "Forneça um e-mail válido")
	private String email;

	public boolean isValid() {
		boolean valid = true;

		if (telefone != null && (!telefone.matches("[0-9]+") || telefone.length() != 10)) {
			valid = false;
		}
		if (nome != null && (nome.length() < 2 || nome.length() > 200)) {
			valid = false;
		}
		if (endereco != null && endereco.length() > 200) {
			valid = false;
		}
        if (CNPJ != null && (!CNPJ.matches("[0-9]+") || CNPJ.length() != 14)) {
            valid = false;
        }

		return valid;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
