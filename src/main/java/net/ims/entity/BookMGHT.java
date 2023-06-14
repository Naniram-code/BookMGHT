package net.ims.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BOOKMGHT")
public class BookMGHT {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ID")
	private int id;
	@Column (name="TITLE")
	private String title;
	@Column (name="AUTHOR")
	private String author;
	@Column (name="PUBLICATION_YEAR")
	private String publication_year;
	
	
	

}
