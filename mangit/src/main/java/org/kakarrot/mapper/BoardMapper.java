package org.kakarrot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.kakarrot.domain.BoardVO;

public interface BoardMapper extends CrudMapper<BoardVO, Integer>, ListMapper<BoardVO>{

	
	public List<BoardVO> searchList(
			@Param("page") int page,
			@Param("amount") int amount,
			@Param("keyword") String keyword,
			@Param("types") String[] types
			);
	
//	public int searchCount(
//			@Param("keyword") String keyword,
//			@Param("type") String[] type 
//			);
}
