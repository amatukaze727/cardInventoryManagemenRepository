package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CardStockAddForm;
import com.example.demo.repository.CardDetailRepository;

@Service
public class CardStockAddService {
	
	/** カード在庫追加処理を行うリポジトリ */
	@Autowired
	private CardDetailRepository repository;
	
	/**
	 * カード在庫追加処理を行う
	 * 
	 * @param cardDetailInfo カード詳細情報
	 */
	public void registCardDetailInfo(CardStockAddForm cardDetailInfo) {
		repository.insertCardDetailInfo(cardDetailInfo.getCardId(), cardDetailInfo.getCardLocation(), cardDetailInfo.getCardStatus());
	}
}
