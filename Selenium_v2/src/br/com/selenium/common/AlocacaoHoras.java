package br.com.selenium.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlocacaoHoras {

	public WebDriver driver;
	
	public AlocacaoHoras(WebDriver iDriver){
		driver = iDriver;
	}
	
	public void selecionarData(int mes, int ano){
		
		String idData, data, idBotaoOK;
		
		idData = "txtDtReferencia";
		data = mes + "/" + ano;
		idBotaoOK = "cphBody_btnPesquisaPeriodo";
		
		driver.findElement(By.id(idData)).clear();
		driver.findElement(By.id(idData)).sendKeys(data);
		driver.findElement(By.id(idBotaoOK)).click();
		
	}
	
	public boolean validarLancamento(){
		
		String valor = driver.findElement(By.id("cphBody_lblSaldoHorasNormais")).getText();
		
		if(valor.equalsIgnoreCase("0,00")){			
			return true;
		}else{
			return false;
		}
	}
	
}
