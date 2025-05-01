package Utilities;
import org.testng.annotations.DataProvider;
public class DataProviderUtil {


        @DataProvider(name = "loginData")
        public Object[][] loginDataProvider() {
            return new Object[][] {
                    {"standard_user", "secret_sauce"},
                    {"locked_out_user", "secret_sauce"},
                    {"", "secret_sauce"}
            };

    }
}
