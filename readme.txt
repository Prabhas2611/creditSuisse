I have created a micro-service named crediSuisse. This micro-service will publish two end points.
1) POST API: to save the logs in the HSQLDB
2) GET API: to display all the data saved in HSQLDB

On running the application, it will publish the end points at port 8080. During run process, it will create the table
Log_Table. 

1) POST API: end point for this is localhost:8080/save. You need to provide the txt file location for the input.
On hitting this end point, it will create entry in the table Log_Table for the event id, event duration and alert will
be true if duration is more than 4 milliseconds.

2) GET API: end point for this is localhost:8080/all. Once the above API is hit and entries are saved into database.
This API will display all the saved logs from table in the JSON format in the output.

Test classes LogControllerTest and LogServiceTest covers the test coverage for LogController and LogService classes.

For the Exception handling HandleException.java class is created for central level exception handling.
Also for logging aspect is created as Logging.java.