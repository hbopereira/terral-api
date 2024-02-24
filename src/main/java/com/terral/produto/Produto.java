package com.terral.produto;

import java.math.BigDecimal;

import com.terral.base.BaseEntity;
import com.terral.colaborador.Colaborador;
import com.terral.secao.Secao;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto extends BaseEntity {

	private String descricaoProduto;
	private BigDecimal valor;
	private BigDecimal valorColaborador;
	private Integer porcentagemColaborador;
	private Integer quantidade;
	private Integer temEstoque;

	@ManyToOne(optional = false)
	@JoinColumn(name = "secao_cod", referencedColumnName = "cod", nullable = false)
	private Secao secao;

	@ManyToOne(optional = false)
	@JoinColumn(name = "colaborador_cod", referencedColumnName = "cod", nullable = false)
	private Colaborador colaborador;

	public Produto() {
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricao(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
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

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Integer getPorcentagemColaborador() {
		return porcentagemColaborador;
	}

	public void setPorcentagemColaborador(Integer porcentagemColaborador) {
		this.porcentagemColaborador = porcentagemColaborador;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getTemEstoque() {
		return temEstoque;
	}

	public void setTemEstoque(Integer temEstoque) {
		this.temEstoque = temEstoque;
	}

}
