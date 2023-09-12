package br.com.fiap.cg.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * Esta classe serve como uma superclasse mapeada para adicionar campos de auditoria
 * como 'createdAt' e 'updatedAt' às entidades que a estendem.
 */
@MappedSuperclass
public abstract class Auditavel {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    
    
    /**
     * Método chamado antes da persistência de uma nova entidade.
     * Define o campo 'createdAt'.
     */
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    /**
     * Método chamado antes de atualizar uma entidade existente.
     * Define o campo 'updatedAt'.
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
}
