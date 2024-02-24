package com.terral.colaborador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.terral.base.BaseController;
import com.terral.constantes.ConstantesRest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ConstantesRest.PATH_COLABORADORES)
public class ColaboradorController extends BaseController<Colaborador, ColaboradorRepository, ColaboradorService> {

	@Autowired
	private ColaboradorService colaboradorService;

	@GetMapping("/listarPorCod")
	public Colaborador listarPorCod(@RequestParam("cod") Long cod) {
		return colaboradorService.listarPorCod(cod);
	}

}
