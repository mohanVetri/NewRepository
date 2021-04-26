<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    </head>
    <body>
        <jsp:include page="index.jsp" />
       <span id="message"></span>
       <span id="login"></span>
        <script>
            $.ajax({
                url: "http://localhost:8080/LoginUsingSpringMVC/welcomeJson",
                method:"GET",
                success: function(data){
                    if(data.session!=null){
                        $("#message").html(data.name+","+data.message);
                    }
                    else{
                        $("#message").html(data.message);
                        $("#login").load("loginForm.jsp");
                    }
                }

            })
        </script>
    </body>
</html>