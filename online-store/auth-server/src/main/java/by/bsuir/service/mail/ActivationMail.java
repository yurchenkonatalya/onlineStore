package by.bsuir.service.mail;

import java.util.HashMap;
import java.util.Map;

public class ActivationMail implements Mail{
    private final String SUBJECT = "Confirm you email address";
    private final String LOCATION = "key";
    private final String KEY_ACTIVATION = "activationKey";


    private final String receiver;
    private final String key;
    private Map<String, Object> context;

    public ActivationMail(String receiver, String key){
        this.receiver = receiver;
        this.key = key;
        context = new HashMap<>();
        context.put(KEY_ACTIVATION, key);
    }

    @Override
    public String getSubject() {
        return SUBJECT;
    }

    @Override
    public String getLocation() {
        return LOCATION;
    }

    @Override
    public String getReceiver() {
        return receiver;
    }

    public String getKey(){
        return key;
    }

    @Override
    public Map<String, Object> getContext() {
        return context;
    }
}
