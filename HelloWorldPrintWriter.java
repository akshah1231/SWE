package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

public class HelloWorldPrintWriter {
	public static void main(String args[]) {
		int[] numbers = {10, 14, 35, 25, 49, 70, 1};
        printHelloWorld(numbers);	
	}
	public static void printHelloWorld(int[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]%5==0 && numbers[i]%7==0 ) {
				System.out.println("Hello World");
			}
			else if(numbers[i]%5==0 ) {
				System.out.println("Hello");
			}
			else if(numbers[i]%7==0 ) {
				System.out.println("World");
			}
		}
	}

}
