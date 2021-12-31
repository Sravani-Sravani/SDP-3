<html>
<head>
<title>Add Job</title>
</head>
<link href="${pageContext.request.contextPath}/css/orgaos.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/orgbootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/orgbootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/orgglightbox.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/orgswiper-bundle.min.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/alstyle.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  

  <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/css/orghome.css" rel="stylesheet">
<style>

.video-overlay {
    position: absolute;
   /* background-color: rgba(31,39,43,0.75); */
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    width: 100%;
}

.container {
  width: 100%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto; }
  
  .login-wrap {
  position: relative;
  background: #000232;
  border-radius: 5px;
  heigth:2500px;
  padding-left: 30px;
  padding-right: 30px;
  -webkit-box-shadow: 0px 10px 34px -15px rgba(0, 0, 0, 0.24);
  -moz-box-shadow: 0px 10px 34px -15px rgba(0, 0, 0, 0.24);
  box-shadow: 0px 10px 34px -15px rgba(0, 0, 0, 0.24); }
  .login-wrap h3 {
    font-weight: 400;
    font-size: 18px;
    color: #fff;
    text-transform: uppercase;
    letter-spacing: 1px; }
  .login-wrap p {
    color: rgba(255, 255, 255, 0.5); }
  .login-wrap .img {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    margin: 0 auto;
    margin-bottom: 20px; }
  
  #bg-video {
    min-width: 100%;
    min-height: 100%;
    max-width: 100%;
    max-height: 100%;
    object-fit: cover;
    heigth:100%;
    z-index: -1;
    opacity: 4.5;
}
  
</style>
<body>

<header id="header" class="d-flex align-items-center ">
    <div class="container-fluid container-xxl d-flex align-items-center">

      <div id="logo" class="me-auto">
        <!-- Uncomment below if you prefer to use a text logo -->
        <h1><a href="index.html">Scout <span>Ninja</span></a></h1>
      <!--  <a href="index.html" class="scrollto"><img src="logo.png" alt="" title=""></a> -->
      </div>


      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a class="nav-link scrollto active" href="#hero">Home</a></li> &nbsp;&nbsp;&nbsp;
          <li><a class="nav-link" href="/AddJob">Add Jobs</a></li>          &nbsp;&nbsp;&nbsp;
          <li><a class="nav-link scrollto" href="#speakers">View Jobs</a></li> &nbsp;&nbsp;&nbsp;
  <li><a class="nav-link scrollto" href="#schedule">View Applicants</a></li> &nbsp;&nbsp;&nbsp;
  <li><a class="nav-link scrollto" href="#venue">Accepted Applicants</a></li> &nbsp;&nbsp;&nbsp;
  <li><a class="nav-link scrollto" href="#hotels">Rejected Applicants</a></li> &nbsp;&nbsp;&nbsp;
         
        </ul>

      </nav><!-- .navbar -->
 
      <a class="buy-tickets scrollto" href="#buy-tickets">Logout</a>


    </div>

  </header><!-- End Header -->
    <video autoplay muted loop id="bg-video">
          <source src="${pageContext.request.contextPath}/css/home.mp4" type="video/mp4" />
      </video>
        
            <div class="video-overlay">
               <br><br>
<section class="ftco-section">
  
		<div class="container">
			<div class="row justify-content-center">
				
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap py-5">
		  	<div class="img d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath}/images/logo.png);"></div> 		      	
						<form method="post" action="/submitjobdata" class="login-form">
		      		<div class="form-group">
		      			<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-user"></span></div>
		      <input type="password" class="form-control" placeholder="Your Organization" name="org" required>
		      		</div>
	            <div class="form-group">
	            	<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-lock"></span></div>
     <input type="password" class="form-control" placeholder="Job Role" name="jtitle" required>
	             </div>
	             <div class="form-group">
		      			<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-user"></span></div>
		      <input type="password" class="form-control" placeholder="Location" name="loc" required>
		      		</div>
		      		<div class="form-group">
		      			<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-user"></span></div>
		      <input type="password" class="form-control" placeholder="Time Period(In years)" name="tp" required>
		      		</div>
		      		<div class="form-group">
		      			<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-user"></span></div>
		      <input type="password" class="form-control" placeholder="Amount per annum" name="amt" required>
		      		</div>
		      			<div class="form-group">
		      			<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-user"></span></div>
		      <input type="password" class="form-control" placeholder="Expected Graduation Year" name="yr" required>
		      		</div>
	            <div class="form-group d-md-flex">
								
	            </div>
	            <div class="form-group">
	<button type="submit" class="btn form-control btn-primary rounded submit px-3">Add Job</button>
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
                            