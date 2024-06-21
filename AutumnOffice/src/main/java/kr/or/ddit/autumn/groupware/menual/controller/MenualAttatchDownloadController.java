package kr.or.ddit.autumn.groupware.menual.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.autumn.management.menu.service.DocManageMenualService;
import kr.or.ddit.autumn.vo.AttatchVO;

@Controller
public class MenualAttatchDownloadController {

	@Inject
	private DocManageMenualService service;
	
	@RequestMapping("/groupware/menual/download.do")
	public String download(
			@RequestParam(name="what", required=true) int attNo
			, Model model
		)throws IOException {
			AttatchVO attatch = service.retrieveAttatch(attNo);
			model.addAttribute("attatch", attatch);
			return "downloadView";
	}
}
