package by.bsuir.service.schedule;

import by.bsuir.dao.TokenDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class ExpirationTokenExecutor {

    private final TokenDao tokenDao;

    public ExpirationTokenExecutor(TokenDao tokenDao){
        this.tokenDao = tokenDao;
    }

    @Transactional
  //  @Scheduled(fixedDelayString = "${jwt.time.delete-tokens}")
    public void deleteExpirationToken(){
        log.info("start remove");
        tokenDao.removeExpirationTokens();
        log.info("end remove");
    }
}
