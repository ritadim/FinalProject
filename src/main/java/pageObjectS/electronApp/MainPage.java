package pageObjectS.electronApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    // Input placeholder for creating a task
    @FindBy(xpath = "//input[@placeholder='Create a task']")
    private WebElement placeholder;

    // List of all tasks
    @FindBy(css = "div[class='view_2Ow90']")
    private List<WebElement> tasks;

    // List of task text labels
    @FindBy(css = "label[class='label_5i8SP']")
    private List<WebElement> tasksText;

    // Button to remove a task
    @FindBy(css = "svg[class='destroy_19w1q']")
    private WebElement removeBtn;

    // Checkbox for marked tasks
    @FindBy(css = "div[class='view_2Ow90']>label>svg>path")
    private WebElement markedCheckbox;

    // Checkbox for unmarked (empty) tasks
    @FindBy(css = "div[class='view_2Ow90']>label>svg>circle")
    private WebElement emptyCheckbox;

    // Getter for 'placeholder'
    public WebElement getPlaceholder() {
        return placeholder;
    }

    // Getter for 'tasks'
    public List<WebElement> getTasks() {
        return tasks;
    }

    // Getter for 'tasksText'
    public List<WebElement> getTasksText() {
        return tasksText;
    }

    // Getter for 'removeBtn'
    public WebElement getRemoveBtn() {
        return removeBtn;
    }

    // Getter for 'markedCheckbox'
    public WebElement getMarkedCheckbox() {
        return markedCheckbox;
    }

    // Getter for 'emptyCheckbox'
    public WebElement getEmptyCheckbox() {
        return emptyCheckbox;
    }
}