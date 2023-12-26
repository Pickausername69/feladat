package hu.orszaggyules.feladat.dal.dao;

import hu.orszaggyules.feladat.dal.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDao {
    @Autowired
    private TestRepository testRepository;

    public String getString(int value) {
        return testRepository.findById(value).get().getStrValue();
    }
}
