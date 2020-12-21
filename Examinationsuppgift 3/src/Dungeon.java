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

      System.out.println("Welcome " + player.getName() + " to your treasure hunt. beware of the dragon!");

      while (true)
      {
         String playerInput;
         boolean north = false;
         boolean south = false;
         boolean west = false;
         boolean east = false;
         
         Item[] inventory = player.getInventory();
         

         for (int i = 0; i < 4; i++)
         {
            Door[] doors = currentRoom.getDoors();
            if (doors[i].getPosition() == 'w')
            {
               west = true;
            } else if (doors[i].getPosition() == 'e')
            {
               east = true;
            } else if (doors[i].getPosition() == 's')
            {
               south = true;
            } else if (doors[i].getPosition() == 'n')
            {
               north = true;
            }
         }
         
         player.displayInventory(inventory);
         AsciiArt.displayRoom(north, south, west, east);

         boolean validInput = false;
         while (!validInput)
         {

            if (currentRoom.isHasItem())
            {
               System.out.println("you found an item!");
               
               

               System.out.println("Do you want to pick up item? [p]");
            }

            System.out.print("Choose an action: ");
            
            playerInput = userInput.nextLine();

            if (playerInput.equalsIgnoreCase("n") && north || playerInput.equalsIgnoreCase("s") && south)
            {
               py = updatePosition(py, playerInput);
               validInput = true;
            } else if (playerInput.equalsIgnoreCase("w") && west || playerInput.equalsIgnoreCase("e") && east)
            {
               px = updatePosition(px, playerInput);
               validInput = true;
            } else if (playerInput.equalsIgnoreCase("p") && currentRoom.isHasItem())
            {
               System.out.println("Picked up Item");
               
               player.addItem(currentRoom.getSword());
               player.addItem(currentRoom.getKey());
               player.addItem(currentRoom.getTreasure());
               player.addItem(currentRoom.getPotion());
               currentRoom.setHasItem(false);
               validInput = true;
            }
            else
            {
               System.out.println("Invalid input, try again!");
            }
         }
         currentRoom = rooms[px][py];
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
