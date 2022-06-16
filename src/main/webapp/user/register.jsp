<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/16/2022
  Time: 6:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/15/2022
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/style.css">

</head>
<body class="img js-fullheight" style="background-image: url(/images/bg.jpg);">
<section class="ftco-section">
    <div class="container">
        <%--    <div class="row justify-content-center">--%>
        <%--      <div class="col-md-6 text-center mb-5">--%>
        <%--        <h2 class="heading-section">Login #10</h2>--%>
        <%--      </div>--%>
        <%--    </div>--%>
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <div class="login-wrap p-0">
                    <h3 class="mb-4 text-center">Have an account?</h3>
                    <form action="#" class="signin-form" method="post">
                        <div class="form-group">
                            <input id="username" name="username" type="text" class="form-control" placeholder="Username" required>
                        </div>
                        <div class="form-group">
                            <input name="email" id="email" type="email" class="form-control" placeholder="Email" required>
                            <%--                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>--%>
                        </div>
                        <div class="form-group">
                            <input name="password" id="password" type="password" class="form-control" placeholder="Password" required>
<%--                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>--%>
                        </div>
                        <div class="form-group">
                            <input name="re-password" id="re-password" type="password" class="form-control" placeholder="re-Password" required>
<%--                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>--%>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="form-control btn btn-primary submit px-3">Sign In</button>
                        </div>
                        <div class="form-group d-md-flex">
                            <div class="w-50">
                                <label class="checkbox-wrap checkbox-primary">Remember Me
                                    <input type="checkbox" checked>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                            <div class="w-50 text-md-right">
                                <a href="#" style="color: #fff">Forgot Password</a>
                            </div>
                        </div>
                    </form>
                    <p class="w-100 text-center">&mdash; <a href="/user?action=login" class="px-2 py-2 mr-md-1 rounded">Register</a></p>

                </div>
            </div>
        </div>
    </div>
</section>

<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<script>

</script>

</body>
</html>

