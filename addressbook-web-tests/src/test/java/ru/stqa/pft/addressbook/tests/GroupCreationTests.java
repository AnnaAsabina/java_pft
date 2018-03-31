package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().initGroupCreation();
    GroupData group = new GroupData().withName("test1");
    app.group().fillGroupForm(group);
    app.group().submitGroupCreation();
    app.group().returnToGroupPage();
    Groups after = app.group().all();
    assertThat(after.size(),equalTo(before.size()+1));



    assertThat(after, equalTo
            (before.withAdded(group.withId((after.stream().mapToInt((g)-> g.getId()).max().getAsInt())))));


   /*before.add(group);
    Comparator<? super GroupData> byId = (g1,g2)-> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);/* это сортировка по ID внутри списка, но мы какого-то хрена все поменяли на множества
  }
*/
  }
}