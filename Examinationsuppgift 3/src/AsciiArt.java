
public class AsciiArt
{

   public static void startScreen()
   {
      System.out.print("Welcome to");
      System.out.print("\r\n" + 
            " __, __,  _,  _,  _, _, _   ___ __, __,  _,  _, _,_ __, __,\r\n" + 
            " | \\ |_) /_\\ / _ / \\ |\\ |    |  |_) |_  /_\\ (_  | | |_) |_ \r\n" + 
            " |_/ | \\ | | \\ / \\ / | \\|    |  | \\ |   | | , ) | | | \\ |  \r\n" + 
            " ~   ~ ~ ~ ~  ~   ~  ~  ~    ~  ~ ~ ~~~ ~ ~  ~  `~' ~ ~ ~~~\r\n" + 
            "                                                           \r\n" + 
            "");
      System.out.println("Write your name and press [Enter] to start a new game...");
   }
   
   

   
   
   public static void displayOutside()
   {
      System.out.print("        _    .  ,   .           .\r\n" + 
            "    *  / \\_ *  / \\_      _  *        *   /\\'__        *\r\n" + 
            "      /    \\  /    \\,   ((        .    _/  /  \\  *'.\r\n" + 
            " .   /\\/\\  /\\/ :' __ \\_  `          _^/  ^/    `--.\r\n" + 
            "    /    \\/  \\  _/  \\-'\\      *    /.' ^_   \\_   .'\\  *\r\n" + 
            "  /\\  .-   `. \\/     \\ /==~=-=~=-=-;.  _/ \\ -. `_/   \\\r\n" + 
            " /  `-.__ ^   / .-'.--\\ =-=~_=-=~=^/  _ `--./ .-'  `-\r\n" + 
            "/        `.  / /       `.~-^=-=~=^=.-'      '-._ `._\r\n" + 
            "");
   }
   
   public static void displayRoom(boolean N, boolean S, boolean W, boolean E)
   {
    
    if(N)
    {
       System.out.print(
             " ___________     ____________\r\n" +  
             "|  _________     __________  |\r\n" + 
             "| |           N            | |\r\n" + 
             "| |                        | |\r\n" + 
             "| |                        | |\r\n" );
    }
    else
    {
       System.out.print(
             " ____________________________\r\n" +  
             "|  ________________________  |\r\n" + 
             "| |                        | |\r\n" + 
             "| |                        | |\r\n" + 
             "| |                        | |\r\n" );
    }

    if(W && E)
    {
       System.out.print(
             "                               \r\n" + 
             "   W                      E    \r\n" + 
             "                               \r\n");
    }
    else if (W && !E)
    {
       System.out.print(
             "                           | | \r\n" + 
             "   W                       | | \r\n" + 
             "                           | | \r\n");
    }
    else if (!W && E)
    {
       System.out.print(
             "| |                           \r\n" + 
             "| |                       E   \r\n" + 
             "| |                           \r\n");
    }
    else
    {
       System.out.print(
             "| |                        | | \r\n" + 
             "| |                        | | \r\n" + 
             "| |                        | | \r\n");
    }

      
    if(S)
    {
       System.out.print(
             "| |                        | |\r\n" + 
             "| |                        | |\r\n" + 
             "| |_________  S  __________| |\r\n" + 
             "|___________     ____________|\n" ); 
    }
    else
    {
       System.out.print(
             "| |                        | |\r\n" + 
             "| |                        | |\r\n" + 
             "| |________________________| |\r\n" + 
             "|____________________________|\n" ); 
    }

      

      

   }
}
