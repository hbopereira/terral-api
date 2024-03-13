package com.terral.colaborador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terral.base.BaseService;
import com.terral.produto.ProdutoService;

import jakarta.transaction.Transactional;

@Service
public class ColaboradorService extends BaseService<Colaborador, ColaboradorRepository> {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@Transactional
	public Colaborador listarPorCod(Long cod) {
		Optional<Colaborador> colaborador = Optional.empty();
		if (colaboradorRepository.existsById(cod)) {
			colaborador = colaboradorRepository.findById(cod);
		}
		return colaborador.get();
	}

}
