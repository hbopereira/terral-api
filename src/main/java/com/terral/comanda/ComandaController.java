package com.terral.comanda;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.terral.base.BaseController;
import com.terral.constantes.ConstantesRest;
import com.terral.itemcomanda.ItemComanda;
import com.terral.produto.Produto;


@RestController
@CrossOrigin(origins = ConstantesRest.PATH_PRODUCAO)
@RequestMapping(ConstantesRest.PATH_COMANDAS)
public class ComandaController extends BaseController<Comanda, ComandaRepository, ComandaService> {

	@Autowired
	private ComandaService comandaService;

	@PostMapping(value = "/salvar")
	public ResponseEntity<String> salvar(@RequestBody Comanda comanda) {
		Optional<Comanda> resultado = comandaService.salvar(comanda);
		if (resultado.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(resultado.get().getCod().toString());
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/adicionarItem")
	public ResponseEntity<String> adicionarItem(@RequestBody ItemComanda item,
			@RequestParam("codComanda") Long codComanda) {
		Optional<Comanda> resultado = comandaService.adicionarItem(item, codComanda);
		if (resultado.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(resultado.get().getCod().toString());
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("/removerItem")
	public void excluirItem(@RequestParam("codItem") Long codItem) {
		comandaService.excluirItem(codItem);
	}

	@GetMapping("/listarPorDataEVendedor")
	public List<Comanda> listarPorDataEVendedor(@RequestParam("dataInicial") Date dataInicial,
			@RequestParam("dataFinal") Date dataFinal, @RequestParam(required = false) Long codVendedor) {
		return comandaService.listarPorDataEVendedor(dataInicial, dataFinal, codVendedor);
	}

	@GetMapping("/listarPorCodComanda")
	public List<ItemComanda> listarPorCodComanda(@RequestParam("codComanda") Long codComanda) {
		return comandaService.listarItensPorComanda(codComanda);
	}
	
	@PutMapping("/setarQuantidade")
	public ResponseEntity<Void> setarQuantidade(@RequestBody ItemComanda item) {
		comandaService.setarQuantidade(item);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/setarValorVenda")
	public ResponseEntity<Void> setarValorVenda(@RequestBody Comanda comanda){
		comandaService.setarValorTotal(comanda);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/setarValorItem")
	public ResponseEntity<Void> setarValorItem(@RequestBody ItemComanda item) {
		comandaService.setarValorItem(item);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}
