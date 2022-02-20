package by.bsuir.service.impl;

import by.bsuir.service.CryptoService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class CryptoServiceImpl implements CryptoService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CryptoServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public boolean checkPassword(String userPass, String databasePass) {
        return bCryptPasswordEncoder.matches(userPass, databasePass);
    }

    @Override
    public String createActivationKey(String email) {
        return Base64.getEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String getEmailFromActivationKey(String key) {
        return new String(Base64.getDecoder().decode(key));
    }
}
