package br.com.selenium.common;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Navegador{
	
	public static WebDriver browser;
			
	public static WebDriver startBrowser(ENavegador janela, String url) {
		
		String caminhoNavegador = new File("").getAbsoluteFile() + "//Browser//";
		
		switch (janela){		
			case CHROME:
				caminhoNavegador += "chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", caminhoNavegador);
				browser = new ChromeDriver();	
				break;
			case FIREFOX:
				caminhoNavegador += "geckodriver.exe";			
				System.getProperty("webdriver.gecko.driver", new File("").getAbsolutePath()+ "//Browser//geckodriver.exe");
								
				browser = new FirefoxDriver();
				break;
			case INTERNET_EXPLORER:
				caminhoNavegador += "IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", caminhoNavegador);
				browser = new InternetExplorerDriver();
				
		}
		
		//Carregar páginas da internet		
		browser.get(url);
		//chrome.navigate().to("http://youtube.com");
		
		//Maximizar Janela
		browser.manage().window().maximize();
			
		return browser;
	}
	
	public static void closeBrowser() {
		try{
			browser.close();
		}catch(Exception e){
			System.out.println("Não foi possível encerrar o browser \n" + e.toString() );
		}		
	}
	
	public static void scrollDown(){
		JavascriptExecutor jse = ((JavascriptExecutor) browser);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	

}
