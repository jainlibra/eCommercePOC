package com.publicissapient.service;

import com.publicissapient.Exception.CardDetailNotFound;
import com.publicissapient.Exception.CardDuplicationException;
import com.publicissapient.pojo.CardDetail;
import com.publicissapient.pojo.CardsInfo;

public interface CardService {
    String saveCardDetail(String userId, CardDetail cardDetail) throws CardDuplicationException;

    CardsInfo getCardDetailList(String userId) throws CardDetailNotFound;

    String deleteCardDetail(String userId,String cardNo) throws CardDetailNotFound;

    CardDetail getCardDetail(String userId, String cardNo) throws CardDetailNotFound;
}
