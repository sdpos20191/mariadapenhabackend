package br.cin.ufpe.sdpos.mpback.controllers;

import br.cin.ufpe.sdpos.mpback.models.mongo.Ocorrencia;
import br.cin.ufpe.sdpos.mpback.repositories.mongo.OcorrenciaMongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OcorrenciaController {

    @Autowired
    private OcorrenciaMongoDBRepository repository;

    @GetMapping(value = "/ocorrencias")
    public List<Ocorrencia> listar(){
        return repository.findAll();
    }

    @GetMapping(value = "/ocorrencias/{id}")
    public Ocorrencia obterPorId(@PathVariable("id") String id){
        return repository.findOne(id);
    }

    @PostMapping(value="/ocorrencias")
    public Ocorrencia salvar(@RequestBody Ocorrencia ocorrencia){
        return repository.save(ocorrencia);
    }

    @PutMapping(value = "/ocorrencias/{id}")
    public Ocorrencia atualizar(@PathVariable("id") String id,
                                @RequestBody Ocorrencia ocorrencia){
        return repository.save(ocorrencia);
    }
}
