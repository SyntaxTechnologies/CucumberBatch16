package steps;

import com.beust.ah.A;
import org.apache.commons.math3.analysis.function.Add;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageInitializer {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeSearchPage employeeSearchPage;


   public static void initializePageObjects(){
       loginPage = new LoginPage();
       dashboardPage = new DashboardPage();
       addEmployeePage = new AddEmployeePage();
       employeeSearchPage = new EmployeeSearchPage();
   }
}
