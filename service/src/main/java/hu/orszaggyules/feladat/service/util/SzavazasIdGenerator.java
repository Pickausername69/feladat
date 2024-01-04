package hu.orszaggyules.feladat.service.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SzavazasIdGenerator {
    public String generateSzavazasId(int idLength) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < idLength; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }
}
