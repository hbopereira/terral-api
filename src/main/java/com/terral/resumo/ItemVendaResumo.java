package com.terral.resumo;

import java.math.BigDecimal;
import java.util.Date;

public interface ItemVendaResumo {

	String getDescricao();
	BigDecimal getValorColaborador();
	Integer getQuantidade();
	Integer getPorcentagemColaborador();
	Date getDataVenda();
	BigDecimal getValor();
	String getNomeVendedor();
	String getFormaPagamento();
}
