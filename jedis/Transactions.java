package com.pivotal.edu.redis;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.*;

/**
 * Redis transactions
 *
 */
public class Transactions 
{
	private static Jedis jedis;
	
	private static Response<String> updateOrderStatus(Transaction txn, String id, String status) {
		
    	// Define the key
    	String key = "order:" + id;
		
    	// We'll want to set multiple fields in our hash, so create a map to store them
    	Map<String, String> hash = new HashMap<String, String>();
    	hash.put("id", id);
    	hash.put("status", status);
    	
    	// Put the entire map into Redis
		return txn.hmset(key, hash);
		
	}
	
	
	private static Response<Long> storeOrderItems(Transaction txn, String orderId, String[] orderItemIds) {
		
		// Define the key
		String key = "orderItems:" + orderId;
		
		// Put order item ID's into a Redis set 
		return txn.sadd(key, orderItemIds);
	
	}
	
	
	private static Response<Long> addOrderToProcessList(Transaction txn, String id) {
		
    	// Define the key
    	String key = "OrdersToProcess";
		
    	// Add the order ID to the end of the list
    	return txn.rpush(key, id);
    	
	}
	
	
    public static void main( String[] args )
    {
    	// Open a connection to Redis
    	jedis = new Jedis("192.168.73.129");
    	
    	// Create the orderID and orderItemIds variables
    	String orderId = "6884";
    	String[] orderItemIds = {"73332", "855749", "20003"};
    	
    	// Start the transaction
    	Transaction txn = jedis.multi();
    	
    	// Call the updateOrderStatus(), storeOrderItems(), and addOrderToProcessList() methods
    	Response<String> rsp1 = updateOrderStatus(txn, orderId, "received");
    	Response<Long> rsp2 = storeOrderItems(txn, orderId, orderItemIds);
    	Response<Long> rsp3 = addOrderToProcessList(txn, orderId);

    	// Execute the transaction
    	txn.exec();
    	
    	// Print out the results of each step in the transaction
    	System.out.println("rsp1=" + rsp1.get());
    	System.out.println("rsp2=" + rsp2.get());
    	System.out.println("rsp3=" + rsp3.get());
    	
    	// Close the connection
    	jedis.close();
        
    }
}
