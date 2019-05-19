package br.cin.ufpe.sdpos.mpback.repositories;

import br.cin.ufpe.sdpos.mpback.models.Ocorrencia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OcorrenciaRepository extends MongoRepository<Ocorrencia, String> {
}
