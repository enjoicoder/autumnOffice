package kr.or.ddit.autumn.web.advice.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.autumn.vo.AttatchVO;
import kr.or.ddit.autumn.web.advice.service.AdviceService;
/**
 *	상담요청 다운로드 컨트롤러 
 *
 */
@Controller
public class AdviceAttatchDownloadController {
	@Inject
	private AdviceService service;
	
	@RequestMapping("/web/advice/download.do")
	public String download(
		@RequestParam(name="what", required=true) int attNo
		, Model model
	) throws IOException {
		AttatchVO attatch = service.retrieveAttatch(attNo);
		model.addAttribute("attatch", attatch);
		return "downloadView";
	}
}
