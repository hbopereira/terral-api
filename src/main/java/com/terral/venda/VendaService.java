package com.terral.venda;

import java.time.LocalDate;
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
	public void setarVendasIntesVendaComoPago(List<Long> listaCodigos, Boolean isVenda) {
		if (listaCodigos.size() > 0) {
			listaCodigos.stream().forEach(item -> {
				if(isVenda) {
					vendaRepository.setarVendasComoPago(item);
				} else {
					itemVendaRepository.setarItensVendasComoPago(item);
				}
			});
		}
	}
	
	public List<Venda> listarPorDia(){
		LocalDate mesReferencia = LocalDate.now();
		LocalDate primeiroDia = mesReferencia.withDayOfMonth(1);
		LocalDate ultimoDia = mesReferencia.withDayOfMonth(mesReferencia.lengthOfMonth());
		Date dataInicial = java.sql.Date.valueOf(primeiroDia);
		Date dataFinal = java.sql.Date.valueOf(ultimoDia);
		return vendaRepository.listarPorDataEVendedor(dataInicial, dataFinal, null);
	}

	@Transactional
	public List<Venda> listarPorDataEVendedor(Date dataInicial, Date dataFinal, Long codVendedor) {
		return vendaRepository.listarPorDataEVendedor(dataInicial, dataFinal, codVendedor);
	}

	@Transactional
	public List<ItemVendaResumo> listarDadosRelatorioProdutoColaborador(Date dataInicial, Date dataFinal,
			Long codVendedor) {
		return itemVendaRepository.listarDadosRelatorioProdutoColaborador(dataInicial, dataFinal, codVendedor);
	}

}
