package br.cin.ufpe.sdpos.mpback.repositories.mongo;

import br.cin.ufpe.sdpos.mpback.models.mongo.Dispositivo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DispositivoMongoDBRepository extends MongoRepository<Dispositivo, String> {
}
