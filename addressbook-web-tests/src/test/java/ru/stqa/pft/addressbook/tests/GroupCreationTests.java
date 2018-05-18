package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader  reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml ="";
    String line = reader.readLine();
    while(line !=null){
      String[] split = line.split(";");
      list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
      xml += line;
      line =reader.readLine();
    }
    return list.iterator();


  }

  @Test (dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {

    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().initGroupCreation();
    app.group().fillGroupForm(group);
    app.group().submitGroupCreation();
    app.group().returnToGroupPage();
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo
            (before.withAdded(group.withId((after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))));


   /*before.add(group);
    Comparator<? super GroupData> byId = (g1,g2)-> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);/* это сортировка по ID внутри списка, но мы какого-то хрена все поменяли на множества
  }
*/
  }

  @Test(enabled=false)
  public void testBadGroupCreation() {

    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().initGroupCreation();
    GroupData group = new GroupData().withName("test1'");
    app.group().fillGroupForm(group);
    app.group().submitGroupCreation();
    app.group().returnToGroupPage();
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size()));


    assertThat(after, equalTo(before));
  }
}