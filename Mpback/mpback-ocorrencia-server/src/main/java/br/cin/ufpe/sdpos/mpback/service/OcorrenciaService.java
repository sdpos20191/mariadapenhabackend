package br.cin.ufpe.sdpos.mpback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cin.ufpe.sdpos.mpback.models.jpa.OcorrenciaEntity;
import br.cin.ufpe.sdpos.mpback.repositories.jpa.OcorrenciaJPARepository;

@Service
public class OcorrenciaService {

	@Autowired
    private OcorrenciaJPARepository jpaRepository;
	
	public OcorrenciaEntity save(OcorrenciaEntity ocorrencia) {
        return jpaRepository.saveAndFlush(ocorrencia);
    }
	
}
