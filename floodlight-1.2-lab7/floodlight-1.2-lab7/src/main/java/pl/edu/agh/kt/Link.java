package pl.edu.agh.kt;

public class Link {
	
    private String firstNode;
    private String secondNode;
    private boolean isCongested;
    
    public Link(String firstNode, String secondNode){
    	this.firstNode = firstNode;
    	this.secondNode = secondNode;
        this.isCongested = false;
    }
    
    public Link(String firstNode, String secondNode, boolean isCongested){
    	this.firstNode = firstNode;
    	this.secondNode = secondNode;
        this.isCongested = isCongested;
    }
    
    public void setIsCongested(boolean isCongested){
    	this.isCongested = isCongested;
    }
    
    public boolean getIsCongested(){
    	return this.isCongested;
    }
    
    public String getFirstNode(){
    	return this.firstNode;
    }
    
    public String getSecondNode(){
    	return this.secondNode;
    }
    
}
