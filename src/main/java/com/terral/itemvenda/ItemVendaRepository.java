package com.terral.itemvenda;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.terral.base.BaseRepository;
import com.terral.resumo.ItemVendaResumo;

@Repository
public interface ItemVendaRepository extends BaseRepository<ItemVenda>{
	
	@Query(value = "SELECT i.descricao, i.valor_colaborador as valorColaborador, "
			+ "i.quantidade, i.porcentagem_colaborador as porcentagemColaborador, "
			+ "v.data_venda as dataVenda , i.valor, cc.nome as nomeVendedor,"
			+ "v.forma_pagamento as formaPagamento FROM item_venda i "
			+ "INNER JOIN venda v on v.cod = i.venda_cod "
			+ "INNER JOIN produto p ON p.cod = i.cod_produto "
			+ "INNER JOIN colaborador c ON c.cod = p.colaborador_cod "
			+ "INNER JOIN colaborador cc on cc.cod = v.vendedor_cod "
			+ "WHERE (:codVendedor IS NULL OR c.cod =:codVendedor) "
			+ "AND v.data_venda BETWEEN :dataInicial AND :dataFinal ", nativeQuery = true)
	public List<ItemVendaResumo> listarDadosRelatorioProdutoColaborador(@Param("dataInicial") Date dataInicial,
			@Param("dataFinal") Date dataFinal, @Param("codVendedor") Long codVendedor);
	
}
