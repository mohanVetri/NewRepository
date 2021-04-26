<%@ page isELIgnored="false" %>
    <%@ page session="false" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>LoginPage</title>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        </head>

        <body>
                <span id="include"></span>  
                <span id="message"></span>
                <span id="loginForm"></span>
                        
                    <script>
                            $.ajax("http://localhost:8080/LoginUsingSpringMVC/loginJson",{
                             method: "GET",
                             success: function(data){
                                 $("#include").load("index.jsp");
                                 if(data.session!=null){
                                     $("#message").html(data.message);
                                 }
                                 else{
                                     $("#loginForm").load("loginForm.jsp");
                                 }
                             },
                             error: function(responseTxt,statusTxt,xhr){
                                 alert(statusTxt);
                             }
                        });
                    </script>
        </body>
        </html>