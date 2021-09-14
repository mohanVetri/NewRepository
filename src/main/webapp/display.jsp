<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Display Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    </head>
    <body>
        <jsp:include page="index.jsp"></jsp:include>
        <span id="output"></span>
        <script>
                $.ajax("http://localhost:8080/LoginUsingSpringMVC/displayJson",{
                    method: "GET",
                success:function(data,status,xhr){
                    $("#output").html(data.message);
                },
                error: function(jqXhr, textStatus, errorMessage){
                    alert(textStatus);
                }
                })
        </script>
        <jsp:include page="loginForm.jsp" /> 
    </body>
</html>
