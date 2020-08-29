package ProvaSoc;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import suporte.Generator;
import suporte.Screenshot;


import java.util.concurrent.TimeUnit;

public class ProvaSocTest {
    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\User\\ProvaSOC\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://ww2.soc.com.br/blog/");

        WebElement botaoAceitarCookie = driver.findElement(By.id("barra-cookie"));
        botaoAceitarCookie.click();
    }

    @Test
    public void buscaNoBlog() {

        WebElement formularioBusca = driver.findElement(By.xpath("//input[@name='s']"));
        formularioBusca.findElement(By.xpath("//input[@name='s']")).sendKeys("home office");

        WebElement clicarBotaoBusca = driver.findElement(By.xpath("//input[@type='submit']"));
        clicarBotaoBusca.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement resultadoBuscaComSucesso = driver.findElement(By.xpath("//a[text()='4 vantagens de trabalhar em home office']"));

        Assert.assertTrue(resultadoBuscaComSucesso.getText().contains("home office"));

        Screenshot.tirar(driver, "D:\\User\\ProvaSOC\\Screenshots\\Busca" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void preencherFormulario() {

        WebElement acessarMenuFAP = driver.findElement(By.xpath("//*[@id=\"navegacao-superior\"]/ul/li[3]"));
        acessarMenuFAP.findElement(By.xpath("//*[@id=\"navegacao-superior\"]/ul/li[3]")).click();

        WebElement acessarLinkFAP = driver.findElement(By.xpath("//*[@id=\"navegacao-superior\"]/ul/li[3]/div/div[2]/ul/li[4]/a/abbr"));
        acessarLinkFAP.findElement(By.xpath("//*[@id=\"navegacao-superior\"]/ul/li[3]/div/div[2]/ul/li[4]/a/abbr")).click();

        WebElement campoNomeDaEmpresa = driver.findElement(By.xpath("//input[@id='nomeEmpresa']"));
        campoNomeDaEmpresa.findElement(By.xpath("//input[@id='nomeEmpresa']")).sendKeys("BBB");

        WebElement campoFAP = driver.findElement(By.xpath("//input[@id='fap']"));
        campoFAP.findElement(By.xpath("//input[@id='fap']")).sendKeys("123");

        //Método fazendo a função do Select que não funcionou. O mesmo está comentado após esse bloco.
        WebElement comboRat = driver.findElement(By.xpath("//span[text()='Selecione']"));
        comboRat.findElement(By.xpath("//span[text()='Selecione']")).click();
        WebElement campoRat = driver.findElement(By.xpath("//li[text()='1']"));
        campoRat.findElement(By.xpath("//li[text()='1']")).click();

        //Select campoRat = new Select(driver.findElement(By.xpath("//select[@id='rat']")));
        //campoRat.selectByVisibleText("1");

        WebElement campoProjecaoDeMassaSalarial = driver.findElement(By.xpath("//input[@id='projecao']"));
        campoProjecaoDeMassaSalarial.findElement(By.xpath("//input[@id='projecao']")).sendKeys("800000");

        WebElement botaoEstimarFAP = driver.findElement(By.xpath("//input[@id='estimar']"));
        botaoEstimarFAP.findElement(By.xpath("//input[@id='estimar']")).click();

        String texto = driver.findElement(By.xpath("//h1[text()='Estimativa FAP da empresa']")).getText();
        Assert.assertEquals("ESTIMATIVA FAP DA EMPRESA", texto);

        Screenshot.tirar(driver, "D:\\User\\ProvaSOC\\Screenshots\\FAP" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @After
    public void fecharBrowser() {
        driver.quit();
    }
}
