# Item System Development Task
## How to run
The project is possible to open via "Eclipse IDE for Java Developers 2024-12". In the workspace, select import -> Existing Projects into Workspace -> Select root directory (select the folder with this project) -> Finish
This project is a console applicationa and can be ran with  Run -> Run (ctrl+F11).

## What it does
It will bring up a grid with randomly generated items which are stored within an instance of Inventory class. The main field of it is a HashMap consisting of ( Item, Amount ) key/value pairs where an Item is an instace of the Item class, consisting of Name, Rarity, upgradeCountEpic for the Epic rarity types.
After that it will ask to type an Action (case sensitive): Add for adding another item to the inventory, Upgrade for upgrading an item, Show for displaying the current state of the inventory. It will further instruct the user after each commend on what to do.
Not that this project is a prototype and more functionality is to be added in the future. 
