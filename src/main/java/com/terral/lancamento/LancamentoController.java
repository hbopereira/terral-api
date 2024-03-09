package com.terral.lancamento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terral.base.BaseController;
import com.terral.constantes.ConstantesRest;

@RestController
@RequestMapping(ConstantesRest.PATH_LANCAMENTOS)
public class LancamentoController extends BaseController<Lancamento, LancamentoRepository,LancamentoService>{

}
