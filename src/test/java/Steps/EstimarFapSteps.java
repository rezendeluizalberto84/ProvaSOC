package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class EstimarFapSteps {

    private WebDriver driver;

    @Quando("clico no menu Soluções e Recursos")
    public void clicoNoMenuSoluçõesERecursos() {
        driver.findElement(By.xpath("//*[@id=\"navegacao-superior\"]/ul/li[3]")).click();
    }

    @Quando("clico no menu FAP")
    public void clicoNoMenuFAP() {
        driver.findElement(By.xpath("//*[@id=\"navegacao-superior\"]/ul/li[3]/div/div[2]/ul/li[4]/a/abbr")).click();
    }
    @Quando("informo o nome da empresa {string}")
    public void informoONomeDaEmpresa(String string) {
        driver.findElement(By.xpath("//input[@id='nomeEmpresa']")).sendKeys(string);
    }
    @Quando("informo o numero FAP {string}")
    public void informoONumeroFAP(String string) {
        driver.findElement(By.xpath("//input[@id='fap']")).sendKeys(string);
    }
    @Quando("seleciono a porcentagem RAT")
    public void selecionoAPorcentagemRAT() {
        driver.findElement(By.xpath("//span[text()='Selecione']")).click();
        driver.findElement(By.xpath("//li[text()='1']")).click();
    }
    @Quando("informo a projeção salarial {string}")
    public void informoAProjeçãoSalarial(String string) {
        driver.findElement(By.xpath("//input[@id='projecao']")).sendKeys(string);
    }
    @Quando("seleciono Estimar FAP")
    public void selecionoEstimarFAP() {
        driver.findElement(By.xpath("//input[@id='estimar']")).click();
    }
    @Então("os cálculos são exibidos na tela com sucesso")
    public void osCálculosSãoExibidosNaTelaComSucesso() {
        String texto = driver.findElement(By.xpath("//h1[text()='Estimativa FAP da empresa']")).getText();
        Assert.assertEquals("ESTIMATIVA FAP DA EMPRESA", texto);
    }

    @After(order = 1)
    public void screenshots(Scenario cenario) {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("D:\\User\\ProvaSOC\\target\\screenshots" + cenario.getId() + ".jpg"));
        }catch (IOException e) {
            e.printStackTrace();
       }
    }

        @After(order = 0)
        public void fecharBrowser() {
            driver.quit();
        }

}
