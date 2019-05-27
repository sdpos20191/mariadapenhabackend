package br.cin.ufpe.sdpos.mpback.controllers.mongo;

import br.cin.ufpe.sdpos.mpback.models.jpa.OcorrenciaEntity;
import br.cin.ufpe.sdpos.mpback.models.mongo.Ocorrencia;
import br.cin.ufpe.sdpos.mpback.repositories.mongo.OcorrenciaMongoDBRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@Path(value = "/mongo/")
public class OcorrenciaMongoController {

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
        return repository.save(ocorrencia);
    }

    @ApiOperation(value = "Atualizar Ocorrencia",
            response = Ocorrencia.class,
            notes = "Essa operacao atualiza uma ocorrencia.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna a instancia da Ocorrencia atualizada.",
                    response = Ocorrencia.class)
    )
    @PutMapping(value = "/ocorrencias/{id}")
    public Ocorrencia atualizar(@ApiParam @PathVariable("id") String id,
                                @RequestBody Ocorrencia ocorrencia){
        return repository.save(ocorrencia);
    }
}
