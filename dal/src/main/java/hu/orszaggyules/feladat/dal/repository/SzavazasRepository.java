package hu.orszaggyules.feladat.dal.repository;

import hu.orszaggyules.feladat.dal.domain.SzavazasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SzavazasRepository extends JpaRepository<SzavazasEntity, String> {
    @Query(value = "SELECT sz.* FROM szavazas sz WHERE sz.tipus='JELENLET' AND sz.idopont < :currentTime ORDER BY sz.idopont DESC LIMIT 1", nativeQuery = true)
    Optional<SzavazasEntity> findOldestJelenletiSzavazas(LocalDateTime currentTime);

    @Query(value = "SELECT sz.* FROM szavazas sz WHERE CAST(sz.idopont AS DATE) = :date", nativeQuery = true)
    List<SzavazasEntity> findAllOnDate(LocalDate date);

    List<SzavazasEntity> findByIdopontBetween(LocalDateTime start, LocalDateTime end);

    boolean existsByidopont(LocalDateTime date);
}
