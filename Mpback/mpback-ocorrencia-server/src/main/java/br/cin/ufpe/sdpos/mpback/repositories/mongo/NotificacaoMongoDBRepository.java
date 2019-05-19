package br.cin.ufpe.sdpos.mpback.repositories.mongo;

import br.cin.ufpe.sdpos.mpback.models.mongo.Notificacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificacaoMongoDBRepository extends MongoRepository<Notificacao, String> {
}
