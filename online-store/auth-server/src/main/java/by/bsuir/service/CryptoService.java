package by.bsuir.service;

public interface CryptoService {
    String encodePassword(String password);
    boolean checkPassword(String userPass, String databasePass);
    String createActivationKey(String email);
    String getEmailFromActivationKey(String key);
}
