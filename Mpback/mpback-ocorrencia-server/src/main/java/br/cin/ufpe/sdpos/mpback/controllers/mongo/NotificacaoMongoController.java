package br.cin.ufpe.sdpos.mpback.controllers.mongo;

import java.util.List;

import br.cin.ufpe.sdpos.mpback.service.NotificacaoMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cin.ufpe.sdpos.mpback.models.ApisVersion;
import br.cin.ufpe.sdpos.mpback.models.mongo.Notificacao;
import br.cin.ufpe.sdpos.mpback.repositories.mongo.NotificacaoMongoDBRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(ApisVersion.V1)
public class NotificacaoMongoController {

    @Autowired
    private NotificacaoMongoDBRepository repository;

    @Autowired
    private NotificacaoMessageSender notificacaoMessageSender;

    @ApiOperation(value = "Listar Notificacoes",
            response = Notificacao.class,
            notes = "Essa operacao retorna todas as notificacoes cadastradas.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna uma lista de objetos do tipo Notificacao.",
                    response = Notificacao.class,
                    responseContainer = "List")
    )
    @GetMapping(value = "/notificacoes")
    public List<Notificacao> listar(){
        return repository.findAll();
    }

    @ApiOperation(value = "Obter Notificacao",
            response = Notificacao.class,
            notes = "Essa operacao recupera uma notificacao cadastrada.")
    @ApiResponses({
            @ApiResponse(code=200,
                    message = "Retorna uma instancia de um objeto do tipo Notificacao.",
                    response = Notificacao.class),
            @ApiResponse(code=500,
                         message = "Erro interno do servidor",
                         response = Exception.class)
    })
    @GetMapping(value = "/notificacoes/{id}")
    public Notificacao obterPorId(@ApiParam @PathVariable("id") String id){
        return repository.findOne(id);
    }

    @ApiOperation(value = "Salvar Notificacoes",
            response = Notificacao.class,
            notes = "Essa operacao persiste uma nova notificacao.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna uma nova instancia de um objeto do tipo Notificacao.",
                    response = Notificacao.class)
    )
    @PostMapping(value="/notificacoes")
    public Notificacao salvar(@RequestBody Notificacao notificacao){
        Notificacao salva = repository.save(notificacao);
        notificacaoMessageSender.sendNotificacao(salva);
        return salva;
    }

    @ApiOperation(value = "Atualizar Notificacao",
            response = Notificacao.class,
            notes = "Essa operacao atualiza uma notificacao cadastrada.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna a instancia do Notificacao atualizada.",
                    response = Notificacao.class)
    )
    @PutMapping(value = "/notificacoes/{id}")
    public Notificacao atualizar(@PathVariable("id") String id,
                                 @RequestBody Notificacao notificacao){
    	notificacao.setId(id);
        return repository.save(notificacao);
    }
}
