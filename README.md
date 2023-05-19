# Steps to run the gRPC service.
This code implements one or more gRPC service where the client subscribes to topics via 
gRPC channel on a specific TCP port. The server responsd back with the response.

# First run the server code to start listening on port 50051

# Step 1 : Execute trafficServer.java

``` 
Server Started
Listening on port: 50052
```
# Step 2 : Now execute clientSubscribe.java

``` 
Enter from the following topics to subscribe: 
1) Traffic statistics: 
2) Health of the System: 
3) Uptime of the System 
4) Check server capability 
5) Check active subscription 
Enter your choice: 
```

## The user enters any of the given service option. The client code will
## start the gRPC service to the remote machine.

# Step 3: Junit Test

# Execute clientSubscribeTest.java

``` 
Test Passed.
Process finished with exit code 0
```