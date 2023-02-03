package com.qalegendbilling.dataprovider;

import com.qalegendbilling.utilities.ExcelUtility;
import org.testng.annotations.DataProvider;

public class DataProviders {
    ExcelUtility excel=new ExcelUtility();
    @DataProvider(name = "InvalidUserCredentials")
    public Object[][] invalidUserCredentialsToLogin(){
        Object[][] data=excel.dataProviderRead("LoginPageDataProvider");
        return data;
    }
    @DataProvider(name = "InvalidCredentials")
    public Object[][] InvalidCredentials() {
        Object[][] data = {{"selenium1", "test123"}, {"selenium2", "test@123"},{"selenium3","789"}};
        return data;
    }
}
