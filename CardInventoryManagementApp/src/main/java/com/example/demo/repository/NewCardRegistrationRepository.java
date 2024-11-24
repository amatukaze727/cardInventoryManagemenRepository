package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NewCardRegistrationRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertNewCardInfo(String name, String abbreviation, String title) {
		String query = "INSERT INTO card_info (name, abbreviation, title) VALUES(?, ?, ?)";
		jdbcTemplate.update(query, name, abbreviation, title);
	}
}
