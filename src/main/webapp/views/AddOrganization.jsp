<html>

<head>
<title>Add Organization</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/alstyle.css">

  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap" rel="stylesheet">
   
   <style>
   * {
    margin: 0;
    padding: 0;
}
body {
    font-family: 'Poppins', sans-serif;
}
.wrapper {
    width: 1170px;
    margin: auto;
}
header {
  background: linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)), url(/images/5.jpg);
    height: 100vh;
    -webkit-background-size: cover;
    background-size: cover;
    background-position: center center;
    position: relative;
}
.nav-area {
    float: right;
    list-style: none;
    margin-top: 30px;
}
.nav-area li {
    display: inline-block;
}
.nav-area li a {
    color: white;
    text-decoration: none;
    padding: 5px 20px;
    font-family: poppins;
    font-size: 16px;
    text-transform: uppercase;
}
.nav-area li a:hover {
    background: white;
    color: black;
}
.logo {
    float: left;
}
.logo img {
    width: 100%;
    padding: 15px 0;
}
.welcome-text {
    position: absolute;
    width: 600px;
    height: 300px;
    margin: 20% 30%;
    text-align: center;
}
.welcome-text h1 {
    text-align: center;
    color: white;
    text-transform: uppercase;
    font-size: 60px;
}
.welcome-text h1 span {
    color: white;
}
.welcome-text a {
    border: 1px solid #fff;
    padding: 10px 25px;
    text-decoration: none;
    text-transform: uppercase;
    font-size: 14px;
    margin-top: 20px;
    display: inline-block;
    color: white;
}
.welcome-text a:hover {
    background: #fff;
    color: black;
}
/*resposive*/

@media (max-width:600px) {
    .wrapper {
        width: 100%;
    }
    .logo {
        float: none;
        width: 50%;
        text-align: center;
        margin: auto;
    }
    img {
        width: ;
    }
    .nav-area {
        float: none;
        margin-top: 0;
    }
    .nav-area li a {
        padding: 5px;
        font-size: 11px;
    }
    .nav-area {
        text-align: center;
    }
    .welcome-text {
        width: 100%;
        height: auto;
        margin: 30% 0;
    }
    .welcome-text h1 {
        font-size: 30px;
    }
}
   </style>
</head>
<body >
  <header>
    <div class="wrapper">
        <div class="logo">          
        </div>
<ul class="nav-area">
<li><a href="/adminhome">Home</a></li>
<li><a href="addstudent">Add Student</a></li>
<li><a href="checkstudents1">View Students</a></li>
<li><a href="addorg">Add Organization</a></li>
<li><a href="vieworg">View Organization</a></li>
<li><a href="/viewalljobs">View Jobs</a></li>
<li><a href="#">Post</a></li>
<li><a href="/adminlogin">Logout</a></li>
</ul>
<br><br>
<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap py-5">
		      	<div class="img d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath}/images/logo.png);"></div>
		      	<h3 class="text-center mb-0">Add Organization</h3>
		      	
						<form action="/submitorgdata" method="POST" enctype="multipart/form-data">
		      		
		      		  <div class="form-group">
	            	<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-envelope"></span></div>
     <input type="email" class="form-control" placeholder="Email" name="email" required>
	             </div>
		      		<div class="form-group">
		      			<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-user"></span></div>
		      <input type="text" class="form-control" placeholder="Name" name="name" required>
		      		</div>
		      		<div class="form-group">
		      			<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-file"></span></div>
		      <input type="file" class="form-control" placeholder="Upload file" name="img" required>
		      		</div>
	          
	            <div class="form-group d-md-flex">
								
	            </div>
	            <div class="form-group">
	<button type="submit" class="btn form-control btn-primary rounded submit px-3">Add</button>
	            </div>
	          </form>
	          
	        </div>
				</div>
			</div>
		</div>
	</section>
	</div>

</body>
</html>