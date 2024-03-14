package com.terral.itemcomanda;

import java.io.Serializable;
import java.math.BigDecimal;

import com.terral.base.BaseEntity;
import com.terral.comanda.Comanda;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_comanda")
public class ItemComanda extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private BigDecimal valor;
	private BigDecimal valorColaborador;
	private Integer quantidade;
	private Integer quantidadeGramas;
	private Integer codProduto;
	private Integer porcentagemColaborador;
	private String nomeColaborador;
	private String codRandom;
	private Boolean usaGramas;
	
	

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "comanda_cod")
	private Comanda comanda;

	public ItemComanda() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorColaborador() {
		return valorColaborador;
	}

	public void setValorColaborador(BigDecimal valorColaborador) {
		this.valorColaborador = valorColaborador;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	public Integer getPorcentagemColaborador() {
		return porcentagemColaborador;
	}

	public void setPorcentagemColaborador(Integer porcentagemColaborador) {
		this.porcentagemColaborador = porcentagemColaborador;
	}

	public String getNomeColaborador() {
		return nomeColaborador;
	}

	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}

	public Integer getQuantidadeGramas() {
		return quantidadeGramas;
	}

	public void setQuantidadeGramas(Integer quantidadeGramas) {
		this.quantidadeGramas = quantidadeGramas;
	}

	public Boolean getUsaGramas() {
		return usaGramas;
	}

	public void setUsaGramas(Boolean usaGramas) {
		this.usaGramas = usaGramas;
	}

	public String getCodRandom() {
		return codRandom;
	}

	public void setCodRandom(String codRandom) {
		this.codRandom = codRandom;
	}
	
	
	
	

}
