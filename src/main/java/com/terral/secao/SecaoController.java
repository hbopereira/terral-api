package com.terral.secao;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terral.base.BaseController;
import com.terral.constantes.ConstantesRest;

@CrossOrigin(origins = "https://terral-front.vercel.app")
@RestController
@RequestMapping(ConstantesRest.PATH_SECOES)
public class SecaoController extends BaseController<Secao, SecaoRepository, SecaoService>{

}
