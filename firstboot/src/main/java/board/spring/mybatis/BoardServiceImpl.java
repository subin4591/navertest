package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;
	
	@Override
	public int insertBoard(BoardDTO dto) {
		return dao.insertBoard(dto);
	}

	@Override
	public int getTotalBoard() {
		return dao.getTotalBoard();
	}

	@Override
	public List<BoardDTO> pagingList(int limitIndex[]) {
		return dao.pagingList(limitIndex);
	}

	@Override
	public void plusViewcount(int seq) {
		dao.plusViewcount(seq);
	}

	@Override
	public BoardDTO oneBoard(int seq) {
		return dao.oneBoard(seq);
	}

	@Override
	public void deleteBoard(int seq) {
		dao.deleteBoard(seq);
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		dao.updateBoard(dto);
	}

	@Override
	public List<BoardDTO> searchList(HashMap<String, String> hash) {
		return dao.searchList(hash);
	}

	@Override
	public BoardMemberDTO boardWriterInform(int seq) {
		return dao.boardWriterInform(seq);
	}
}