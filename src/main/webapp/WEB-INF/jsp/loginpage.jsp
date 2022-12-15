<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:include page="include/header.jsp" />


<c:if test="${param.showMessage eq 'true'}">
      <p>This is the message that will be displayed only if the "showMessage"
      <br>parameter is set to "true".</p>
    </c:if>

    <div class="container">
        <div class="row mt-3 mb-1 justify-content-center">
            <div class="col-4">
            	<h2>Login</h2>
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
	            	<button type="submit" class="btn btn-primary">Submit</button>
	             </div>
	        </div>
        </form>
    </div>

<div="container">
    <h1>my radio buttons</h1>
    <label class="container">One
      <input type="radio" checked="checked" name="radio">
      <span class="checkmark"></span>
    </label>
    <label class="container">Two
      <input type="radio" name="radio">
      <span class="checkmark"></span>
    </label>
    <label class="container">Three
      <input type="radio" name="radio">
      <span class="checkmark"></span>
    </label>
    <label class="container">Four
      <input type="radio" name="radio">
      <span class="checkmark"></span>
    </label>


    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>

</body>

</html>



