package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.SearchCardForm;
import com.example.demo.entity.SearchCardResult;
import com.example.demo.repository.CardSearchRepository;

public class CardSearchService {
	@Autowired
	private CardSearchRepository repository;
	
	public List<SearchCardResult> searchCard(SearchCardForm form) {
		// カード略称を元にカード情報を検索する
		List<Map<String, Object>> resultList = repository.selectCardInfo(form.getCardAbbreviation());
		// SearchCardResultに受け取った情報をセットする
		List<SearchCardResult> searchCardResultList = new ArrayList<SearchCardResult>();
		for(Map<String,Object> result:resultList){
			SearchCardResult searchCardResult = new SearchCardResult();
			searchCardResult.setCardId((String)result.get("card_id"));
			searchCardResult.setCardName((String)result.get("card_name"));
			// カードIDを元にカード枚数を検索する
			searchCardResult.setCardCount(repository.selectCardCount(searchCardResult.getCardId()));
			searchCardResultList.add(searchCardResult);
		}
		return searchCardResultList;
	}
}
