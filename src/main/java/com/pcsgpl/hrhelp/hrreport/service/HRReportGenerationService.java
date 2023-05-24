package com.pcsgpl.hrhelp.hrreport.service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
@Service
public class HRReportGenerationService {
	private Logger logger =LoggerFactory.getLogger(HRReportGenerationService.class);
	
   public ByteArrayInputStream createPdf() {
	   
	   logger.info("createPdf started :  ");
	   
	   
	   String title="Sub: Provisional Joining Letter ( EILP Program)";
	   String content="Dear John Doe,\n"
	   		+"We are pleased to inform you that you have successfully appeared all of our preliminary and basic level selection procedures. Hence, we would like to offer you a post of “Trainee Software Engineer” in our organization with effect  14th April 2023 with below Agreement.\r\n"
	   		+ "Designation : Trainee Software Engineer\n"
	   		+ "Provisional Associate Id : 1904\n"
	   		+ "Date Of Joining :14 April ,2023 \n"
	   		+ "Primary Technical  Domain :  Java Full Stack Developer\n"
	   		+ "  Primary Terms &  Conditions ( Agreement) : \n"
	   		
	   		+ "A.  Both party understand & agreed that EILP - Program is an opportunity first to be Industry Ready within an incubation period of  two months (60 days).\r\n"
	   		+ "B.  Stipend / Salary - Both party understand & agreed that no salary or stipend applicable until unless a developer on board to  Client / Partner / Product Deliverable Project  through multiple evaluation by Technical Leads , S/W Clients , em-paneled vendors. Entire Trainee Software Engineer period is non salaried period of engagement with company.  \n"
	   		+ "C.  EILP - Both Party understand  & agreed that EILP is primary Self Learning  with minimum mentor-ship ( Weekly 2 days guidance and Weekly 1 days skill presentation & Case Study / Project presentation)\r\n"
	   		+ "D. Both Party understand & Agreed that EILP is strictly programme for entry level engineers  to startup career first. After getting opportunity an associates need prove his/her caliber to learn first , employable first to deliver In-house, Domestic,  Client project successfully with perfection . Have to achieve capability for client problem solving , delivery of assigned work perfectly in time bound period .\n"
	   		+ "E. During two months incubation period through multiple technical evaluation good performer resource will promoted with revise permanent Joining Letter with permanent associate id , stipend/salary letter will be awarded on the basis of performance while an associates will be promoted to next designation .\n"
	   		+ "F. No Service Bond during EILP period, Associates is entitled to get release and Trainee experience letter within 15 days formal leaving of organization with proper release notification , with separation formalities completion only.\r\n"
	   		+ "G. EILP period is valid up to one year from the date of joining.";
	   
	   		 ByteArrayOutputStream out =new ByteArrayOutputStream();
	   		 Document  document =new Document();
	   		PdfWriter.getInstance(document, out);
	   		
	   		document.open();
	   		Font titleFont =FontFactory.getFont(FontFactory.HELVETICA_BOLD , 20);
	   	   Paragraph titlePara =new Paragraph(title,titleFont);
	   	   titlePara.setAlignment(Element.ALIGN_CENTER);
	   	   document.add(titlePara);
	   	   
	   	   Font paraFont =FontFactory.getFont(FontFactory.HELVETICA, 18);
	   	   Paragraph paragraph=new Paragraph(content);
	   	   document.add(paragraph);
	   	   document.close();
	   	   
	   	   return new ByteArrayInputStream(out.toByteArray());
	   	   
	   
   }
}
 