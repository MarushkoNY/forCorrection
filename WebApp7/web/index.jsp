<%-- 
    Document   : index
    Created on : 18.12.2017, 10:18:05
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
        <form method="post" action="Store">
            Store IP address and time of this request: <button type="submit">Store</button>
        </form>
        <br><hr>
        <form action="GetData" method="get">
            Get IP and time of the last request: <button type="submit">Get</button>
        </form>
    </body>
</html>
