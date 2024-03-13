package com.terral.itemvenda;

import java.io.Serializable;
import java.math.BigDecimal;

import com.terral.base.BaseEntity;
import com.terral.venda.Venda;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_venda")
public class ItemVenda extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private BigDecimal valor;
	private BigDecimal valorColaborador;
	private Integer quantidade;
	private Integer quantidadeGramas;
	private Integer codProduto;
	private String nomeColaborador;
	private Integer porcentagemColaborador;
	private Boolean pago;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "venda_cod")
	private Venda venda;

	public ItemVenda() {

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

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Venda getVenda() {
		return venda;
	}

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	public String getNomeColaborador() {
		return nomeColaborador;
	}

	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}

	public Integer getPorcentagemColaborador() {
		return porcentagemColaborador;
	}

	public void setPorcentagemColaborador(Integer porcentagemColaborador) {
		this.porcentagemColaborador = porcentagemColaborador;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public Integer getQuantidadeGramas() {
		return quantidadeGramas;
	}

	public void setQuantidadeGramas(Integer quantidadeGramas) {
		this.quantidadeGramas = quantidadeGramas;
	}

}
