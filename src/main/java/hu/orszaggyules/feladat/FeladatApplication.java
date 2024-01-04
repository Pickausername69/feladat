package hu.orszaggyules.feladat;

import hu.orszaggyules.feladat.web.converter.SzavazasSaveRequestSzavazatToSzavazatConverter;
import hu.orszaggyules.feladat.web.converter.SzavazasSaveRequestToSzavazasConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FeladatApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FeladatApplication.class, args);
        System.out.println("[!] "+context.getBeansOfType(SzavazasSaveRequestToSzavazasConverter.class));
    }

}
