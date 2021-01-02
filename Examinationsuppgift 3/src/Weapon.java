
public class Weapon extends Item
{
   private static int increaseDamage;
   public Weapon(String name, String desc, int increaseDamage)
   {
     super(name, desc);
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
