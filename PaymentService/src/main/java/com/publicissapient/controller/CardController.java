package com.publicissapient.controller;

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

        @PostMapping("/payment/cardDetail/{userId}")
        public String saveCardDetail(@RequestBody CardDetail cardDetail,@PathVariable String userId) throws CardDuplicationException {
            System.out.println(cardDetail.toString());
            return cardService.saveCardDetail(userId,cardDetail);


        }


    @RequestMapping(value = "/payment/cardDetail/{userId}", method = RequestMethod.GET)
    public CardsInfo getCardDetail(@PathVariable String userId)
    {
        return cardService.getCardDetail(userId);

    }
    @RequestMapping(value = "/payment/cardDetail/{cardNo}", method = RequestMethod.DELETE)
    public String deleteCardDetail(@PathVariable String cardNo)
    {
         return cardService.deleteCardDetail(cardNo);

    }

}
