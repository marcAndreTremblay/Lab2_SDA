package core;

import java.sql.Time;
import java.time.*;

public class FastTimer {
	  	
		double StartingTime;
		double LastDelta;
		public FastTimer () {
			this.StartingTime = 0.d;
	    }
	   public void StartTime(){
		   StartingTime  = System.currentTimeMillis();
	   }
	   
	   public void StopTimeAndPrint(){
		   double delta =  System.currentTimeMillis() - StartingTime;
		   System.out.print(delta + " milliseconde\n");
	   }
	   public void StopTime(){
		   LastDelta =  System.currentTimeMillis() - StartingTime;
	   }
}
