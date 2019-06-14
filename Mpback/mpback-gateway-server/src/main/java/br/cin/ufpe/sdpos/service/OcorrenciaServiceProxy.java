package br.cin.ufpe.sdpos.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.cin.ufpe.sdpos.model.OcorrenciaDtoInfo;

@FeignClient(name = "ocorrencia-server", url = "http://ocorrencia-server:9093")
public interface OcorrenciaServiceProxy {

	@GetMapping(value = "/api/v1/ocorrencias")
	public ResponseEntity<List<OcorrenciaDtoInfo>> listar();
	
}
