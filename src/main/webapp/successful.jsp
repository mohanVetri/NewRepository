<%@ page isELIgnored="false"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Successful Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    </head>
    <body>
        <span id="index"></span>
        <span id="message"></span>
        <span id="login"></span>
            <script>
                $.ajax({
                    url: "http://localhost:8080/LoginUsingSpringMVC/successJson",
                    method: "GET",
                    success: function(data){
                        $("#index").load("index.jsp");
                        if(data.session!=null){
                        $("#message").html(data.name+","+data.message);
                        }
                        else{
                            $("#message").html(data.message);
                            $("#login").load("loginForm.jsp");
                        }
                    },
                    error: function(statusTxt,responseTxt,xhr){
                        alert(statusTxt+"response:"+responseTxt);
                    }
                })
            </script>
    </body>
</html>