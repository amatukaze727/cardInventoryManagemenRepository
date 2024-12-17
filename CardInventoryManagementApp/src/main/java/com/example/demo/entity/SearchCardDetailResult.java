package com.example.demo.entity;

import lombok.Data;

@Data
public class SearchCardDetailResult {
	
	/** カード名 */
	private String cardName;
	
	/** カードID */
	private String cardId;
	
	/** カード個別ID */
	private String cardDetailId;
	
	/** カード配置場所 */
	private String cardLocation;
	
	/** カード状態 */
	private String cardStatus;
}
