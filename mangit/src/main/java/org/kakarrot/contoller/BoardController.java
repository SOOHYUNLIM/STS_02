package org.kakarrot.contoller;

import java.util.Arrays;
import java.util.List;

import org.kakarrot.domain.BoardVO;
import org.kakarrot.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {

	@Autowired
	private BoardMapper boardMapper;

	@GetMapping("/register")
	public void registerGET() {
	}

	@GetMapping("/list")
	public void list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int amount,
			String keyword, String[] types, Model model

	) {
		log.info(Arrays.toString(types) );
		log.info(keyword);

//		log.info("............." + page);
//		log.info("............." + boardMapper);
//
//		List<BoardVO> list = boardMapper.selectList(page, amount);
//		log.info(list);
//
//		model.addAttribute("list", list);

		List<BoardVO> list = boardMapper.searchList(page, amount, keyword, types);
		model.addAttribute("list", list);
		log.info(list);
	}

	@PostMapping("/register")
	public String postRegister(BoardVO vo) {
		boardMapper.insert(vo);
		return "redirect:list";
	}

}
