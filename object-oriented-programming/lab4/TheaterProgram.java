package kmu.oop.practice.lab4.theater;

import kmu.oop.practice.lab4.common.*;
import kmu.oop.practice.lab4.theater.*;

public class TheaterProgram {
	public TheaterType type;
	public String program;
	boolean sold[][];
	int admissionFee[]; //변수 선언 -> 배열 길이 모른
//	static DoubleFor df;
	static Common df;

	public TheaterProgram()
	{

	}

	// Test2: set up 3 variables with incoming arguments, and then, construct
	// 2-dimensional variable(sold[][]) followed by initializing as 'false'.
	public TheaterProgram(TheaterType t, String p, int ad[])
	{
		admissionFee=ad;
		type = t;
		program = p;
		
		// set up type, program, admission fee//re
		sold = new boolean[type.level][];
		
		for(int i=0; i<type.level;i++)
		{
			sold[i] = new boolean[type.size[i]];
		}
		
		for(int i = 0; i < type.level; i++) {
			for(int j = 0; j < type.size[i]; j ++) {
				sold[i][j]=false;
			}
		}
		
		// set up sold[][] by allocating memory space and initialing the value by 'false'

	}
	
	static public void setDoubleFor(Common df)
	{
		TheaterProgram.df = df;
	}
	
	public int vacantSeat() {
		int sum=0;
		
		for(int i=0; i < sold.length; i++)
			for(int j=0; j < sold[i].length; j++)
				if(!sold[i][j])
					sum ++;
		
		return sum;		
	}

	public int changeLevel(String level)
	{
		int res=-1;
		
		switch(level)
		{
			case "Royal":
				res=0;
				break;
			case "Premium":
				res=1;
				break;
			case "Economy":
				res=2;
				break;
			default:
		}
		
		return res;
	}

	// Test3: mark the seat sold out with 'true'
	public boolean sell(String level, int position)
	{
		sold[changeLevel(level)][position-1] = true;// mark sold[][] at the proper seat location
		
		return true;
	}
	
	public String seatStatus(String level, int position)
	{
		String res;
		
		if(sold[changeLevel(level)][position-1]) res="Sold";
		else res="Vacant";
		
		return res;
	}
	
	// Test4: compute the total income yielded by selling tickets
	public int income() {
		int sum=0;
		
		for(int i=0; i < sold.length; i++)
		{
			for(int j=0; j < sold[i].length; j++)
			{
				if(sold[i][j] == true) 
				{
					sum += admissionFee[i];
				}
			}// compute total income by selling tickets
		}
		
		return sum;
	}
	
}

