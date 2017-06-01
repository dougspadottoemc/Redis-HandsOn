# Objective

Examine some tips and techniques to manage and monitor your Redis server.

# Preparation

Make sure that your Redis server is running, and that you can connect to it from the command-line interface.

# Redis User Authentication

Redis allows simple username/password authentication.  Let's configure your server for this.

## Instructions

1.  Open your Redis configuration file for editing, and find the "requirepass" option.
2.  Uncomment it, and set the value to the password you want to use.  Keep in mind that for production, if you are setting this parameter you should set it to a very long string as Redis is extremely fast at serving requests.  So a malicious client could attempt to break the password through brute force.
3.  Restart the Redis server for the config changes to take effect.
4.  Connect to the server using the Redis CLI, and attempt to execute some basic commands.  You should get a "NOAUTH Authentication required" error.
5.  Execute the auth command with an invalid password to see the resulting error response.
6.  Now execute the auth command with the correct password, and retry some of the previous basic commands that failed earlier.  You should be able to execute them successfully now.

## Solution

`$ src/redis-cli`
`127.0.0.1:6379> info Keyspace`
`NOAUTH Authentication required.`
`127.0.0.1:6379> keys *`
`(error) NOAUTH Authentication required.`
`127.0.0.1:6379> auth wrongPassword`
`(error) ERR invalid password`
`127.0.0.1:6379> auth super5ecretP@ssword`
`OK`
`127.0.0.1:6379> info Keyspace`
`# Keyspace`
`db0:keys=5,expires=0,avg_ttl=0`
`127.0.0.1:6379> keys *`
`1) "myhash"`
`2) "location:kitten"`
`3) "mylist"`
`4) "mysortedset"`
`5) "myset"`
`127.0.0.1:6379>`

# Obfuscating Commands

To further secure your Redis server, we will look at obfuscating some of the more critical Redis commands.  This can be done in the config file, by adding the "rename-command" parameter to specify which command(s) are to be obfuscated.

## Instructions

1.  Open your Redis config file for editing, and find the "rename-command" parameter (which should currently be commented out).  Rename the CONFIG command to an empty string, which will completely disable it.
2.  Add another line to obfuscate the "INFO" command, to a string of your choice, then (re)start your Redis server.
3.  Start the Redis CLI and connect to your server.  First try executing a CONFIG command, you should get "(error) ERR unknown command 'config'".
4.  Now try to execute the INFO command, it should also return the same error.
5.  Use the obfuscated string you selected to run the INFO command, it should complete successfully this time.

## Solution

`$ src/redis-cli`
`127.0.0.1:6379> config set loglevel debug`
`(error) ERR unknown command 'config'`
`127.0.0.1:6379> info Keyspace`
`ERR unknown command 'info'`
`127.0.0.1:6379> getserverdetails Keyspace`
`"# Keyspace\r\ndb0:keys=5,expires=0,avg_ttl=0\r\n"`
`127.0.0.1:6379>`