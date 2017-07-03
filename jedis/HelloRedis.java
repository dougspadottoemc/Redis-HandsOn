package com.pivotal.edu.redis;

import redis.clients.jedis.*;

/**
 * Hello Redis!
 *
 */
public class HelloRedis 
{
    public static void main( String[] args )
    {
    	// Open a connection to Redis
    	Jedis jedis = new Jedis("127.0.0.1");
    	
    	// Define the key
    	String key = "Hello";
    	
    	// Insert the key-value pair into Redis
    	jedis.set(key, "Redis!");
    	
    	// Fetch the value, length, and first three characters from the server
    	String value = jedis.get(key);
    	long valLen = jedis.strlen(key);
    	String subString = jedis.getrange(key, 0, 2);
    	
    	// Print the values to the console
    	System.out.println( key + " " + value + ", length=" + valLen + ", substring=" + subString);
    	
    	// Delete the key from the server
    	jedis.del(key);
    	
    	// Close the connection
    	jedis.close();
        
    }
}
