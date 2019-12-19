package com.publicissapient.service;

import com.publicissapient.Exception.CardDuplicationException;
import com.publicissapient.dao.CardDaoImpl;
import com.publicissapient.pojo.CardDetail;
import com.publicissapient.pojo.CardsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {


    @Autowired
    CardDaoImpl cardDao;
    @Override
    public String saveCardDetail(String userId, CardDetail cardDetail) throws CardDuplicationException {
        return cardDao.saveCardDetail(userId,cardDetail);
    }

    @Override
    public CardsInfo getCardDetail(String userId) {
        return cardDao.getCardDetail(userId) ;
    }

    @Override
    public String deleteCardDetail(String cardNo) {
        return cardDao.deleteCardDetail(cardNo);
    }
}
