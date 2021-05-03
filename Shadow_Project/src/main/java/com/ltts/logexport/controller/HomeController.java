package com.ltts.logexport.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ltts.logexport.ziputility.*;
import com.ltts.logexport.exception.*;
import com.ltts.logexport.filestorageservice.FileStorageService;

@Controller
public class HomeController {

	@GetMapping("")
	public String view() {

		return "home";
		
	}
	@GetMapping("/download")
	public void download(HttpServletResponse res)throws Exception
	{
 
		try
		{
			ConvertToZip.zip_one_file();
			System.out.println("File zipped");
			FileStorageService.saveFile(res);
		}
		catch(Exception ex)
		{
			throw new logException();
		}
	}

}
