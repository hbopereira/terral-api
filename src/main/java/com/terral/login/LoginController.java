package com.terral.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terral.colaborador.Colaborador;
import com.terral.constantes.ConstantesRest;

@RestController
@CrossOrigin(origins = ConstantesRest.PATH_PRODUCAO)
@RequestMapping(ConstantesRest.PATH_LOGIN)
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping
	public ResponseEntity<Colaborador> autenticar(@RequestBody Colaborador colaborador) {
		Optional<Colaborador> resultado = loginService.autenticar(colaborador);
		if (resultado.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(resultado.get());
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	

}
