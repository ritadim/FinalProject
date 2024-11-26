package sanity;

import extensions.ApiActions;
import extensions.Verifications;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class ReqresAPI extends CommonOps {

    //get method
    @Test(description = "Test01 - Verify The First Name of User Number 10")
    @Description("Verifies The First Name of The Tenth User")
    public void test01VerifyName(){
        String actual = ApiFlows.getUserData("data.first_name","2",10);
        Verifications.VerifyText(actual,"Byron");
    }
    //post method
    @Test(description = "Test02 - Create New User")
    @Description("Verifies Creation of a New User")
    public void test02CreateNewUser(){
        String actual = ApiActions.extractFromJSON(ApiFlows.postUser("Dudi","Qa"),"name");
        Verifications.VerifyText(actual,"Dudi");
    }
    //put method
    @Test(description = "Test03 - Updates an Existing User")
    @Description("Updates and Verifies The User")
    public void test03UpdateUser(){
        String actual = ApiActions.extractFromJSON(ApiFlows.updateUser("Mika","Dev"),"name");
        Verifications.VerifyText(actual,"Mika");
    }
    //delete method
    @Test(description = "Test04 - Delete an Existing User")
    @Description("Delete User and Verify")
    public void test04DeleteUser(){
        int actual = ApiFlows.deleteUser().getStatusCode();
        Verifications.VerifyNumber(actual,204);
    }
}
