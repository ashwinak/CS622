# Steps to run the gRPC service.
This code implements one or more gRPC service where the client subscribes to topics via 
gRPC channel on a specific TCP port. The server responds back with the response.

# First run the server code to start listening on port 50051

# Step 1 : Execute trafficServer.java

``` 
Server Started
Listening on port: 50052
```
# Step 2 : Now execute clientSubscribe.java

``` 
############################
Enter from the following topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) HighestLeadTimeAndCost: 
6) QueryProductCostAndLeadTime: 
7) StopSubscription/ShutDown: 
Enter your choice: 
5
#### Subscription topic is : ProductCostAndLeadTime
Enter More Specific Queries in ProductCostAndLeadTime Topic: 
5a) List Products with N lead time in Days (200 days) : 

200
200
[Switch, Router]
Enter More Specific Queries in ProductCostAndLeadTime Topic: 
5b) List products greater than N Cost in $ (150 $) :  

150$
150$
[Router]
#### Subscription topic is : ProductCostAndLeadTime
[{Router=$1000 and 300 Days}, {Switch=$500 and 250 Days}, {Server=$150 and 100 Days}]


############################
Enter from the following topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) HighestLeadTimeAndCost: 
6) QueryProductCostAndLeadTime: 
7) StopSubscription/ShutDown: 
Enter your choice: 
7
Shutting Down
### Implementing Down Casting
Printing all topic schemas supported by Server
### Polymorphic - > Many Forms
The topic most subscribed by the client
The topic having the longest run time

Process finished with exit code 0

```

## The user enters any of the given service option. The client code will
## start the gRPC service to the remote machine.

# Step 3: Junit Test

# Execute clientSubscribeTest.java

``` 
Test Passed.
Process finished with exit code 0
```

# Step 4 : Execute as a JAR file

```
ashwinak@ashwinak-u2:~$ java -jar '/media/ashwinak/Ashwin-CBK/CS622-Advanced Programming Technique/Project/out/artifacts/gRPC_Project_main_jar/gRPC-Project.main.jar' 
 

############################
Enter from the following topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) HighestLeadTimeAndCost: 
6) QueryProductCostAndLeadTime: 
7) StopSubscription/ShutDown: 
Enter your choice: 
5
#### Subscription topic is : ProductCostAndLeadTime
Enter More Specific Queries in ProductCostAndLeadTime Topic: 
5a) List Products with N lead time in Days (200 days) : 

123
Invalid Option Selected, only supports '200' days as input!
Enter More Specific Queries in ProductCostAndLeadTime Topic: 
5b) List products greater than N Cost in $ (150 $) :  

111
Invalid Option Selected, only supports '150$'  as input!
#### Subscription topic is : ProductCostAndLeadTime

File write failed, if executing as JAR file this is expected.

[{Router=$1000 and 300 Days}, {Switch=$500 and 250 Days}, {Server=$150 and 100 Days}]


############################
Enter from the following topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) HighestLeadTimeAndCost: 
6) QueryProductCostAndLeadTime: 
7) StopSubscription/ShutDown: 
Enter your choice: 
7
Shutting Down
### Implementing Down Casting
Printing all topic schemas supported by Server
### Polymorphic - > Many Forms
The topic most subscribed by the client
The topic having the longest run time
ashwinak@ashwinak-u2:~$ 




```