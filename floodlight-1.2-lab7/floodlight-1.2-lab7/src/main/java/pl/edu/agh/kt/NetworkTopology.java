package pl.edu.agh.kt;

import java.util.List;
import java.util.ArrayList;

public final class NetworkTopology {
	
	private static volatile NetworkTopology networkTopology;
	private Demand h0ToH1;
	private Demand h1ToH0;
	private Demand h0ToH2;
	private Demand h2ToH0;
	private Demand h1ToH2;
	private Demand h2ToH1;
    
	
	private NetworkTopology(){

		createH0ToH1();
		createH1ToH0();
		createH0ToH2();
		createH2ToH0();
		createH1ToH2();
		createH2ToH1();
	}
	
	public static NetworkTopology getInstance(){
		
		NetworkTopology result = networkTopology;
		if(result != null){
			return result;
		}
		
		synchronized(NetworkTopology.class){
			if(networkTopology == null){
				networkTopology = new NetworkTopology();
			}
			return networkTopology;
		}
	}
	
	public List<Demand> getDemands(){
		ArrayList<Demand> demands = new ArrayList<Demand>();
		
		demands.add(this.h0ToH1);
		demands.add(this.h1ToH0);
		demands.add(this.h0ToH2);
		demands.add(this.h2ToH0);
		demands.add(this.h1ToH2);
		demands.add(this.h2ToH1);
		
		return demands;
	}
	
	private void createH0ToH1(){
		ArrayList<Link> links = new ArrayList<Link>();
		ArrayList<Path> paths = new ArrayList<Path>();
		
		links.add(new Link("h0-eth0", "swac0-eth1", false));
		links.add(new Link("swac0-eth2", "swag0-eth1", false));
		links.add(new Link("swag0-eth2", "swac1-eth2", false));
		links.add(new Link("swac1-eth1", "h1-eth0", false));
		paths.add(new Path("h0", "h1", new ArrayList<Link>(links), true));
		links.clear();
		
		links.add(new Link("h0-eth0", "swac0-eth1", false));
		links.add(new Link("swac0-eth2", "swag1-eth1", false));
		links.add(new Link("swag1-eth2", "swac1-eth3", false));
		links.add(new Link("swac1-eth1", "h1-eth0", false));
		paths.add(new Path("h0", "h1", new ArrayList<Link>(links), false));
        links.clear();
		
		links.add(new Link("h0-eth0", "swac0-eth1", false));
		links.add(new Link("swac0-eth2", "swag0-eth1", false));
		links.add(new Link("swag0-eth4", "swc1-eth1", false));
		links.add(new Link("swc1-eth2", "swag1-eth4", false));
		links.add(new Link("swag1-eth2", "swac1-eth3", false));
		links.add(new Link("swac1-eth1", "h1-eth0", false));
		paths.add(new Path("h0", "h1", new ArrayList<Link>(links), false));
		
		this.h0ToH1 = new Demand("h0", "h1", paths);
	}
	
	private void createH1ToH0(){
		ArrayList<Link> links = new ArrayList<Link>();
		ArrayList<Path> paths = new ArrayList<Path>();
		
		links.add(new Link("h1-eth0", "swac1-eth1", false));
		links.add(new Link("swac1-eth2", "swag0-eth2", false));
		links.add(new Link("swag0-eth1", "swac0-eth2", false));
		links.add(new Link("swac0-eth1", "h0-eth0", false));
		paths.add(new Path("h1", "h0", new ArrayList<Link>(links), true));
		links.clear();
		
		links.add(new Link("h1-eth0", "swac1-eth1", false));
		links.add(new Link("swac1-eth3", "swag1-eth2", false));
		links.add(new Link("swag1-eth1", "swac0-eth2", false));
		links.add(new Link("swac0-eth1", "h0-eth0", false));
		paths.add(new Path("h1", "h0", new ArrayList<Link>(links), false));
        links.clear();
		
        links.add(new Link("h1-eth0", "swac1-eth1", false));
        links.add(new Link("swac1-eth3", "swag1-eth2", false));
        links.add(new Link("swag1-eth4", "swc1-eth2", false));
        links.add(new Link("swc1-eth1", "swag0-eth4", false));
        links.add(new Link("swag0-eth1", "swac0-eth2", false));
		links.add(new Link("swac0-eth1", "h0-eth0", false));
		paths.add(new Path("h1", "h0", new ArrayList<Link>(links), false));
		
		this.h1ToH0 = new Demand("h1", "h0", paths);
	}
	
	private void createH0ToH2(){
		ArrayList<Link> links = new ArrayList<Link>();
		ArrayList<Path> paths = new ArrayList<Path>();
		
		links.add(new Link("h0-eth0", "swac0-eth1", false));
		links.add(new Link("swac0-eth2", "swag0-eth1", false));
		links.add(new Link("swag0-eth2", "swac1-eth2", false));
		links.add(new Link("swac1-eth3", "swag1-eth2", false));
		links.add(new Link("swag1-eth3", "swac2-eth3", false));
		links.add(new Link("swac2-eth1", "h2-eth0", false));
		paths.add(new Path("h0", "h2", new ArrayList<Link>(links), true));
		links.clear();
		
		links.add(new Link("h0-eth0", "swac0-eth1", false));
		links.add(new Link("swac0-eth2", "swag1-eth1", false));
		links.add(new Link("swag1-eth3", "swac2-eth3", false));
		links.add(new Link("swac2-eth1", "h2-eth0", false));
		paths.add(new Path("h0", "h2", new ArrayList<Link>(links), false));
        links.clear();
		
		links.add(new Link("h0-eth0", "swac0-eth1", false));
		links.add(new Link("swac0-eth2", "swag0-eth1", false));
		links.add(new Link("swag0-eth4", "swc1-eth1", false));
		links.add(new Link("swc1-eth2", "swag1-eth4", false));
		links.add(new Link("swag1-eth3", "swac2-eth3", false));
		links.add(new Link("swac2-eth1", "h2-eth0", false));
		paths.add(new Path("h0", "h2", new ArrayList<Link>(links), true));
		
		this.h0ToH2 = new Demand("h0", "h2", paths);
	}
	
