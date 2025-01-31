import java.util.HashMap;
import java.util.Random;

class Inventory{
	
	private static HashMap<Item, Integer> inventory;
	
	Inventory(){
		GenerateItems();
		Random random = new Random();
		int count = random.nextInt(6, 9);
		while (inventory.size() < count) {
            String randomName = Item.names[random.nextInt(Item.names.length)];
            String randomRarity = Item.rarities[random.nextInt(Item.rarities.length)];
            //inventory.add(new Item(randomName, randomRarity, random.nextInt(1,5)));
            inventory.put(new Item(randomName, randomRarity), random.nextInt(1,5));
        }
		
	}
	public void ShowInventory() {
		System.out.println("Current Inventory:");
		System.out.printf("%-15s || %-10s || %-3s %n", "Name",  "Rarity", "Amount");
		System.out.println("------------");
		inventory.forEach( (item, amount) -> { 
			System.out.printf("%-15s || %-10s || %-3s %n", item.getName(),  item.getRarity(), amount); 
			} );
		System.out.println();
	}
	
	public void addItem (Item newItem)
	{
		if (inventory.containsKey(newItem)) {			
				inventory.put(newItem, inventory.get(newItem)+1);
		}
		else inventory.put(newItem, 1);
	}
	
	public void addItem (Item newItem, int amount)
	{
		if (inventory.containsKey(newItem)) {			
				inventory.put(newItem, inventory.get(newItem)+amount);
		}
		else inventory.put(newItem, amount);
	}
	
	public void removeItem (Item newItem, int amount)
	{
		if (inventory.containsKey(newItem)) {			
				inventory.put(newItem, inventory.get(newItem)-amount);
				if (inventory.get(newItem) <= 0) {
					inventory.remove(newItem);
				}
		}
		else {
			System.out.println("Trying to remove non-existent item");
		}
		return;
	}
	
	private void GenerateItems(){
		inventory = new HashMap<Item, Integer>();
		
	}
	
	public HashMap<Item, Integer> getInventory() {
		return inventory;
	}
	
	/*Item itemToModify = null;
	int oldAmount = 0;
	for ( Item i: inventory.keySet()) {
		if (i == newItem) {
			itemToModify = i;
			oldAmount = i.amount;
			break;
		}
	if (itemToModify != null) {
		inventory.remove(itemToModify);
		inventory.add(new Item (newItem.getName(), newItem.getRarity(), oldAmount+1));
		}*/
	
	
}