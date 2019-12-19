package com.publicissapient.pojo;

import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.List;

@Document
public class CardsInfo {
    @Id
    private String userId;
    private List<CardDetail> listCard;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CardDetail> getListCard() {
        return listCard;
    }

    public void setListCard(List<CardDetail> listCard) {
        this.listCard = listCard;
    }
}
