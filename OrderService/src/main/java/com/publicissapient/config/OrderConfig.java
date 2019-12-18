package com.publicissapient.config;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.publicissapient.config.DatabaseConfig;

@Component
public class OrderConfig {
	@Autowired
	private DatabaseConfig config;
	private Bucket bucket;
	private Cluster cluster;

	public Bucket getBucket() {
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
