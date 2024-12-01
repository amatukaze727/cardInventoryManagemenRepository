package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.SearchCardForm;
import com.example.demo.repository.CardSearchRepository;

public class CardSearchService {
	@Autowired
	private CardSearchRepository repository;
	
	public void searchCard(SearchCardForm form) {
		// repositoryにカード検索用のメソッドを定義する
	};
}
