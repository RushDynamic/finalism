package com.rushdynamic.finalism.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rushdynamic.finalism.entity.UrlEntity;

public interface UrlRepository extends JpaRepository<UrlEntity, Long> {
	
	UrlEntity findByShortUrl(String shortUrl);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE url_dtl SET total_hits = total_hits + 1 WHERE short_url = :shortUrl", 
			nativeQuery = true)
	void incrementHits(@Param("shortUrl") String shortUrl);
}