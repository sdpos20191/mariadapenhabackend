package br.cin.ufpe.sdpos.mpback.controllers.jpa;

import br.cin.ufpe.sdpos.mpback.mapping.Mapeador;
import br.cin.ufpe.sdpos.mpback.models.jpa.OcorrenciaDto;
import br.cin.ufpe.sdpos.mpback.models.jpa.OcorrenciaEntity;
import br.cin.ufpe.sdpos.mpback.repositories.jpa.OcorrenciaJPARepository;
import br.cin.ufpe.sdpos.mpback.service.OcorrenciaService;
import br.cin.ufpe.sdpos.mpback.models.ApisVersion;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(ApisVersion.V1+"/jpa/ocorrencias")
public class OcorrenciaJpaController {
	
    @Autowired
    private OcorrenciaJPARepository jpaRepository;
    
    @Autowired
	private Mapeador mapeador;
    
    @Autowired
    private OcorrenciaService ocorrenciaService;

    @ApiOperation(value = "Listar Ocorrencias",
            response = OcorrenciaEntity.class,
            notes = "Essa operacao retorna todas as ocorrencias cadastradas.")
    @ApiResponses(
            @ApiResponse(code=200,
                         message = "Retorna uma lista do tipo OcorrenciaEntity.",
                         response = OcorrenciaEntity.class,
                         responseContainer = "List")
    )
    @GetMapping
    public @ResponseBody ResponseEntity<List<OcorrenciaDto>> listar() {
    	List<OcorrenciaEntity> ocorrencias = jpaRepository.findAll();
    	List<OcorrenciaDto> dtos = mapeador.getInstancia().mapAsList(ocorrencias, OcorrenciaDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @ApiOperation(value = "Listar uma Ocorrencia",
            response = OcorrenciaEntity.class,
            notes = "Essa operacao retorna uma ocorrencia.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna uma instancia de um objeto OcorrenciaEntity.",
                    response = OcorrenciaEntity.class)
    )
    @GetMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<OcorrenciaDto> obterPorId(@ApiParam @PathVariable("id") Long id){
    	OcorrenciaEntity ocorrencia = jpaRepository.findOne(id);
    	OcorrenciaDto dto = mapeador.getInstancia().map(ocorrencia, OcorrenciaDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "Cadastrar Nova Ocorrencia",
                  response = OcorrenciaEntity.class,
                  notes = "Essa operacao salva um nova ocorrencia.")
    @ApiResponses(
        @ApiResponse(code=200,
                     message = "Retorna a instancia da Ocorrencia salva.",
                     response = OcorrenciaEntity.class)
    )
    @PostMapping
    public @ResponseBody ResponseEntity<Void> salvar(@ApiParam @RequestBody OcorrenciaDto dto){
    	OcorrenciaEntity ocorrencia = mapeador.getInstancia().map(dto, OcorrenciaEntity.class);
        OcorrenciaEntity savedEntity = ocorrenciaService.save(ocorrencia);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedEntity.getId()).toUri();
		return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value = "Atualizar Ocorrencia",
            response = OcorrenciaEntity.class,
            notes = "Essa operacao atualiza uma ocorrencia.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna a instancia da Ocorrencia atualizada.",
                    response = OcorrenciaEntity.class)
    )
    @PutMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<Void> atualizar(@ApiParam @PathVariable("id") Long id,
                                      @RequestBody OcorrenciaDto dto){
    	
    	// Estou com dúvida sobre o update. conversaro com o pessoal sobre essa regra de negócio.
    	OcorrenciaEntity ocorrenciaBase = jpaRepository.findOne(id);
    	dto.setId(ocorrenciaBase.getId());
    	dto.getLocalizacaoDto().setId(ocorrenciaBase.getLocalizacao().getId());
    	dto.getDispositivoDto().setId(ocorrenciaBase.getDispositivo().getId());
    	dto.getDispositivoDto().getAtualDto().setId(ocorrenciaBase.getDispositivo().getAtual().getId());
    	
    	OcorrenciaEntity ocorrencia = mapeador.getInstancia().map(dto, OcorrenciaEntity.class);
        ocorrenciaService.save(ocorrencia);
        return ResponseEntity.noContent().build();
    }
}