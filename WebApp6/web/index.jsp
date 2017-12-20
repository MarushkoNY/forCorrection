<%-- 
    Document   : index
    Created on : 15.12.2017, 15:08:59
    Author     : Nikolay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="storeData" method="post">
            Store current time and IP address: <button type="submit">STORE</button>
        </form>
        <br><hr>
        <form action="getData" method="get">
            Get time and IP address of the last request: <button type="submit">GET</button>
        </form> 
    </body>
</html>
