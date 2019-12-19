package com.publicissapient.service;

import com.publicissapient.Exception.CardDuplicationException;
import com.publicissapient.pojo.CardDetail;
import com.publicissapient.pojo.CardsInfo;

public interface CardService {
    String saveCardDetail(String userId, CardDetail cardDetail) throws CardDuplicationException;

    CardsInfo getCardDetail(String userId);

    String deleteCardDetail(String cardNo);
}
