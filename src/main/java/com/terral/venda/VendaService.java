package com.terral.venda;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terral.base.BaseService;
import com.terral.itemvenda.ItemVendaRepository;
import com.terral.resumo.ItemVendaResumo;

import jakarta.transaction.Transactional;

@Service
public class VendaService extends BaseService<Venda, VendaRepository> {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ItemVendaRepository itemVendaRepository;

	@Transactional
	public Optional<Venda> salvar(Venda venda) {
		venda.setDataVenda(new Date());
		venda.getItens().forEach(item -> {
			item.setVenda(venda);
		});
		Venda nova = vendaRepository.save(venda);
		return Optional.of(nova);

	}

	@Transactional
	public List<Venda> listarPorDataEVendedor(Date dataInicial, Date dataFinal, Long codVendedor) {
		return vendaRepository.listarPorDataEVendedor(dataInicial, dataFinal, codVendedor);
	}

	@Transactional
	public List<ItemVendaResumo> listarDadosRelatorioProdutoColaborador(Date dataInicial, Date dataFinal, Long codVendedor) {
		return itemVendaRepository.listarDadosRelatorioProdutoColaborador(dataInicial, dataFinal, codVendedor);
	}

}