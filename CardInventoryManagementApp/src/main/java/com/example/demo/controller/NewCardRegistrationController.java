package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.AddNewCardInfoForm;
import com.example.demo.service.NewCardRegistrationService;

@RequestMapping("newCardRegistration")
@Controller
public class NewCardRegistrationController {

	@Autowired
	/** 新規カード登録処理を行うサービス */
	private NewCardRegistrationService service;
	
	/**
	 * 新規カード登録画面を表示するS
	 * 
	 * @return 新規カード登録画面のパス
	 */
	@GetMapping("/index")
	public String display() {
		return "newCardRegistration";
	}
	
	/**
	 * 新規カードの登録処理を行う
	 * 
	 * @param form 新規カード登録情報
	 * @param model モデル
	 * @return 新規カード登録画面へのリダイレクトパス
	 */
	@PostMapping("/register")
	public String add(@ModelAttribute AddNewCardInfoForm form, Model model) {
		service.registCardInfo(form);
		return "redirect:/index";
	}
}
