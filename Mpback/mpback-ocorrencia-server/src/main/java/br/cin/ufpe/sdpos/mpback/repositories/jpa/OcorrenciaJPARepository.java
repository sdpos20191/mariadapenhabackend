package br.cin.ufpe.sdpos.mpback.repositories.jpa;

import br.cin.ufpe.sdpos.mpback.models.jpa.OcorrenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaJPARepository extends JpaRepository<OcorrenciaEntity, Long> {
}
