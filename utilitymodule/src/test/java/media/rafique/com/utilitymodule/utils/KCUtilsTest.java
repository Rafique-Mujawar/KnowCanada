package media.rafique.com.utilitymodule.utils;

import android.text.TextUtils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import media.rafique.com.utilitymodule.data.HomeResponseItem;

import static org.mockito.Matchers.any;

/**
 * @author Rafique Mujawar
 * Date 19-11-2018
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(TextUtils.class)
public class KCUtilsTest {

  @Before
  public void setup() {
    PowerMockito.mockStatic(TextUtils.class);
    PowerMockito.when(TextUtils.isEmpty(any(CharSequence.class))).thenAnswer(new Answer<Boolean>() {
      @Override
      public Boolean answer(InvocationOnMock invocation) {
        CharSequence a = (CharSequence) invocation.getArguments()[0];
        return !(a != null && a.length() > 0);
      }
    });
  }

  @Test
  public void testValidFactItemWithValidTitle() {
    HomeResponseItem item = new HomeResponseItem();
    item.setTitle("Test title");
    Assert.assertTrue(KCUtils.isValidFactItem(item));
  }

  @Test
  public void testValidFactItemWithValidDescription() {
    HomeResponseItem item = new HomeResponseItem();
    item.setDescription("Test description");
    Assert.assertTrue(KCUtils.isValidFactItem(item));
  }

  @Test
  public void testValidFactItemWithValidHref() {
    HomeResponseItem item = new HomeResponseItem();
    item.setImageHref("Test image link");
    Assert.assertTrue(KCUtils.isValidFactItem(item));
  }

  @Test
  public void testValidFactItemWithInValidData() {
    HomeResponseItem item = new HomeResponseItem();
    Assert.assertFalse(KCUtils.isValidFactItem(item));
  }

  @Test
  public void testValidFactItemWithNullData() {
    HomeResponseItem item = null;
    Assert.assertFalse(KCUtils.isValidFactItem(item));
  }
}
