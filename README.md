# JMS Project with ActiveMQ

This project demonstrates sending and receiving JMS messages using ActiveMQ as the broker. It was developed in Java with Maven and uses the Jakarta JMS API.

## Requirements

- Java 11 or higher  
- Maven 3.6+  
- ActiveMQ running (default: `tcp://localhost:61616`)

## ActiveMQ Setup

1. Download and install [ActiveMQ](https://activemq.apache.org/).  
2. Start the service with the appropriate command (e.g., `bin/activemq start`).  
3. Make sure the broker is listening on port `61616`.

## Build and Run

### Compile the project:

`bash`
mvn clean compile


### To run the message sender application:

`bash`
mvn exec:java -Dexec.mainClass="com.pedrohk.JMSSender"


### To run the receiver application:

If you have a message receiver application, execute it with the appropriate command.

## Project Structure

* `src/main/java/com/pedrohk/JMSSender.java`: Class that sends a message to the queue `my.queue`.
* `src/main/java/com/pedrohk/JMSReceiver.java`: *(Example)* Class responsible for receiving messages.

## Notes

* Ensure the broker URL (`tcp://localhost:61616` by default) is correct.
* If you encounter connection errors, review your ActiveMQ configuration and port settings.
