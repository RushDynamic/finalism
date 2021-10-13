package com.rushdynamic.finalism.entity;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="url_dtl")
public class UrlEntity {

	@Id
	@GeneratedValue
	@Column(name="url_id")
	int urlId;
	
	@Column(name="orig_url")
	String originalUrl;
	
	@Column(name="short_url")
	String shortUrl;
	
	@Column(name="created_at")
	Timestamp createdAt;
	
	@Column(name="last_visited")
	Timestamp lastVisited;
	
	@Column(name="total_hits")
	int totalHits;
	
	@PrePersist
    public void onInsert() {
		createdAt = Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant());
		lastVisited = createdAt;
    }
	
}
