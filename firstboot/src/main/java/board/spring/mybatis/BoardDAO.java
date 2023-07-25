package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDAO {
	public int insertBoard(BoardDTO dto);
	public int getTotalBoard();
	public List<BoardDTO> pagingList(int limitIndex[]);
	public void plusViewcount(int seq);
	public BoardDTO oneBoard(int seq);
	public void deleteBoard(int seq);
	public void updateBoard(BoardDTO dto);
	public List<BoardDTO> searchList(HashMap<String, String> hash);
	public BoardMemberDTO boardWriterInform(int seq);
}