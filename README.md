# Software Engineering Project 2021

## Group GC10

* [Ariel Ratzonel](https://github.com/ArielRatzonel00) (909986) 
* [Luca Polattini](https://github.com/LucaPolattini) (910003) 
* [Matias Salaris](https://github.com/MatiasSalaris) (910033) 

Master of Renaissance Board Game is the final test of "Software Engineering", course of "Computer Science Engineering" held at Politecnico di Milano (2020/2021).\
Teacher: Gianpaolo Cugola

<a href="url"><img src="https://github.com/fillics/ingswAM2021-calio-bartolozzi-caleffi/blob/master/src/main/resources/images/github/imageReadMe.png" align="center" height="450" width="800" ></a>


# Implemented Functionalities
| Functionality        | Status  | 
| ------------- |:-------------:| 
| Basic rules     | :heavy_check_mark: | 
| Complete rules    | :heavy_check_mark:     |
| Socket    | :heavy_check_mark:     |   
| CLI    | :heavy_check_mark:     |    
| Multiple games    | :heavy_check_mark:     |   
| Resilience to Disconnections (single player and multiplayer) | :heavy_check_mark:      | 


# How to generate the JAR archives from terminal
1. Move to the project folder
2. Run the command 
```
mvn package 
```
3. Locate the generated JAR files in the /target folder


# How to generate the JAR archives from terminal
1. Move to the project folder
2. Run the command 
```
mvn package 
```
3. Locate the generated JAR files in the /target folder

# Test coverage 
![Screenshot Coverage](https://raw.githubusercontent.com/LucaPolattini/ing-sw-2021-polattini-ratzonel-salaris/master/Coverage/Coverage02_07_21.JPG?token=ATCFD3GVBR4PEQZ6PRVO4K3A5CDAQ)

(Total number of tests: 60)


## Server
Remember to specify the port number.
It is recommended to run this as Administrator.
```
java -jar GC10-1.0-SNAPSHOT-jar-with-dependencies.jar -server port
```

Example: java -jar GC10-1.0-SNAPSHOT-jar-with-dependencies.jar -server 1334
### CLI
Remember to specify the port number and the server's IPv4 address.
```
java -jar GC10-1.0-SNAPSHOT-jar-with-dependencies.jar -cli port IPv4
```
N.B. The server's IPv4 address must be written without dots.

Example: java -jar GC10-1.0-SNAPSHOT-jar-with-dependencies.jar -cli 1334 84 221 232 254
