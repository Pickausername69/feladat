package hu.orszaggyules.feladat.dal.repository;

import hu.orszaggyules.feladat.dal.domain.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {
}
