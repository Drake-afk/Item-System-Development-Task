import java.util.ArrayList;
import java.util.Random;
import java.util.*;
import java.util.Scanner;


public class ItemSystemTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventory curInventory = new Inventory();
		curInventory.ShowInventory();
		
		//curInventory.addItem(new Item ("Moonbow","Common"));
		//inventory.ShowInventory();
		//System.out.println("Contains Moonbow Common?: " + curInventory.getInventory().containsKey(new Item("Moonbow","Common")));
		//curInventory.addItem(new Item ("Moonbow","Common"));
		//curInventory.ShowInventory();
		//
		for(int i  = 0; i < 10; i++) {
			actionRequest(curInventory);
		}
	}
	
	public static void actionRequest(Inventory inventory) 	{
		System.out.println("Type an Action: Add - ADD ITEM, Upgrade - Upgrade Item, 'Show' - Show current inventory");
		
		Scanner scanObj = new Scanner(System.in);
		String action = scanObj.nextLine();
		String typedName;
		String typedRarity;
		Item targetItem;
		
		switch (action) {
		
		case "Upgrade":
			
			System.out.println("What item do you wish Upgrade?");
			typedName = scanObj.nextLine().trim();
			System.out.println("What rarity is it?");
			typedRarity = scanObj.nextLine().trim();
			
			targetItem = new Item(typedName, typedRarity);
			targetItem.displayItem();
			//int amount = inventory.getInventory().get(targetItem);
			
			if (inventory.getInventory().containsKey(targetItem)) {
				System.out.println("There are " + inventory.getInventory().get(targetItem) + " of " 
						+ typedRarity + " " + typedName);
				
				if (isUpgradable(targetItem, inventory.getInventory().get(targetItem), inventory))  {
					
					System.out.println("You have sufficient items to upgrade current item. Do you want to proceed? (Y / N)");
					
					switch (scanObj.nextLine()) {
					case ("Y"):
						inventory.addItem(new Item (typedName, nextRarity(targetItem.getRarity())));
						int amount = 0;
						if (typedRarity == "Common" ||
								typedRarity == "Great" ||
								typedRarity == "Rare" ||
								typedRarity == "Epic 2") {
							amount = 3;
							inventory.removeItem(targetItem, amount);
						}
						else if (typedRarity == "Epic" ||
									typedRarity == "Epic 1") {
							//COME BACK TO THIS
						}
						
					case ("N"):
						System.out.println();
						return;
					default:
						
					}
				}
				else {
					System.out.println("You don't have sufficient items to upgrade current item");
					return;
				}
				
			} else {
				System.out.println("There are no such items!");
				System.out.println();
				return;
			}
			
		case "Add":
			
			
			System.out.println("What item do you wish Add?");
			typedName = scanObj.nextLine().trim();
			System.out.println("What rarity is it?");
			typedRarity = scanObj.nextLine().trim();
			System.out.println("How much?");
			int typedAmount = scanObj.nextInt();
			
			targetItem = new Item(typedName, typedRarity);
			inventory.addItem(targetItem, typedAmount);
			
			System.out.println("Added Succesfully!");
			System.out.println();
			
			break;
			
		case "Show":
			inventory.ShowInventory();
		default:
		}
		
		//Commands : Upgrade, Add, Show
	}
	
	public static boolean isUpgradable(Item item, Integer amount, Inventory inventory) {
		int epicCount = 0;
		switch (item.getRarity()) {
		case ("Common"):
			if (amount >= 3) {
				return true;
			}
		case ("Great"):
			if (amount >= 3) {
				return true;
			}
		case ("Rare"):
			if (amount >= 3) {
				return true;
			}
		case ("Epic"):
			epicCount = amount;
			for (Item i : inventory.getInventory().keySet()) {
				if (i != item && i.getRarity() == "Epic") {
						epicCount += inventory.getInventory().get(i);
				}
			}
			if (epicCount >= 2) {
				return true;
			}
		case ("Epic 1"):
			epicCount = amount;
			for (Item i : inventory.getInventory().keySet()) {
				if (i != item && i.getRarity() == "Epic") {
						epicCount += inventory.getInventory().get(i);
				}
			}	
			if (epicCount >= 2) {
				return true;
			}
		case ("Epic 2"):
			if (amount >= 3) {
				return true;
			}
		default:
			return false;
		}
	}
	
	static String nextRarity(String rarity) {
		String[] rars = Item.rarities;
		for ( int i = 0; i < rars.length; i++)
		{
			if (rars[i] == rarity && rarity != "Legendary") {
				return rars[i+1].toString();
			}
		}
		return rars[rars.length-1];
	}
	
	

}