	private void createH2ToH0(){
		ArrayList<Link> links = new ArrayList<Link>();
		ArrayList<Path> paths = new ArrayList<Path>();
		
		links.add(new Link("h2-eth0", "swac2-eth1", false));
		links.add(new Link("swac2-eth3", "swag1-eth3", false));
		links.add(new Link("swac2-eth3", "swag1-eth3", false));
		links.add(new Link("swag1-eth2", "swac1-eth3", false));
		links.add(new Link("swac1-eth2", "swag0-eth2", false));
		links.add(new Link("swag0-eth1", "swac0-eth2", false));
		links.add(new Link("swac0-eth1", "h0-eth0", false));
		paths.add(new Path("h2", "h0", new ArrayList<Link>(links), true));
		links.clear();
		
		links.add(new Link("h2-eth0", "swac2-eth1", false));
		links.add(new Link("swac2-eth3", "swag1-eth3", false));
		links.add(new Link("swag1-eth1", "swac0-eth2", false));
		links.add(new Link("swac0-eth1", "h0-eth0", false));
		paths.add(new Path("h2", "h0", new ArrayList<Link>(links), false));
        links.clear();
		
        links.add(new Link("h2-eth0", "swac2-eth1", false));
        links.add(new Link("swac2-eth3", "swag1-eth3", false));
        links.add(new Link("swag1-eth4", "swc1-eth2", false));
        links.add(new Link("swc1-eth1", "swag0-eth4", false));
        links.add(new Link("swag0-eth1", "swac0-eth2", false));
		links.add(new Link("swac0-eth1", "h0-eth0", false));
		paths.add(new Path("h2", "h0", new ArrayList<Link>(links), true));
		
		this.h2ToH0 = new Demand("h2", "h0", paths);
	}
	
	private void createH1ToH2(){
		ArrayList<Link> links = new ArrayList<Link>();
		ArrayList<Path> paths = new ArrayList<Path>();
		
		links.add(new Link("h1-eth0", "swac1-eth1", false));
		links.add(new Link("swac1-eth3", "swag1-eth2", false));
		links.add(new Link("swag1-eth3", "swac2-eth3", false));
		links.add(new Link("swac2-eth1", "h2-eth0", false));
		paths.add(new Path("h1", "h2", new ArrayList<Link>(links), true));
		links.clear();
		
		links.add(new Link("h1-eth0", "swac1-eth1", false));
		links.add(new Link("swac1-eth2", "swag0-eth2", false));
		links.add(new Link("swag0-eth3", "swac2-eth2", false));
		links.add(new Link("swac2-eth1", "h2-eth0", false));
		paths.add(new Path("h1", "h2", new ArrayList<Link>(links), false));
        links.clear();
		
        links.add(new Link("h1-eth0", "swac1-eth1", false));
		links.add(new Link("swac1-eth2", "swag0-eth2", false));
		links.add(new Link("swag0-eth4", "swc1-eth1", false));
		links.add(new Link("swc1-eth2", "swag1-eth4", false));
		links.add(new Link("swag1-eth3", "swac2-eth3", false));
		links.add(new Link("swac2-eth1", "h2-eth0", false));
		paths.add(new Path("h1", "h2", new ArrayList<Link>(links), false));
		
		this.h1ToH2 = new Demand("h1", "h2", paths);
	}
	
	private void createH2ToH1(){
		ArrayList<Link> links = new ArrayList<Link>();
		ArrayList<Path> paths = new ArrayList<Path>();
		
		links.add(new Link("h2-eth0", "swac2-eth1", false));
		links.add(new Link("swac2-eth3", "swag1-eth3", false));
		links.add(new Link("swag1-eth2", "swac1-eth3", false));
		links.add(new Link("swac1-eth1", "h1-eth0", false));
		paths.add(new Path("h2", "h1", new ArrayList<Link>(links), true));
		links.clear();
		
		links.add(new Link("h2-eth0", "swac2-eth1", false));
		links.add(new Link("swac2-eth2", "swag0-eth3", false));
		links.add(new Link("swag0-eth2", "swac1-eth2", false));
		links.add(new Link("swac1-eth1", "h1-eth0", false));
		paths.add(new Path("h2", "h1", new ArrayList<Link>(links), false));
        links.clear();
		
        links.add(new Link("h2-eth0", "swac2-eth1", false));
        links.add(new Link("swac2-eth3", "swag1-eth3", false));
        links.add(new Link("swag1-eth4", "swc1-eth2", false));
        links.add(new Link("swc1-eth1", "swag0-eth4", false));
        links.add(new Link("swag0-eth2", "swac1-eth2", false));
        links.add(new Link("swac1-eth1", "h1-eth0", false));
		paths.add(new Path("h2", "h1", new ArrayList<Link>(links), false));
		
		this.h2ToH1 = new Demand("h2", "h1", paths);
	}
}



/*
 * 
 * Phisical topology - the device names match the name in the mininet script
 * https://github.com/Infam852/sdn-project/blob/main/topo.py?fbclid=IwAR1BiwblXc5JlRC5icfiWOAkFRGGmOPv4WrRzCdSxEU13TA3cyu-CX2Qq6A
 * 
 * 
 *         swc1
 *       
 *     swag0   swag1
 *         
 * swac0  swac1   swac2
 *                
 *  h0      h1      h2        
 */




