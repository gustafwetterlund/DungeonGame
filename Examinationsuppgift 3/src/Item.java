
public class Item
{
   private String name;
   private String desc;
   private boolean consumable;
   
   public Item(String name, String desc, boolean consumable)
   {
      this.setName(name);
      this.setDesc(desc);
      this.setConsumable(consumable);
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getDesc()
   {
      return desc;
   }

   public void setDesc(String desc)
   {
      this.desc = desc;
   }

   public boolean isConsumable()
   {
      return consumable;
   }

   public void setConsumable(boolean consumable)
   {
      this.consumable = consumable;
   }


   
   
   
}
