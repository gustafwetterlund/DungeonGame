
public class Door
{
   private char position;
   private boolean locked;
   
   public Door(char position, boolean locked)
   {
      this.setPosition(position);
      this.setLocked(locked);
   }

   public char getPosition()
   {
      return position;
   }

   public void setPosition(char position)
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
   
   
}
