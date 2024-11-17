package com.example.demo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class AddNewCardInfoForm implements Serializable{
	/** カード名 */
	private String cardName;
	/** カード略称 */
	private String cardAbbreviation;
	/** カードゲームタイトル */
	private String cardTitle;
}
