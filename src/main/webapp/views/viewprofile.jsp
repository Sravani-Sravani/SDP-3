<!doctype html>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
  	<title>View Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/templatemo-edu-meeting.css">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/vpstyle.css">

	</head>
	
	<body style="background-color:#4a4a4a;  height:755px;">
<%System.out.println("Hello s"); %>


  <header class="header-area header-sticky">
      <div class="container">
          <div class="row">
              <div class="col-12">
                  <nav class="main-nav">
                      <!-- ***** Logo Start ***** -->
                      <a href="index.html" class="logo">
                          Scout Ninja
                      </a>
                      <!-- ***** Logo End ***** -->
                      <!-- ***** Menu Start ***** -->
                      <ul class="nav">
                          <li class="scroll-to-section"><a href="#top" class="active">Home</a></li>
                          <li><a href="meetings.html">Profile</a></li>
                          <li><a href="meetings.html">Update Profile</a></li>
                          <li><a href="meetings.html">Change Password</a></li>
                          <li><a href="meetings.html">View Status</a></li>
                          <li><a href="meetings.html">Logout</a></li>

                          
                      <!-- ***** Menu End ***** -->
                  </nav>
              </div>
          </div>
      </div>
  </header>

<br><br><br>

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
						    	<th><b>ID<b></th>
						    	<th><b>Name<b></th>
						    	<th><b>Email</b></th>
						      <th><b>Curr Date</b></th>
						       <th><b>View</b></th>
                               <th><b>Update</b></th>
						    </tr>
						  </thead>
						  <tbody>
						   <c:forEach var="profile" items="${profile}">
						    <tr class="alert" role="alert">
						   <td>${profile.id}</td>

 
					<!-- <td>  -->	 
	<!-- <div class="img" style="background-image: url(${pfile}); border-radius: 50%;"></div> -->		
<!-- 	<img class="img" src="data:image/jpg;base64,${profile.pfile} alt="Girl in a jacket" style="width:60px;height:60px;border-radius: 50%;">  -->	
						<!--   	</td>  -->   
					    							      
					    	  <td>${profile.cname }</td>
						      <td>${profile.aemail }</td>
						      <td>
					        	${profile.dt}	
				          </td>
				        
  <td class="border-bottom-0"><a href="/getresume/${profile.id}" class="btn btn-primary" style="background-color:#f44336;">View</a></td>
  
						      
						    

		<%System.out.println("Hello Srav"); %>
				        
  <td class="border-bottom-0"><a href="/updateprofileview/${profile.id}" class="btn btn-primary" style="background-color:#f44336;">Update</a></td>
						      
						    </tr>   
						    </c:forEach>
						  </tbody>
						</table>
					
				</div>
			</div>
		</div>
	</section>


	</body>

	
</html>

