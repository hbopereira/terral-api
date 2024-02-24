package com.terral.comanda;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.terral.base.BaseRepository;

@Repository
public interface ComandaRepository extends BaseRepository<Comanda> {

	@Query(value = "SELECT c FROM Comanda c WHERE (:codVendedor IS NULL OR c.vendedor.cod =:codVendedor) AND c.dataComanda BETWEEN :dataInicial AND :dataFinal ")
	public List<Comanda> listarPorDataEVendedor(@Param("dataInicial") Date dataInicial,
			@Param("dataFinal") Date dataFinal, @Param("codVendedor") Long codVendedor);
	
	@Modifying
	@Query(value="UPDATE comanda SET valor_total =:valorTotal WHERE cod =:comandaCod ", nativeQuery = true)
	public void setarValorTotal(@Param("comandaCod") Long comandaCod, @Param("valorTotal") BigDecimal valorTotal);

}
