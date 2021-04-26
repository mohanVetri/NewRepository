<%@ page session="false" %>
<!DOCTYPE html>
<html>

<body>
    <form id="form" action="validate" method="POST">
        <table>
            <tr>
                <td><b>UserName:</b></td>
                <td><input id="name" type="text" name="userName" /></td>
            </tr>
            <tr>
                <td><b>Password:</b></td>
                <td><input id="password" type="text" name="password" /></td>
            </tr>
        </table>
        
    </form>
    <input type="submit" value="Sign in" onclick="submitForm()" />
   <a href="registrationView"><button>Sign Up</button></a> 

   <script>
       function submitForm(){
           document.getElementById("form").submit();
       }
   </script>
</body>

</html>