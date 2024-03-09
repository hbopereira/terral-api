package com.terral.venda;

import java.util.Date;
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
import com.terral.produto.Produto;
import com.terral.resumo.ItemVendaResumo;
import com.terral.resumo.VendaResumo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ConstantesRest.PATH_VENDAS)
public class VendaController extends BaseController<Venda, VendaRepository, VendaService> {

	@Autowired
	private VendaService vendaService;


	@PostMapping(value = "/salvar")
	public ResponseEntity<String> salvar(@RequestBody Venda venda) {
		Optional<Venda> resultado = vendaService.salvar(venda);
		if (resultado.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(resultado.get().getCod().toString());
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/listarPorDataEVendedor")
	public List<Venda> listarPorDataEVendedor(@RequestParam("dataInicial") Date dataInicial,
			@RequestParam("dataFinal") Date dataFinal, @RequestParam(required = false) Long codVendedor) {
		return vendaService.listarPorDataEVendedor(dataInicial, dataFinal, codVendedor);
	}
	
	@GetMapping("/listarVendasProdutoSecao")
	public List<VendaResumo> listarVendasProdutoSecao(){
		return vendaService.listarVendasProdutoSecao();
	}

	@GetMapping("/listarPorDia")
	public List<Venda> listarPorDia() {
		return vendaService.listarPorDia();
	}

	@GetMapping("/produtoColaborador")
	public List<ItemVendaResumo> listarDadosRelaorioComissaoVendedores(@RequestParam("dataInicial") Date dataInicial,
			@RequestParam("dataFinal") Date dataFinal, @RequestParam(required = false) Long codVendedor) {
		return vendaService.listarDadosRelatorioProdutoColaborador(dataInicial, dataFinal, codVendedor);
	}

	@PutMapping("/setarVendasItensVendaComoPago")
	public void setarVendasItensVendaComoPago(@RequestBody List<Long> listaCodigosVenda,
			@RequestParam("isVenda") Boolean isVenda) {
		vendaService.setarVendasIntesVendaComoPago(listaCodigosVenda, isVenda);
	}

}
