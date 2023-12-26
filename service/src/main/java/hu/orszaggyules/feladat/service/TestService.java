package hu.orszaggyules.feladat.service;

import hu.orszaggyules.feladat.dal.dao.TestDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class TestService {
    @Autowired
    private TestDao testDao;
    public String getString(int value) {
        return testDao.getString(value);
    }
}
