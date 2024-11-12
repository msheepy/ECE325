package ece325.labs.lab2;

import java.util.ArrayList;
import java.util.HashMap;

public class EquipmentInventory {

	//Stores list of equipment added to inventory
	ArrayList<Equipment> inventory; 
	//Stores each piece of equipment's name
	//alongside the amount of that piece of equipment in the inventory
	HashMap<String, Integer> inventoryCount; 

	public EquipmentInventory() {
		//When object of type EquuipmentInventory is instantiated
		//Instantiates its corresponding null inventory and inventoryCount
		inventoryCount = new HashMap<>();
		inventory = new ArrayList<>();
	}

	public void add(Equipment e) {
		increaseInventoryCount(e); //adds object to inventoryCount
		//If object isnt already in inventory adds it to inventory
		if(!inventory.contains(e)){
			inventory.add(e);
		}
	}

	//Fix???
	public void remove(Equipment e) {
		//It was easier to modify both inventoryCount and inventory in the same function
		decreaseInventoryCount(e);
	}

	protected void increaseInventoryCount(Equipment e) {
		String name = e.toString();
		//If already in inventory increase associated value
		if(inventoryCount.containsKey(name)){
			inventoryCount.replace(name, inventoryCount.get(name)+1);
		}
		//If not in inventory remove from inventory
		else {
			inventoryCount.put(name, 1);
		}
	}

	protected void decreaseInventoryCount(Equipment e) {
		String name = e.toString();
		//check if item user wishes to remove exists
		if(inventoryCount.containsKey(name)){
			//if only one remove from inventories completely
			if(inventoryCount.get(name) == 1){
				inventory.remove(e);
				inventoryCount.remove(name);
			}
			//if more then one just decrement quantity present
			else{
				inventoryCount.put(name, inventoryCount.get(name)-1);
				//no need to modify inventory
			}
		}
		//If item doesn't exist throws error
		else {
			System.err.println("can't remove an object that doesn't exist");
		}
	}

	//I did not use this function but I could have used it to avoid any potential 
	//errors in my increaseInventory and decreaseInventory functions where I use 
	//inventoryCount.get(). However because these functions already had their own
	//error checks I felt this would make the code unnecessarily complex
	public Integer getInventoryCount(Equipment e) {
		String name = e.toString();
		//If equipment not in inventory throw an error
		if(!inventoryCount.containsKey(name)){
			return -1;
		}
		//Otherwise return amount of equipment
		else {
			return inventoryCount.get(name);
		}
	}
	
	public String toString() {
		String str = "[EquipmentInventory: ";
		for (Equipment equ: inventory){
			String name = equ.toString();
			//adds name of object and its corresponding amount with proper format
			str += name + ": " + inventoryCount.get(name) + ", ";
		}
		//For last item remove unnecessary comma
		str = str.substring(0, str.length() - 2);
		str += "]";
		return str;
	}

	public static void main(String[] args) {
		EquipmentInventory inventory = new EquipmentInventory();
		//Define an object of each typw
        Keyboard piano = new Keyboard();
        Guitar guitar = new Guitar();
        Stool stool = new Stool();
        Chair chair = new Chair();
		//Test adding objects
        inventory.add(guitar);
        inventory.add(guitar);
        inventory.add(guitar);
        inventory.add(stool);
        inventory.add(stool);
        inventory.add(stool);
        inventory.add(chair);
        inventory.add(piano);
        inventory.add(piano);
		//Show results
        System.out.println(inventory);
		//Test removing objects
        inventory.remove(piano);
        inventory.remove(stool);
		//Show results
        System.out.println(inventory);
	}
}
