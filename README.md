# Steps to run the gRPC service.
This code implements one or more gRPC service where the client subscribes to topics via 
gRPC channel on a specific TCP port. The server responds back with the response.

# Pre-conditions
```
> Ensure SQLITE along with JDBC is installed before executing this code.
> Ensure port 50051 and 50052 is not occupied by any other process on the local Machine.
> Ensure Gradle Installation with proper settings.
```

# First run the server code to start listening on port 50051

# Step 1 : Execute trafficServer.java

``` 
Starting Thread1 for port 50051
Listening on port: 50051
### Starting new Thread and new port for full inventory list subscription....
Number of threads 4
Starting Thread2 for port 50052
Listening on port: 50052



```
# Step 2 : Now execute clientSubscribe.java

``` 

########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryProductAvailability: 
4) QueryHighestLeadTimeAndCost: 
5) QueryProductCostAndLeadTime: 
6) DownloadFullInventoryList and Shutdown: 
Enter your choice: 
1
#### Subscription Topic is: r1/openconfig/interfaces/interface/state
### Writing the response from server to a binary file
### Write object complete..

### Reading from the binary file..
 
  openconfig/interfaces/interface/state/r1/aggregate=1tbps
  openconfig/interfaces/interface/state/r2/aggregate=2tbps
  openconfig/interfaces/interface/state/r3/aggregate=3tbps
  openconfig/interfaces/interface/state/r4/aggregate=4tbps
  openconfig/interfaces/interface/state/r5/aggregate=5tbps
  openconfig/interfaces/interface/state/r6/aggregate=6tbps
  openconfig/interfaces/interface/state/r7/aggregate=7tbps
  openconfig/interfaces/interface/state/r8/aggregate=8tbps
  openconfig/interfaces/interface/state/r9/aggregate=9tbps
  openconfig/interfaces/interface/state/r10/aggregate=10tbps
  openconfig/interfaces/interface/state/r11/aggregate=11tbps
  openconfig/interfaces/interface/state/r12/aggregate=12tbps
  openconfig/interfaces/interface/state/r13/aggregate=13tbps
  openconfig/interfaces/interface/state/r14/aggregate=14tbps
  openconfig/interfaces/interface/state/r15/aggregate=15tbps















#Reading from SQLite Database....
#Number of rows in the Table TrafficStats from SQLite DB is 15

##Printing TrafficStats Table as is
RouterName  Stats
openconfig/interfaces/interface/state/r1/aggregate     1tbps
openconfig/interfaces/interface/state/r2/aggregate     2tbps
openconfig/interfaces/interface/state/r3/aggregate     3tbps
openconfig/interfaces/interface/state/r4/aggregate     4tbps
openconfig/interfaces/interface/state/r5/aggregate     5tbps
openconfig/interfaces/interface/state/r6/aggregate     6tbps
openconfig/interfaces/interface/state/r7/aggregate     7tbps
openconfig/interfaces/interface/state/r8/aggregate     8tbps
openconfig/interfaces/interface/state/r9/aggregate     9tbps
openconfig/interfaces/interface/state/r10/aggregate     10tbps
openconfig/interfaces/interface/state/r11/aggregate     11tbps
openconfig/interfaces/interface/state/r12/aggregate     12tbps
openconfig/interfaces/interface/state/r13/aggregate     13tbps
openconfig/interfaces/interface/state/r14/aggregate     14tbps
openconfig/interfaces/interface/state/r15/aggregate     15tbps

##Printing TrafficStats Table Ordered view
RouterName  Stats
openconfig/interfaces/interface/state/r10/aggregate     10tbps
openconfig/interfaces/interface/state/r11/aggregate     11tbps
openconfig/interfaces/interface/state/r12/aggregate     12tbps
openconfig/interfaces/interface/state/r13/aggregate     13tbps
openconfig/interfaces/interface/state/r14/aggregate     14tbps
openconfig/interfaces/interface/state/r15/aggregate     15tbps
openconfig/interfaces/interface/state/r1/aggregate     1tbps
openconfig/interfaces/interface/state/r2/aggregate     2tbps
openconfig/interfaces/interface/state/r3/aggregate     3tbps
openconfig/interfaces/interface/state/r4/aggregate     4tbps
openconfig/interfaces/interface/state/r5/aggregate     5tbps
openconfig/interfaces/interface/state/r6/aggregate     6tbps
openconfig/interfaces/interface/state/r7/aggregate     7tbps
openconfig/interfaces/interface/state/r8/aggregate     8tbps
openconfig/interfaces/interface/state/r9/aggregate     9tbps



##Printing TrafficStats Table joined with SysInfo Table
RouterName  Stats  CPUStats
openconfig/interfaces/interface/state/r1/aggregate     1tbps    35%
openconfig/interfaces/interface/state/r2/aggregate     2tbps    45%


########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryProductAvailability: 
4) QueryHighestLeadTimeAndCost: 
5) QueryProductCostAndLeadTime: 
6) DownloadFullInventoryList and Shutdown: 
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
3) QueryProductAvailability: 
4) QueryHighestLeadTimeAndCost: 
5) QueryProductCostAndLeadTime: 
6) DownloadFullInventoryList and Shutdown: 
Enter your choice: 
3
#### Subscription topic is : ProductAvailability
 Router=200 Count
 Server=75 Count
 Switch=100 Count 


########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryProductAvailability: 
4) QueryHighestLeadTimeAndCost: 
5) QueryProductCostAndLeadTime: 
6) DownloadFullInventoryList and Shutdown: 
Enter your choice: 
4
#### Subscription topic is : ProductCostAndLeadTime
Enter More Specific Queries in ProductCostAndLeadTime Topic: 
5a) List Products with N lead time in Days (200 days) : 

200
200
 Switch
 Router
Enter More Specific Queries in ProductCostAndLeadTime Topic: 
5b) List products greater than specific Cost(150$) :  

150$
150$
 Router


########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryProductAvailability: 
4) QueryHighestLeadTimeAndCost: 
5) QueryProductCostAndLeadTime: 
6) DownloadFullInventoryList and Shutdown: 
Enter your choice: 
5
#### Subscription topic is : ProductCostAndLeadTime
 Router=$1000 and 300 Days
 Switch=$500 and 250 Days
 Server=$150 and 100 Days 


########################################################
Select topics to subscribe: 
1) QueryTrafficStatistics: 
2) QuerySystemHealth:  
3) QueryProductAvailability: 
4) QueryHighestLeadTimeAndCost: 
5) QueryProductCostAndLeadTime: 
6) DownloadFullInventoryList and Shutdown: 
Enter your choice: 
6


Do you want to download Full Inventory List? (yes or no): 
Enter your choice: 
yes
### Downloading FullInventoryList from Server...
 Router
 Server
 Switch 
############
Shutdown channel & channel2....



############
### Implementing Down Casting
Printing all topic schemas supported by Server
### Polymorphic - > Many Forms
The topic most subscribed by the client
The topic having the longest run time

Process finished with exit code 0


```