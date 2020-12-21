
public class Treasure extends Item
{
   private boolean winsGame;
   public Treasure(String name, String desc, boolean consumable, boolean winsGame)
   { 
         super(name, desc, consumable);
         this.setWinsGame(winsGame);
   }
   public boolean isWinsGame()
   {
      return winsGame;
   }
   public void setWinsGame(boolean winsGame)
   {
      this.winsGame = winsGame;
   }

}
