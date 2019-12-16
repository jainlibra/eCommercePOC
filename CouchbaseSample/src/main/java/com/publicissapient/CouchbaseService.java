package com.publicissapient;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

@Service
public class CouchbaseService {
	@Autowired
	private Database config;

    private Bucket bucket;
    private Cluster cluster;

    
    public Bucket getBucket() {
        //this.config = config;

        //connect to the cluster and open the configured bucket
        this.cluster = CouchbaseCluster.create(config.getNodes());
        this.bucket = cluster.openBucket(config.getBucket(), config.getPassword());
        return this.bucket;
    }

    @PreDestroy
    public void preDestroy() {
        if (this.cluster != null) {
            this.cluster.disconnect();
        }
    }

}
