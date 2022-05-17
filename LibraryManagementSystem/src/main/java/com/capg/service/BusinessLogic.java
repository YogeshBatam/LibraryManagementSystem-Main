package com.capg.service;

import java.util.Date;

import org.springframework.stereotype.Service;
@Service
public class BusinessLogic {
	
	public long getFine(long no_of_days)
	{
		
		long fine=0;
		if(no_of_days<2)
		{
			fine=0;
		}
		else if(no_of_days>2 && no_of_days<=5)
		{
		 fine= no_of_days*2;
		}
		else if(no_of_days>5 && no_of_days<=10)
		{
			fine= 14+(no_of_days*4);
		}
		else if(no_of_days>10 && no_of_days<15)
		{
			fine= 42+(no_of_days*6);
		}
		else if(no_of_days>15)
		{
			fine= 84+((no_of_days-42)*8);
		}
		return fine;
	}

}
