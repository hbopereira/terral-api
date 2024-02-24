package com.terral.base;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;

public class BaseService<ENTITY extends BaseEntity, REPOSITORY extends BaseRepository<ENTITY>> {

	@Autowired
	private REPOSITORY repo;

	@Transactional
	public Optional<ENTITY> salvar(ENTITY entity) {
		ENTITY nova = repo.save(entity);
		return Optional.of(nova);
	}
	
	@Transactional
	public Optional<ENTITY> atualizar(ENTITY entidade) {
		if (repo.existsById(entidade.getCod())) {
			salvar(entidade);
			return Optional.of(entidade);
		} else {
			return Optional.empty();
		}
	}
}
