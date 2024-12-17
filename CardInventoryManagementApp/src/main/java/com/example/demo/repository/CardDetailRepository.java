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
}
