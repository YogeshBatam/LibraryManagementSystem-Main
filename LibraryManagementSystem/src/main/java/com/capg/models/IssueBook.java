package com.capg.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class IssueBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int issueId;	
	private int bookId;	
	private int studentId;
	private String dateOfIssue;
	private String dateOfReturn;
	private String returnedStatus="Issued";
	
	private int returnId;

}
