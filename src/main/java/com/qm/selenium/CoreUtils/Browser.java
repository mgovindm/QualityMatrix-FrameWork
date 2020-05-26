package com.qm.selenium.CoreUtils;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface Browser {
	
	public RemoteWebDriver startApp(String browser,boolean bRemote);
	public void switchToFrame(WebElement ele);
	public void defaultContent();
	public void close();
	public void quit();

	
	
	
	

	
}
