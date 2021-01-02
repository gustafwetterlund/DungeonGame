
public class Player
{
    private static String name;
    private static int healthPoints;
    private static int damage;
    private Item[] inventory;

   public Player(String name, int healthPoints, int damage, Item[]inventory)
   {
      this.setName(name);
      Player.setHealthPoints(healthPoints);
      this.setDamage(damage);
      this.inventory = inventory;
   }

   public Item[] addItem(Item item)
   {
      
      if(item.getName() == "Sword")
      {
         setDamage(getDamage() + Weapon.getIncreaseDamage());
      }
      
      for(int i =0; i < inventory.length; i++)
      {
         if(inventory[i] == null)
         {
            inventory[i] = item;
            break;
         }
      }
      
      return inventory;
      
   }
   
   public Item[] removeItem(String itemName)
   {
      for(int i =0; i < inventory.length; i++)
      {
         
         if(inventory[i] != null)
         {
            if(inventory[i].getName() == itemName)
            {
               inventory[i] = null;
            }
         }

      }
      return inventory;
      
   }
   
   public void displayInventory(Item[] inventory)
   {
      Item item;
      System.out.println("Items: ");
      for(int i =0; i < inventory.length; i++)
      {
         if(inventory[i] != null)
         {
            item = inventory[i];
            System.out.print(item.getName() + "  "); 
         }
      }
      System.out.println();
   }
   
   public void setInventory(Item[] inventory)
   {
      this.inventory = inventory;
   }
   
   public Item[] getInventory()
   {
      return inventory;
   }

   public static int getDamage()
   {
      return damage;
   }

   public void setDamage(int damage)
   {
      Player.damage = damage;
   }

   public static int getHealthPoints()
   {
      return healthPoints;
   }

   public static void setHealthPoints(int healthPoints)
   {
      Player.healthPoints = healthPoints;
   }

   public static String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      Player.name = name;
   }
   
   
}
