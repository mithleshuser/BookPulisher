package com.bookpublisher.app.controller;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bookpublisher.app.dto.AuthorsDTO;
import com.bookpublisher.app.dto.BookDTO;
import com.bookpublisher.app.dto.CustomerDTO;
import com.bookpublisher.app.dto.FilePropertiseDTO;
import com.bookpublisher.app.dto.LoginDTO;
import com.bookpublisher.app.dto.PublisherDTO;
import com.bookpublisher.app.service.CustomerService;
import com.bookpublisher.app.service.FileuploadingService;

@Controller
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	private CustomerService userService;
	
	
	@Autowired
	private FileuploadingService fileuploadingService;
	private String saveDirectory = "E:/SERVERLOC/BOOKS";
	
	@RequestMapping(method=RequestMethod.POST,value="/user")
	public String addUser(CustomerDTO user, ModelMap map){
		System.out.println("user going to add");
		String id=userService.add(user);
		if(id!=null){
			map.put("msg",user.getName()+" registered with Id "+id);
		}
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String userLogin(LoginDTO user, ModelMap map){
		try{
			LoginDTO user2=userService.login(user);
		map.put("msg", user2.getEmail()+" succefully logged In");
		return "home";
		}catch(NullPointerException e){
			map.put("msg", "User Not found!!");
			return "login";
		}
	}

	@RequestMapping(method=RequestMethod.POST,value="/publists")
	public String addPublication(Map<String, Object> model, @ModelAttribute("published") PublishedForm obj ,BindingResult result, SessionStatus status){
		System.out.println("addPublication ---- ");
		PublisherDTO p_obj = copyToObjects(obj);
		int id=userService.addPublishedForm(p_obj);
		if(id!=0){
			model.put("msg"," registered with Id "+id);
		}
		return "uplod_books";
	
	}

	private PublisherDTO copyToObjects(PublishedForm obj) {
		PublisherDTO publisherObject = new PublisherDTO();
		AuthorsDTO authorObj = new AuthorsDTO();
		BookDTO bookObj = new BookDTO();
		
		
		Set<AuthorsDTO> set_authors = new HashSet<AuthorsDTO>();
		Set<BookDTO> set_books = new HashSet<BookDTO>();
		Set<PublisherDTO> set_publisherObj = new HashSet<PublisherDTO>();
		
		publisherObject.setPublishar_name(obj.getPublishar_name());
		publisherObject.setPublishar_ratings(obj.getAuthor_ratings());
		
		authorObj.setAuthor_name(obj.getAuthor_name());
		authorObj.setAuthor_ratings(obj.getAuthor_ratings());
		
		bookObj.setBook_name(obj.getBook_name());
		bookObj.setBook_edition(obj.getBook_edition());
		bookObj.setBook_ratings(obj.getBook_ratings());
		
		set_authors.add(authorObj);
		set_books.add(bookObj);
		set_publisherObj.add(publisherObject);
		
		bookObj.setAuthors(set_authors);
		authorObj.setBooks(set_books);
		authorObj.setPublisher(set_publisherObj);
		publisherObject.setAuthors(set_authors);
		
		return publisherObject;
	}
	

	@RequestMapping(method = RequestMethod.POST, value = "/uploadFile")
	public String handleFileUpload(HttpServletRequest request,ModelMap map, @RequestParam CommonsMultipartFile[] fileUpload)throws Exception {
		System.out.println("i AM in uploadFile");
		System.out.println("description: " + request.getParameter("description"));
		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {
				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
					System.out.println("Saving file: " + aFile.getOriginalFilename());
					FilePropertiseDTO filePropertise = new FilePropertiseDTO();  
					filePropertise.setFlocation(aFile.getStorageDescription());
					filePropertise.setFname(aFile.getOriginalFilename());
					filePropertise.setFsize(aFile.getSize());
					filePropertise.setFdate(new Date());
					
					System.out.println("date : " + filePropertise.getFdate());
					System.out.println("File Location : " + filePropertise.getFlocation());
					System.out.println("File size : " + filePropertise.getFsize());
					System.out.println("File Name : " + filePropertise.getFname());
					System.out.println("=======Ready for save to the database ======");
					fileuploadingService.saveFile(filePropertise);
				}
			}
		}else{
			return "Error";
		}
		map.put("msg","Your file aplod success ");
		return "shopping_tiles";
	}
	
	

	@RequestMapping(method=RequestMethod.GET,value="/login_link")
	public String getLoginPage(){
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/uplod_books")
	public String goUplodBook(){
		return "uplod_books";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/shopping_tiles")
    public String getAllFileList(ModelMap map)
    {
       map.addAttribute("fileList", fileuploadingService.getFileList());
      // map.addAttribute("bookDetailsList", fileuploadingService.getbookDetailsLiat());
        return "shopping_tiles";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/book_list")
    public String getAllBookList(ModelMap map)
    {
      map.addAttribute("bookDetailsList", fileuploadingService.getbookDetailsLiat());
        return "shopping_tiles";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public String getDeleatRow(ModelMap map,@PathVariable int id, HttpServletResponse response)
    {
		System.out.println("hii i am going to deleate");
		if(fileuploadingService.doDeleateRow(id)){
			map.put("msg", "one row has deleatede "+id);
		}else{
			map.put("msg", "some thing is wrong during deleation of this id = "+id);
		}
        return "home";
    }
	

}