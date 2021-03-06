package utilities;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper {

	private static Random random = new Random();
	
	// Method to take screenshot when the test cases fail
	public static void captureScreenshot(WebDriver driver , String screenshotname) 
	{
		Path dest = Paths.get("./Screenshots",screenshotname+".png"); 
		
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			
		} catch (IOException e) {
			System.out.println("Excpetion while taking screenshot: "+ e.getMessage());
		}
	}
	
	public static int generateRandomNumber() {		
		return random.nextInt(5000) + 1;
	}

	public static String generateProductKeyword(String product) {
		int length = product.length();
		int startIndex, endIndex;
		String keyword;

		while (true) {
			startIndex = random.nextInt(length -1) + 0;
			endIndex = random.nextInt(length -1) + 0;

			if (endIndex - startIndex >= 5) {
				keyword = product.substring(startIndex, endIndex);
				break;
			}
		}
		return keyword;
	}
}
