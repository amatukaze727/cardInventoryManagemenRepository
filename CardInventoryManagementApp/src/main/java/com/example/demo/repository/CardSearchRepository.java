package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CardSearchRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * カード情報検索処理
	 * 
	 * @param name
	 * @return カード情報
	 */
	public List<Map<String, Object>> selectCardInfo(String abbreviation) {
		String query = "SELECT card_name, card_id FROM card_info WHERE card_abbreviation = ?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(query, abbreviation);
		return list;
	}
	
	/**
	 * カード枚数検索処理
	 * 
	 * @param cardId カードID
	 * @return カード枚数
	 */
	public int selectCardCount(String cardId) {
		String query= "SELECT COUNT(*) FROM card_detail_info WHERE card_id = ?";
		return jdbcTemplate.queryForObject(query, Integer.class, cardId);
	}
}
