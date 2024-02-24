package com.terral.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terral.base.BaseService;
import com.terral.resumo.ProdutoResumo;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService extends BaseService<Produto, ProdutoRepository> {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoResumo> listarPorColaboradorESecao(Long colaboradorCod, Long secaoCod, String descricao) {
		if (descricao.equals("")) {
			descricao = null;
		}
		return produtoRepository.listarPorColaboradorESecao(colaboradorCod, secaoCod, descricao);
	}

	@Transactional
	public void setarQuantidade(Produto produto) {
		produtoRepository.setarQuantidade(produto.getCod(), produto.getQuantidade());
	}

	@Transactional
	public ProdutoResumo devolverQuantidadeProduto(Long produtoCod) {
		return produtoRepository.devolverQuantidadeProduto(produtoCod);
	}

}
