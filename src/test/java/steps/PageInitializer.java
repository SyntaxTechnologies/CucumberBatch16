package steps;

import pages.LoginPage;

public class PageInitializer {

    public static LoginPage loginPage;


   public static void initializePageObjects(){
       loginPage = new LoginPage();

   }
}
