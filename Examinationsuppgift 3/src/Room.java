

public class Room
{
   private int xPos;
   private int yPos;
   private String desc;
   private Weapon sword;
   private Key key;
   private Potion potion;
   private Treasure treasure;
   private Door[] doors = new Door[4];
   private Monster monster;
   private boolean hasItem;
   private boolean hasMonster;
   
   
   public Room(int xPos, int yPos)
   {
      
      //Room1
      if(xPos == 0 && yPos == 0)
      {
         
         this.setDesc("Sword Room");
         this.getDoors()[0] = new Door('x',false);
         this.getDoors()[1] = new Door('e',false);
         this.getDoors()[2] = new Door('n',false);
         this.getDoors()[3] = new Door('x',false);
         this.setSword(new Weapon("Sword","Increases damage by ", false, 1));
         this.setHasItem(true);
      }
     //Room2
      if(xPos == 1 && yPos == 0)
      {
         this.setDesc("Starting Room");
         this.getDoors()[0] = new Door('w',false);
         this.getDoors()[1] = new Door('e',false);
         this.getDoors()[2] = new Door('x',false);
         this.getDoors()[3] = new Door('x',false);
      }   
      //Room3
      if(xPos == 2 && yPos == 0)
      {
         this.setDesc("Right corner Room");
         this.getDoors()[0] = new Door('w',false);
         this.getDoors()[1] = new Door('x',false);
         this.getDoors()[2] = new Door('n',false);
         this.getDoors()[3] = new Door('x',false);
      }
      //Room4
      if(xPos == 0 && yPos == 1)
      {
         this.setDesc("Monster Room");
         this.getDoors()[0] = new Door('x',false);
         this.getDoors()[1] = new Door('e',false);
         this.getDoors()[2] = new Door('n',true);
         this.getDoors()[3] = new Door('s',false);
      }
      //Room5
      if(xPos == 1 && yPos == 1)
      {
         this.setDesc("Middle room");
         this.getDoors()[0] = new Door('w',false);
         this.getDoors()[1] = new Door('e',false);
         this.getDoors()[2] = new Door('n',true);
         this.getDoors()[3] = new Door('x',false);
         this.setPotion(new Potion("Potion","Restores health", true, true));
         this.setHasItem(true);
      }
      //Room6
      if(xPos == 2 && yPos == 1)
      {
         this.setDesc("Right room");
         this.getDoors()[0] = new Door('w',false);
         this.getDoors()[1] = new Door('x',false);
         this.getDoors()[2] = new Door('n',false);
         this.getDoors()[3] = new Door('s',false);
      }
      //Room7
      if(xPos == 0 && yPos == 2)
      {
         this.setDesc("Exit");
         this.getDoors()[0] = new Door('x',false);
         this.getDoors()[1] = new Door('x',false);
         this.getDoors()[2] = new Door('x',false);
         this.getDoors()[3] = new Door('s',false);
      }
      //Room8
      if(xPos == 1 && yPos == 2)
      {
         this.setDesc("Dragon Room");
         this.getDoors()[0] = new Door('x',false);
         this.getDoors()[1] = new Door('x',false);
         this.getDoors()[2] = new Door('x',false);
         this.getDoors()[3] = new Door('s',false);
         this.setTreasure(new Treasure("Treasure","Wins the game", true, true));
         this.setHasItem(true);
      }
      //Room8
      if(xPos == 2 && yPos == 2)
      {
         this.setDesc("Key Room");
         this.getDoors()[0] = new Door('x',false);
         this.getDoors()[1] = new Door('x',false);
         this.getDoors()[2] = new Door('x',false);
         this.getDoors()[3] = new Door('s',false);
         this.setKey(new Key("Key","Opens one door", true, true));
         this.setHasItem(true);
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


   public Weapon getSword()
   {
      return sword;
   }


   public void setSword(Weapon sword)
   {
      this.sword = sword;
   }


   public Key getKey()
   {
      return key;
   }


   public void setKey(Key key)
   {
      this.key = key;
   }


   public Potion getPotion()
   {
      return potion;
   }


   public void setPotion(Potion potion)
   {
      this.potion = potion;
   }


   public Treasure getTreasure()
   {
      return treasure;
   }


   public void setTreasure(Treasure treasure)
   {
      this.treasure = treasure;
   }


   public Monster getMonster()
   {
      return monster;
   }


   public void setMonster(Monster monster)
   {
      this.monster = monster;
   }


   public boolean isHasItem()
   {
      return hasItem;
   }


   public void setHasItem(boolean hasItem)
   {
      this.hasItem = hasItem;
   }


   public boolean isHasMonster()
   {
      return hasMonster;
   }


   public void setHasMonster(boolean hasMonster)
   {
      this.hasMonster = hasMonster;
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


   public Door[] getDoors()
   {
      return doors;
   }


   public void setDoors(Door[] doors)
   {
      this.doors = doors;
   }

  

 
   
   
   
   
}
