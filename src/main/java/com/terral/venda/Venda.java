package com.terral.venda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.terral.base.BaseEntity;
import com.terral.colaborador.Colaborador;
import com.terral.itemvenda.ItemVenda;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "venda")
public class Venda extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date dataVenda;

	private BigDecimal valorTotal;
	private BigDecimal percentualDesconto;
	private BigDecimal taxa;
	private BigDecimal valorVendedor;
	private String formaPagamento;
	private String nomeCliente;

	@ManyToOne(optional = false)
	@JoinColumn(name = "vendedor_cod", referencedColumnName = "cod", nullable = false)
	private Colaborador vendedor;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venda", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties(value = { "venda" }, allowSetters = true)
	private List<ItemVenda> itens;

	public Venda() {
		this.itens = new ArrayList<ItemVenda>();
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Colaborador getVendedor() {
		return vendedor;
	}

	public void setVendedor(Colaborador vendedor) {
		this.vendedor = vendedor;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValorVendedor() {
		return valorVendedor;
	}

	public void setValorVendedor(BigDecimal valorVendedor) {
		this.valorVendedor = valorVendedor;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

}
