package br.cin.ufpe.sdpos.mpback.controllers.jpa;

import br.cin.ufpe.sdpos.mpback.models.jpa.OcorrenciaEntity;
import br.cin.ufpe.sdpos.mpback.repositories.jpa.OcorrenciaJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
public class OcorrenciaJpaController {
    @Autowired
    private OcorrenciaJPARepository jpaRepository;

    @GetMapping(value = "/jpa/ocorrencias")
    public List<OcorrenciaEntity> listar(){
        return jpaRepository.findAll();
    }

    @GetMapping(value = "/jpa/ocorrencias/{id}")
    public OcorrenciaEntity obterPorId(@PathVariable("id") Long id){
        return jpaRepository.findOne(id);
    }

    @PostMapping(value="/jpa/ocorrencias")
    public OcorrenciaEntity salvar(@RequestBody OcorrenciaEntity ocorrencia){
        return jpaRepository.save(ocorrencia);
    }

    @PutMapping(value = "/jpa/ocorrencias/{id}")
    public OcorrenciaEntity atualizar(@PathVariable("id") Long id,
                                      @RequestBody OcorrenciaEntity ocorrencia){
        return jpaRepository.save(ocorrencia);
    }
}