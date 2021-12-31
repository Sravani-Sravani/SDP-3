package com.klu.demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;

@Controller
public class ProfileController
{
	 private static final Logger logger = LoggerFactory.getLogger("ProfileController.class");
	    @Autowired
	    private MyService myService;
		private ModelAndView modelAndView;
		private MyService studentService;
		
		private PDFService pdfService;
		@Autowired
		private SendMailOrg sendmail;

	    @PostMapping("/fileupload")
	    public String fileUpload(@RequestParam("email") String email,@RequestParam("gyear") int gyear,@RequestParam("name") String name,@RequestParam("gender") String gender,@RequestParam("sname") String sname,@RequestParam("cname") String cname, @RequestParam("scgpa") double scgpa,@RequestParam("ccgpa") double ccgpa,@RequestParam("gcname") String gcname,@RequestParam("branch") String branch,@RequestParam("gcgpa") double gcgpa,@RequestParam("spec") String spec,@RequestParam("skills") String skills,@RequestParam("project") String project,@RequestParam("experience") String experience,@RequestParam("file") MultipartFile file,@RequestParam("specs") String specs) {
	        try {
	            logger.info("Name= " + name);
	            byte[] file1 = file.getBytes();
	            
	            Profile model = new Profile(email,gyear,name,gender,sname,cname,scgpa,ccgpa,gcname,branch,gcgpa,spec,skills,project,experience,file1,specs);
	            Date curr_date = new Date(System.currentTimeMillis());
	              model.setDt(curr_date.toString());
	            int saveProfile = myService.saveProfile(model);
	            if (saveProfile == 1) {
	                return "success";
	            } else {
	                return "error";
	            }
	        } catch (Exception e) {
	            logger.error("ERROR", e);
	            return "error";
	        }
	    }
	    @GetMapping("/getDetail/{email}")
	    public ModelAndView getDbDetils(@PathVariable String email) throws UnsupportedEncodingException {
	      
	        	
	    /*        List<Profile> imageList= new ArrayList<Profile>();
	            for (Profile m : new ArrayList<Profile>(imagesObj)) {
	                String base64Encoded = javax.xml.bind.DatatypeConverter.printBase64Binary(m.getPfile());
	                Profile imagepath = new Profile();
	                imagepath.setPfile(base64Encoded);
	             //   imagepath.setItemName(m.getItemName());
	                imageList.add(imagepath);
	            } 
	    */        
	    	ModelAndView model=new ModelAndView();
            List<Profile> imagesObj = myService.getImages(email);
	            System.out.println(" Controller class print :"+email);
	          //  model.addObject("id", Profile.getId());
	           // model.addObject("aemail", ((Profile) imagesObj).getAemail());
	          //  byte[] encode = java.util.Base64.getEncoder().encode(((Profile) imagesObj).getPfile());
         //  model.addObject("pfile", new String(encode, "UTF-8"));
	          
	             
	            model.addObject("profile",imagesObj);
	            //model.addObject("img");
	           model.setViewName( "viewprofile");
	            return model;
	        
		
	    }
	    
