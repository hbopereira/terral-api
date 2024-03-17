package com.terral.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terral.colaborador.Colaborador;
import com.terral.colaborador.ColaboradorRepository;

import jakarta.transaction.Transactional;

@Service
public class LoginService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@Transactional
	public Optional<Colaborador> autenticar(Colaborador colaborador) {
		Optional<Colaborador> colab = Optional
				.ofNullable(colaboradorRepository.devolverColaborador(colaborador.getNome(), colaborador.getSenha()));
		if (colab.isPresent()) {
			return colab;
		} else {
			return Optional.empty();
		}
	}

}
