package br.cin.ufpe.sdpos.mpback.controllers.mongo;

import br.cin.ufpe.sdpos.mpback.models.mongo.Dispositivo;
import br.cin.ufpe.sdpos.mpback.repositories.mongo.DispositivoMongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@Path(value = "/mongo/")
public class DispositivoMongoController {

    @Autowired
    private DispositivoMongoDBRepository repository;

    @GetMapping(value = "/dispositivos")
    public List<Dispositivo> listar(){
        return repository.findAll();
    }

    @GetMapping(value = "/dispositivos/{id}")
    public Dispositivo obterPorId(@PathVariable("id") String id){
        return repository.findOne(id);
    }

    @PostMapping(value="/dispositivos")
    public Dispositivo salvar(@RequestBody Dispositivo dispositivo){
        return repository.save(dispositivo);
    }

    @PutMapping(value = "/dispositivos/{id}")
    public Dispositivo atualizar(@PathVariable("id") String id,
                                 @RequestBody Dispositivo dispositivo){
        return repository.save(dispositivo);
    }
}
