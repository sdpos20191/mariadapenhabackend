package br.cin.ufpe.sdpos.mpback.repositories;

import br.cin.ufpe.sdpos.mpback.models.Localizacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocalizacaoRepository extends MongoRepository<Localizacao, String> {
}
