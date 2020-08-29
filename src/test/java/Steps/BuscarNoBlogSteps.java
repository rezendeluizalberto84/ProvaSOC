package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BuscarNoBlogSteps {

    private WebDriver driver;

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        System.setProperty("webdriver.chrome.driver", "D:\\User\\ProvaSOC\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://ww2.soc.com.br/blog/");

        WebElement botaoAceitarCookie = driver.findElement(By.id("barra-cookie"));
        botaoAceitarCookie.click();
    }

    @Quando("informo a palavra {string}")
    public void informoAPalavra(String string) {
        driver.findElement(By.xpath("//input[@name='s']")).sendKeys(string);
    }
    @Quando("seleciono Buscar")
    public void selecionoBuscar() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @Então("o resultado é exibido com sucesso")
    public void oResultadoÉExibidoComSucesso() {
        WebElement resultadoBuscaComSucesso = driver.findElement(By.xpath("//a[text()='4 vantagens de trabalhar em home office']"));

        Assert.assertTrue(resultadoBuscaComSucesso.getText().contains("home office"));
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
