<!doctype html>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
  <head>
    <title>View Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/vstyle.css"> 
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/vsstyle.css">
   

  <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  

  </head>
  
  <body >



 <header>
    <div class="wrapper">
        <div class="logo">
            
        </div>
<ul class="nav-area">
<li><a href="#">Home</a></li>
<li><a href="addstudent">Add Student</a></li>
<li><a href="checkstudents1">View Students</a></li>
<li><a href="#">Add Organization</a></li>
<li><a href="#">View Organization</a></li>
<li><a href="#">Post</a></li>
<li><a href="home">Logout</a></li>
</ul>
</div>

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
                  <th style="text-align:center;"><b>Status<b></th>
                  <th style="text-align:center;"><b>Download<b></th>
               </tr>
              </thead>
              <tbody>
              <c:forEach var="jobdata" items="${jobdata}">
                <tr class="alert" role="alert">
               <td style="text-align:center;"><b>${jobdata.stuid}</b></td>
    <td style="text-align:center;"><b>${jobdata.fullname}</b></td>
        <td style="text-align:center;"><b>${jobdata.email}</b></td>
            <td style="text-align:center;"><b>${jobdata.org}</b></td>
             
                  <td style="text-align:center;"><b>${jobdata.status}</b></td>
           
                
  <td class="border-bottom-0" style="text-align:center;"><a href="/downloadFile/${jobdata.id}" class="btn btn-primary" style="background-color:#f44336;">Download</a></td>
                  
                </tr>
</c:forEach>
               
              </tbody>
            </table>
          
        </div>
      </div>
    </div>
  </section>


</header>

  </body>
</html>