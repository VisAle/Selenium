package br.com.selenium.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver browser){
		driver = browser;	
	}
	
	public Object selecionarMenu(EMenuGenteGestao menu){
		
		String opcaoMenu = null;
		Object paginaRetorno = null;
		switch (menu){
			case ABERTURA_CHAMADO:
				opcaoMenu = "Abertura de Chamado";
				break;
			case ALOCACAO_HORAS:
				opcaoMenu = "Alocação de Horas";
				paginaRetorno = new AlocacaoHoras(driver);
				break;
			case HOLERITE:
				opcaoMenu = "Consulta Holerite";
				break;
			case DOCUMENTO_PUBLICO:
				opcaoMenu = "Documentos Públicos";
				break;
			case REEMBOLSO_DESPESAS:
				opcaoMenu = "Reembolso de Despesas";
		}
		
		driver.findElement(By.linkText(opcaoMenu)).click();
		return paginaRetorno;
		
	}
	
	
}
