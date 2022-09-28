package com.internet.site.entitys;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Table(name="f_like")
@Data
public class Like {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="comment_id",nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Comment comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	User user;
}