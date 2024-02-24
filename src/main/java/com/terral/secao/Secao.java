package com.terral.secao;

import com.terral.base.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "secao")
public class Secao extends BaseEntity {

	private String descricaoSecao;

	public Secao() {

	}

	public String getDescricaoSecao() {
		return descricaoSecao;
	}

	public void setDescricao(String descricaoSecao) {
		this.descricaoSecao = descricaoSecao;
	}

}
