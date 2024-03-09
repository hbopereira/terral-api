package com.terral.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terral.base.BaseController;
import com.terral.constantes.ConstantesRest;

@RestController
@RequestMapping(ConstantesRest.PATH_PESSOAS)
public class PessoaController extends BaseController<Pessoa,PessoaRepository,PessoaService>{

}
