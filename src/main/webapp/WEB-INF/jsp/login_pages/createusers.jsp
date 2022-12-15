<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Welcome To Argot</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="pub/css/follow.css" rel="stylesheet">

    <script src="https://kit.fontawesome.com/b049835cf5.js" crossorigin="anonymous"></script>

</head>

<body>

    <!--Navigation-->

    <nav class="navbar navbar-expand-lg navbar-light bg-light py-0 fixed-top">
        <div class="container">
            <img src="pub/images/Community Logo.png" alt="Community Logo" />
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="homepage">Home</a>
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
                        <a class="nav-link" href="follow">Support Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="loginpage">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Signup</a>
                    </li>
                    <li class="nav-item">
                        <i class="fa-solid fa-magnifying-glass"></i>
                        <i class="fa-solid fa-cart-shopping"></i>

                    </li>

                </ul>
            </div>
        </div>
    </nav>
<div class="container">
    <div class="row mt-3 mb-1">
    <br>
    <br>
    <br>
    <br>
    </div>
</div>

<div class="container">
    <div class="row mt-3 mb-1">
        <h2>Create user</h2>
    </div>


        <c:if test="${bindingResult.hasErrors()}">
          <c:forEach items="${bindingResult.getAllErrors()}" var="error">
            <p class="mt-0 mb-1" style="color:red">${error.getDefaultMessage()}</p>
          </c:forEach>
        </c:if>

<form action="/createusers" method="POST">
  <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email address</label>
        <input type="email" value="${form.email}" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>

  <div class="row">
      <div class="mb-3 col-6">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input type="password" value="${form.password}"name="password" class="form-control" id="exampleInputPassword1">
      </div>

      <div class="mb-3 col-6">
        <label for="confirmPassword" class="form-label">Confirm Password</label>
        <input type="password" value="${form.confirmPassword}"name="confirmpassword" class="form-control" id="confirmPassword">
      </div>
      </div>

      <div class="row">
        <div class="mb-3 col-6">
          <label for="firstName" class="form-label">First Name</label>
          <input type="text" value="${form.firstName}"name="firstName" class="form-control" id="firstName" aria-describedby="firstNameHelp">
          <label class="firstNameHelp" for="form-text">Please give me your first name</label>
        </div>

        <div class="mb-3 col-6">
          <label for="lastName" class="form-label">Last Name</label>
          <input type="text" value="${form.lastName}"name="lastName" class="form-control" id="lastName" aria-describedby="lastNameHelp">
          <label class="lastNameHelp" for="form-text">Please give me your last name</label>
        </div>
      </div>

      <div class="row">
          <div class="mb-3 col-6">
            <label for="address" class="form-label">Address</label>
            <input type="text" value="${form.address}"name="address" class="form-control" id="address" aria-describedby="addressHelp">
            <label class="addressHelp" for="form-text">Please give me your address</label>
          </div>
      </div>

      <div class="row">
        <div class="mb-3 col-4">
          <label for="city" class="form-label">City</label>
          <input type="text" value="${form.city}"name="city" class="form-control" id="city" aria-describedby="cityHelp">
          <label class="cityHelp" for="form-text">Enter Your City</label>
      </div>

        <div class="mb-3 col-4">
          <label for="state" class="form-label">State</label>
          <input type="text" value="${form.state}"name="state" class="form-control" id="state" aria-describedby="stateHelp">
          <label class="stateHelp" for="form-text">Enter Your State</label>
        </div>

        <div class="mb-3 col-4">
          <label for="zip" class="form-label">Zip</label>
          <input type="text" value="${form.zip}"name="zip" class="form-control" id="zip" aria-describedby="zipHelp">
          <label class="zipHelp" for="form-text">Enter Your Zip</label>
        </div>
      </div>


        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>



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