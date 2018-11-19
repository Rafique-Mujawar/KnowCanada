package media.rafique.com.utilitymodule.utils;

import org.junit.Assert;
import org.junit.Test;

import media.rafique.com.utilitymodule.data.HomeResponseItem;

/**
 * @author Rafique Mujawar
 * Date 19-11-2018
 */
public class KCUtilsTest {

  @Test
  public void testValidFactItem1() {
    HomeResponseItem item = new HomeResponseItem();
    item.setTitle("Test title");
    Assert.assertEquals(true, KCUtils.isValidFactItem(item));
  }

  @Test
  public void testValidFactItem2() {
    HomeResponseItem item = new HomeResponseItem();
    item.setDescription("Test description");
    Assert.assertEquals(true, KCUtils.isValidFactItem(item));
  }

  @Test
  public void testValidFactItem3() {
    HomeResponseItem item = new HomeResponseItem();
    item.setImageHref("Test image link");
    Assert.assertEquals(true, KCUtils.isValidFactItem(item));
  }
}
