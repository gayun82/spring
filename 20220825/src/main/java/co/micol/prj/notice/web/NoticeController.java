package co.micol.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.service.NoticeService;
import co.micol.prj.service.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService ns;
	
	@Autowired
	public ServletContext servletContext;
	
	@RequestMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) {
		vo.setNoticeId(21);//강제로 하나의 레코드를 선택하기 위해 만든 것
		model.addAttribute("n", ns.noticeSelect(null));
		return "notice/noticeSelect";
	}
	
	@GetMapping("/noticeSelectList.do")
	public String noticeSelectList(Model model) {
	model.addAttribute("notices",ns.noticeSelectList());
	return "notice/noticeSelectList";
	}
	
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
		//file upload 처리해야함
		String saveFolder = servletContext.getRealPath("/fileUpload");//저장할 공간 폴더 명
		File sfile = new File(saveFolder);//물리적 저장할 위치
		String oFileName = file.getOriginalFilename();//넘어온 파일의 이름
		if(!oFileName.isEmpty()) {
		//파일명 충돌방지를 위한 파일 별명만듦
		String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf("."));
		file.transferTo(new File(sfile,sFileName));//파일을 물리적 위치에 저장한다.
		vo.setNoticeAttech(oFileName);
		vo.setNoticeAttechdir(saveFolder + File.separator + sFileName); // fileUpload/273747.txt
		}
		
		ns.noticeInsert(vo);
		return "redirect:noticeSelectList.do";
	}
	
	@RequestMapping("/noticeUpdate.do")
	public String noticeUpdate(NoticeVO vo) {
		vo.setNoticeWriter("관리자");
		vo.setNoticeId(1);
		ns.noticeUpdate(vo);
		return "redirect:noticeSelectList.do";
	}
	
	@RequestMapping("/noticeSearch.do")
	public String noticeSearch(NoticeVO vo,String key,//@RequstParm("key")Strting key
			String val, Model model) {
		key = "1";
		val ="테스트";
		model.addAttribute("notices", ns.noticeSearch(key, val));
		return "notice/noticeSearch";
	}
	
	@GetMapping("/noticeForm.do")
	public String noticeInsertForm() {
		return "notice/noticeForm";
	}
	
	@RequestMapping(value = "/ajaxNoticeSelect.do" , produces = "application/text; charset=UTF-8")
	@ResponseBody //호출한 페이지로 결과를 돌려보내준다.
	public String ajaxNoticeSelect(HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		String message = "ajax test를 한번 해봅니다.";
		return message;
	}
	
	@GetMapping("/ajaxTest.do")
	public String ajaxTest() {
		return "notice/ajaxTest";
	}
}
