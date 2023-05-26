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

# Step 4 : Execute as a JAR file

```
ashwinak@ashwinak-u2:~$ java -jar '/media/ashwinak/Ashwin-CBK/CS622-Advanced Programming Technique/Project/out/artifacts/gRPC_Project_jar/gRPC-Project.jar' 
Enter from the following topics to subscribe: 
1) Stream Traffic statistics: 
2) Stream System Health:  
3) Stream Common Friends in FB Acct: 
4) Stream Weather Information: 
5) Stream Flight Status: 
Enter your choice: 
1
#### Subscription Topic is: r1/openconfig/interfaces/interface/state

File write failed, if executing as JAR file this is expected.

[{openconfig/interfaces/interface/state/r1/aggregate=1tbps}, {openconfig/interfaces/interface/state/r1/aggregate=2tbps}, {openconfig/interfaces/interface/state/r1/aggregate=3tbps}, {openconfig/interfaces/interface/state/r1/aggregate=4tbps}, {openconfig/interfaces/interface/state/r1/aggregate=5tbps}, {openconfig/interfaces/interface/state/r1/aggregate=6tbps}, {openconfig/interfaces/interface/state/r1/aggregate=7tbps}, {openconfig/interfaces/interface/state/r1/aggregate=8tbps}, {openconfig/interfaces/interface/state/r1/aggregate=9tbps}, {openconfig/interfaces/interface/state/r1/aggregate=10tbps}]
### Implementing Down Casting
Printing all topic schemas supported by Server
### Polymorphic - > Many Forms
The topic most subscribed by the client
The topic having the longest run time
Shutting Down
ashwinak@ashwinak-u2:~$ java -jar '/media/ashwinak/Ashwin-CBK/CS622-Advanced Programming Technique/Project/out/artifacts/gRPC_Project_jar/gRPC-Project.jar' 
Enter from the following topics to subscribe: 
1) Stream Traffic statistics: 
2) Stream System Health:  
3) Stream Common Friends in FB Acct: 
4) Stream Weather Information: 
5) Stream Flight Status: 
Enter your choice: 
2
#### Subscription topic is : System Health

File write failed, if executing as JAR file this is expected.

[{CPU_Usage=35%}, {Memory_Usage=44%}, {System_State=Good}, {System_Capacity=115tbps}, {System_Availability=60% Available}]
### Implementing Down Casting
Printing all topic schemas supported by Server
### Polymorphic - > Many Forms
The topic most subscribed by the client
The topic having the longest run time
Shutting Down
ashwinak@ashwinak-u2:~$ 



```