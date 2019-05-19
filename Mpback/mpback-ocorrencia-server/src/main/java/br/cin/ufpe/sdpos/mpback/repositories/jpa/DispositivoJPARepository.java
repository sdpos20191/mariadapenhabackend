package br.cin.ufpe.sdpos.mpback.repositories.jpa;

import br.cin.ufpe.sdpos.mpback.models.jpa.DispositivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoJPARepository extends JpaRepository<DispositivoEntity, Long> {
}
