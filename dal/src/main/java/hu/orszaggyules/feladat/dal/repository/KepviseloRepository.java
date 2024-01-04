package hu.orszaggyules.feladat.dal.repository;

import hu.orszaggyules.feladat.dal.domain.KepviseloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KepviseloRepository extends JpaRepository<KepviseloEntity, String> {
    boolean existsAllByIdIn(List<String> ids);
}
