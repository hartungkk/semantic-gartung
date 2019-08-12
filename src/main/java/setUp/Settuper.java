package setUp;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settuper {


    public static void setUp() {
        WebDriverManager.chromedriver().version("76.0.3809.68").setup();
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://virtuoso.poolparty.biz/PoolParty";
        Configuration.browserSize = "1280x1024";
    }
}
