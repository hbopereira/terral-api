package com.terral.itemcomanda;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.terral.base.BaseRepository;

@Repository
public interface ItemComandaRepository extends BaseRepository<ItemComanda>{
	
	@Query(value="SELECT i FROM ItemComanda i WHERE i.comanda.cod =:codComanda ORDER BY i.descricao DESC ")
	public List<ItemComanda> listarItensPorComanda(@Param("codComanda") Long codComanda);
	
	@Modifying
	@Query(value="UPDATE ItemComanda SET quantidade =:quantidade WHERE cod =:itemCod ")
	public void setarQuantidade(@Param("itemCod") Long itemCod, @Param("quantidade") Integer quantidade);
	
	@Modifying
	@Query(value="UPDATE ItemComanda SET valor =:valor WHERE cod =:itemCod ")
	public void setarValorItem(@Param("itemCod") Long itemCod, @Param("valor") BigDecimal valor);
	
	@Modifying
	@Query(value="UPDATE ItemComanda SET valorColaborador =:valor WHERE cod =:itemCod ")
	public void setarValorColaborador(@Param("itemCod") Long itemCod, @Param("valor") BigDecimal valor);
	

}
