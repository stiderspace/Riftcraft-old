package com.stider.riftcraft.util;

import java.util.Random;

public class Mathhelper {

		
		 public static int random (int par1)
		  {
			 Random rand = new Random();
			 par1 = rand.nextInt(11);
			 	    
		     	   return par1;		    		       
		  }
		 public static boolean between(double Var1, double Var2, double Var3)
		  {
		      return (Var1 <= Var2) && (Var2 <= Var3);
		  }
 	
}
