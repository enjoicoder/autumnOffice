package kr.or.ddit.autumn.groupware.mail.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.autumn.groupware.mail.service.MailReaderServiceImpl;
import kr.or.ddit.autumn.groupware.mail.vo.ReceiveMailVO;
import kr.or.ddit.autumn.web.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/groupware/mail")
public class MailimapController {
	private String userName = "chansol128@naver.com";
	private String password = "cksthfl!128";
	
	@Inject
	private MailReaderServiceImpl receiver;
	
	@Value("#{appInfo.attatchFolder}")//el코드를 쓸수있는 어노테이션
	private Resource attatchFolder;
	private File saveFolder;
	
	@PostConstruct
	public void init() throws IOException {

		saveFolder = attatchFolder.getFile();
		
		if(!saveFolder.exists())
			saveFolder.mkdirs();
		
		log.info("로딩된 saveFolder : {}",saveFolder.getCanonicalPath());
	}
	
	
	//메일 페이징 리스트
		@PostMapping(value="/mailList.do",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		public PagingVO<ReceiveMailVO> mailPagingList(HttpServletRequest request
					,@RequestParam(name="page", required=false, defaultValue="1") int currentPage) throws ParseException, MessagingException, IOException {
			
	    String saveDirectory = "D:\\saveFiles\\";
	    receiver.setSaveDirectory(saveFolder);
	    
		PagingVO<ReceiveMailVO> pagingVO = new PagingVO<>(10,3);
		pagingVO.setCurrentPage(currentPage);
		
		int totalRecord = receiver.retrieveMailCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		
	    List<ReceiveMailVO> mailList = receiver.receiveMailAttachedFilePaging(request, userName, password, currentPage);
	    pagingVO.setDataList(mailList);
	   
	    return pagingVO;
		}
	
	//메일 하나삭제
	@PostMapping(value="/mailDelete.do")
	@ResponseBody
	public boolean mailDelete(Integer mailNo) throws ParseException, MessagingException, IOException {
	
	    	List<ReceiveMailVO> mailList = receiver.deleteMail(mailNo, userName, password);
	   
    String viewName = "redirect:/groupware/mail/mailList.do";
    boolean result = true;
    return result;
	}
	
	//메일 하나삭제
	@PostMapping(value="/mailDetailDelete.do")
	public String mailDetailDelete(Integer mailNo) throws ParseException, MessagingException, IOException {
	
	    	List<ReceiveMailVO> mailList = receiver.deleteMail(mailNo, userName, password);
	   
    String viewName = "redirect:/groupware/mail/mailList.do";
    
    return viewName;
	}
	
	//메일체크박스삭제
		@PostMapping(value="/mailCheckDelete.do")
		@ResponseBody
		public boolean mailCheckDelete(@RequestParam("deleteNos[]") String [] deleteNos) throws ParseException, MessagingException, IOException {
			System.out.println(deleteNos);
			 Integer[] intDeletetNos = Stream.of(deleteNos).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
			
			boolean result	 = receiver.deleteCheckMail(intDeletetNos, userName, password);
		  
	    String viewName = "redirect:/groupware/mail/mailList.do";
	    return result;
		}
	
	
}