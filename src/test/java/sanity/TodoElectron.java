package sanity;

import extensions.Verifications;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

import java.util.Arrays;
import java.util.List;

@Listeners(utilities.Listeners.class)
public class TodoElectron extends CommonOps {
    @Test(description = "Test01 - Create Tasks And Verify The Tasks Names")
    @Description("Make Sure The Relevant Tasks are Displayed(using soft assertion)")
    public void test01CreateTasksAndVerify(){
        List<String> list= Arrays.asList("learn python","learn java","go to the gym","meditate","aaa","bbb","ccc","ddd");
        ElectronFlows.addNewTask(list);
        Verifications.ComparisonBetweenText(ElectronFlows.getTasksNames(),list);
        for(int i =0;i< list.size();i++){
            ElectronFlows.clearTask();
        }
    }
    @Test(description = "Test02 - Create Task And Toggle As Completed")
    @Description("Makes Sure The Checkbox is Enabled")
    public void test02CreateTasksAndVerify(){
        List<String> list= Arrays.asList("test1");
        ElectronFlows.addNewTask(list);
        ElectronFlows.CheckboxMark();
        Verifications.elementEnable(electronMain.getMarkedCheckbox());
    }
}