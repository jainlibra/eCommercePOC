package com.publicissapient.dao;

import com.publicissapient.Exception.CardDuplicationException;
import com.publicissapient.pojo.CardDetail;
import com.publicissapient.pojo.CardsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CardDaoImpl {

    @Autowired
    CardRepository cardRepository;

    public String saveCardDetail(String userId,CardDetail cardDetail) throws CardDuplicationException {
        ArrayList<CardDetail> cardList=new ArrayList<>();
        CardsInfo cInfo;
        System.out.println(cardDetail.toString());
        if(!cardRepository.existsById(userId)) {
            cInfo=new CardsInfo();
            cInfo.setUserId(userId);
            cInfo.setListCard(cardList);
            cardList.add(cardDetail);
            cardRepository.save(cInfo);
        }
        else
        {
            cInfo=cardRepository.findById(userId).get();
            if(cInfo.getListCard().contains(cardDetail))
                throw new CardDuplicationException();
            cInfo.getListCard().add(cardDetail);
            cardRepository.save(cInfo);
        }

        return "SUCCESS";

    }

    public String  deleteCardDetail(String cardNo) {
        cardRepository.deleteById(cardNo);

        return "SUCCESS";
    }

    public CardsInfo getCardDetail(String userId) {
        return cardRepository.findById(userId).get();
    }
}
