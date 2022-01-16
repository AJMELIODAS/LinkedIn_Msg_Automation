import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the Recepent Name:");
    String name=sc.nextLine();
    System.out.println("Enter the Message");
    String msg=sc.nextLine();
    
    // System.setProperty("webdriver.chrome.drver", "C:/Users/new/OneDrive/Desktop/Selenium_Practice/Practice/chromedriver.exe");
    ChromeDriver cd= new ChromeDriver();
    try{
        cd.manage().window().maximize(); // Maximizing browser window
        cd.get("https://www.linkedin.com/checkpoint/lg/login"); // routing to linked in login page
        
        // Entering the credentials
        cd.findElement(By.id("username")).sendKeys(Credentials.getUsetName());//Entering Username
        cd.findElement(By.id("password")).sendKeys(Credentials.getPassword());// Entering Password
        cd.findElement(By.xpath("//button[text()='Sign in']")).click();//Clicking signin button
        // Entered the linkedin
        Thread.sleep(2000);
        //Messaging a friend
        cd.findElement(By.xpath("//h4[text()='"+name+"']")).click();
        cd.findElement(By.xpath("//div[@class= 'flex-grow-1'][1]/div/p")).sendKeys(msg);
        Thread.sleep(1000);//Wait for a sec
        cd.findElement(By.xpath("//button[text()='Send']")).click();
        Thread.sleep(3000);
        cd.findElement(By.xpath("//div[@class= 'flex-grow-1'][1]/div/p")).sendKeys(Keys.ESCAPE);
        //Messaged a friend
        Thread.sleep(2000);

        // Exiting the linkedin
        // System.out.println("------------Starts----------------");
        cd.findElement(By.id("ember31")).click();// Clicking on menu in the navbar
        Thread.sleep(2000);// Wait 1 second to load all the elements
        cd.findElement(By.partialLinkText(" Out")).click();// Clicking on Signout button
        // Out of the linkedin

        Thread.sleep(2000);

        }
    catch(Exception e){
        System.out.println(e);
    }
    finally{
        cd.quit();
    }
}
}
