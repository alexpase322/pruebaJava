package com.example.persistant.interfaces;


import com.example.persistant.models.Mall;
import com.example.persistant.models.MallWatchman;
import com.example.persistant.models.Watchman;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MallwatchmanDaoImplement implements MallwatchmanDao {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    MallDao mallDao;

    @Autowired
    WatchmanDao watchmanDao;

    @Override
    public boolean asignarVigilante(Long watchmanId, Long mallId){
        try {
            Mall mall_find = mallDao.getMallById(mallId);
            Watchman watchman_find = watchmanDao.getWatchmanById(watchmanId);
            MallWatchman mallWatchman = new MallWatchman();
            mallWatchman.setMall(mall_find);
            mallWatchman.setWatchman(watchman_find);
            entityManager.merge(mallWatchman);
            return true;
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return false;
        }
    }
}
