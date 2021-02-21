// Java code to print the elements of Stream using double colon operator 

import java.util.stream.*; 

class ColonOperator{ 
	public static void main(String[] args) 
	{ 

		// Get the stream 
		Stream<String> stream 
			= Stream.of("The", "World", 
						"is", "not", 
						"enough"); 

		// Print the stream using double colon operator 
		stream.forEach(System.out::println); 
	} 
} 
