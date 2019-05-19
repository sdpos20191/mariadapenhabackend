package br.cin.ufpe.sdpos.mpback.repositories.mongo;

import br.cin.ufpe.sdpos.mpback.models.mongo.Localizacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocalizacaoMongoDBRepository extends MongoRepository<Localizacao, String> {
}
