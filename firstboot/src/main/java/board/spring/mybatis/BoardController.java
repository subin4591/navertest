package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("boardServiceImpl")
	BoardService service;
	
	@RequestMapping("/")
	public String start() {
		return "board/start";
	}
	
	@GetMapping("/boardwrite")
	public String writeform() {
		return "board/writingform";
	}
	
	@PostMapping("/boardwrite")
	public ModelAndView writeprocess(BoardDTO dto) {
		int insertcount = service.insertBoard(dto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("insertcount", insertcount);
		mv.setViewName("board/writeresult");
		return mv;
	}
	
	@RequestMapping("/boardlist")
	public ModelAndView boardlist(@RequestParam(value="page", required=false, defaultValue="1") int page) {
		int totalBoard = service.getTotalBoard();
		int num = 5;
		int limitIndex[] = {(page - 1) * num, num};
		List<BoardDTO> dtolist = service.pagingList(limitIndex);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalBoard", totalBoard);
		mv.addObject("num", num);
		mv.addObject("dtolist", dtolist);
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping("/boarddetail")
	public ModelAndView detail(int seq) {
		service.plusViewcount(seq);
		BoardDTO dto = service.oneBoard(seq);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping("/boarddelete")
	public String boardDelete(int seq) {
		service.deleteBoard(seq);
		return "redirect:/boardlist";
	}
	
	@RequestMapping("/boardupdate")
	public String boardUpdate(int seq, String title, String contents) {
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContents(contents);
		
		service.updateBoard(dto);
		return "redirect:/boardlist";
	}
	
	@RequestMapping("/boardsearchlist")
	public ModelAndView boardSearchList(String item, String word,
			@RequestParam(value="page", required=false, defaultValue="1") int page
			) {
		HashMap<String, String> hash = new HashMap<>();
		hash.put("colName", item);
		hash.put("colValue", "%" + word + "%");
		
		List<BoardDTO> searchlist = service.searchList(hash);
		List<BoardDTO> dtolist = null;
		
		int totalBoard = searchlist.size();
		int num = 5;
		int limitIndex = (page - 1) * num;
		
		if (limitIndex + num >= totalBoard)
			dtolist = searchlist.subList(limitIndex, totalBoard);
		else
			dtolist = searchlist.subList(limitIndex, limitIndex + num);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalBoard", totalBoard);
		mv.addObject("num", num);
		mv.addObject("dtolist", dtolist);
		mv.setViewName("board/searchlist");
		return mv;
	}
	
	@RequestMapping("/boardwriterinform")
	public ModelAndView boardWriterInform(int seq) {
		BoardMemberDTO writerDto = service.boardWriterInform(seq);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("writerDto", writerDto);
		mv.setViewName("board/writerinform");
		return mv;
	}
}