	    @GetMapping("/getresume/{id}")
	    public String getresume(@PathVariable String id, Model model) {
	        try {
	            logger.info("Id= " + id);
	            Profile imagesObj = myService.getResume(Long.parseLong(id));
	            ImageUtil i=new ImageUtil();
	            model.addAttribute("id", imagesObj.getId());
	            model.addAttribute("aemail", imagesObj.getAemail());
	            model.addAttribute("cname",imagesObj.getCname());
	            model.addAttribute("esname", imagesObj.getEsname());
	            model.addAttribute("fcname",imagesObj.getFcname());
	            model.addAttribute("gscgpa",imagesObj.getGscgpa());
	            model.addAttribute("hccgpa",imagesObj.getHccgpa());
	            model.addAttribute("igcname",imagesObj.getIgcname());
	            model.addAttribute("jbranch",imagesObj.getJbranch());
	            model.addAttribute("kgcgpa",imagesObj.getKgcgpa());
	            model.addAttribute("lspec",imagesObj.getLspec());
	            model.addAttribute("mskills",imagesObj.getMskills());
	            model.addAttribute("nproject",imagesObj.getNproject());
	            model.addAttribute("oexperience",imagesObj.getOexperience());
	            
	          //  model.addAttribute("pfile",imagesObj.getPfile());
	        
	          //  model.addAttribute("imageutil",new ImageUtil());
	           
	            byte[] encode = java.util.Base64.getEncoder().encode(imagesObj.getPfile());
	            model.addAttribute("pfile", new String(encode, "UTF-8"));
	            return "thymeleaf/resume";
	        } catch (Exception e) {
	            logger.error("Error", e);
	            model.addAttribute("message", "Error in getting image");
	            return "redirect:/";
	        }
	    }
	    
	    
	    @GetMapping("/students/{id}")
	    public ModelAndView studentsView(ModelAndView modelAndView ,@PathVariable("id") long id) {
	        modelAndView.addObject("students", studentService.getResume(id));
	        modelAndView.setViewName("thymeleaf/resume");
	        return modelAndView;
	    }
	    
	    @Autowired
	    public ProfileController(MyService studentService, PDFService pdfService) {
	        this.studentService = studentService;
	        this.pdfService = pdfService;
	    }
	    @RequestMapping(value="/download-pdf/{id1}",method=RequestMethod.GET)
	    public void downloadPDFResource(HttpServletResponse response,@PathVariable String id1) {
	        try {
	        	 Path file = Paths.get(pdfService.generatePdf(Long.parseLong(id1)).getAbsolutePath());
	            if (Files.exists(file)) {
	                response.setContentType("application/pdf");
	                response.addHeader("Content-Disposition",
	                        "attachment; filename=" + file.getFileName());
	                Files.copy(file, response.getOutputStream());
	                response.getOutputStream().flush();
	            }
	        } catch (DocumentException | IOException ex) {
	            ex.printStackTrace();
	        }
	    }

	    
	    // View Students
	    
	    @GetMapping("/dviewstudents")
	    public ModelAndView viewemployees()
	    {
	  	  List<Student> students= myService.getallstudentrecords();
	  	  ModelAndView mv=new ModelAndView();
	  	  mv.setViewName("ViewStudents");
	  	  mv.addObject("studentdata",students);
	  	  return mv;
	    }
	    
	    
	    // ADD ORGANIZATION
	    
	    @GetMapping("/addorg")// resp method gets executed, this is known as Handler Mapping
	    public ModelAndView addorg()
	    {
	      ModelAndView mv=new ModelAndView();
	      mv.setViewName("AddOrganization");
	      return mv;
	    }
	    
	    @PostMapping("/submitorgdata")
	    public ModelAndView Addorganization(@RequestParam("img") MultipartFile img,@RequestParam("email") String email,@RequestParam("name") String name) throws IOException {
	            logger.info("Name= " + name);
	            byte[] img1 = img.getBytes();
	           Organization org= new Organization();
	            org.setImg(img1);
	            org.setEmail(email);
	            org.setName(name);
	           System.out.println(" Controller:"+org.getEmail());
	        	String pas=sendmail.sendMail(org);
	        	
	        	 org.setPassword(pas);
	        	 System.out.println(pas);
	        	  myService.saveorganization(org);
	        	    ModelAndView mv=new ModelAndView();
	        	    mv.setViewName("AddSuccess");
	        	    mv.addObject("name",org.getName());
	        	    return mv;
	        } 
	    // View Organization
	    
	    @GetMapping("/vieworg")
	    public ModelAndView vieworg()
	    {
	      List<Organization> org= studentService.getallorgrecords();
	      ModelAndView mv=new ModelAndView();
	      mv.setViewName("ViewOrganization");
	      mv.addObject("orgdata",org);
	      mv.addObject("imgUtil", new ImageUtil());
	      return mv;
	    }
	    
	   	    
	    
	    
	    }