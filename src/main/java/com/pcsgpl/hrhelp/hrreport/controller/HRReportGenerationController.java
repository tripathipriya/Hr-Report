package com.pcsgpl.hrhelp.hrreport.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcsgpl.hrhelp.hrreport.service.HRReportGenerationService;
 //import sun.security.provider.certpath.ResponderId;

@Controller
@RequestMapping("/pdf")
public class HRReportGenerationController {
	@Autowired
	private HRReportGenerationService hrReportGenerationService;
	
	
	@GetMapping("/createPdf")
	public ResponseEntity<InputStreamResource> createPdf() {
		ByteArrayInputStream pdf =hrReportGenerationService.createPdf();
		HttpHeaders httpHeaders= new HttpHeaders();
	   httpHeaders.add("Content-Disposition", "inline;file=offerlatter.pdf");
	   
	   return ResponseEntity
			   .ok()
			   .headers(httpHeaders)
			   .contentType(MediaType.APPLICATION_PDF)
		       .body(new InputStreamResource(pdf));
		
		
		
	}
	
	
	


}
