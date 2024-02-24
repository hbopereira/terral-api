package com.terral.venda;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.terral.base.BaseRepository;


@Repository
public interface VendaRepository extends BaseRepository<Venda> {

	@Query(value = "SELECT v FROM Venda v WHERE (:codVendedor IS NULL OR v.vendedor.cod =:codVendedor) AND v.dataVenda BETWEEN :dataInicial AND :dataFinal ")
	public List<Venda> listarPorDataEVendedor(@Param("dataInicial") Date dataInicial,
			@Param("dataFinal") Date dataFinal, @Param("codVendedor") Long codVendedor);


}
