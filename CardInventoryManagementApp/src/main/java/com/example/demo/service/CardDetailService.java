package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SearchCardDetailForm;
import com.example.demo.entity.SearchCardDetailResult;
import com.example.demo.entity.SearchCardResult;
import com.example.demo.repository.CardDetailRepository;

@Service
public class CardDetailService {
	@Autowired
	private CardDetailRepository repository;
	
	public List<SearchCardDetailResult> searchCardDetail(SearchCardDetailForm form) {
		// カード詳細情報
		List<Map<String, Object>> resultList = repository.selectCardDetail(form.getCardId());
		// SearchCardResultに受け取った情報をセットする
		// しゅうせい
		List<SearchCardDetailResult> searchCardResultList = new ArrayList<SearchCardDetailResult>();
		for(Map<String, Object> result:resultList){
			SearchCardResult searchCardResult = new SearchCardResult();
			searchCardResult.setCardId(result.get("card_id").toString());
			searchCardResult.setCardName(result.get("card_name").toString());
			// カードIDを元にカード枚数を検索する
			searchCardResult.setCardCount(repository.selectCardCount(searchCardResult.getCardId()));
			searchCardResultList.add(searchCardResult);
		}
		return searchCardResultList;
	}
}
