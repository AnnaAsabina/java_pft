package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData objectData)
  { type(By.name("firstname"), objectData.getName());
    type(By.name("middlename"), objectData.getMiddleName());
    type(By.name ("lastname"), objectData.getLastName());

  }

  public void submitEdition(){
    click(By.name("home"));
  }
}
