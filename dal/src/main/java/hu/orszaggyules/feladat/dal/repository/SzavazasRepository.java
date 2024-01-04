package hu.orszaggyules.feladat.dal.repository;

import hu.orszaggyules.feladat.dal.domain.SzavazasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface SzavazasRepository extends JpaRepository<SzavazasEntity, String> {
    @Query(value = "SELECT sz.* FROM szavazas sz WHERE sz.tipus='JELENLET' AND sz.idopont < :currentTime ORDER BY sz.idopont DESC LIMIT 1", nativeQuery = true)
    SzavazasEntity findOldestJelenletiSzavazas(LocalDateTime currentTime);
}
