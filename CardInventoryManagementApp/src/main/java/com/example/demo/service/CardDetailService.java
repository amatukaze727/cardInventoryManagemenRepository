package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SearchCardDetailForm;
import com.example.demo.entity.SearchCardDetailResult;
import com.example.demo.repository.CardDetailRepository;

@Service
public class CardDetailService {
	@Autowired
	private CardDetailRepository repository;
	
	public List<SearchCardDetailResult> searchCardDetail(SearchCardDetailForm form) {
		// カード詳細情報
		List<Map<String, Object>> resultList = repository.selectCardDetail(form.getCardId());
		// SearchCardDetailResultに受け取った情報をセットする
		List<SearchCardDetailResult> searchCardDetailResultList = new ArrayList<SearchCardDetailResult>();
		for(Map<String, Object> result:resultList){
			SearchCardDetailResult searchCardDetailResult = new SearchCardDetailResult();
			searchCardDetailResult.setCardName(form.getCardName());
			searchCardDetailResult.setCardId(result.get("card_id").toString());
			searchCardDetailResult.setCardDetailId(result.get("card_detail_id").toString());
			searchCardDetailResult.setCardLocation(result.get("card_location").toString());
			searchCardDetailResult.setCardStatus(result.get("card_status").toString());
			searchCardDetailResultList.add(searchCardDetailResult);
		}
		return searchCardDetailResultList;
	}
}
