import java.util.Scanner;

public class DungeonMaster
{
   //dungeon attributes
   private final static int DUNGEON_SIZE = 3;
   

   //player attributes
   private static  String playerName;
   private static int playerHp = 100;
   private static int playerDmg = 10;
   private static Item[] inventory = new Item[4];
   
   
   private static Scanner userInput = new Scanner(System.in);

   public static void main(String[] args)
   {
      
      
      AsciiArt.startScreen();
      playerName = userInput.nextLine();
      
      
      startGame();
      Dungeon.playGame();
   }

   public static void startGame()
   {
      new Dungeon(DUNGEON_SIZE, new Player(playerName, playerHp, playerDmg, inventory));
      
      
     
   }

   public static void endGame()
   {
   }

}
