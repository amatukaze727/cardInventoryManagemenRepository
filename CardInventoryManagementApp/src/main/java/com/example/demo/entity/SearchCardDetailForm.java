package com.example.demo.entity;

import lombok.Data;

@Data
public class SearchCardDetailForm {
	/** カードID */
	private String cardId;
	
	/** カード名 */
	private String cardName;
	
	/** 枚数 */
	private int cardCount;
}
