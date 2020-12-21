
public class Potion extends Item
{
   private boolean restoresHealth;
   public Potion(String name, String desc, boolean consumable, boolean restoresHealth)
   { 
         super(name, desc, consumable);
         this.setRestoresHealth(restoresHealth);
   }
   public boolean isRestoresHealth()
   {
      return restoresHealth;
   }
   public void setRestoresHealth(boolean restoresHealth)
   {
      this.restoresHealth = restoresHealth;
   }
   
}
