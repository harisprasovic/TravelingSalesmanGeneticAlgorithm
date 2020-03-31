//@author: Haris Prasovic 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SalesmanGenome implements Comparable{

	List<Integer> genome;
	
	int[][] travelPrices;
	
	int startingCity;
	int numberOfCities;
	
	int fitness;
	
	public SalesmanGenome(int numberOfCities, int[][] travelPrices, int startingCity) {
		this.travelPrices= travelPrices;
		this.startingCity= startingCity;
		this.numberOfCities= numberOfCities;
		
		this.genome= randomSalesman();
		this.fitness= this.calculateFitness();
	}
	
	public SalesmanGenome(List<Integer> permutationOfCities, int numberOfCities, int[][] travelPrices, int startingCity) {
		this.travelPrices= travelPrices;
		this.startingCity= startingCity;
		this.numberOfCities= numberOfCities;
		
		this.genome= permutationOfCities;
		this.fitness= this.calculateFitness();
	}
	
	private List<Integer> randomSalesman(){
		List<Integer> result= new ArrayList<Integer>();
		for(int i=0;i< numberOfCities; i++) {
			if(i !=startingCity) {
				result.add(i);
			}
		}
		Collections.shuffle(result);
		return result;
	}
	
	public int calculateFitness() {
		int fitness=0;
		int currentCity=startingCity;
		
		for(int gene:genome) {
			fitness+= travelPrices[currentCity][gene];
			currentCity = gene;
		}
		fitness += travelPrices[genome.get(numberOfCities-2)][startingCity];
		
		return fitness;
	}
	
	 public List<Integer> getGenome() {
	        return genome;
	    }

	    public int getStartingCity() {
	        return startingCity;
	    }

	    public int getFitness() {
	        return fitness;
	    }

	    public void setFitness(int fitness) {
	        this.fitness = fitness;
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Path: ");
	        sb.append(startingCity);
	        for ( int gene: genome ) {
	            sb.append(" ");
	            sb.append(gene);
	        }
	        sb.append(" ");
	        sb.append(startingCity);
	        sb.append("\nLength: ");
	        sb.append(this.fitness);
	        return sb.toString();
	    }


	    @Override
	    public int compareTo(Object o) {
	        SalesmanGenome genome = (SalesmanGenome) o;
	        if(this.fitness > genome.getFitness())
	            return 1;
	        else if(this.fitness < genome.getFitness())
	            return -1;
	        else
	            return 0;
	    }
	
}
