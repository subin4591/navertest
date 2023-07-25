package board.spring.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberBoardController {
	@Autowired
	@Qualifier("memberServiceImpl")
	MemberService service;
	
	@GetMapping("/boardlogin")
	public String loginform() {
		return "board/loginform";
	}
	
	@PostMapping("/boardlogin")
	public String loginprocess(String member_id, int pw, HttpSession session) {
		// c_member 테이블에서 member_id, pw 확인
		MemberDTO dto = service.oneMember(member_id);
		
		if (dto != null) {
			if (dto.getPw() == pw) {
				session.setAttribute("sessionid", member_id);
			}
			else {
				// session.setAttribute("sessionid", "PW가 다릅니다.");
			}
		}
		else {
			// session.setAttribute("sessionid", "ID가 존재하지 않습니다.");
		}
		
		return "board/start";
	}
	
	@RequestMapping("/boardlogout")
	public String logout(HttpSession session) {
		if (session.getAttribute("sessionid") != null) {
			session.removeAttribute("sessionid");			
		}
		return "board/start";
	}
}