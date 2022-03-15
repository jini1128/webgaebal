package com.tj.spring.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tj.spring.repository.BoardDAO;
import com.tj.spring.vo.BoardVO;

@Controller
public class BoardController {


	@Autowired
	private BoardDAO boardDAO;
	
	@RequestMapping("/board")
	public String board(/*@RequestParam String a*/Model model) {
//		System.out.println("param=");
		List<BoardVO> list = boardDAO.getList();
		model.addAttribute("list",list);
		return "/WEB-INF/bo/list.jsp";
	}
	
	@RequestMapping(value="/addboard",method=RequestMethod.POST)
	public String add(@ModelAttribute BoardVO boardVO) { // list.jsp���� form���� �Ѱ��� �Ķ���͸� �޾ƿ��⸦ �Ϸ��� modelattribute ������̼�
		
		boardDAO.insert(boardVO);
		
		return "redirect:/board";//������ �ٽ� ����
	}
	
	@RequestMapping("/delboard")
	public String del(@RequestParam String pw,@RequestParam String no) {
		
	boardDAO.del(no,pw);
		
		return "redirect:/board";
		
	}
	
	@RequestMapping("/delboardpg")//������������ �̵�
	public String deldb() {
		return "/WEB-INF/views/delete.jsp";
	}
	
}
