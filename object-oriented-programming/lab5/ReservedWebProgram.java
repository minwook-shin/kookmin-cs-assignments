package kmu.oop.practice.lab4.theater;

import kmu.oop.practice.lab4.common.*;
import kmu.oop.practice.lab4.theater.*;
import java.io.*;

public class ReservedWebProgram extends ReservedProgram {
	
	String URL;
	
	public ReservedWebProgram(TheaterType type, String program, int admissionFee[], String URL)
	{
		super(type,program,admissionFee);
		this.URL = URL;
		// (Test1) implements constructor for subclass ReservedWebProgram
		
	}
	
	public void showURL()
	{
		
		// (Test5) implements showURL() that displays the URL home page site by executing Google Chrome
		
        String dosCommand = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
        String chromdOption = " -window-size=1400,1040 --window-position=4800,400 --force-device-scale-factor=0.3 ";
        try
        {
            final Process process = Runtime.getRuntime().exec(dosCommand + chromdOption+ URL);
            final InputStream in = process.getInputStream();
            int ch;
            while((ch = in.read()) != -1)
            {
                System.out.print((char)ch);
            }
            
        } 
        catch (IOException e) {
        e.printStackTrace();
    }
	}
}
