<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Profile</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/bootstrap.min.css'>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pstyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/templatemo-edu-meeting.css">

</head>

<!-- partial:index.partial.html -->
<body>
 <body>
    <div class="image-container set-full-height" style="background-image: url(images/wizard-book.jpg)">
	    <!--   Creative Tim Branding   -->
	         <div class="logo-container">
	            <div class="logo">
	                <img src="${pageContext.request.contextPath}/images/new_logo.png">
	            </div>
	            <div class="brand">
	             Scout Ninja
	            </div>
	        </div>
	    
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

	    <!--   Big container   -->
	    <div class="container">
	        <div class="row">
		        <div class="col-sm-8 col-sm-offset-2">
		            <!-- Wizard container -->
		            <div class="wizard-container">
		                <div class="card wizard-card" data-color="red" id="wizard">
		                    <form action="/updateprofilecheck/${id}" method="POST" enctype="multipart/form-data">
		                <!--        You can switch " data-color="blue" "  with one of the next bright colors: "green", "orange", "red", "purple"             -->

		                    	<div class="wizard-header">
		                        	<h3 class="wizard-title">
		                        		Profile
		                        	</h3>
									<h5>This information will let us know more about you.</h5>
		                    	</div>
								<div class="wizard-navigation">
									<ul>
			                            <li><a href="#details" data-toggle="tab">About</a></li>
			                            <li><a href="#education" data-toggle="tab">Education</a></li>
			                            

			                            </li>
			                           <li><a href="#graduation" data-toggle="tab">Graduation</a></li>
			                            <li><a href="#skills" data-toggle="tab">Skills</a></li>
			                            <li><a href="#projects" data-toggle="tab">Projects</a>
			                            <li><a href="#experience" data-toggle="tab">Experience</a>
			                            <li><a href="#image" data-toggle="tab">Photo</a>
			                        </ul>
								</div>

		                        <div class="tab-content">
		                            <div class="tab-pane" id="details">
		                            	<div class="row">
			                            	<div class="col-sm-12">
			                                	<h4 class="info-text"> Let's start with the basic details.</h4>
			                            	</div>
		                                	<div class="col-sm-6">
												<div class="input-group">
													<span class="input-group-addon">
														<i class="material-icons">email</i>
													</span>
													<div class="form-group label-floating">
			                                          	<label class="control-label">Email</label>
			                                          	<input name="email" type="text" class="form-control" value="${aemail}">
			                                        </div>
												</div>

												<div class="input-group">
													<span class="input-group-addon">
														<i class="material-icons">lock_outline</i>
													</span>
													<div class="form-group label-floating">
			                                          	<label class="control-label">Password</label>
			                                          	<input name="bgyear" type="number" class="form-control">
			                                        </div>
												</div>

		                                	</div>
		                                	<div class="col-sm-4">
		                                    	<div class="form-group label-floating">
			                                          	<label class="control-label">Name</label>
			                                          	<input name="name" type="text" class="form-control">
			                                     </div>
		                
												<div class="form-group label-floating">
		                                        	<label class="control-label">Gender</label>
	                                        		<select class="form-control" name="gender">
														<option disabled="" selected=""></option>
	                                                	<option value="male"> Male</option>
	                                                	<option value="female"> Female </option>
	                                                	<option value="o"> Others </option>
		                                        	</select>
		                                    	</div>

		                                	</div>
		                            	</div>

		                            </div>
		                            <div class="tab-pane" id="education">
		                            	<div class="row">

		                                	<div class="col-sm-6">
												<div class="input-group">
													<span class="input-group-addon">
														<i class="material-icons">school</i>
													</span>
													<div class="form-group label-floating">
			                                         <label class="control-label">School Name</label>
			                                          	<input name="sname" type="text" class="form-control">
			                                        </div>
												</div>

												<div class="input-group">
													<span class="input-group-addon">
														<i class="material-icons">school</i>
													</span>
													<div class="form-group label-floating">
			                                         <label class="control-label">College Name</label>
			                                          	<input name="cname" type="text" class="form-control">
			                                        </div>
												</div>

		                                	</div>
		                                	<div class="col-sm-4">
		                                    	<div class="form-group label-floating">
			                                          	<label class="control-label">CGPA</label>
			                                          	<input name="scgpa" type="text" class="form-control">
			                                     </div>
		                
												

		                                	</div>
		                                	<div class="col-sm-4">
		                                    	<div class="form-group label-floating">
			                                          	<label class="control-label">CGPA</label>
			                                          	<input name="ccgpa" type="text" class="form-control">
			                                     </div>
			                                 </div>
		                            	</div>
		                            </div>


		                            <div class="tab-pane" id="graduation">
		                            	<div class="row">

		                                	<div class="col-sm-6">
												<div class="input-group">
													<span class="input-group-addon">
														<i class="material-icons">school</i>
													</span>
													<div class="form-group label-floating">
			                                         <label class="control-label">College Name</label>
			                                          	<input name="gcname" type="text" class="form-control">
			                                        </div>
												</div>

												<div class="input-group">
													<span class="input-group-addon">
														<i class="material-icons">book</i>
													</span>
													<div class="form-group label-floating">
			                                         <label class="control-label">Branch</label>
			                                          	<input name="branch" type="text" class="form-control">
			                                        </div>
												</div>

		                                	</div>
		                                	<div class="col-sm-4">
		                                    	<div class="form-group label-floating">
			                                          	<label class="control-label">CGPA</label>
			                                          	<input name="gcgpa" type="text" class="form-control">
			                                     </div>
		                
												

		                                	</div>
		                                	<div class="col-sm-4">
		                                    	<div class="form-group label-floating">
			                                   	<label class="control-label">Specialization</label>
			                                          	<input name="spec" type="text" class="form-control">
			                                     </div>
			                                 </div>
		                            	</div>
		                            </div>


                                    <div class="tab-pane" id="skills">
		                                <div class="row">
		                                    <h4 class="info-text"> Drop us a small description.</h4>
		                                    <div class="col-sm-6 col-sm-offset-1">
	                                    		<div class="form-group">
		                                            <label>Skills description</label>
		                                            <textarea class="form-control" placeholder="" rows="8" name="skills" ></textarea>
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-4">
		                                    	<div class="form-group">
		                                 <label class="control-label">Skills</label>
		                                            <p class="description">• <b>Technologies</b>:
