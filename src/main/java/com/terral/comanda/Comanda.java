package com.terral.comanda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.terral.base.BaseEntity;
import com.terral.colaborador.Colaborador;
import com.terral.itemcomanda.ItemComanda;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "comanda")
public class Comanda extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date dataComanda;

	@Enumerated(EnumType.STRING)
	private StatusComanda status;

	@Enumerated(EnumType.STRING)
	private FormaPagamentoComanda formaPagamento;

	private BigDecimal valorTotal;
	private BigDecimal percentualDesconto;
	private BigDecimal valorVendedor;
	private BigDecimal taxa;
	private String nomeCliente;

	@ManyToOne(optional = true)
	@JoinColumn(name = "vendedor_cod", referencedColumnName = "cod", nullable = false)
	private Colaborador vendedor;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comanda", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties(value = { "comanda" }, allowSetters = true)
	private List<ItemComanda> itens;

	public Comanda() {
		this.itens = new ArrayList<ItemComanda>();
	}

	public Date getDataComanda() {
		return dataComanda;
	}

	public void setDataComanda(Date dataComanda) {
		this.dataComanda = dataComanda;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public FormaPagamentoComanda getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoComanda formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Colaborador getVendedor() {
		return vendedor;
	}

	public void setVendedor(Colaborador vendedor) {
		this.vendedor = vendedor;
	}

	public List<ItemComanda> getItens() {
		return itens;
	}

	public void setItens(List<ItemComanda> itens) {
		this.itens = itens;
	}

	public StatusComanda getStatus() {
		return status;
	}

	public void setStatus(StatusComanda status) {
		this.status = status;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public BigDecimal getValorVendedor() {
		return valorVendedor;
	}

	public void setValorVendedor(BigDecimal valorVendedor) {
		this.valorVendedor = valorVendedor;
	}

}
