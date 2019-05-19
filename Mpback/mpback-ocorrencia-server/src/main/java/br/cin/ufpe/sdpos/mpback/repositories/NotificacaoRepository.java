package br.cin.ufpe.sdpos.mpback.repositories;

import br.cin.ufpe.sdpos.mpback.models.Notificacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificacaoRepository extends MongoRepository<Notificacao, String> {
}
