//@author: Haris Prasovic 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void printTravelPrices(int[][] travelPrices, int numberOfCities){
        for(int i = 0; i<numberOfCities; i++){
            for(int j=0; j<numberOfCities; j++){
                System.out.print(travelPrices[i][j]);
                if(travelPrices[i][j]/10 == 0)
                    System.out.print("  ");
                else
                    System.out.print(' ');
            }
            System.out.println("");
        }
    }
	
	public static void main(String [] args) throws IOException {
		Scanner s=new Scanner(System.in);
		System.out.println("Please enter file name you would like to open");
		String name=s.nextLine();
		
		File tem= new File(name+".txt");
		while(tem.exists()==false) {
    		System.out.println("File does not exist, try again!");
    		name=s.nextLine();
    		tem= new File(name+".txt");
    		}
    	boolean exists=tem.exists();
    	
    	FileReader nam= new FileReader(name+".txt");
    	Scanner sc= new Scanner( new BufferedReader(nam));
    	
    	int cities= sc.nextInt();
    	
    	int [][]matrix=new int[cities][cities];
    	for(int i=0;i<cities;i++) {
    		for(int j=0;j<cities;j++) {
    			matrix[i][j]=sc.nextInt();
    		}
    	}
    	
    	printTravelPrices(matrix,cities);
    	SalesAlg geneticAlgorithm= new SalesAlg(cities, SelectionType.ROULETTE, matrix, 0, 0);
    	
    	SalesmanGenome result= geneticAlgorithm.optimize();
    	System.out.println(result);
    	
	}
	
	
}
