package br.com.selenium.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	public static WebDriver browser;
	
	public Login(WebDriver driver){
		browser = driver;
	}
	
	public void preencherLogin(String usuario, String senha){
		
		try{
			browser.findElement(By.id("txtUsuario")).sendKeys(usuario);
			browser.findElement(By.id("txtSenha")).sendKeys(senha);	
		}catch (Exception e){
			System.out.println("Não foi possível inserir login e senha nos campos txtUsuario e txtSenha\n" + e.toString());	
		}
	}
	
	public boolean clicarLogin(){
		
		boolean result = false;
		
		try{
			browser.findElement(By.name("btnLogin")).click();
			result = validarLogin();
		}catch(Exception e){
			System.out.println("Não foi possível logar na página\n" + e.toString());
			result = false;
		}
		return result;
	}
	
	private boolean validarLogin(){
		String idMsgErro = "lblAlerta";
		try{
			browser.wait(7000L);
			browser.findElement(By.id(idMsgErro));
			return false;
		}catch (Exception e){
			return true;
		}				
	}
	
}
