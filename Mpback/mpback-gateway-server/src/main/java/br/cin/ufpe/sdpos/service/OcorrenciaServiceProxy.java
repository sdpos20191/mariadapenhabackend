package br.cin.ufpe.sdpos.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.cin.ufpe.sdpos.model.OcorrenciaDtoInfo;

@FeignClient(name = "mpback-ocorrencia-server", url = "http://ocorrencia-server:9093")
public interface OcorrenciaServiceProxy {

	@GetMapping(value = "/jpa/ocorrencias")
	public @ResponseBody ResponseEntity<List<OcorrenciaDtoInfo>> listar();
	
}
