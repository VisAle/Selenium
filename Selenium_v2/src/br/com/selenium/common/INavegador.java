package br.com.selenium.common;

import org.openqa.selenium.WebDriver;

public interface INavegador {

	WebDriver startBrowser(ENavegador janela, String url);
	void closeBrowser(WebDriver browser);
	
}
