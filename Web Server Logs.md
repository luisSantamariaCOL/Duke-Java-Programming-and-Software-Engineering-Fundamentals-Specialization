### Understanding Log Files

* The first thing you want to do is rename a web server log file and represent the information in it in Java Objects:  
  * What does all of the information in the web server log mean?
  * How do yo represent it in a Java Class?
  
Entry from a web server log file: 

![web server log file](https://i.imgur.com/NKs4n0q.png?1)

This particular data came from the web server log for an Apache 2.4 web server.  
The IP address in a web server log indicates the device on the internet that made the request.  

### How we represent?

IP address -> **String** (**Note:** Java does have a built-in class for IP addresses, wich would give us some more features if we wanted to actually connect to that address.  
Date -> **Built-in Java Date class**
Request -> String
Status   -> int

    public class LogEntry {
            String ipAddress;
            Date accessTime;
            String request;
            int statusCode;
            int bytesReturned
    }
