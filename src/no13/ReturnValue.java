package no13;

public class ReturnValue {
	public static void main(String[] args) {
		  System.out.println(decision()); 
	}
	
	public static boolean decision() { 
	     try { 
	         return true; 
	     } finally { 
	         return false; 
	     } 
	 }  
}
