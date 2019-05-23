package br.cin.ufpe.sdpos.mpback.controllers.jpa;

import br.cin.ufpe.sdpos.mpback.models.jpa.OcorrenciaEntity;
import br.cin.ufpe.sdpos.mpback.repositories.jpa.OcorrenciaJPARepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OcorrenciaJpaController {
    @Autowired
    private OcorrenciaJPARepository jpaRepository;

    @ApiOperation(value = "Listar Ocorrencias",
            response = OcorrenciaEntity.class,
            notes = "Essa operacao retorna todas as ocorrencias cadastradas.")
    @ApiResponses(
            @ApiResponse(code=200,
                         message = "Retorna uma lista do tipo OcorrenciaEntity.",
                         response = OcorrenciaEntity.class,
                         responseContainer = "List")
    )
    @GetMapping(value = "/jpa/ocorrencias")
    public @ResponseBody ResponseEntity<List<OcorrenciaEntity>> listar(){
        return new ResponseEntity<>(jpaRepository.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Listar uma Ocorrencia",
            response = OcorrenciaEntity.class,
            notes = "Essa operacao retorna uma ocorrencia.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna uma instancia de um objeto OcorrenciaEntity.",
                    response = OcorrenciaEntity.class)
    )
    @GetMapping(value = "/jpa/ocorrencias/{id}")
    public @ResponseBody ResponseEntity<OcorrenciaEntity> obterPorId(@ApiParam @PathVariable("id") Long id){
        return new ResponseEntity<>(jpaRepository.findOne(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Cadastrar Nova Ocorrencia",
                  response = OcorrenciaEntity.class,
                  notes = "Essa operacao salva um nova ocorrencia.")
    @ApiResponses(
        @ApiResponse(code=200,
                     message = "Retorna a instancia da Ocorrencia salva.",
                     response = OcorrenciaEntity.class)
    )
    @PostMapping(value="/jpa/ocorrencias")
    public @ResponseBody ResponseEntity<OcorrenciaEntity> salvar(@ApiParam @RequestBody OcorrenciaEntity ocorrencia){
        OcorrenciaEntity savedEntity = jpaRepository.save(ocorrencia);
        return new ResponseEntity<>(savedEntity, HttpStatus.OK);
    }

    @ApiOperation(value = "Atualizar Ocorrencia",
            response = OcorrenciaEntity.class,
            notes = "Essa operacao atualiza uma ocorrencia.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna a instancia da Ocorrencia atualizada.",
                    response = OcorrenciaEntity.class)
    )
    @PutMapping(value = "/jpa/ocorrencias/{id}")
    public @ResponseBody ResponseEntity<OcorrenciaEntity> atualizar(@ApiParam @PathVariable("id") Long id,
                                      @RequestBody OcorrenciaEntity ocorrencia){
        OcorrenciaEntity updated = jpaRepository.save(ocorrencia);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}