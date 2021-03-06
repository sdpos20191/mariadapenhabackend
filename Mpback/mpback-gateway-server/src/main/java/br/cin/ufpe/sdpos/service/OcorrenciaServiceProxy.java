package br.cin.ufpe.sdpos.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.cin.ufpe.sdpos.model.OcorrenciaDtoInfo;

@FeignClient(value = "ocorrencia-server", url = "${feign.client.url.TestUrl}")
public interface OcorrenciaServiceProxy {

	@GetMapping(value = "/api/v1/ocorrencias")
	public List<OcorrenciaDtoInfo> listar();
	
}
