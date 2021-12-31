<!doctype html>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
  <head>
    <title>View Profile</title>
    <meta charset="utf-8">
     <link href="${pageContext.request.contextPath}/css/orgaos.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/orgbootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/orgbootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/orgglightbox.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/orgswiper-bundle.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/vsstyle.css">
    <link href="${pageContext.request.contextPath}/css/orghome.css" rel="stylesheet">

  </head>
  <style>
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
  <body >
<header id="header" class="d-flex align-items-center ">
    <div class="container-fluid container-xxl d-flex align-items-center">

      <div id="logo" class="me-auto">
        <!-- Uncomment below if you prefer to use a text logo -->
        <h1><a href="index.html">Scout <span>Ninja</span></a></h1>
      <!--  <a href="index.html" class="scrollto"><img src="logo.png" alt="" title=""></a> -->
      </div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

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
<section class="ftco-section">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6 text-center mb-4">
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          
            <table class="table">
              <thead class="thead-primary">
                <tr>
                  <th style="text-align:center;"><b>ID<b></th>
                  <th style="text-align:center;"><b>Name</b></th>
                  <th style="text-align:center;"><b>Email</b></th>
                  <th style="text-align:center;"><b>Organization</b></th>
                  <th style="text-align:center;"><b>Role</b></th>
                  <th style="text-align:center;"><b>Download<b></th>
                   <th style="text-align:center;"><b>Accept<b></th>
                    <th style="text-align:center;"><b>Reject<b></th>
               </tr>
              </thead>
              <tbody>
              <c:forEach var="jobdata" items="${jobdata}">
                <tr class="alert" role="alert">
               <td style="text-align:center;"><b>${jobdata.stuid}</b></td>
    <td style="text-align:center;"><b>${jobdata.fullname}</b></td>
        <td style="text-align:center;"><b>${jobdata.email}</b></td>
            <td style="text-align:center;"><b>${jobdata.org}</b></td>
              <td style="text-align:center;"><b>${jobdata.role}</b></td>
           
                
  <td class="border-bottom-0" style="text-align:center;"><a href="/downloadFile/${jobdata.id}" class="btn btn-primary" style="background-color:#f44336;">Download</a></td>
     <td class="border-bottom-0" style="text-align:center;"><a href="/acceptrequest/${jobdata.email}/${jobdata.role}/${jobdata.org}" class="btn btn-primary" style="background-color:#f44336;">Accept</a></td>
     <td class="border-bottom-0" style="text-align:center;"><a href="/rejectrequest/${jobdata.email}/${jobdata.role}/${jobdata.org}" class="btn btn-primary" style="background-color:#f44336;">Reject</a></td>
         
                </tr>
</c:forEach>
               
              </tbody>
            </table>
          
        </div>
      </div>
    </div>
  </section>
</div>



  </body>
</html>