package steps;


import org.apache.commons.math3.analysis.function.Add;
import pages.*;

public class PageInitializer {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeSearchPage employeeSearchPage;
    public static JobPage jobPage;


   public static void initializePageObjects(){
       loginPage = new LoginPage();
       dashboardPage = new DashboardPage();
       addEmployeePage = new AddEmployeePage();
       employeeSearchPage = new EmployeeSearchPage();
       jobPage=new JobPage();
   }
}
