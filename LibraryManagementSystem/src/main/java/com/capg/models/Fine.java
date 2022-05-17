package com.capg.models;

import java.util.Date;

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
@Entity
@Table(name = "fine")
@NoArgsConstructor
public class Fine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fineid;
	private Date finedate;
	private int isuueid;
	private int returnId;
	private int bookid;
	private int studentid;
	private int noOfDelayDays;
	private long fineamount;

}
