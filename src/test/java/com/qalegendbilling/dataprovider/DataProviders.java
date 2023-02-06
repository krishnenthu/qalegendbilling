package com.qalegendbilling.dataprovider;

import com.qalegendbilling.constants.ExcelSheet;
import com.qalegendbilling.utilities.ExcelUtility;
import org.testng.annotations.DataProvider;

public class DataProviders {
    ExcelUtility excel=new ExcelUtility();
    @DataProvider(name = "InvalidUserCredentials")
    public Object[][] invalidUserCredentialsToLogin(){
        Object[][] data=excel.dataProviderRead(ExcelSheet.LOGIN_PAGE_INVALID_DATA_SHEET);
        return data;
    }
}
