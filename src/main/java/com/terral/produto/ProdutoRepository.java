package com.terral.produto;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.terral.base.BaseRepository;
import com.terral.resumo.ProdutoResumo;

@Repository
public interface ProdutoRepository extends BaseRepository<Produto>{
	
	@Query(value="SELECT p.cod as cod_produto, c.cod as cod_secao, co.cod as cod_colaborador, "
			+ " p.descricao_produto, c.descricao_secao, co.nome, p.valor, p.valor_colaborador, "
			+ " p.porcentagem_colaborador, p.quantidade, p.tem_estoque, p.cod_fabricante, p.cod_loja FROM produto p "
			+ " LEFT JOIN secao c on c.cod = p.secao_cod "
			+ " LEFT JOIN colaborador co ON co.cod = p.colaborador_cod "
			+ " WHERE (:colaboradorCod IS NULL OR p.colaborador_cod=:colaboradorCod) "
			+ " AND (:secaoCod IS NULL OR p.secao_cod=:secaoCod) "
			+ " AND ((cast(:descricao as VARCHAR) IS NULL ) OR LOWER(p.descricao_produto) ILIKE %:descricao%) " 
			+ " AND ((cast(:fabricante as VARCHAR) IS NULL ) OR LOWER(p.cod_fabricante) LIKE %:fabricante%) "
			+ " AND ((cast(:codLoja as VARCHAR) IS NULL ) OR LOWER(p.cod_loja) LIKE %:codLoja%) "
			+ " ORDER BY p.descricao_produto ", nativeQuery = true)
	public List<ProdutoResumo> listarPorColaboradorESecao(@Param("colaboradorCod") Long colaboradorCod,
			                                              @Param("secaoCod") Long secaoCod, 
			                                              @Param("descricao") String descricao,
			                                              @Param("fabricante") String codFabricante,
			                                              @Param("codLoja") String codLoja
			                                              );
	
	@Modifying
	@Query(value="UPDATE Produto SET quantidade =:quantidade WHERE cod =:produtoCod ")
	public void setarQuantidade(@Param("produtoCod") Long produtoCod, @Param("quantidade") Integer quantidade);
	
	@Modifying
	@Query(value="UPDATE Produto SET porcentagemColaborador =:porcentagem WHERE colaborador.cod =:colaboradorCod ")
	public void setarPorcentagemProduto(@Param("colaboradorCod") Long colaboradorCod, @Param("porcentagem") Integer porcentagem);
	
	@Query(value = "SELECT p.quantidade, p.tem_estoque from produto p WHERE p.cod =:produtoCod ", nativeQuery = true)
	public ProdutoResumo devolverQuantidadeProduto(@Param("produtoCod") Long produtoCod);
	
	

}
