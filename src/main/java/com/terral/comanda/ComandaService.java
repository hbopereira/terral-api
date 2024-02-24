package com.terral.comanda;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terral.base.BaseService;
import com.terral.itemcomanda.ItemComanda;
import com.terral.itemcomanda.ItemComandaRepository;

import jakarta.transaction.Transactional;

@Service
public class ComandaService extends BaseService<Comanda, ComandaRepository> {

	@Autowired
	private ComandaRepository comandaRepository;

	@Autowired
	private ItemComandaRepository itemComandaRepository;

	public Optional<Comanda> salvar(Comanda comanda) {
		comanda.setDataComanda(new Date());
		comanda.getItens().forEach(item -> {
			item.setComanda(comanda);
		});
		Comanda nova = comandaRepository.save(comanda);
		return Optional.of(nova);
	}

	@Transactional
	public Optional<Comanda> adicionarItem(ItemComanda itemComanda, Long codComanda) {
		Boolean entrou = false;
		Optional<Comanda> comanda = Optional.of(comandaRepository.getReferenceById(codComanda));
		if (comanda.isPresent()) {
			comanda.get().getItens().add(itemComanda);
			comanda.get().setItens(comanda.get().getItens());
			entrou = true;
		}
		return (entrou) ? atualizar(comanda.get()) : Optional.empty();
	}

	@Transactional
	public void excluirItem(Long codItem) {
		if (itemComandaRepository.existsById(codItem)) {
			itemComandaRepository.deleteById(codItem);
		}
	}

	@Transactional
	public List<Comanda> listarPorDataEVendedor(Date dataInicial, Date dataFinal, Long codVendedor) {
		return comandaRepository.listarPorDataEVendedor(dataInicial, dataFinal, codVendedor);
	}

	@Transactional
	public List<ItemComanda> listarItensPorComanda(Long codComanda) {
		return itemComandaRepository.listarItensPorComanda(codComanda);
	}

	@Transactional
	public void setarQuantidade(ItemComanda item) {
		itemComandaRepository.setarQuantidade(item.getCod(), item.getQuantidade());
	}

	@Transactional
	public void setarValorTotal(Comanda comanda) {
		comandaRepository.setarValorTotal(comanda.getCod(), comanda.getValorTotal());
	}

	@Transactional
	public void setarValorItem(ItemComanda item) {
		itemComandaRepository.setarValorItem(item.getCod(), item.getValor());
		itemComandaRepository.setarValorColaborador(item.getCod(), item.getValorColaborador());
	}
}
