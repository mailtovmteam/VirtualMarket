<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>:: Home ::</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vm_styles/vm.css" />">
</head>
<body>
<div id = "top_div"></div>
<div id = "header">
		 <div style="width: 100%; height: 12px;"></div>
		<span id = "header_title">VirtualMarket</span>
		<span>
			<input type="text" id = "top_searchbox" name = "search_val" placeholder="Search by product, shop, dealer name ..." />
		</span>
		<span style=" margin-right: 10px;">
			<input type="button" class="button_login button_register" name = "register" value="Register Shop" />
			<input type="button" class="button_login" name = "login" value="Login Shop" />
		</span>
</div>

<div class="main">
<div class="left">
	<div style="margin-top: 70px;">
		<img alt="Lady shopping" src="resources/vm_graphics/lady-shopping-1.jpg" />
	</div>
</div>
<div class="content"></div>
<c:url var="addAction" value="/login" ></c:url>
<div class="right">
	<section class="container">
	    <div class="login">
	      <h1>Login Shop</h1>
	      <form:form method="post" commandName="logdata" action="${addAction}">
	        <p><form:input path="user_name" placeholder="Username or Email" /></p>
	        <p><form:password path="password" placeholder="Password" /></p>
	        <p class="remember_me">
	          <form:label path="">
	            <input type="checkbox" />
	            Remember me on this computer
	          </form:label>
	        </p>
	        <p class="submit"><input type="submit" name="commit" value="Login"></p>
	      </form:form>
	    </div>
	
	    <div class="login-help">
	      <p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>
	    </div>
  </section>
</div>

	<!-- Registration box -->
	<div class="right-register" style="display: none;">
	<section class="container">
	    <div class="login">
	      <h1>Login Shop</h1>
	      <form:form method="post" commandName="logdata" action="${addAction}">
	        <p><form:input path="user_name" placeholder="Username or Email" /></p>
	        <p><form:password path="password" placeholder="Password" /></p>
	        <p class="remember_me">
	          <form:label path="">
	            <input type="checkbox" />
	            Remember me on this computer
	          </form:label>
	        </p>
	        <p class="submit"><input type="submit" name="commit" value="Login"></p>
	      </form:form>
	    </div>
	
	    <div class="login-help">
	      <p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>
	    </div>
  </section>
</div>
	
</div>

</body>
</html>
