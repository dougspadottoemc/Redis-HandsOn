package com.pivotal.edu.redis;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.*;

/**
 * Redis Datastructures
 *
 */
public class SimpleDatastructures 
{
	private static Jedis jedis;
	
	private static void updateOrderStatus(String id, String status) {
		
    	// Define the key
    	String key = "order:" + id;
		
    	// We'll want to set multiple fields in our hash, so create a map to store them
    	HashMap<String, String> hash = new HashMap<String, String>();
    	hash.put("id", id);
    	hash.put("status", status);
    	
    	// Put the entire map into Redis
		jedis.hmset(key, hash);

	}
	
	
	private static void storeOrderItems(String orderId, String[] orderItemIds) {
		
		// Define the key
		String key = "orderItems:" + orderId;
		
		// Put order item ID's into a Redis set 
		jedis.sadd(key, orderItemIds);
	
	}
	
	
	private static void addOrderToProcessList(String id) {
		
    	// Define the key
    	String key = "OrdersToProcess";
		
    	// Add the order ID to the end of the list
    	jedis.rpush(key, id);
    	
	}
	
	
    public static void main( String[] args )
    {
    	// Open a connection to Redis
    	jedis = new Jedis("127.0.0.1");
    	
    	// Create the orderID and orderItemIds variables
    	String orderId = "6884";
    	String[] orderItemIds = {"73332", "855749", "20003"};
    	
    	// Call the updateOrderStatus(), storeOrderItems(), and addOrderToProcessList() methods
    	updateOrderStatus(orderId, "received");
    	storeOrderItems(orderId, orderItemIds);
    	addOrderToProcessList(orderId);
    	
    	// Close the connection
    	jedis.close();
        
    }
}
