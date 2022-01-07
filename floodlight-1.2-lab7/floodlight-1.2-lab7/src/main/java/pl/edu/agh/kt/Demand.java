package pl.edu.agh.kt;

import java.util.List;


public class Demand {
    private String sourceHost;
    private String destinationHost;
    private List<Path> paths;
    
    public Demand(String sourceHost, String destinationHost, List<Path> paths){
    	this.sourceHost = sourceHost;
    	this.destinationHost = destinationHost;
    	this.paths = paths;
    }
    
    public String getSourceHost(){
    	return this.sourceHost;
    }
    
    public String getDestinationHost(){
    	return this.destinationHost;
    }
    
    public List<Path> getPaths(){
    	return this.paths;
    }
}
