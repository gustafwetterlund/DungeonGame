import java.util.Scanner;

public class Dungeon
{

   private static Room[][] rooms;
   private static Player player;

   public Dungeon(int dungeonSize, Player player)
   {
      rooms = new Room[dungeonSize][dungeonSize];
      Dungeon.player = player;

      for (int i = 0; i < dungeonSize; i++)
      {
         for (int j = 0; j < dungeonSize; j++)
         {
            rooms[i][j] = new Room(i, j);
         }
      }
   }

   public static void playGame()
   {

      // starting position
      int px = 1;
      int py = 0;
      Room currentRoom = rooms[px][py];

      @SuppressWarnings("resource")
      Scanner userInput = new Scanner(System.in);

      System.out.println("Welcome " + Player.getName() + " to your treasure hunt. beware of the dragon!");

      while (true)
      {

         String playerInput;
         boolean north = false;
         boolean south = false;
         boolean west = false;
         boolean east = false;
         boolean northLocked = false;
         boolean southLocked = false;
         boolean westLocked = false;
         boolean eastLocked = false;

         Item[] inventory = player.getInventory();
         boolean playerHasPotion = false;
         boolean playerHasKey = false;
         boolean playerHasTreasure = false;
         Door[] doors = currentRoom.getDoors();

         // checks for doors in current room
         for (int i = 0; i < doors.length; i++)
         {
            if (doors[i].getPosition() == "w")
            {
               if (doors[i].isLocked())
                  westLocked = true;
               west = true;
            } else if (doors[i].getPosition() == "e")
            {
               if (doors[i].isLocked())
                  eastLocked = true;
               east = true;
            } else if (doors[i].getPosition() == "s")
            {
               if (doors[i].isLocked())
                  southLocked = true;
               south = true;
            } else if (doors[i].getPosition() == "n")
            {
               if (doors[i].isLocked())
                  northLocked = true;
               north = true;
            }
         }
         
         if(px == 0 && py == 2)
         {
            AsciiArt.displayOutside();
         }
         else
         {
            player.displayInventory(inventory);
            AsciiArt.displayRoom(north, south, west, east);
         }


         // checks for items in current room
         if (currentRoom.getItem() != null && !currentRoom.getItem().getName().equals("Treasure"))
         {
            System.out.println("you found an item!");
            System.out.println(currentRoom.getItem().getName());
            System.out.println(currentRoom.getItem().getDesc());
            System.out.println("Do you want to pick up item? [p]");
         }

         // checks for monsters in current room
         if (currentRoom.getMonster() != null)
         {
            if(currentRoom.getMonster().getMonsterName().equals("The Legendary Dragon!"))
            {
               AsciiArt.displayDragon();
               Room.dragonFight(currentRoom.getMonster());
               currentRoom.setMonster(null);
               System.out.println("You found the dragons treasure! Now you can exit the cave!");
               player.addItem(currentRoom.getItem());
               currentRoom.setItem(null); 
            }
            else
            {
               Room.startFight(currentRoom.getMonster());
               currentRoom.setMonster(null);
            }
            
            player.displayInventory(inventory);
            AsciiArt.displayRoom(north, south, west, east);
         }
         
       

         // input
         boolean validInput = false;
         while (!validInput)
         {

            // checks what items player has in inventory
            for (int i = 0; i < player.getInventory().length; i++)
            {
               if (player.getInventory()[i] != null)
               {
                  if (player.getInventory()[i].getName() == "Potion")
                     playerHasPotion = true;
                  else if (player.getInventory()[i].getName() == "Key")
                     playerHasKey = true;
                  else if (player.getInventory()[i].getName() == "Treasure")
                     playerHasTreasure = true;
               }

            }
            
            if(px == 0 && py == 2)
            {
               if(playerHasTreasure)
               {
                  DungeonMaster.endGame(true); 
               }
               else
               {
                  System.out.println("You found the exit! Retrieve the treasure before you escape. \n"
                        + "Press [s] to go back into the cave");
               }
            }

            if (playerHasPotion)
               System.out.println("Press [h] to use potion");

            System.out.print("Choose an action: ");

            playerInput = userInput.nextLine();

            if (playerInput.equalsIgnoreCase("n") && north || playerInput.equalsIgnoreCase("s") && south)
            {
               if (playerInput.equalsIgnoreCase("n") && northLocked || playerInput.equalsIgnoreCase("s") && southLocked)
               {
                  if (playerHasKey)
                  {
                     System.out.println("Used key and unlocked door");
                     doors = Door.unlockDoor(doors, playerInput);
                     currentRoom.setDoors(doors);
                     player.removeItem("Key");
                     validInput = true;

                  } else
                  {

                     System.out.println("Door is locked!");
                     validInput = true;
                  }
               } else
               {
                  py = updatePosition(py, playerInput);
                  validInput = true;
               }

            } else if (playerInput.equalsIgnoreCase("w") && west || playerInput.equalsIgnoreCase("e") && east)
            {
               if (playerInput.equalsIgnoreCase("w") && westLocked || playerInput.equalsIgnoreCase("e") && eastLocked)
               {
                  if (playerHasKey)
                  {
                     System.out.println("Used key and unlocked door");
                     doors = Door.unlockDoor(doors, playerInput);
                     currentRoom.setDoors(doors);
                     player.removeItem("Key");
                     validInput = true;

                  } else
                  {

                     System.out.println("Door is locked!");
                     validInput = true;
                  }
               } else
               {
                  px = updatePosition(px, playerInput);
                  validInput = true;
               }
            } else if (playerInput.equalsIgnoreCase("p") && currentRoom.getItem() != null)
            {
               System.out.println("Picked up Item");

               player.addItem(currentRoom.getItem());
               currentRoom.setItem(null);
               validInput = true;
            } else if (playerInput.equalsIgnoreCase("h") && playerHasPotion)
            {
               Player.setHealthPoints(100);
               System.out.println("Your health is fully restored!");
               player.removeItem("Potion");
               validInput = true;
            }

            else
            {
               System.out.println("Invalid input, try again!");
            }
         }

         // updates currentRoom to the next room
         currentRoom = rooms[px][py];
         System.out.println("------------------------------");
      }

   }

   static int updatePosition(int position, String direction)
   {
      if (direction.equalsIgnoreCase("n") || direction.equalsIgnoreCase("e"))
      {
         position++;
      } else if (direction.equalsIgnoreCase("s") || direction.equalsIgnoreCase("w"))
      {
         position--;
      }
      return position;
   }

}
