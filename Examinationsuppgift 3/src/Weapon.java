
public class Weapon extends Item
{
   private static int increaseDamage;
   public Weapon(String name, String desc, boolean consumable, int increaseDamage)
   {
     super(name, desc, consumable);
     Weapon.setIncreaseDamage(increaseDamage);
     
   }
   public static int getIncreaseDamage()
   {
      return increaseDamage;
   }
   public static void setIncreaseDamage(int increaseDamage)
   {
      Weapon.increaseDamage = increaseDamage;
   }
}
