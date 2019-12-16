package com.publicissapient;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

@RestController
public class CouchbaseController {
	
	@Autowired
	private CouchbaseService couchbaseService;
	@RequestMapping(method = RequestMethod.GET,value="/customer/bucket/{customerName}")
	public String getBucketName(@PathVariable String customerName) {
		return couchbaseService.getBucket().get("customer::"+customerName).content().toString();
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/customer/add")
	public void addCustomerDoc(@RequestBody String customerJson) {
		//System.out.println("here now");
		//System.out.println(reqJson.get("userName"));
		/*
		 * JsonObject customer = JsonObject.empty().put("email",
		 * reqJson.get("email")).put("userName", reqJson.get("userName"))
		 * .put("firstName", reqJson.get("firstName")).put("lastName",
		 * reqJson.get("lastName"));
		 */
		JsonObject customer = JsonObject.fromJson(customerJson);
		JsonDocument customerDoc = JsonDocument.create("customer"+"::"+customer.get("userName"), customer);
		couchbaseService.getBucket().insert(customerDoc);
	}

}
