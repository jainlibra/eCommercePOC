package com.publicissapient.dao;

import com.publicissapient.pojo.CardsInfo;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CouchbaseRepository<CardsInfo,String> {
}
