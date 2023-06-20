# Steps to run the gRPC service.
This code implements one or more gRPC service where the client subscribes to topics via 
gRPC channel on a specific TCP port. The server responds back with the response.

# First run the server code to start listening on port 50051

# Step 1 : Execute trafficServer.java

``` 
Server Started
Listening on port: 50051

```
# Step 2 : Now execute clientSubscribe.java

``` 

########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) QueryHighestLeadTimeAndCost: 
6) QueryProductCostAndLeadTime: 
7) StopSubscription/ShutDown: 
Enter your choice: 
1
#### Subscription Topic is: r1/openconfig/interfaces/interface/state
### Writing the response from server to a binary file
### Write object complete..

### Reading from the binary file..
 
  openconfig/interfaces/interface/state/r1/aggregate=1tbps
  openconfig/interfaces/interface/state/r1/aggregate=2tbps
  openconfig/interfaces/interface/state/r1/aggregate=3tbps
  openconfig/interfaces/interface/state/r1/aggregate=4tbps
  openconfig/interfaces/interface/state/r1/aggregate=5tbps
  openconfig/interfaces/interface/state/r1/aggregate=6tbps
  openconfig/interfaces/interface/state/r1/aggregate=7tbps
  openconfig/interfaces/interface/state/r1/aggregate=8tbps
  openconfig/interfaces/interface/state/r1/aggregate=9tbps
  openconfig/interfaces/interface/state/r1/aggregate=10tbps

########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) QueryHighestLeadTimeAndCost: 
6) QueryProductCostAndLeadTime: 
7) StopSubscription/ShutDown: 
Enter your choice: 
2
#### Subscription topic is : System Health
 CPU_Usage=35%
 Memory_Usage=44%
 System_State=Good
 System_Capacity=115tbps
 System_Availability=60% Available 


########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) QueryHighestLeadTimeAndCost: 
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
ashwinak@ashwinak-u2:~$ java -jar '/media/ashwinak/Ashwin-CBK/CS622-Advanced Programming Technique/Project/out/artifacts/gRPC_Project_jar/gRPC-Project.jar' 


########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) QueryHighestLeadTimeAndCost: 
6) QueryProductCostAndLeadTime: 
7) StopSubscription/ShutDown: 
Enter your choice: 
1
#### Subscription Topic is: r1/openconfig/interfaces/interface/state

File write failed, if executing as JAR file this is expected.



########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) QueryHighestLeadTimeAndCost: 
6) QueryProductCostAndLeadTime: 
7) StopSubscription/ShutDown: 
Enter your choice: 
2
#### Subscription topic is : System Health

File write failed, if executing as JAR file this is expected.

 CPU_Usage=35%
 Memory_Usage=44%
 System_State=Good
 System_Capacity=115tbps
 System_Availability=60% Available 


########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) QueryHighestLeadTimeAndCost: 
6) QueryProductCostAndLeadTime: 
7) StopSubscription/ShutDown: 
Enter your choice: 
3
#### Subscription topic is : FullInventoryList

File write failed, if executing as JAR file this is expected.

 Router
 Server
 Switch 


########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) QueryHighestLeadTimeAndCost: 
6) QueryProductCostAndLeadTime: 
7) StopSubscription/ShutDown: 
Enter your choice: 
4
#### Subscription topic is : ProductAvailability

File write failed, if executing as JAR file this is expected.

 Router=200 Count
 Server=75 Count
 Switch=100 Count 


########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) QueryHighestLeadTimeAndCost: 
6) QueryProductCostAndLeadTime: 
7) StopSubscription/ShutDown: 
Enter your choice: 
5
#### Subscription topic is : ProductCostAndLeadTime
Enter More Specific Queries in ProductCostAndLeadTime Topic: 
5a) List Products with N lead time in Days (200 days) : 

200
src/main/java/trafficStatistics/client/Topic5a_HigherLeadTimes.txt (No such file or directory)
 Switch
 Router
Enter More Specific Queries in ProductCostAndLeadTime Topic: 
5b) List products greater than N Cost in $ (150 $) :  

150$
src/main/java/trafficStatistics/client/Topic5b_HigherCostProducts.txt (No such file or directory)
 Router


########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) QueryHighestLeadTimeAndCost: 
6) QueryProductCostAndLeadTime: 
7) StopSubscription/ShutDown: 
Enter your choice: 
6
#### Subscription topic is : ProductCostAndLeadTime

File write failed, if executing as JAR file this is expected.

 Router=$1000 and 300 Days
 Switch=$500 and 250 Days
 Server=$150 and 100 Days 


########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryFullInventoryList: 
4) QueryProductAvailability: 
5) QueryHighestLeadTimeAndCost: 
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