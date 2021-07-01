# Prova finale di Ingegneria del Software 2021
## Gruppo GC10

- ### 910003 Luca Polattini 
- ### 909986 Ariel Ratzonel  
- ### 910033 Matias Salaris



## Implemented functionalities 

| Functionality | 
|:-----------------------|
| Basic rules | 
| Complete rules |
| Socket | 
| CLI | 
| Multiple games |




## Test coverage 
![Screenshot Coverage](https://github.com/LucaPolattini/ing-sw-2021-polattini-ratzonel-salaris/blob/master/Coverage/Coverage_final.JPG?raw=true)

(Total number of tests: 58)



## How to generate the JAR archives from terminal
1. Move to the project folder
2. Run the command 
```
mvn package 
```
3. Locate the generated JAR files in the /target folder



## How to run the application
The generated JAR ships all 2 applications, that can be accessed as follows:

### Server
Remember to specify the port number.
It is recommended to run this as Administrator.
```
java -jar GC10-1.0-SNAPSHOT.jar -server <port number>
```
### CLI
Remember to specify the port number and the server's IPv4.
```
java -jar GC10-1.0-SNAPSHOT.jar -cli <port number> <server's IPv4 (example: 192 168 1 241)>
```
