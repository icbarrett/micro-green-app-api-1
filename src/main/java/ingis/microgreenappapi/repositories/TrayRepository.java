package ingis.microgreenappapi.repositories;

import ingis.microgreenappapi.models.Tray;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrayRepository extends JpaRepository<Tray, Integer> {
}