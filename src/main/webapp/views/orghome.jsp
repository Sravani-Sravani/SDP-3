<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Organization Home</title>
  <meta content="" name="description">
  <meta content="" name="keywords">  

  <!-- Vendor CSS Files -->
  <link href="${pageContext.request.contextPath}/css/orgaos.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/orgbootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/orgbootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/orgglightbox.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/orgswiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/css/orghome.css" rel="stylesheet">

</head>

<body>

  <!-- ======= Header ======= -->
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
          <li><a class="nav-link" href="/addjob/${email}">Add Jobs</a></li>          &nbsp;&nbsp;&nbsp;
          <li><a class="nav-link" href="/vieworgjobs/${email}">View Jobs</a></li> &nbsp;&nbsp;&nbsp;
  <li><a class="nav-link" href="/viewapplicants/${email}">View Applicants</a></li> &nbsp;&nbsp;&nbsp;
  <li><a class="nav-link" href="/viewacceptedstudents/${email}">Accepted Applicants</a></li> &nbsp;&nbsp;&nbsp;
  <li><a class="nav-link" href="/viewrejectedstudents/${email}">Rejected Applicants</a></li> &nbsp;&nbsp;&nbsp;
         
        </ul>

      </nav><!-- .navbar -->
      <a class="buy-tickets scrollto" href="#buy-tickets">Logout</a>

    </div>
  </header><!-- End Header -->

    <video autoplay muted loop id="bg-video">
          <source src="${pageContext.request.contextPath}/css/home.mp4" type="video/mp4" />
      </video>
</body>

</html>