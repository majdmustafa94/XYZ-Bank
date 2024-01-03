import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class MyTest extends Parameters{

    @Test(priority = 1,groups = "customer")
    public void loginAsCustomer(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();
    }

    @Test(priority = 1,groups = "manager")
    public void loginAsManager(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")).click();
    }

    @Test(priority = 2,groups = "manager")
    public void Add_Customer() throws InterruptedException {
        int userID=(int)(Math.random()*100);
        StringBuilder userName=new StringBuilder();
        userName.append(userID);
        String user=userName.toString();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys("user"+user);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")).sendKeys("QA");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")).sendKeys(user);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
        Thread.sleep(1000);
        String myText= driver.switchTo().alert().getText();
        boolean myCheck= myText.contains("successfully");

        myAssert.assertEquals(myCheck,true);

        driver.switchTo().alert().accept();

        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input")).sendKeys("user"+user);


        myAssert.assertAll();

    }
}
