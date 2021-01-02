import java.util.Random;
import java.util.Scanner;

public class Room
{
   private int xPos;
   private int yPos;
   private String desc;
   private Weapon sword = new Weapon("Sword","Increases damage by 10", false, 10);
   private Key key = new Key("Key","Opens one door", true, true);
   private Potion potion = new Potion("Potion","Restores health", true, true);
   private Treasure treasure = new Treasure("Treasure","Wins the game", false, true);
   private Item item;
   private Door[] doors;
   private Monster monster;
 
   
   
   public Room(int xPos, int yPos)
   {

      
      
      //Room1
      if(xPos == 0 && yPos == 0)
      {
         
         this.setDesc("Sword Room");
         this.setDoors(new Door[2]);
         this.getDoors()[0] = new Door("e",false);
         this.getDoors()[1] = new Door("n",false);
         this.setItem(sword);
       
      }
     //Room2
      if(xPos == 1 && yPos == 0)
      {
         this.setDoors(new Door[2]);
         this.setDesc("Starting Room");
         this.getDoors()[0] = new Door("w",false);
         this.getDoors()[1] = new Door("e",false);
      }   
      //Room3
      if(xPos == 2 && yPos == 0)
      {
         this.setDoors(new Door[2]);
         this.setDesc("Right corner Room");
         this.getDoors()[0] = new Door("w",false);
         this.getDoors()[1] = new Door("n",false);
      }
      //Room4
      if(xPos == 0 && yPos == 1)
      {
         this.setDoors(new Door[3]);
         this.setDesc("Monster Room");
         this.getDoors()[0] = new Door("e",false);
         this.getDoors()[1] = new Door("n",false);
         this.getDoors()[2] = new Door("s",false);
         this.setMonster(new Monster("Varulven", 1 , 10));
      }
      //Room5
      if(xPos == 1 && yPos == 1)
      {
         this.setDoors(new Door[3]);
         this.setDesc("Middle room");
         this.getDoors()[0] = new Door("w",false);
         this.getDoors()[1] = new Door("e",false);
         this.getDoors()[2] = new Door("n",true);
         this.setItem(potion);
      }
      //Room6
      if(xPos == 2 && yPos == 1)
      {
         this.setDoors(new Door[3]);
         this.setDesc("Right room");
         this.getDoors()[0] = new Door("w",false);
         this.getDoors()[1] = new Door("n",false);
         this.getDoors()[2] = new Door("s",false);
      }
      //Room7
      if(xPos == 0 && yPos == 2)
      {
         this.setDoors(new Door[1]);
         this.setDesc("Exit");
         this.getDoors()[0] = new Door("s",false);
      }
      //Room8
      if(xPos == 1 && yPos == 2)
      {
         this.setDoors(new Door[1]);
         this.setDesc("Dragon Room");
         this.getDoors()[0] = new Door("s",false);
         this.setItem(treasure);
      }
      //Room8
      if(xPos == 2 && yPos == 2)
      {
         this.setDoors(new Door[1]);
         this.setDesc("Key Room");
         this.getDoors()[0] = new Door("s",false);
         this.setItem(key);
      }
   }





   public String getDesc()
   {
      return desc;
   }


   public void setDesc(String desc)
   {
      this.desc = desc;
   }

   public Monster getMonster()
   {
      return monster;
   }


   public void setMonster(Monster monster)
   {
      this.monster = monster;
   }


   public void setItem(Item item)
   {
      this.item = item;
   }
   
   
   public Item getItem()
   {
     return item;  
   }



   public int getyPos()
   {
      return yPos;
   }


   public void setyPos(int yPos)
   {
      this.yPos = yPos;
   }


   public int getxPos()
   {
      return xPos;
   }


   public void setxPos(int xPos)
   {
      this.xPos = xPos;
   }




   public void setDoors(Door[] doors)
   {
      this.doors = doors;
   }

  
   public Door[] getDoors()
   {
      return doors;
   } 
   
   public static void startFight(){
      Monster enemy = new Monster(null, 10, 80);
      enemy.setMonsterName(enemy.monsterRandomizer());
      System.out.printf("Caution!%s appeared with %d HP! and %d damage!\n", enemy.getMonsterName(), enemy.getMonsterHp(),
            enemy.getMonsterDamage());

      while (enemy.getMonsterHp() > 0 && Player.getHealthPoints() > 0)
      {
         System.out.printf("Press: F to attack the %s!", enemy.getMonsterName());
         Scanner input = new Scanner(System.in);
         String val = input.nextLine();

         switch (val)
         {

         case "f":
            Random rand = new Random();
            int randInt = rand.nextInt(100) + 1;
            int monsterInt = rand.nextInt(100) + 1;
            if (randInt <= 80)
            {
               enemy.monsterTakingDamage();
               System.out.printf("\nYou dealt %d damage on the enemy: %s,\nEnemy has %d HP left!",
                     Player.getDamage(), enemy.getMonsterName(), enemy.getMonsterHp());
            } else if (randInt > 80)
            {
               System.out.println("You missed your attack, and dealt no damage!");
            }

            if (monsterInt <= 70)
            {
               Player.setHealthPoints(Player.getHealthPoints() - enemy.getMonsterDamage() );
               System.out.printf("\n%s hit you for %d, you have %d HP left!", enemy.getMonsterName(),
                     enemy.getMonsterDamage(), Player.getHealthPoints());
            }

            else if (monsterInt > 70)
            {
               System.out.printf("\n%s missed their attack on you and dealt no damage!", enemy.getMonsterName());
            }

            System.out.printf("\nThe %s have %d HP left, and you (%s) have %d HP left!", enemy.getMonsterName(),
                  enemy.getMonsterHp(), Player.getName(), Player.getHealthPoints());
            System.out.println("\n*********************************************************************************");
            break;

         default:
            System.out.println("Unknown input registred, please try again!");
            continue;

         }
         

      }
      if (0 >= enemy.getMonsterHp())
      {
         System.out.printf("You defeated the %s, after a glorious battle!\n", enemy.getMonsterName());

      } else
      {
         System.out.println("You died! Game over!");

      }
   }
}
