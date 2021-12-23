package com.classes;

public class Tool {
	
	protected String AdjustTime(String time) {
		if (time.length()==0) {
			return "00:00:00";
		}
		
		String hours = null;
		String minutes = null;
		String seconds = null;
		int counter = 0;
		int lastI = 0;
		
		for (int i=0; i<time.length(); i++) {
			if (counter == 1 && time.charAt(i) == ':') {
				minutes = time.substring(lastI+1,i);
				seconds = time.substring(i+1);
			}
			if (counter == 0 && time.charAt(i) == ':') {
				hours = time.substring(0,i);
				counter++;
				lastI = i;
			}
		}
		
		if (hours.length() == 0) 	{hours = "00";}
		if (minutes.length() == 0) 	{minutes = "00";}
		if (seconds.length() == 0) 	{seconds = "00";}
		
		if (hours.length() == 1) 	{hours = "0" + hours;}
		if (minutes.length() == 1) 	{minutes = "0" + minutes;}
		if (seconds.length() == 1) 	{seconds = "0" + seconds;}
		
		return hours + ":" + minutes + ":" + seconds;
	}
	
	
	protected String computeTotalTime(String inTime, String outTime) {
		
		String strIn_Hours = inTime.substring(0, 2);
		String strIn_Mins = inTime.substring(3, 5);
		String strIn_Secs = inTime.substring(6, 8);
		
		String strOut_Hours = outTime.substring(0, 2);
		String strOut_Mins = outTime.substring(3, 5);
		String strOut_Secs = outTime.substring(6, 8);
		
		int In_Hours = Integer.valueOf(strIn_Hours);
		int In_Mins = Integer.valueOf(strIn_Mins);
		int In_Secs = Integer.valueOf(strIn_Secs);
		
		int Out_Hours = Integer.valueOf(strOut_Hours);
		int Out_Mins = Integer.valueOf(strOut_Mins);
		int Out_Secs = Integer.valueOf(strOut_Secs);
		
		int InTimeSeconds = (In_Hours * 3600) + (In_Mins * 60) + In_Secs;
		int OutTimeSeconds = (Out_Hours * 3600) + (Out_Mins * 60) + Out_Secs;
		
		int TimeSeconds = OutTimeSeconds - InTimeSeconds;
		
		int TotalTimeHours = (TimeSeconds / 3600);
		int TotalTimeMins = ((TimeSeconds % 3600) / 60) / 1;
		int TotalTimeSecs = ((TimeSeconds % 3600) % 60);
		
		return TotalTimeHours + ":" + TotalTimeMins + ":" + TotalTimeSecs;
	}
}
