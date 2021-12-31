package com.klu.demo;
import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ApplyJobController {

    private static final Logger logger = LoggerFactory.getLogger(ApplyJobController.class);

    @Autowired
    private ApplyJobService dbFileStorageService;
    
    
    
    @RequestMapping(value="/index")
  public ModelAndView index()
  {
    ModelAndView mv=new ModelAndView();
    mv.setViewName("index");
    return mv;
  }
    
    @GetMapping("/appjob/{org}/{role}")
    public ModelAndView appjob(@PathVariable("org") String org,@PathVariable("role") String role)
    {
    	System.out.println(org);
    	   System.out.println("Apply Job role"+role);
      ModelAndView mv=new ModelAndView();
      mv.setViewName("ApplyJob");
      mv.addObject("org",org);
      mv.addObject("role",role);
   
      return mv;
    }
    
    
    @RequestMapping(value="/viewpdf")
     public ModelAndView view()
     {
       ModelAndView mv=new ModelAndView();
       mv.setViewName("view");
       return mv;
     }


    @PostMapping("/uploadFile/{org}/{role}")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("message") String message, @RequestParam("email") String email, @RequestParam("full_name") String fname,@RequestParam("stuid") long stuid,@PathVariable String org,@PathVariable String role) {
        String status="PENDING";
    	ApplyJob dbFile = dbFileStorageService.storeFile(file,message, email, fname, stuid,org,status,role);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(dbFile.getId()).toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        ApplyJob dbFile = dbFileStorageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
    
    
    // VIEW JOB
    
    @GetMapping("/viewjobs/{email}")
    public ModelAndView viewemployees(@PathVariable String email)
    {
      Profile p=new Profile();
      List<AddJob> jobs=dbFileStorageService.getjobrecords(email);
      ModelAndView mv=new ModelAndView();
      mv.setViewName("ViewJobs");
      mv.addObject("jobdata",jobs);
      return mv;
    }
    
    // View All Jobs
    
    @GetMapping("/viewalljobs")
    public ModelAndView viewemployees()
    {
      Profile p=new Profile();
      List<AddJob> jobs=dbFileStorageService.getalljobrecords();
      ModelAndView mv=new ModelAndView();
      mv.setViewName("ViewAJob");
      mv.addObject("jobdata",jobs);
      return mv;
    }
    
    // View Status 
    
    @GetMapping("/viewstatus/{email}")
    public ModelAndView viewstatus(@PathVariable String email)
    {
      List<AddJob> jobs=dbFileStorageService.viewjobstatus(email);
      ModelAndView mv=new ModelAndView();
      mv.setViewName("ViewStatus");
      mv.addObject("jobdata",jobs);
      return mv;
    }
    
    
    @GetMapping("/vieworgjobs/{email}")
    public ModelAndView vieworgjobs(@PathVariable String email)
    {
      Profile p=new Profile();
      List<AddJob> jobs=dbFileStorageService.getorgjobrecords(email);
      ModelAndView mv=new ModelAndView();
      mv.setViewName("ViewOrgJobs");
      mv.addObject("jobdata",jobs);
      return mv;
    }
    
    // View Applicants
    
    @GetMapping("/viewapplicants/{email}")
    public ModelAndView viewapplicants(@PathVariable String email)
    {
      List<AddJob> jobs=dbFileStorageService.getviewapplicantrecords(email);
      ModelAndView mv=new ModelAndView();
      mv.setViewName("ViewApplicants");
      mv.addObject("jobdata",jobs);
      return mv;
    }
    
    // Organization Login
    
    @GetMapping("/orglogin")
    public ModelAndView orgloginpage()
    {
      ModelAndView mv=new ModelAndView();
      mv.setViewName("OrgLogin");
      return mv;
    }

    // Check Org Login 
    
    @PostMapping("/checkorglogin")// resp method gets executed, this is known as Handler Mapping
    public ModelAndView orgLogin(@RequestParam("username") String uname,@RequestParam("pass") String pass)
    {
      boolean val=dbFileStorageService.validateOrg(uname, pass);
      ModelAndView mv=new ModelAndView();
      if(val==true)
      {
        mv.setViewName("orghome");
        mv.addObject("email",uname);
      }
      else
      {
        mv.setViewName("adminloginfail");
      }
      return mv;
    }
    
    // Accept Student Request
    
    @GetMapping("/acceptrequest/{email}/{role}/{org}")
    public ModelAndView acceptrequest(@PathVariable String email,@PathVariable String role,@PathVariable String org)
    {
    	List<ApplyJob> students= dbFileStorageService.acceptrequest(email,role,org);
    	System.out.println("Controller Class");
    	System.out.println(email);
    	System.out.println(role);
    	 System.out.println(org);
	  	  ModelAndView mv=new ModelAndView();
	  	  mv.setViewName("AcceptedStudents");
	  	  mv.addObject("jobdata",students);
	  	  return mv;
    }
    
    // Rejected Students
    
    @GetMapping("/rejectrequest/{email}/{role}/{org}")
    public ModelAndView rejectrequest(@PathVariable String email,@PathVariable String role,@PathVariable String org)
    {
    	List<ApplyJob> students= dbFileStorageService.rejectrequest(email,role,org);
    	System.out.println("Controller Class");
    	System.out.println(email);
    	System.out.println(role);
	  	  ModelAndView mv=new ModelAndView();
	  	  mv.setViewName("RejectedStudents");
	  	  mv.addObject("jobdata",students);
	  	  return mv;
    }
    
    // View Accepted Students
    @GetMapping("/viewacceptedstudents/{email}")
    public ModelAndView viewacceptedstudents(@PathVariable String email) 
    {
    	List<ApplyJob> students= dbFileStorageService.viewacceptrequest(email);
    	System.out.println("Controller Class");
    	System.out.println(email);
	  	  ModelAndView mv=new ModelAndView();
	  	  mv.setViewName("AcceptedStudents");
	  	  mv.addObject("jobdata",students);
	  	  return mv;
    }
    
    // View Rejected Students
    
    @GetMapping("/viewrejectedstudents/{email}")
    public ModelAndView viewrejectedstudents(@PathVariable String email)
    {
    	List<ApplyJob> students= dbFileStorageService.viewrejectrequest(email);
    	System.out.println("Controller Class");
    	System.out.println(email);
	  	  ModelAndView mv=new ModelAndView();
	  	  mv.setViewName("RejectedStudents");
	  	  mv.addObject("jobdata",students);
	  	  return mv;
    }
    
    // Search by Role
    
    @PostMapping("/searchbyrole/{email}")// resp method gets executed, this is known as Handler Mapping
    public ModelAndView searchbyrole(@RequestParam("search") String search,@PathVariable String email)
    {
    	  List<AddJob> jobs=dbFileStorageService.searchbyrole(search,email);
          ModelAndView mv=new ModelAndView();
          mv.setViewName("ViewOrgJobs");
          mv.addObject("jobdata",jobs);
          return mv;
    	
    }
    
    /*
    // Request to delete Jobs
    
    @GetMapping("/sendrequest/{id}/{org}/{role}")
    public void sendrequesttodelete(@PathVariable int id,@PathVariable String org,@PathVariable String role)
    {
    	dbFileStorageService.sendrequesttodelete(id,org,role);
    }
    
    // Delete Request Views
    @GetMapping("/deleteviewstudents")
    public ModelAndView deleteviewjobs()
    {
  	  List<RequesttoDJ> students= dbFileStorageService.getalldeletejobrecords();
  	  ModelAndView mv=new ModelAndView();
  	  mv.setViewName("ViewDeleteJobs");
  	  mv.addObject("studentdata",students);
  	  return mv;
    }
    
    @GetMapping("/deletejob/{id}")
    public ModelAndView deletejob(@PathVariable int id)
    {
    	
		return null;
    }
    */
}