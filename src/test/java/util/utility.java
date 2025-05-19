
package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class utility {

    static public WebDriver getBrowser(String BrowserName) throws IOException {
        if (BrowserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");

            // Create a temporary directory for user profile
            Path tempProfile = Files.createTempDirectory("chrome-profile");
            System.out.println("Using temp Chrome profile at: " + tempProfile.toAbsolutePath());

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");  // You can add this if you want to run in headless mode
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            // Set the user-data-dir argument to the temporary profile
            options.addArguments("--user-data-dir=" + tempProfile.toAbsolutePath().toString());

            return new ChromeDriver(options);
        }

        if (BrowserName.equals("ie")) {
            System.setProperty("webdriver.ie.driver", "src/test/resources/driver/IEDriverServer.exe");
            return new InternetExplorerDriver();
        }

        else {
            return null;
        }
    }
}

