package com.epam.ftm.Tests;

import com.epam.ftm.Pages.CloudGooglePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Task3 extends BasicTest  {


    private String VMClass = "Regular";
    private String instanceType = "n1-standard-8";
    private String region = "Frankfurt";
    private String localSSD = "2x375";
    private String commitTerm = "1 Year";

    private String calculatedSum = "USD 1,187.77";

    @Test
    public void Task3Test() throws Exception {

        CloudGooglePage cloudGooglePage = new CloudGooglePage();
        cloudGooglePage.accessUrl();
        cloudGooglePage.goToPage("Products");
        cloudGooglePage.goToPage("Pricing");
        cloudGooglePage.selectGoogleCloudPlatform("Calculators");
        cloudGooglePage.selectSubPlatform("Compute Engine");
        cloudGooglePage.setInstances("4");
        cloudGooglePage.selectOperatingSystem("Free: Debian");
        cloudGooglePage.scrollPage();

        cloudGooglePage.selectMachineClass(VMClass);
        cloudGooglePage.selectMachineType(instanceType);
        cloudGooglePage.addGPUs("1", "Tesla V100");
        cloudGooglePage.selectSSD(localSSD);
        cloudGooglePage.selectDataCenterLocation(region);
        cloudGooglePage.selectCommitedUsage(commitTerm);
        cloudGooglePage.addtoEstimate();


        checkDataPresense("VM class: " + VMClass);
        checkDataPresense("Instance type: " + instanceType);
        checkDataPresense("Region: " + region);
        checkDataPresense("Total available local SSD space " + localSSD);
        checkDataPresense("Commitment term: " + commitTerm);


        checkDataPresense(calculatedSum);

    }




    @Test
    public void smoke(){

        driver.get("https://cloud.google.com/products/calculator/");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://cloudpricingcalculator.appspot.com']")));

        driver.findElement(By.xpath("//label[contains(text(),'Machine type')]/../md-select")).click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.findElement(By.xpath
                ("//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'1.70 GB')]/ancestor::md-option"))
                .click();



        //normalize-space(.)='Machine type'])[1]/following::div[1]



    }


}
