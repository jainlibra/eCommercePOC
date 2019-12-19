package com.catalogmanagement.auth.usermodule.dao;

import com.catalogmanagement.auth.usermodule.util.User;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "user")
public interface StoreUserDetailsDao extends CouchbaseRepository<User,String> {
    User findByName(String name);
}
