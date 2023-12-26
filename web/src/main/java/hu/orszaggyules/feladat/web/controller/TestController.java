package hu.orszaggyules.feladat.web.controller;

import hu.orszaggyules.feladat.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/testGet/{value}", method = RequestMethod.GET)
    public String testPost(@PathVariable int value) {
        return testService.getString(value);
    }
}
