
public class Key extends Item
{
   private boolean opensDoor;
   public Key(String name, String desc, boolean consumable, boolean opensDoor)
   {
      super(name, desc, consumable);
      this.setOpensDoor(opensDoor);
      
   }
   public boolean isOpensDoor()
   {
      return opensDoor;
   }
   public void setOpensDoor(boolean opensDoor)
   {
      this.opensDoor = opensDoor;
   }

 
  

}
