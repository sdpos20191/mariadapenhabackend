package br.cin.ufpe.sdpos.mpback.repositories;

import br.cin.ufpe.sdpos.mpback.models.Dispositivo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DispositivoRepository extends MongoRepository<Dispositivo, String> {
}
