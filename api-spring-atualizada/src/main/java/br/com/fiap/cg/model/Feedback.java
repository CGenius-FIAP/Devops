package br.com.fiap.cg.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity(name = "FEEDBACK")
@Table(name = "TB_FEEDBACK")
public class Feedback {

	@Id
	@SequenceGenerator(name = "SQ_FEEDBACK", sequenceName = "SQ_FEEDBACK", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FEEDBACK")
	@Column(name = "ID_FEEDBACK")
	private Long id;

	@NotNull
	@Min(1)
	@Max(5)
	@Column(name = "AVALIACAO_PRODUTO")
	private Double qualidadeProduto;

	@NotNull
	@Min(1)
	@Max(5)
	@Column(name = "AVALIACAO_ATENDIMENTO")
	private Double atendimento;

	@NotNull
	@Min(1)
	@Max(5)
	@Column(name = "AVALIACAO_PRECO")
	private Double preco;

	@Column(name = "COMENTARIO")
	private String comentario;

	@NotNull
	@Column(name = "RECOMENDA_PRODUTO")
	private Boolean recomendacao;

	@ManyToOne
	@JoinColumn(name = "ID_PRODUTO")
	private Produto produtoEntity;

	
	
	public Feedback() {
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQualidadeProduto() {
		return qualidadeProduto;
	}

	public void setQualidadeProduto(Double qualidadeProduto) {
		this.qualidadeProduto = qualidadeProduto;
	}

	public Double getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Double atendimento) {
		this.atendimento = atendimento;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Boolean getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(Boolean recomendacao) {
		this.recomendacao = recomendacao;
	}

	public Produto getProdutoEntity() {
		return produtoEntity;
	}

	public void setProdutoEntity(Produto produtoEntity) {
		this.produtoEntity = produtoEntity;
	}

}
