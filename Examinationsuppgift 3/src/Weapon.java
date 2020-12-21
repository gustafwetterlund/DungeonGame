
public class Weapon extends Item
{
   private int increaseDamage;
   public Weapon(String name, String desc, boolean consumable, int increaseDamage)
   {
     super(name, desc, consumable);
     this.setIncreaseDamage(increaseDamage);
     
   }
   public int getIncreaseDamage()
   {
      return increaseDamage;
   }
   public void setIncreaseDamage(int increaseDamage)
   {
      this.increaseDamage = increaseDamage;
   }
}
