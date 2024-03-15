package com.terral.secao;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terral.base.BaseController;
import com.terral.constantes.ConstantesRest;


@RestController
@CrossOrigin(origins = ConstantesRest.PATH_PRODUCAO)
@RequestMapping(ConstantesRest.PATH_SECOES)
@EnableScheduling
public class SecaoController extends BaseController<Secao, SecaoRepository, SecaoService>{
	
	@Scheduled(cron = "*/20 * * * * *")
	public void scheduleFixedDelayTask() {
	    System.out.println(
	      "Fixed delay task - " + System.currentTimeMillis() / 1000);
	}

}
