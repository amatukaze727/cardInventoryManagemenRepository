package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.CardStockAddForm;
import com.example.demo.service.CardStockAddService;

@RequestMapping("cardStockAdd")
@Controller
public class CardStockAddController {

	@Autowired
	/** カード在庫追加処理を行うサービス */
	private CardStockAddService service;
	
	/**
	 * カード在庫追加画面を表示する
	 * 
	 * @param cardId カードID
	 * @param model モデル
	 * @return カード在庫追加画面のパス
	 */
	@GetMapping("/index")
	public String display(@RequestParam("cardId")String cardId, Model model) {
		model.addAttribute("cardId", cardId);
		return "cardStockAdd";
	}
	
	/**
	 * カード在庫追加処理を行う
	 * 
	 * @param form 追加在庫情報
	 * @param model モデル
	 * @return カード在庫追加画面へのリダイレクトパス
	 */
	@PostMapping("/register")
	public String add(@ModelAttribute CardStockAddForm form, Model model, RedirectAttributes redirectAttributes) {
		service.registCardDetailInfo(form);
		redirectAttributes.addFlashAttribute("message", "カードを登録しました。");
		return "redirect:index/" + form.getCardId();
	}
}
