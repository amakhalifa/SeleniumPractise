package util;

import base.Testbase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtil extends Testbase {

    public static void takeScreenShot() throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
}
