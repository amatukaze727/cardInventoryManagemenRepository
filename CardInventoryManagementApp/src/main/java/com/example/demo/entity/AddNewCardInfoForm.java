package com.example.demo.entity;

import lombok.Data;

@Data
public class AddNewCardInfoForm{
	/** カード名 */
	private String cardName;
	/** カード略称 */
	private String cardAbbreviation;
	/** カードゲームタイトル */
	private String cardTitle;
}
