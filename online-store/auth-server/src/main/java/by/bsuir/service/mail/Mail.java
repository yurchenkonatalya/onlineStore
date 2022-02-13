package by.bsuir.service.mail;


import java.util.Map;

public interface Mail {
    String getSubject();
    String getLocation();
    String getReceiver();
    Map<String, Object> getContext();
}
