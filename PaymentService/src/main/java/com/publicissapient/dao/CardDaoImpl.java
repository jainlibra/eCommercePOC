package com.publicissapient.dao;

import com.publicissapient.Exception.CardDetailNotFound;
import com.publicissapient.Exception.CardDuplicationException;
import com.publicissapient.pojo.CardDetail;
import com.publicissapient.pojo.CardsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

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

    public String  deleteCardDetail(String userId,String cardNo) throws CardDetailNotFound {
        CardsInfo cardDetail = getCardDetailList(userId);
        System.out.println(cardDetail.getListCard());
        cardDetail.getListCard().removeIf(a->a.getCardNo().equals(cardNo));
        System.out.println(cardDetail.getListCard());
        cardRepository.save(cardDetail);

        return "SUCCESS";
    }

    public CardsInfo getCardDetailList(String userId) throws CardDetailNotFound {
        System.out.println(cardRepository.existsById(userId) +"  "+userId);
        if(!cardRepository.existsById(userId))
            throw new CardDetailNotFound();
        return cardRepository.findById(userId).get();
    }

    public CardDetail getCardDetail(String userId, String cardNo) throws CardDetailNotFound {
        Optional<CardDetail> cardDetailStream = getCardDetailList(userId).getListCard().stream().filter(a -> a.getCardNo().equals(cardNo)).findFirst();
        if(!cardDetailStream.isPresent())
            throw new CardDetailNotFound();
        return cardDetailStream.get();
    }
}
