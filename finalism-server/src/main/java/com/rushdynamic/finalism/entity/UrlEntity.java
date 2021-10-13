package com.rushdynamic.finalism.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

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
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	Date createdAt;
	
	@Column(name="last_visited")
	Date lastVisited;
	
	@Column(name="total_hits")
	int totalHits;
	
}
