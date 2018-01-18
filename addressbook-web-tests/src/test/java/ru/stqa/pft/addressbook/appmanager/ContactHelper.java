package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactHelper extends HelperBase{


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData objectData, boolean creation) {

    type(By.name("firstname"), objectData.getName());
    type(By.name("middlename"), objectData.getMiddleName());
    type(By.name("lastname"), objectData.getLastName());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(objectData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void submitEdition(){
    click(By.name("submit"));
  }

  public void initContactModification() {
    //click(By.id("1"));
    click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img"));
  }

  public void submitContactModification(){click(By.name("update"));
  }

  public void returnToHomePage() {click(By.linkText("home"));
  }
}
