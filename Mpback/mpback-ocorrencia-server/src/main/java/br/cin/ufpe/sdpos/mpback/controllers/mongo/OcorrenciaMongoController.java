package br.cin.ufpe.sdpos.mpback.controllers.mongo;

import java.util.List;

import br.cin.ufpe.sdpos.mpback.service.OcorrenciaMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cin.ufpe.sdpos.mpback.models.ApisVersion;
import br.cin.ufpe.sdpos.mpback.models.mongo.Ocorrencia;
import br.cin.ufpe.sdpos.mpback.repositories.mongo.OcorrenciaMongoDBRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(ApisVersion.V1)
public class OcorrenciaMongoController {

    @Autowired
    private OcorrenciaMessageSender ocorrenciaMessageSender;

    @Autowired
    private OcorrenciaMongoDBRepository repository;

    @ApiOperation(value = "Listar Ocorrencias",
            response = Ocorrencia.class,
            notes = "Essa operacao retorna todas as ocorrencias cadastradas.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna uma lista do tipo Ocorrencia.",
                    response = Ocorrencia.class,
                    responseContainer = "List")
    )
    @GetMapping(value = "/ocorrencias")
    public List<Ocorrencia> listar(){
        return repository.findAll();
    }

    @ApiOperation(value = "Listar uma Ocorrencia",
            response = Ocorrencia.class,
            notes = "Essa operacao retorna uma ocorrencia.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna uma instancia de um objeto Ocorrencia.",
                    response = Ocorrencia.class)
    )
    @GetMapping(value = "/ocorrencias/{id}")
    public Ocorrencia obterPorId(@PathVariable("id") String id){
        return repository.findOne(id);
    }

    @ApiOperation(value = "Cadastrar Nova Ocorrencia",
            response = Ocorrencia.class,
            notes = "Essa operacao salva um nova ocorrencia.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna a instancia da Ocorrencia salva.",
                    response = Ocorrencia.class)
    )
    @PostMapping(value="/ocorrencias")
    public Ocorrencia salvar(@RequestBody Ocorrencia ocorrencia){
        Ocorrencia saved = repository.save(ocorrencia);
        ocorrenciaMessageSender.sendOcorrencia(saved);
        return saved;
    }

}
