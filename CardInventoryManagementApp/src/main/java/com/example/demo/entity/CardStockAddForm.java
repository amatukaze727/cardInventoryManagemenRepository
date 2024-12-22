package com.example.demo.entity;

import lombok.Data;

@Data
public class CardStockAddForm {
	/** カードID */
	private String cardId;
	
	/** カード配置場所 */
	private String cardLocation;
	
	/** カード状態 */
	private String cardStatus;
}
