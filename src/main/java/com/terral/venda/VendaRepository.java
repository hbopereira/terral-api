package com.terral.venda;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.terral.base.BaseRepository;
import com.terral.resumo.VendaResumo;

@Repository
public interface VendaRepository extends BaseRepository<Venda> {

	@Query(value = "SELECT v FROM Venda v WHERE (:codVendedor IS NULL OR v.vendedor.cod =:codVendedor) "
			+ " AND v.dataVenda BETWEEN :dataInicial AND :dataFinal " + " ORDER BY v.dataVenda ")
	public List<Venda> listarPorDataEVendedor(@Param("dataInicial") Date dataInicial,
			@Param("dataFinal") Date dataFinal, @Param("codVendedor") Long codVendedor);

	@Query(value="SELECT SUM(iv.valor * iv.quantidade) as valorTotal, s.descricao_secao FROM venda v "
			+ "INNER JOIN item_venda iv ON iv.venda_cod = v.cod "
			+ "INNER JOIN produto p ON p.cod = iv.cod_produto "
			+ "INNER JOIN secao s ON s.cod = p.secao_cod "
			+ "WHERE v.data_venda BETWEEN :dataInicial AND :dataFinal "
			+ "GROUP BY s.descricao_secao ", nativeQuery=true)
	public List<VendaResumo> listarVendasProdutoSecao(@Param("dataInicial") Date dataInicial,
			@Param("dataFinal") Date dataFinal);

	@Modifying
	@Query(value = "UPDATE Venda SET pago = true WHERE cod =:vendaCod ")
	public void setarVendasComoPago(@Param("vendaCod") Long itemCod);

}
