package com.example.demo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.AddNewCardInfoForm;

public interface NewCardRegistrationRepository extends CrudRepository<AddNewCardInfoForm, Integer>{
	@Modifying
	@Query(value = "INSERT INTO card_info VALUES(0,:name, :abbreviation, :title)")
	void insertNewCardInfo(@Param("name") String name,
	                       @Param("abbreviation") String abbreviation,
	                       @Param("title") String title);
}
