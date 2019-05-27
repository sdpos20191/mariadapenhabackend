package br.cin.ufpe.sdpos.mpback.controllers.mongo;

import br.cin.ufpe.sdpos.mpback.models.mongo.Dispositivo;
import br.cin.ufpe.sdpos.mpback.repositories.mongo.DispositivoMongoDBRepository;
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
public class DispositivoMongoController {

    @Autowired
    private DispositivoMongoDBRepository repository;

    @ApiOperation(value = "Listar Dispositivos",
            response = Dispositivo.class,
            notes = "Essa operacao retorna todas as ocorrencias cadastradas.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna uma lista de objetos do tipo Dispositivo.",
                    response = Dispositivo.class,
                    responseContainer = "List")
    )
    @GetMapping(value = "/dispositivos")
    public List<Dispositivo> listar(){
        return repository.findAll();
    }

    @ApiOperation(value = "Obter Dispositivo",
            response = Dispositivo.class,
            notes = "Essa operacao recupera um dispositivo cadastrado.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna uma instancia de um objeto do tipo Dispositivo.",
                    response = Dispositivo.class)
    )
    @GetMapping(value = "/dispositivos/{id}")
    public Dispositivo obterPorId(@ApiParam(name = "id") @PathVariable("id") String id){
        return repository.findOne(id);
    }

    @ApiOperation(value = "Salvar Dispositivos",
            response = Dispositivo.class,
            notes = "Essa operacao persiste um novo dispositivo.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna uma nova instancia de um objeto do tipo Dispositivo.",
                    response = Dispositivo.class)
    )
    @PostMapping(value="/dispositivos")
    public Dispositivo salvar(@RequestBody Dispositivo dispositivo){
        return repository.save(dispositivo);
    }

    @ApiOperation(value = "Atualizar Dispositivos",
            response = Dispositivo.class,
            notes = "Essa operacao atualiza um dispositivo cadastrado.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna a instancia do Dispositivo atualizado.",
                    response = Dispositivo.class)
    )
    @PutMapping(value = "/dispositivos/{id}")
    public Dispositivo atualizar(@ApiParam @PathVariable("id") String id,
                                 @RequestBody Dispositivo dispositivo){
        return repository.save(dispositivo);
    }
}
