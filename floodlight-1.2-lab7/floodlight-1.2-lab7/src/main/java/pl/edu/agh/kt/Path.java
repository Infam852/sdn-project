package pl.edu.agh.kt;

import java.util.Iterator;
import java.util.List;

public class Path {
	private String sourceNode;
	private String destinationNode;
	private List<Link> links;
	private boolean isCongested;
	private boolean isPrimary;
	
	public Path(String sourceNode, String destiniationNode, List<Link> links, boolean isPrimary){
		this.sourceNode = sourceNode;
		this.destinationNode = destiniationNode;
		this.links = links;
		this.isPrimary = isPrimary;
		
		checkCongestion();
	}
	
	public String getStartingNode(){
		return this.sourceNode;
	}
	
	public String getDestinationNode(){
		return this.destinationNode;
	}
	
	public List<Link> getLinks(){
		return this.links;
	}
	
	public boolean getisCongested(){
		checkCongestion();
		return this.isCongested;
	}
	
	public boolean getIsPrimary(){
		return this.isPrimary;
	}
	
	public void checkCongestion(){
		Iterator<Link> linkIterator = this.links.iterator();
		while(linkIterator.hasNext()){
			if(linkIterator.next().getIsCongested()){
				this.isCongested = true;
				break;
			}
		}
	}
}
