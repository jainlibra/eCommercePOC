package com.publicissapient.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.search.SearchQuery;
import com.couchbase.client.java.search.queries.MatchQuery;
import com.couchbase.client.java.search.result.SearchQueryResult;
import com.couchbase.client.java.search.result.SearchQueryRow;
import com.publicissapient.config.OrderConfig;
import com.publicissapient.handler.ResourceNotFoundException;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private OrderConfig orderConfig;
	public String getOrderByOrderId(long orderId) throws ResourceNotFoundException {
		//simpleTextQuery(orderConfig.getBucket());
		 JsonDocument jsonDocument = orderConfig.getBucket().get("order::"+orderId);
		if(jsonDocument==null) {
			throw new ResourceNotFoundException("resouce not found");
		}
		return jsonDocument.content().toString();
	}

    public static void simpleTextQuery(Bucket bucket) {
        String indexName = "ordersync-sample-idx";
        MatchQuery query = SearchQuery.match("test55");

        SearchQueryResult result = bucket.query(
            new SearchQuery(indexName, query).limit(10));

        printResult("Simple Text Query", result);
    }
    private static void printResult(String label, SearchQueryResult resultObject) {
        System.out.println();
        System.out.println("= = = = = = = = = = = = = = = = = = = = = = =");
        System.out.println("= = = = = = = = = = = = = = = = = = = = = = =");
        System.out.println();
        System.out.println(label);
        System.out.println();

        for (SearchQueryRow row : resultObject) {
            System.out.println(row);
        }
    }
	
}
