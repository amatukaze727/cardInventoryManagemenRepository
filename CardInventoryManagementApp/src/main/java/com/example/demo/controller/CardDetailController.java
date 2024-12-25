package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.SearchCardDetailResult;
import com.example.demo.service.CardDetailService;

@RequestMapping("cardDetail")
@Controller
public class CardDetailController {
	
	@Autowired
	private CardDetailService service;
	
	@GetMapping("/search")
	public String search(@RequestParam("cardId")String cardId, Model model) {
		List<SearchCardDetailResult> searchCardDetailResultList = service.searchCardDetail(cardId);
		model.addAttribute("cardDetailList",searchCardDetailResultList);
		return "cardDetail";
	}
	// 削除機能は後で追加
}
