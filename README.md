# Java websocket example
This example uses [javax.websocket-api] (https://mvnrepository.com/artifact/javax.websocket/javax.websocket-api/1.1) with the container or webserver provided implementation.

###How to run

- Execute `mvn clean install`
- Deploy generated **java-websocket-starter.war** file in any servlet container or websever of your choice
- `Start` servlet container/webserver
- Access the websocket using URL **ws://localhost:\<port>/java-websocket-starter/websocket**
- Send requests to the websocket server like for example
    - `{"type":"REGISTRATION_REQUEST"}` This will register client for broadcasts
    - `{"type":"BROADCAST_REQUEST","message":"Hello all!"} ` This will send message to all the registered clients
    
  
###Note:
To test the websocket any language or tools can be used like [this] (https://chrome.google.com/webstore/detail/simple-websocket-client/pfdhoblngboilpfeibdedpjgfnlcodoo?utm_source=chrome-ntp-icon) chrome extension
