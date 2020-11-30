<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student Registration</title>

    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <link rel="stylesheet" href="css/style.css">
    
</head>
<body>
<body>
	<div class="main">
		 <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="images/signin-image.jpg" alt="sing up image"></figure>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">STUDENT</h2>
                        <form action="registerAccess" method="post">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="studentname" placeholder="Name"/>
                            </div>
                            <div class="form-group">
                                <label for="studentno"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="studentno" placeholder="Student Number"/>
                            </div>
                            <div class="form-group">
                                <label for="studentemail"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="email" name="studentemail" placeholder="Email Address"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" placeholder="Password"/><br>
                            </div>
                             <div class="form-group form-button">
                                <input type="submit" class="form-submit" value="REGISTER"/>
                            </div>

                        <a href="loginAccess" class="signup-image-link">I already have an Account</a>
                        <a href="index.jsp" class="btn btn-primary">Back</a>
                        </form>
                    </div>
                </div>
            </div>
        </section>

</div>
</body>
</html>