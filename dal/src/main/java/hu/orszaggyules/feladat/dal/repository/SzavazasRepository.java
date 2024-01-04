package hu.orszaggyules.feladat.dal.repository;

import hu.orszaggyules.feladat.dal.domain.SzavazasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SzavazasRepository extends JpaRepository<SzavazasEntity, String> {
}
