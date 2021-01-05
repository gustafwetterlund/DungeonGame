import java.util.Random;
import java.util.Scanner;

public class Room
{
   // Deklaration & Definition av Objekt från klasser.
   private String desc;
   private Weapon sword = new Weapon("Sword","Increases damage by 10", 10);
   private Key key = new Key("Key", "Opens one door");
   private Potion potion = new Potion("Potion","Restores health");
   private Treasure treasure = new Treasure("Treasure","Wins the game");
   private Item item;
   private Door[] doors;
   private Monster monster;
 
   
   // Skapande av våra rum, med dörrar sparade i en 2d array för att avgöra vilken position spelaren är vid.
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
         this.setMonster(new Monster("Random enemy", 10, 80));
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
         this.setMonster(new Monster("The Legendary Dragon!",10,180));
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




   // Getters and Setters
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

   public void setDoors(Door[] doors)
   {
      this.doors = doors;
   }

  
   public Door[] getDoors()
   {
      return doors;
   } 
   
   // Combat-Metod för vanliga monster i room 4, där den skapar & initaliserar objektet "enemy" från Constructor i Monster-klassen.
   public static void startFight(Monster enemy){
      //Kallar efter monsterRandomizer metod för att bestämma ett slumpmässigt namn för MonsterName String.
    enemy.setMonsterName(enemy.monsterRandomizer());
      System.out.printf("Caution!%s appeared with %d HP! and %d damage!\n", enemy.getMonsterName(), enemy.getMonsterHp(),
            enemy.getMonsterDamage());

      // while-loop som är aktiv sålänge både Monstrets & Spelarens HP är över 0.
      while (enemy.getMonsterHp() > 0 && Player.getHealthPoints() > 0)
      {
         System.out.printf("Press: F to attack the %s!", enemy.getMonsterName());
         Scanner input = new Scanner(System.in);
         String val = input.nextLine();

         // switch statement som använder använder spelarens input (String val) som cases.
         switch (val)
         {
      // case "f" är det case där man utför "combat".
         case "f":
            //definition av integers som hämtar slumpmässigt värde mellan 1-100, denna används för en mekanik där både spelaren och monstret har en chans att missa sin attack.
            Random rand = new Random();
            int randInt = rand.nextInt(100) + 1;
            int monsterInt = rand.nextInt(100) + 1;
            // För alla värden som är under eller lika med 80 med vår 1-100 random integer för spelaren (randInt), så kommer spelaren att träffa sin attack.
            if (randInt <= 80)
            {
               // Kallar efter vår monsterTakingDamage-metod i vår Monster-klass.
               enemy.monsterTakingDamage();
               System.out.printf("\nYou dealt %d damage on the enemy: %s,\nEnemy has %d HP left!",
                     Player.getDamage(), enemy.getMonsterName(), enemy.getMonsterHp());
             // För alla värden över 80 så missar spelaren sin attack, och gör därav ingen damage då vår monsterTakingDamage-metod inte kallas.
            } else if (randInt > 80)
            {
               System.out.println("You missed your attack, and dealt no damage!");
            }

            // För alla värden som är under eller lika med 70 med vår 1-100 random integer för Monstret (monsterInt), så kommer Monstret att träffa sin attack.
            if (monsterInt <= 70)
            {
               // Kallar efter vår setter för spelarens HP, där den bestäms med vår getter för player HP minus getter för monster Damage.
               Player.setHealthPoints(Player.getHealthPoints() - enemy.getMonsterDamage() );
               System.out.printf("\n%s hit you for %d, you have %d HP left!", enemy.getMonsterName(),
                     enemy.getMonsterDamage(), Player.getHealthPoints());
            }
               
             // Om random integer för monstret är över 70, så missar monstret sin attack och ingen subtraktion utförs på spelarens HP.
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
      // Om monstrets HP är mindre än 0 och spelarens HP är högre än 0 så avslutas vår while-loop för combat, och text printas med att du vann över monstret.
      if (0 >= enemy.getMonsterHp()  && 0 <= Player.getHealthPoints())
      {
         System.out.printf("You defeated the %s, after a glorious battle!\n", enemy.getMonsterName());

      } else
       // Om while-loop avslutades där istället monstrets HP var över 0 men spelarens HP var mindre eller lika med 0, så printas text att du förlorade och spelet avslutas.
      {
         System.out.println("You died! Game over!");
         DungeonMaster.endGame(false);

      }
   }
  
    // Combat metod för Draken, där den användaren objektet från constructor vid room 8 i dess parameter.
   public static void dragonFight(Monster dragon){ 
      
      System.out.println("You suddenly feel a shiver up your spine, a great creature stirs....");
      System.out.printf("\nYou can see the %s nearing you, this might be your final breath",dragon.getMonsterName());
      System.out.printf("\nThe %s has %d HP and deals %d damage!",dragon.getMonsterName(),dragon.getMonsterHp(),dragon.getMonsterDamage());
       // while-loop som är aktiv sålänge BÅDE player & dragon HP är över 100.
      while(dragon.getMonsterHp() > 0 && Player.getHealthPoints() > 0){

       System.out.printf("\nPress F: to fight for your life against the %s!",dragon.getMonsterName());
       Scanner input = new Scanner(System.in);
       String val = input.nextLine();
       // switch-statement som använder userinput (String val) som parameter.
       
         switch(val){
           case "f":
        // Definition av random integers för drake (monsterInt) och spelare (randInt) som används för vår mekanik för slumpmässig miss vid attack. Värden för denna random är mellan 1-100.      
       Random rand = new Random();
       int randInt = rand.nextInt(100) + 1;
       int monsterInt = rand.nextInt(100) +1;
       // om spelarens random integer (randInt) är under eller lika med 80, så träffar spelaren sin attack.
       if(randInt <= 80){
          //Kallar efter metod där monstret tar den skada som den befintliga playerDamage innehar(int).
             dragon.monsterTakingDamage();
            System.out.printf("You dealt: %d damage! %s has %d HP left!",Player.getDamage(),dragon.getMonsterName(),dragon.getMonsterHp());
           }
          // om spelarens random integer i stället är över 80, så missar spelaren sin attack och ingen skada utförs.
       else if(randInt > 80){
           System.out.println("You missed your attack and dealt no damage!");
       }
       
       //Om drakens random int (monsterInt) är över eller lika med 70, så gör draken skada på spelaren.
       if(monsterInt <= 70 ){
          // Kallar efter vår setter för spelarens HP, där den bestäms med vår getter för player HP minus getter för monster Damage.
          Player.setHealthPoints(Player.getHealthPoints() - dragon.getMonsterDamage() );
         System.out.printf("\n%s Cauterizing Flame dealt %d damage on you!",dragon.getMonsterName(),dragon.getMonsterDamage());
       }
               // Om monster random int i stället är över 70, så gör draken ingen skada på spelaren.
       else if(monsterInt > 70){
           System.out.println("You managed to dodge the dragons fireblast!\n You took no damage! ");
       }
            
             System.out.println("\n*********************************************************************************");
             System.out.printf("\n%s have %d HP left, and you (%s) have %d HP left!",dragon.getMonsterName(),dragon.getMonsterHp()
                   ,Player.getName(),Player.getHealthPoints());
            System.out.println("\n*********************************************************************************");
            break;
           
           
           default: 
           System.out.println("Vänligen försök att skriva igen!");
           continue;
           
       }
     }
      // Om drakens hp är mindre än 0, och spelarens hp är över 0 så printas meddelandet att spelaren vann striden.
      if(0 >= dragon.getMonsterHp() && 0 <= Player.getHealthPoints()){
       System.out.printf("You defeated the %s, after a glorious battle!\n",dragon.getMonsterName());
       
       }
      //om while-loopen istället avslutas där spelaren har 0 hp och draken har över 0 hp, så printas meddelandet att spelaren förlorade och spelet avslutas.
     else{
         System.out.println("You died! Game over!");
         DungeonMaster.endGame(false);
     }
     }
}
