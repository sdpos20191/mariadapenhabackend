package br.cin.ufpe.sdpos.mpback.repositories.mongo;

import br.cin.ufpe.sdpos.mpback.models.mongo.Ocorrencia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OcorrenciaMongoDBRepository extends MongoRepository<Ocorrencia, String> {
}
