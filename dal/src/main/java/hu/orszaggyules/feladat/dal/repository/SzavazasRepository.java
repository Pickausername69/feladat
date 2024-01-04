package hu.orszaggyules.feladat.dal.repository;

import hu.orszaggyules.feladat.dal.domain.SzavazasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SzavazasRepository extends JpaRepository<SzavazasEntity, String> {
    @Query(value = "SELECT sz FROM szavazas sz WHERE sz.tipus='JELENLET' AND sz.idopont = (SELECT MAX(value_column) FROM your_table_name)", nativeQuery = true)
    SzavazasEntity findOldestJelenletiSzavazas();
}
