package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CardDetailRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * カード詳細情報検索処理
	 * 
	 * @param cardId カードID
	 * @return カード詳細情報
	 */
	public List<Map<String, Object>> selectCardDetail(String cardId) {
		String query= "SELECT card_id, card_detail_id, card_location, card_status FROM card_detail_info WHERE card_id = ?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(query, cardId);
		return list;
	}
	
	/**
	 * カード詳細情報登録処理
	 * 
	 * @param cardId カードID
	 * @param cardLocation カード配置場所
	 * @param cardStatus カード状態
	 */
	public void insertCardDetailInfo(String cardId, String cardLocation, String cardStatus) {
		String query = "INSERT INTO card_detail_info (card_id, card_location, card_status, date_added, date_updated) VALUES(?, ?, ?, CURRENT_TIME, CURRENT_TIME)";
		jdbcTemplate.update(query, cardId, cardLocation, cardStatus);
	}
	
	/**
	 * カード名検索処理
	 * 
	 * @param cardId カードID
	 * @return cardName カード名
	 */
	public String selectCardName(String cardId) {
		String query= "SELECT card_name FROM card_info WHERE card_id = ?";
		return jdbcTemplate.queryForObject(query, String.class, cardId);
	}
}
