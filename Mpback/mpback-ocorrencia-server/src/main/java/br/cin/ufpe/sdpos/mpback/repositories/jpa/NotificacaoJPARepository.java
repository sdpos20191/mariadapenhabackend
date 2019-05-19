package br.cin.ufpe.sdpos.mpback.repositories.jpa;

import br.cin.ufpe.sdpos.mpback.models.jpa.NotificacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoJPARepository extends JpaRepository<NotificacaoEntity, Long> {
}
