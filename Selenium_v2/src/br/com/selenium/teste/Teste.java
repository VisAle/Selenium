package br.com.selenium.teste;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;

import br.com.selenium.common.AlocacaoHoras;
import br.com.selenium.common.EMenuGenteGestao;
import br.com.selenium.common.ENavegador;
import br.com.selenium.common.HomePage;
import br.com.selenium.common.Login;
import br.com.selenium.common.Navegador;

public class Teste {

	public static void main(String[] args) {
				
		String url = "http://aplic.inmetrics.com.br/pcweb/login.aspx";	
		boolean logado = false;
		WebDriver driver;
		Login login;
		HomePage home;
		AlocacaoHoras alocacaoHoras;
		
		boolean alocouTudo;
		
		try{
			
			driver = Navegador.startBrowser(ENavegador.CHROME, url);
						
			login = new Login(driver);
			
			login.preencherLogin("vivianro", "Jesusefiel10");
			logado = login.clicarLogin();
			
			home = new HomePage(driver);
			
			if (logado){
				alocacaoHoras = (AlocacaoHoras) home.selecionarMenu(EMenuGenteGestao.ALOCACAO_HORAS);
				alocacaoHoras.selecionarData(02, 2017);
				
				Navegador.scrollDown();
				
				alocouTudo = alocacaoHoras.validarLancamento();
				
				if (alocouTudo){
					JOptionPane.showMessageDialog(null, "Parabéns você alocou todas as horas!!!");
				}else{
					JOptionPane.showMessageDialog(null, "Opa, por favor aloque todas as horas!!!");
				}
				
			}else{				
				System.out.println("Não foi possível logar na aplicação");
			}
								
		}catch (Exception e){
			System.out.println("Erro ao tentar acesso o firefox " + e);
		}finally{
			//Navegador.closeBrowser();
		}
		
	}	
		
}
	
	
