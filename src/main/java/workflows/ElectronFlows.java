package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElectronFlows extends CommonOps {
    @Step("Business Flow: creating a list of tasks")
    public static void addNewTask(List<String> taskNames){
        for (String taskName: taskNames){
            UIActions.updateText(electronMain.getPlaceholder(),taskName);
            UIActions.Enter(electronMain.getPlaceholder(), Keys.RETURN);
        }
    }
    @Step("Business Flow: returns a list of tasks")
    public static List<String> getTasksNames(){
        return UIActions.getTextOfElems(electronMain.getTasksText());
    }
    @Step("Business Flow: returns the number of tasks in the list")
    public static int getNumberOfTasks(){
        return electronMain.getTasks().size();
    }
    @Step("Business Flow: clears task from the list")
    public static void clearTask(){
        UIActions.mouseHover(electronMain.getRemoveBtn());
        Uninterruptibles.sleepUninterruptibly(Long.parseLong(getData("Timeout02")), TimeUnit.SECONDS);
    }
    @Step("Business Flow: toggle checkbox")
    public static void CheckboxMark(){
        UIActions.mouseHover(electronMain.getEmptyCheckbox());
    }
}