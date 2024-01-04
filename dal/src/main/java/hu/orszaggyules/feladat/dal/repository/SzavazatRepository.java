package hu.orszaggyules.feladat.dal.repository;


import hu.orszaggyules.feladat.dal.domain.SzavazatEntity;
import hu.orszaggyules.feladat.dal.domain.SzavazatIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SzavazatRepository extends JpaRepository<SzavazatEntity, SzavazatIdEntity> {
}
