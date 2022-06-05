package com.capg.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ReturnBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int returnId;
	@OneToOne
	private IssueBook issueBook;
	
	private int issuedId;

	private int studentId;

	private int bookId;

	private String actualReturnDate;
	@OneToOne
	private Fine fine;

}
