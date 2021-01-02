
public class Door
{
   private String position;
   private boolean locked;
   
   public Door(String position, boolean locked)
   {
      this.setPosition(position);
      this.setLocked(locked);
   }

   public String getPosition()
   {
      return position;
   }

   public void setPosition(String position)
   {
      this.position = position;
   }

   public boolean isLocked()
   {
      return locked;
   }

   public void setLocked(boolean locked)
   {
      this.locked = locked;
   }
   
   public static Door[] unlockDoor(Door[] doors, String position)
   {
      for(int i = 0; i < doors.length; i++)
      { 
         if(doors[i].getPosition().equals(position))
         {
            doors[i].setLocked(false);
         }
            
      }
      return doors;
   }
   
   
}
