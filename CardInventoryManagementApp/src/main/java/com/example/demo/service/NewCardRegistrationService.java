package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AddNewCardInfoForm;
import com.example.demo.repository.NewCardRegistrationRepository;

@Service
public class NewCardRegistrationService {
	
	/** 新規カード登録処理を行うリポジトリ */
	@Autowired
	private NewCardRegistrationRepository repository;
	
	/**
	 * 新規カード情報登録処理を行う
	 */
	public void registCardInfo(AddNewCardInfoForm cardInfo) {
		repository.insertNewCardInfo(cardInfo.getCardName(), cardInfo.getCardAbbreviation(), cardInfo.getCardTitle());
	}
}
