package com.terral.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.terral.base.BaseController;
import com.terral.constantes.ConstantesRest;
import com.terral.resumo.ProdutoResumo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ConstantesRest.PATH_PRODUTOS)
public class ProdutoController extends BaseController<Produto, ProdutoRepository, ProdutoService> {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping(value = "/salvarEmLote")
	public ResponseEntity<Integer> salvarEmLote(@RequestBody List<Produto> listaProdutos) {
		Optional<Integer> resultado = produtoService.salvarEmLote(listaProdutos);
		if (resultado.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(resultado.get());
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/setarQuantidade")
	public ResponseEntity<Void> setarQuantidade(@RequestBody Produto produto) {
		produtoService.setarQuantidade(produto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping(value = "/listar")
	public List<ProdutoResumo> listarPorColaboradorESecao(@RequestParam(required = false) Long colaboradorCod,
			@RequestParam(required = false) Long secaoCod, @RequestParam(required = false) String descricao,
			@RequestParam(required = false) String codFabricante, @RequestParam(required = false) String codLoja) {
		return produtoService.listarPorColaboradorESecao(colaboradorCod, secaoCod, descricao, codFabricante, codLoja);
	}

	@GetMapping(value = "/devolverQuantidadeProduto")
	public ProdutoResumo devolverQuantidadeProduto(@RequestParam("produtoCod") Long produtoCod) {
		return produtoService.devolverQuantidadeProduto(produtoCod);
	}

}