Golang, Python, C++, Tensorflow,MapReduce, GCP, Protocol Buffers <br>
•<b> Patterns & Practices</b>:
OPPS, Functional Programming, CI & CD, Microservices <br>
• <b>Project Management</b>:
Agile, Scrum, Google Workspace
</p>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>

		                            <div class="tab-pane" id="projects">
		                                <div class="row">
		                                    <h4 class="info-text"> Drop us a small description.</h4>
		                                    <div class="col-sm-6 col-sm-offset-1">
	                                    		<div class="form-group">
		                                            <label>Projects description</label>
		                                            <textarea class="form-control" placeholder="" rows="8" name="project"></textarea>
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-4">
		                                    	<div class="form-group">
		                                 <label class="control-label">Projects</label>
		                                            <p class="description">• <b>Tensorflow</b> [tensorflow.org]
An open-source machine-learning software library
C++, Python, Bash <br>
•<b> LevelDB</b> [github.com/google/leveldb]
An open-source on-disk key-value store
C++
</p>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>

		                            <div class="tab-pane" id="experience">
		                                <div class="row">
		                                    <h4 class="info-text"> Drop us a small description.</h4>
		                                    <div class="col-sm-6 col-sm-offset-1">
	                                    		<div class="form-group">
		                                            <label>Your Experience</label>
		                                            <textarea class="form-control" placeholder="" rows="6" name="experience"></textarea>
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-4">
		                                    	<div class="form-group">
		                                            <label class="control-label"><b>Experience</b></label>
		   <p class="description">• <b>Dream Company</b>
Senior Software Engineer - San Fransisco, CA
Co-designer and co-implementor of five successive
generations of Google’s crawling indexing and query
retrieval systems.
August 1999 onwards </p>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>

		                            <div class="tab-pane" id="image">
		                                <div class="row">
		                                    <h4 class="info-text"> Drop us a small description.</h4>
		                                    <div class="col-sm-4 col-sm-offset-1">
		                                    	<label>Upload Image</label>
	                                    		<input type="file" name="file" required>
		                                    </div>
		                                    <div class="col-sm-4 col-sm-offset-1">
		                                    	<div class="form-group">
		                                        <label>Specilizations</label>
		                                            <textarea class="form-control" placeholder="" rows="6" name="specs"></textarea>
		                                        </div>
		                                </div>
		                            </div>


		                        </div>
	                        	<div class="wizard-footer">
	                            	<div class="pull-right">
	                                    <input type='button' class='btn btn-next btn-fill btn-danger btn-wd' name='next' value='Next' />
	                                    <input type='submit' class='btn btn-finish btn-fill btn-danger btn-wd' name='finish' value='Finish' />
	                                </div>
	                                <div class="pull-left">
	                                    <input type='button' class='btn btn-previous btn-fill btn-default btn-wd' name='previous' value='Previous' />

										
	                                </div>
	                                <div class="clearfix"></div>
	                        	</div>
		                    </form>
		                </div>
		            </div> <!-- wizard container -->
		        </div>
	    	</div> <!-- row -->
		</div> <!--  big container -->

	   
	</div>


</body>
<!-- partial -->
  <script src='${pageContext.request.contextPath}/js/jquery.min.js'></script>
<script src='${pageContext.request.contextPath}/js/bootstrap.min.js'>
</script><script  src="${pageContext.request.contextPath}/js/pscript.js"></script>

</body>
</html>
