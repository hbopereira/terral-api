package com.terral.resumo;

import java.math.BigDecimal;

public interface ProdutoResumo {
	Long getCod_Produto();
	Long getCod_Secao();
	Long getCod_Colaborador();
	String getDescricao_Produto();
	String getDescricao_Secao();
	String getNome();
	BigDecimal getValor();
	BigDecimal getValor_Colaborador();
	Integer getPorcentagem_Colaborador();
	Integer getQuantidade();
	Integer getTem_Estoque();
}
