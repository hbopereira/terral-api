package com.terral.colaborador;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.terral.base.BaseRepository;

@Repository
public interface ColaboradorRepository extends BaseRepository<Colaborador>{
	

}
