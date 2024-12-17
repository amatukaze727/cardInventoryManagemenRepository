package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.SearchCardDetailForm;
import com.example.demo.entity.SearchCardDetailResult;
import com.example.demo.service.CardDetailService;

@RequestMapping("cardDetail")
@Controller
public class CardDetailController {
	
	@Autowired
	private CardDetailService service;
	
	@GetMapping("/search")
	public String search(@ModelAttribute SearchCardDetailForm form, Model model) {
		List<SearchCardDetailResult> searchCardDetailResultList = service.searchCardDetail(form);
		model.addAttribute("cardDetailList",searchCardDetailResultList);
		return "cardDetail";
	}
}
