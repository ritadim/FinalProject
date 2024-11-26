package sanity;

import extensions.MobileActions;
import extensions.Verifications;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class UnitConverterMobile extends CommonOps {
    @Test(description = "Test01 - currency conversion from ILS to USD")
    @Description("Verifies The conversion from ILS to USD(with a one-digit number)")
    public void test01VerifyConversion(){
        MobileFlows.updateNumberFieldLessThan10();
        Verifications.VerifyText(MobileActions.attributeValue(MobileLivingCategory
                .getCurrencyUnits().get(1),"text"),getData("ExpectedUSD1"));
    }

    @Test(description = "Test02 - currency conversion from ILS to USD")
    @Description("Verifies The conversion from ILS to USD(with a two-digit number)")
    public void test02VerifyConversion(){
        MobileFlows.updateNumberFieldGreaterThan10();
        Verifications.VerifyText(MobileActions.attributeValue(MobileLivingCategory
                .getCurrencyUnits().get(1),"text"),getData("ExpectedUSD2"));
    }
}