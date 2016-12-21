package allen.chen;

import java.util.HashMap;

public class myCart {
	private String name ;
	private HashMap<String,Integer> addName;
	
	public myCart(String name){
		this.name = name;
		addName = new HashMap<>();
	}
	public HashMap<String,Integer> getMap(){
		return addName ;
	}
	public void addMap(String name , Integer num){
		addName.put(name, num);
	}
	
}
