package com.publicissapient.controller;

import com.publicissapient.Exception.CardDetailNotFound;
import com.publicissapient.Exception.CardDuplicationException;
import com.publicissapient.pojo.CardDetail;
import com.publicissapient.pojo.CardsInfo;
import com.publicissapient.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {
    @Autowired
    CardService cardService;

        @PostMapping("/user/{userId}/cardDetail")
        public String saveCardDetail(@RequestBody CardDetail cardDetail,@PathVariable String userId) throws CardDuplicationException {
            System.out.println(cardDetail.toString());
            return cardService.saveCardDetail(userId,cardDetail);


        }


    @RequestMapping(value = "/user/{userId}/cards", method = RequestMethod.GET)
    public CardsInfo getCardsDetailList(@PathVariable String userId) throws CardDetailNotFound {
        return cardService.getCardDetailList(userId);

    }
    @RequestMapping(value = "/user/{userId}/card/{cardNo}", method = RequestMethod.DELETE)
    public String deleteCardDetail(@PathVariable String userId,@PathVariable String cardNo) throws CardDetailNotFound {
         return cardService.deleteCardDetail(userId,cardNo);

    }

    @RequestMapping(value="/user/{userId}/cardDetail/{cardNo}" ,method =RequestMethod.GET)
    public CardDetail getCardDetail(@PathVariable String userId,@PathVariable String  cardNo) throws CardDetailNotFound {
        return cardService.getCardDetail(userId,cardNo);
    }

}
