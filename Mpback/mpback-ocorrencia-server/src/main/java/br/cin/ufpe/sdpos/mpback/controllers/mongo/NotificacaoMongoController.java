package br.cin.ufpe.sdpos.mpback.controllers.mongo;

import br.cin.ufpe.sdpos.mpback.models.mongo.Notificacao;
import br.cin.ufpe.sdpos.mpback.repositories.mongo.NotificacaoMongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@Path(value = "/mongo/")
public class NotificacaoMongoController {

    @Autowired
    private NotificacaoMongoDBRepository repository;

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

    @PutMapping(value = "/notificacoes/{id}")
    public Notificacao atualizar(@PathVariable("id") String id,
                                 @RequestBody Notificacao notificacao){
        return repository.save(notificacao);
    }
}
