package br.cin.ufpe.sdpos.mpback.controllers;

import br.cin.ufpe.sdpos.mpback.models.Ocorrencia;
import br.cin.ufpe.sdpos.mpback.repositories.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OcorrenciaController {

    @Autowired
    private OcorrenciaRepository repository;

    @GetMapping(value = "/ocorrencias")
    public List<Ocorrencia> listarOcorrencias(){
        return repository.findAll();
    }

    @GetMapping(value = "/ocorrencias/{id}")
    public Ocorrencia obterOcorrenciaPorId(@PathVariable("id") String id){
        return repository.findOne(id);
    }

    @PostMapping(value="/ocorrencias")
    public Ocorrencia salvarOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return repository.save(ocorrencia);
    }

    @PutMapping(value = "/ocorrencias/{id}")
    public Ocorrencia atualizarOcorrencia(@PathVariable("id") String id,
                                          @RequestBody Ocorrencia ocorrencia){
        return repository.save(ocorrencia);
    }
}
