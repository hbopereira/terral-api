package com.terral.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terral.base.BaseService;
import com.terral.resumo.ProdutoResumo;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService extends BaseService<Produto, ProdutoRepository> {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public Optional<Integer> salvarEmLote(List<Produto> listaProdutos) {
		Integer retorno = 0;
		if (listaProdutos.size() > 0) {
			produtoRepository.saveAll(listaProdutos);
			retorno = 1;
		}
		return Optional.of(retorno);
	}

	@Transactional
	public List<ProdutoResumo> listarPorColaboradorESecao(Long colaboradorCod, Long secaoCod, String descricao,
			String codFabricante, String codLoja) {
		Boolean isVazio = false;
		isVazio = validarParametros(descricao);
		if (isVazio) {
			descricao = null;
		}
		isVazio = validarParametros(codFabricante);
		if (isVazio) {
			codFabricante = null;
		}
		isVazio = validarParametros(codLoja);
		if (isVazio) {
			codLoja = null;
		}
		return produtoRepository.listarPorColaboradorESecao(colaboradorCod, secaoCod, descricao, codFabricante, codLoja);
	}

	@Transactional
	public void setarQuantidade(Produto produto) {
		produtoRepository.setarQuantidade(produto.getCod(), produto.getQuantidade());
	}

	@Transactional
	public ProdutoResumo devolverQuantidadeProduto(Long produtoCod) {
		return produtoRepository.devolverQuantidadeProduto(produtoCod);
	}

	private Boolean validarParametros(String valor) {
		Boolean entrou = false;
		switch (valor) {
		case "":
			entrou = true;
			break;
		default:
		}
		return entrou;
	}

}
