package com.internet.site.entitys;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="comment")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="film_id",nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	Film film;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	User user;


	String title;
	@Lob
	@Column(columnDefinition="text")
	String text;

	@Temporal(TemporalType.TIMESTAMP)
	Date createDate;



}
