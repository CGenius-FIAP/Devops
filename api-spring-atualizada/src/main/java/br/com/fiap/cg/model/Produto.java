package br.com.fiap.cg.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity(name = "PRODUTO")
@Table(name = "TB_PRODUTO")
public class Produto extends Auditavel {

	@Id
	@SequenceGenerator(name = "SQ_PRODUTO", sequenceName = "SQ_PRODUTO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
	@Column(name = "ID_PRODUTO")
	private Long idProduto;

	@NotNull
	@Column(name = "NOME")
	private String nome;

	@NotNull
	@Column(name = "DESCRICAO")
	private String descricao;

	@NotNull
	@Min(1)
	@Column(name = "PRECO")
	private Double preco;

	@ManyToOne
	@JoinColumn(name = "ID_EMPRESA")
	private Empresa empresa;

	@OneToMany(mappedBy = "produtoEntity", cascade = CascadeType.ALL)
	private List<Feedback> feedbacks;

	public Produto() {
	}

	public String getNome() {
		return nome;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Produto setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getDescricao() {
		return descricao;
	}

	public Produto setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public Double getPreco() {
		return preco;
	}

	public Produto setPreco(Double preco) {
		this.preco = preco;
		return this;
	}
}
