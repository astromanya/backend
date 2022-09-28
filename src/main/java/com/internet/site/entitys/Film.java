package com.internet.site.entitys;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="film")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String title;
	@Lob
    @Column(columnDefinition="text")
	String text;
	@Lob
	@Column(columnDefinition="BLOB(10000000)")
	public Byte[] Film_Pic;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Film film = (Film) o;
		return id != null && Objects.equals(id, film.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}