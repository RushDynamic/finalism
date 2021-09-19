package com.rushdynamic.finalism.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rushdynamic.finalism.entity.UrlEntity;

public interface UrlRepository extends JpaRepository<UrlEntity, Long> {
	
}
