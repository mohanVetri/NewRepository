<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Logout Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    </head>
    <body>
        <span id="include"></span>
            <span id="message"></span>
            <span id="page"></span>

            <script>
                $.ajax("http://localhost:8080/LoginUsingSpringMVC/logoutJson",{
                    method: "GET",
                    success: function(data){
                        $("#include").load("index.jsp");
                        if(data.session!=null){
                            $("#message").html(data.name+","+data.message);
                        }
                        else{
                            $("#message").html(data.message+"<br>");
                            $("#page").load("loginForm.jsp");
                        }
                    }
                });
            </script>
    </body>
</html>
