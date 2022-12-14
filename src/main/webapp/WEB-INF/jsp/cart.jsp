<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Shopping Cart</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="pub/css/cart.css" rel="stylesheet">


    <script src="https://kit.fontawesome.com/b049835cf5.js" crossorigin="anonymous"></script>


</head>

<body>
    <header>
        <div class="overlay"></div>
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
                                <a class="nav-link active" href="#">Cart</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Support Us</a>
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
    </header>

     <div class="container">
        </div>

        <section id="home" class="pt-5 mt-5 container">
            <h2 class="font-weight-bold pt-5">Shopping Cart</h2>
            <hr>
        </section>

        <section id="cart-container" class="container my-5">
            <table width="100%">
                <thead>
                    <tr>
                        <td>Remove</td>
                        <td>Image</td>
                        <td>Product</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <td>Total</td>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td><a href="#"><i class="fas fa-trash-alt"></i></a></td>
                        <td><img src="pub/images/T-Shirt-removebg-preview.png" alt=""></td>
                        <td>
                            <h5>Tee Shirt
                            </h5>
                        </td>
                        <td>
                            <h5>$15.00</h5>
                        </td>
                        <td><input class="w-25 pl-1" value="1" type="number"></td>
                        <td>
                            <h5>$30.00</h5>
                        </td>
                    </tr>
                    <tr>
                        <td><a href="#"><i class="fas fa-trash-alt"></i></a></td>
                        <td><img src="pub/images/Silicone_Wristband-removebg-preview.png" alt=""></td>
                        <td>
                            <h5>Wristband
                            </h5>
                        </td>
                        <td>
                            <h5>$5.00</h5>
                        </td>
                        <td><input class="w-25 pl-1" value="1" type="number"></td>
                        <td>
                            <h5>$10.00</h5>
                        </td>
                    </tr>
                    <tr>
                        <td><a href="#"><i class="fas fa-trash-alt"></i></a></td>
                        <td><img src="pub/images/BaseBall_Hat-removebg-preview.png" alt=""></td>
                        <td>
                            <h5>B-ball Cap
                            </h5>
                        </td>
                        <td>
                            <h5>$25.00</h5>
                        </td>
                        <td><input class="w-25 pl-1" value="1" type="number"></td>
                        <td>
                            <h5>$50.00</h5>
                        </td>
                    </tr>
                    <tr>
                        <td><a href="#"><i class="fas fa-trash-alt"></i></a></td>
                        <td><img src="pub/images/Crew_Socks-removebg-preview.png" alt=""></td>
                        <td>
                            <h5>Crew Socks
                            </h5>
                        </td>
                        <td>
                            <h5>$10.00</h5>
                        </td>
                        <td><input class="w-25 pl-1" value="1" type="number"></td>
                        <td>
                            <h5>$20.00</h5>
                        </td>
                    </tr>
                </tbody>
            </table>
        </section>

        <section id="cart-bottom" class="container">
            <div class="row">
                <div class="coupon col-lg-6 col-md-6 col-12 mb-4">
                    <div>
                        <h5>COUPON</h5>
                        <p>Enter your coupon code</p>
                        <input type="text" placeholder="Coupon Code">
                        <button class="btn-dark">Apply Coupon</button>
                    </div>
                </div>

            <div class="total col-lg-6 col-md-6 col-12">
                <div>
                    <h5>CART TOTAL</h5>
                    <div class="d-flex justify-content-between">
                        <h6>Subtotal</h6>
                        <p>$200.00</p>
                    </div>
                    <div class="d-flex justify-content-between">
                        <h6>Shipping</h6>
                        <p>$200.00</p>
                    </div>
                    <hr class="second-hr">
                    <div class="d-flex justify-content-between">
                        <h6>Total</h6>
                        <p>$200.00</p>
                    </div>

                    <button class="ml-auto btn-dark">Proceed To Checkout</button>
                </div>
            </div>
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


    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
    <script src="pub/js/products.js"></script>



</body>

</html>