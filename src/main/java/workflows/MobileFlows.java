package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: currency conversion from ILS to USD")
    public static void updateNumberFieldLessThan10(){
        MobileActions.mobileClick(MobileHeader.getNotNow());
        MobileActions.mobileClick(MobileHeader.getLivingTitle());
        MobileActions.mobileClick(MobileLivingCategory.getCurrency());
        MobileActions.mobileClick(MobileLivingCategory.getTabInput());
        MobileActions.clickOnElemFromList(MobileNumbersTab.getNumKeyboard(),getData("KeyboardCharacter"),getData("AttributeName"));
    }
    @Step("Business Flow: currency conversion from ILS to USD")
    public static void updateNumberFieldGreaterThan10(){
        MobileActions.mobileClick(MobileHeader.getNotNow());
        MobileActions.mobileClick(MobileHeader.getLivingTitle());
        MobileActions.mobileClick(MobileLivingCategory.getCurrency());
        MobileActions.mobileClick(MobileLivingCategory.getTabInput());
        MobileActions.clickOnEveryCharacter(MobileNumbersTab.getNumKeyboard(),getData("KeyboardValue"),getData("AttributeName"));
    }
}