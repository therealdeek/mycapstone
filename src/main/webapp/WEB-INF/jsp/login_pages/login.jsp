<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="pub/css/login.css" rel="stylesheet">

    <script src="https://kit.fontawesome.com/b049835cf5.js" crossorigin="anonymous"></script>

</head>

<body>

<!--Navigation-->

    <nav class="navbar navbar-expand-lg navbar-light bg-light py-3 fixed-top">
        <div class="container">
            <img src="pub/images/Community Logo.png" alt="Community Logo" />
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="index">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="products">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cart">Cart</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Support Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="createusers">Signup</a>
                    </li>
                    <li class="nav-item">
                        <i class="fa-solid fa-magnifying-glass"></i>
                        <i class="fa-solid fa-cart-shopping"><span> 0 </span></i>

                    </li>

                </ul>
            </div>
        </div>
    </nav>

    <br>
    <br>


<section id="home">
    <div class="container">
        <div class="row mt-3 mb-1 justify-content-center">
            <div class="col-4">
            	<h2>Login</h2>
            	<p>Please enter in your username and password</p>
            </div>
        </div>

        <form action="/users/loginpost" method="POST">
            <div class="row justify-content-center">
	            <div class="mt-2 mb-3 col-4">
	                <label for="username" class="form-label">Username</label>
	                <input type="username" name="username" class="form-control" id="username"
	                    aria-describedby="usernameHelp">
	                <div id="usernameHelp" class="form-text">Enter your username</div>
	            </div>
            </div>
            <div class="row justify-content-center">
	            <div class="mt-2 mb-3 col-4">
	                <label for="password" class="form-label">Password</label>
	                <input type="password" name="password" class="form-control" id="password"
	                    aria-describedby="passwordHelp">
	                <div id="passwordHelp" class="form-text">Enter your password</div>
	            </div>
	        </div>

            <div class="row justify-content-center">
	            <div class="mt-2 mb-3 col-4">
	            	<button type="submit" class="btn btn-dark">Submit</button>
	             </div>
	        </div>
        </form>
    </div>
</section>

<footer class="mt-4 py-2">
            <div class="row">
                <div class="footer-one col-lg-3 col-md-4 col-12">
                    <img src="pub/images/Community Logo.png" alt="">
                    <p> Life is life. Style is style. Argot is a lifestyle.</p>
                </div>
                <div class="footer-one col-lg-3 col-md-4 col-12">
                    <h3>Social Media</h3>
                    <ul class="sm-links list-unstyled">
                        <i class="fa-brands fa-twitter"></i>
                        <i class="fa-brands fa-facebook"></i>
                        <i class="fa-brands fa-instagram"></i>
                        <i class="fa-brands fa-youtube"></i>
                        <i class="fa-brands fa-patreon"></i>

                    </ul>
                </div>
            </div>
        </footer>

        </ul>
    </nav>


    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>

</body>

</html>