
public class Player
{
    private String name;
    private int healthPoints;
    private int damage;
    private Item[] inventory;

   public Player(String name, int healthPoints, int damage, Item[]inventory)
   {
      this.setName(name);
      this.setHealthPoints(healthPoints);
      this.setDamage(damage);
      this.inventory = inventory;
   }

   public Item[] addItem(Item item)
   {
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
   
   public Item[] removeItem(Item item)
   {
      for(int i =0; i < inventory.length; i++)
      {
         if(inventory[i] == item)
         {
            inventory[i] = null;
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

   public int getDamage()
   {
      return damage;
   }

   public void setDamage(int damage)
   {
      this.damage = damage;
   }

   public int getHealthPoints()
   {
      return healthPoints;
   }

   public void setHealthPoints(int healthPoints)
   {
      this.healthPoints = healthPoints;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }
   
   
}
