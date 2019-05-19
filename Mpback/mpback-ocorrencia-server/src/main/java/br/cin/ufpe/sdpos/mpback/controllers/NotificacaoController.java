package br.cin.ufpe.sdpos.mpback.controllers;

import br.cin.ufpe.sdpos.mpback.models.Notificacao;
import br.cin.ufpe.sdpos.mpback.models.Ocorrencia;
import br.cin.ufpe.sdpos.mpback.repositories.NotificacaoRepository;
import br.cin.ufpe.sdpos.mpback.repositories.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificacaoController {

    @Autowired
    private NotificacaoRepository repository;

    @GetMapping(value = "/notificacoes")
    public List<Notificacao> listar(){
        return repository.findAll();
    }

    @GetMapping(value = "/notificacoes/{id}")
    public Notificacao obterPorId(@PathVariable("id") String id){
        return repository.findOne(id);
    }

    @PostMapping(value="/notificacoes")
    public Notificacao salvar(@RequestBody Notificacao notificacao){
        return repository.save(notificacao);
    }

    @PutMapping(value = "/ocorrencias/{id}")
    public Notificacao atualizar(@PathVariable("id") String id,
                                 @RequestBody Notificacao notificacao){
        return repository.save(notificacao);
    }
}
