
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest1 {

  public static boolean debug = false;

  @Test
  public void test01() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test01"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    stackAr0.push((java.lang.Object)10);
    java.lang.Object obj6 = stackAr0.top();
    org.autotest.StackAr stackAr8 = new org.autotest.StackAr((int)'4');
    boolean b9 = stackAr8.isFull();
    boolean b10 = stackAr0.equals((java.lang.Object)stackAr8);
    boolean b11 = stackAr8.isFull();
    java.lang.String str12 = stackAr8.toString();
    boolean b13 = stackAr8.isFull();
    org.autotest.StackAr stackAr15 = new org.autotest.StackAr((int)(byte)10);
    java.lang.String str16 = stackAr15.toString();
    boolean b17 = stackAr15.isEmpty();
    org.autotest.StackAr stackAr18 = new org.autotest.StackAr();
    boolean b19 = stackAr18.isFull();
    boolean b20 = stackAr18.isFull();
    boolean b22 = stackAr18.equals((java.lang.Object)10.0f);
    int i23 = stackAr18.size();
    boolean b24 = stackAr18.isFull();
    boolean b25 = stackAr15.equals((java.lang.Object)stackAr18);
    stackAr8.push((java.lang.Object)stackAr18);
    org.autotest.StackAr stackAr28 = new org.autotest.StackAr((int)(byte)1);
    stackAr8.push((java.lang.Object)stackAr28);
    java.lang.String str30 = stackAr28.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj6 + "' != '" + 10+ "'", obj6.equals(10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b10 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str12 + "' != '" + "[]"+ "'", str12.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b13 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str16 + "' != '" + "[]"+ "'", str16.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b17 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b19 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b20 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b22 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i23 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b24 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b25 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str30 + "' != '" + "[]"+ "'", str30.equals("[]"));

  }

  @Test
  public void test02() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test02"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    java.lang.String str2 = stackAr0.toString();
    java.lang.String str3 = stackAr0.toString();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr();
    boolean b5 = stackAr4.isFull();
    java.lang.String str6 = stackAr4.toString();
    boolean b7 = stackAr4.isEmpty();
    boolean b8 = stackAr4.isEmpty();
    stackAr0.push((java.lang.Object)b8);
    boolean b10 = stackAr0.isFull();
    java.lang.String str11 = stackAr0.toString();
    java.lang.Object obj12 = stackAr0.top();
    boolean b13 = stackAr0.isEmpty();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[]"+ "'", str6.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b10 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str11 + "' != '" + "[true]"+ "'", str11.equals("[true]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj12 + "' != '" + true+ "'", obj12.equals(true));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b13 == false);

  }

  @Test
  public void test03() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test03"); }


    org.autotest.StackAr stackAr1 = new org.autotest.StackAr((int)'4');
    int i2 = stackAr1.size();
    org.autotest.StackAr stackAr3 = new org.autotest.StackAr();
    boolean b4 = stackAr3.isEmpty();
    org.autotest.StackAr stackAr5 = new org.autotest.StackAr();
    boolean b6 = stackAr5.isFull();
    boolean b7 = stackAr5.isFull();
    boolean b8 = stackAr3.equals((java.lang.Object)b7);
    org.autotest.StackAr stackAr9 = new org.autotest.StackAr();
    boolean b10 = stackAr9.isFull();
    java.lang.String str11 = stackAr9.toString();
    boolean b12 = stackAr9.isEmpty();
    org.autotest.StackAr stackAr13 = new org.autotest.StackAr();
    boolean b14 = stackAr13.isEmpty();
    java.lang.String str15 = stackAr13.toString();
    java.lang.String str16 = stackAr13.toString();
    int i17 = stackAr13.size();
    stackAr9.push((java.lang.Object)i17);
    java.lang.Object obj19 = stackAr9.top();
    stackAr3.push((java.lang.Object)stackAr9);
    org.autotest.StackAr stackAr21 = new org.autotest.StackAr();
    boolean b23 = stackAr21.equals((java.lang.Object)0);
    stackAr21.push((java.lang.Object)"[]");
    stackAr9.push((java.lang.Object)"[]");
    stackAr1.push((java.lang.Object)stackAr9);
    java.lang.Object obj28 = stackAr9.top();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b10 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str11 + "' != '" + "[]"+ "'", str11.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b12 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b14 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "[]"+ "'", str15.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str16 + "' != '" + "[]"+ "'", str16.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i17 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj19 + "' != '" + 0+ "'", obj19.equals(0));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b23 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj28 + "' != '" + "[]"+ "'", obj28.equals("[]"));

  }

  @Test
  public void test04() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test04"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    boolean b2 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr3 = new org.autotest.StackAr();
    boolean b4 = stackAr3.isFull();
    java.lang.String str5 = stackAr3.toString();
    boolean b7 = stackAr3.equals((java.lang.Object)(-1));
    boolean b8 = stackAr0.equals((java.lang.Object)stackAr3);
    org.autotest.StackAr stackAr10 = new org.autotest.StackAr((int)(byte)10);
    java.lang.String str11 = stackAr10.toString();
    stackAr3.push((java.lang.Object)str11);
    org.autotest.StackAr stackAr13 = new org.autotest.StackAr();
    boolean b14 = stackAr13.isFull();
    java.lang.String str15 = stackAr13.toString();
    boolean b16 = stackAr13.isEmpty();
    boolean b17 = stackAr13.isEmpty();
    org.autotest.StackAr stackAr18 = new org.autotest.StackAr();
    boolean b19 = stackAr18.isFull();
    java.lang.String str20 = stackAr18.toString();
    boolean b21 = stackAr18.isEmpty();
    stackAr18.push((java.lang.Object)10);
    java.lang.String str24 = stackAr18.toString();
    stackAr13.push((java.lang.Object)stackAr18);
    java.lang.String str26 = stackAr18.toString();
    org.autotest.StackAr stackAr27 = new org.autotest.StackAr();
    boolean b28 = stackAr27.isFull();
    boolean b29 = stackAr27.isFull();
    java.lang.String str30 = stackAr27.toString();
    boolean b31 = stackAr27.isEmpty();
    stackAr18.push((java.lang.Object)stackAr27);
    org.autotest.StackAr stackAr34 = new org.autotest.StackAr((int)' ');
    boolean b35 = stackAr34.isEmpty();
    stackAr18.push((java.lang.Object)stackAr34);
    boolean b37 = stackAr3.equals((java.lang.Object)stackAr18);
    java.lang.Object obj38 = stackAr3.top();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str11 + "' != '" + "[]"+ "'", str11.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b14 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "[]"+ "'", str15.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b16 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b17 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b19 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str20 + "' != '" + "[]"+ "'", str20.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b21 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str24 + "' != '" + "[10]"+ "'", str24.equals("[10]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str26 + "' != '" + "[10]"+ "'", str26.equals("[10]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b28 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b29 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str30 + "' != '" + "[]"+ "'", str30.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b31 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b35 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b37 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj38 + "' != '" + "[]"+ "'", obj38.equals("[]"));

  }

  @Test
  public void test05() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test05"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    stackAr0.push((java.lang.Object)100.0d);
    int i6 = stackAr0.size();
    java.lang.String str7 = stackAr0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[100.0]"+ "'", str7.equals("[100.0]"));

  }

  @Test
  public void test06() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test06"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    java.lang.String str1 = stackAr0.toString();
    int i2 = stackAr0.size();
    int i3 = stackAr0.size();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr();
    boolean b5 = stackAr4.isFull();
    boolean b6 = stackAr4.isFull();
    boolean b8 = stackAr4.equals((java.lang.Object)10.0f);
    org.autotest.StackAr stackAr9 = new org.autotest.StackAr();
    boolean b10 = stackAr9.isEmpty();
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isFull();
    java.lang.String str13 = stackAr11.toString();
    boolean b14 = stackAr11.isEmpty();
    boolean b15 = stackAr11.isEmpty();
    org.autotest.StackAr stackAr16 = new org.autotest.StackAr();
    boolean b17 = stackAr16.isFull();
    java.lang.String str18 = stackAr16.toString();
    boolean b19 = stackAr16.isEmpty();
    stackAr16.push((java.lang.Object)10);
    java.lang.String str22 = stackAr16.toString();
    stackAr11.push((java.lang.Object)stackAr16);
    stackAr9.push((java.lang.Object)stackAr16);
    boolean b25 = stackAr4.equals((java.lang.Object)stackAr9);
    boolean b26 = stackAr4.isEmpty();
    stackAr0.push((java.lang.Object)stackAr4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b10 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b12 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "[]"+ "'", str13.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b14 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b15 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b17 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str18 + "' != '" + "[]"+ "'", str18.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b19 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "[10]"+ "'", str22.equals("[10]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b25 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b26 == true);

  }

  @Test
  public void test07() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test07"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isFull();
    boolean b4 = stackAr2.isFull();
    boolean b5 = stackAr0.equals((java.lang.Object)b4);
    org.autotest.StackAr stackAr6 = new org.autotest.StackAr();
    boolean b7 = stackAr6.isFull();
    java.lang.String str8 = stackAr6.toString();
    boolean b9 = stackAr6.isEmpty();
    org.autotest.StackAr stackAr10 = new org.autotest.StackAr();
    boolean b11 = stackAr10.isEmpty();
    java.lang.String str12 = stackAr10.toString();
    java.lang.String str13 = stackAr10.toString();
    int i14 = stackAr10.size();
    stackAr6.push((java.lang.Object)i14);
    java.lang.Object obj16 = stackAr6.top();
    stackAr0.push((java.lang.Object)stackAr6);
    org.autotest.StackAr stackAr18 = new org.autotest.StackAr();
    boolean b20 = stackAr18.equals((java.lang.Object)0);
    stackAr18.push((java.lang.Object)"[]");
    stackAr6.push((java.lang.Object)"[]");
    java.lang.String str24 = stackAr6.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "[]"+ "'", str8.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str12 + "' != '" + "[]"+ "'", str12.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "[]"+ "'", str13.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i14 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj16 + "' != '" + 0+ "'", obj16.equals(0));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b20 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str24 + "' != '" + "[0,[]]"+ "'", str24.equals("[0,[]]"));

  }

  @Test
  public void test08() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test08"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    boolean b4 = stackAr0.isEmpty();
    boolean b5 = stackAr0.isEmpty();
    int i6 = stackAr0.size();
    int i7 = stackAr0.size();
    java.lang.String str8 = stackAr0.toString();
    boolean b9 = stackAr0.isFull();
    java.lang.String str10 = stackAr0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "[]"+ "'", str8.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str10 + "' != '" + "[]"+ "'", str10.equals("[]"));

  }

  @Test
  public void test09() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test09"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    stackAr0.push((java.lang.Object)10);
    java.lang.Object obj6 = stackAr0.top();
    org.autotest.StackAr stackAr8 = new org.autotest.StackAr((int)'4');
    boolean b9 = stackAr8.isFull();
    boolean b10 = stackAr0.equals((java.lang.Object)stackAr8);
    boolean b11 = stackAr8.isFull();
    java.lang.String str12 = stackAr8.toString();
    boolean b13 = stackAr8.isFull();
    org.autotest.StackAr stackAr15 = new org.autotest.StackAr((int)(byte)10);
    java.lang.String str16 = stackAr15.toString();
    boolean b17 = stackAr15.isEmpty();
    org.autotest.StackAr stackAr18 = new org.autotest.StackAr();
    boolean b19 = stackAr18.isFull();
    boolean b20 = stackAr18.isFull();
    boolean b22 = stackAr18.equals((java.lang.Object)10.0f);
    int i23 = stackAr18.size();
    boolean b24 = stackAr18.isFull();
    boolean b25 = stackAr15.equals((java.lang.Object)stackAr18);
    stackAr8.push((java.lang.Object)stackAr18);
    org.autotest.StackAr stackAr28 = new org.autotest.StackAr((int)(byte)1);
    stackAr8.push((java.lang.Object)stackAr28);
    org.autotest.StackAr stackAr30 = new org.autotest.StackAr();
    boolean b31 = stackAr30.isEmpty();
    boolean b33 = stackAr30.equals((java.lang.Object)100);
    org.autotest.StackAr stackAr35 = new org.autotest.StackAr((int)(byte)100);
    boolean b36 = stackAr35.isEmpty();
    stackAr30.push((java.lang.Object)stackAr35);
    boolean b38 = stackAr35.isFull();
    boolean b39 = stackAr28.equals((java.lang.Object)stackAr35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj6 + "' != '" + 10+ "'", obj6.equals(10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b10 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str12 + "' != '" + "[]"+ "'", str12.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b13 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str16 + "' != '" + "[]"+ "'", str16.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b17 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b19 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b20 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b22 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i23 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b24 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b25 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b31 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b33 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b36 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b38 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b39 == false);

  }

  @Test
  public void test10() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test10"); }


    org.autotest.StackAr stackAr1 = new org.autotest.StackAr((int)(byte)100);
    boolean b2 = stackAr1.isEmpty();
    boolean b3 = stackAr1.isEmpty();
    boolean b5 = stackAr1.equals((java.lang.Object)(-1));
    boolean b6 = stackAr1.isFull();
    java.lang.String str7 = stackAr1.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[]"+ "'", str7.equals("[]"));

  }

  @Test
  public void test11() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test11"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    java.lang.String str2 = stackAr0.toString();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr((int)(byte)100);
    boolean b5 = stackAr0.equals((java.lang.Object)stackAr4);
    org.autotest.StackAr stackAr6 = new org.autotest.StackAr();
    boolean b7 = stackAr6.isFull();
    java.lang.String str8 = stackAr6.toString();
    boolean b9 = stackAr6.isEmpty();
    stackAr6.push((java.lang.Object)10);
    java.lang.String str12 = stackAr6.toString();
    org.autotest.StackAr stackAr13 = new org.autotest.StackAr();
    boolean b14 = stackAr13.isEmpty();
    java.lang.String str15 = stackAr13.toString();
    java.lang.String str16 = stackAr13.toString();
    boolean b17 = stackAr13.isEmpty();
    org.autotest.StackAr stackAr18 = new org.autotest.StackAr();
    boolean b19 = stackAr18.isEmpty();
    java.lang.String str20 = stackAr18.toString();
    java.lang.String str21 = stackAr18.toString();
    org.autotest.StackAr stackAr22 = new org.autotest.StackAr();
    boolean b23 = stackAr22.isFull();
    boolean b24 = stackAr18.equals((java.lang.Object)stackAr22);
    boolean b25 = stackAr18.isFull();
    stackAr13.push((java.lang.Object)stackAr18);
    boolean b27 = stackAr6.equals((java.lang.Object)stackAr13);
    boolean b28 = stackAr0.equals((java.lang.Object)stackAr13);
    boolean b29 = stackAr13.isFull();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "[]"+ "'", str8.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str12 + "' != '" + "[10]"+ "'", str12.equals("[10]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b14 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "[]"+ "'", str15.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str16 + "' != '" + "[]"+ "'", str16.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b17 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b19 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str20 + "' != '" + "[]"+ "'", str20.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "[]"+ "'", str21.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b23 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b24 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b25 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b27 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b28 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b29 == false);

  }

  @Test
  public void test12() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test12"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isFull();
    boolean b4 = stackAr2.isFull();
    boolean b5 = stackAr0.equals((java.lang.Object)b4);
    org.autotest.StackAr stackAr6 = new org.autotest.StackAr();
    boolean b7 = stackAr6.isEmpty();
    java.lang.String str8 = stackAr6.toString();
    java.lang.String str9 = stackAr6.toString();
    org.autotest.StackAr stackAr10 = new org.autotest.StackAr();
    boolean b11 = stackAr10.isFull();
    boolean b12 = stackAr6.equals((java.lang.Object)stackAr10);
    int i13 = stackAr6.size();
    boolean b14 = stackAr0.equals((java.lang.Object)stackAr6);
    org.autotest.StackAr stackAr15 = new org.autotest.StackAr();
    boolean b16 = stackAr15.isEmpty();
    org.autotest.StackAr stackAr17 = new org.autotest.StackAr();
    boolean b18 = stackAr17.isEmpty();
    java.lang.String str19 = stackAr17.toString();
    java.lang.String str20 = stackAr17.toString();
    int i21 = stackAr17.size();
    boolean b22 = stackAr15.equals((java.lang.Object)stackAr17);
    int i23 = stackAr15.size();
    org.autotest.StackAr stackAr24 = new org.autotest.StackAr();
    boolean b25 = stackAr24.isEmpty();
    org.autotest.StackAr stackAr26 = new org.autotest.StackAr();
    boolean b27 = stackAr26.isFull();
    boolean b28 = stackAr26.isFull();
    boolean b29 = stackAr24.equals((java.lang.Object)b28);
    org.autotest.StackAr stackAr30 = new org.autotest.StackAr();
    boolean b31 = stackAr30.isEmpty();
    java.lang.String str32 = stackAr30.toString();
    java.lang.String str33 = stackAr30.toString();
    org.autotest.StackAr stackAr34 = new org.autotest.StackAr();
    boolean b35 = stackAr34.isFull();
    boolean b36 = stackAr30.equals((java.lang.Object)stackAr34);
    java.lang.String str37 = stackAr30.toString();
    stackAr24.push((java.lang.Object)stackAr30);
    boolean b39 = stackAr15.equals((java.lang.Object)stackAr24);
    boolean b40 = stackAr15.isEmpty();
    boolean b41 = stackAr6.equals((java.lang.Object)stackAr15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "[]"+ "'", str8.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str9 + "' != '" + "[]"+ "'", str9.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b12 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i13 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b14 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b16 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b18 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str19 + "' != '" + "[]"+ "'", str19.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str20 + "' != '" + "[]"+ "'", str20.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b22 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i23 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b25 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b27 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b28 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b29 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b31 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str32 + "' != '" + "[]"+ "'", str32.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str33 + "' != '" + "[]"+ "'", str33.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b35 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b36 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str37 + "' != '" + "[]"+ "'", str37.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b39 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b40 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b41 == true);

  }

  @Test
  public void test13() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test13"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr();
    boolean b5 = stackAr4.isFull();
    java.lang.String str6 = stackAr4.toString();
    boolean b7 = stackAr4.isEmpty();
    stackAr4.push((java.lang.Object)10);
    boolean b10 = stackAr0.equals((java.lang.Object)stackAr4);
    java.lang.Object obj11 = stackAr4.top();
    boolean b12 = stackAr4.isEmpty();
    org.autotest.StackAr stackAr13 = new org.autotest.StackAr();
    boolean b14 = stackAr13.isFull();
    java.lang.String str15 = stackAr13.toString();
    boolean b16 = stackAr13.isEmpty();
    boolean b17 = stackAr13.isEmpty();
    org.autotest.StackAr stackAr18 = new org.autotest.StackAr();
    boolean b19 = stackAr18.isFull();
    java.lang.String str20 = stackAr18.toString();
    boolean b21 = stackAr18.isEmpty();
    stackAr18.push((java.lang.Object)10);
    java.lang.String str24 = stackAr18.toString();
    stackAr13.push((java.lang.Object)stackAr18);
    java.lang.String str26 = stackAr18.toString();
    java.lang.Object obj27 = stackAr18.top();
    java.lang.Object obj28 = stackAr18.top();
    org.autotest.StackAr stackAr29 = new org.autotest.StackAr();
    boolean b30 = stackAr29.isEmpty();
    org.autotest.StackAr stackAr31 = new org.autotest.StackAr();
    boolean b32 = stackAr31.isEmpty();
    java.lang.String str33 = stackAr31.toString();
    java.lang.String str34 = stackAr31.toString();
    int i35 = stackAr31.size();
    boolean b36 = stackAr29.equals((java.lang.Object)stackAr31);
    boolean b37 = stackAr31.isFull();
    int i38 = stackAr31.size();
    stackAr18.push((java.lang.Object)i38);
    java.lang.Object obj40 = stackAr18.top();
    boolean b41 = stackAr18.isFull();
    boolean b42 = stackAr4.equals((java.lang.Object)stackAr18);
    boolean b43 = stackAr18.isEmpty();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[]"+ "'", str6.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b10 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj11 + "' != '" + 10+ "'", obj11.equals(10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b12 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b14 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "[]"+ "'", str15.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b16 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b17 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b19 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str20 + "' != '" + "[]"+ "'", str20.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b21 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str24 + "' != '" + "[10]"+ "'", str24.equals("[10]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str26 + "' != '" + "[10]"+ "'", str26.equals("[10]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj27 + "' != '" + 10+ "'", obj27.equals(10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj28 + "' != '" + 10+ "'", obj28.equals(10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b30 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b32 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str33 + "' != '" + "[]"+ "'", str33.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str34 + "' != '" + "[]"+ "'", str34.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i35 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b36 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b37 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i38 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj40 + "' != '" + 0+ "'", obj40.equals(0));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b41 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b42 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b43 == false);

  }

  @Test
  public void test14() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test14"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b2 = stackAr0.equals((java.lang.Object)0);
    org.autotest.StackAr stackAr3 = new org.autotest.StackAr();
    boolean b4 = stackAr3.isFull();
    java.lang.String str5 = stackAr3.toString();
    boolean b6 = stackAr3.isEmpty();
    boolean b7 = stackAr3.isEmpty();
    org.autotest.StackAr stackAr8 = new org.autotest.StackAr();
    boolean b9 = stackAr8.isFull();
    java.lang.String str10 = stackAr8.toString();
    boolean b11 = stackAr8.isEmpty();
    stackAr8.push((java.lang.Object)10);
    java.lang.String str14 = stackAr8.toString();
    stackAr3.push((java.lang.Object)stackAr8);
    stackAr0.push((java.lang.Object)stackAr3);
    org.autotest.StackAr stackAr17 = new org.autotest.StackAr();
    boolean b18 = stackAr17.isEmpty();
    org.autotest.StackAr stackAr19 = new org.autotest.StackAr();
    boolean b20 = stackAr19.isFull();
    boolean b21 = stackAr19.isFull();
    boolean b22 = stackAr17.equals((java.lang.Object)b21);
    org.autotest.StackAr stackAr23 = new org.autotest.StackAr();
    boolean b24 = stackAr23.isEmpty();
    java.lang.String str25 = stackAr23.toString();
    java.lang.String str26 = stackAr23.toString();
    org.autotest.StackAr stackAr27 = new org.autotest.StackAr();
    boolean b28 = stackAr27.isFull();
    boolean b29 = stackAr23.equals((java.lang.Object)stackAr27);
    java.lang.String str30 = stackAr23.toString();
    stackAr17.push((java.lang.Object)stackAr23);
    org.autotest.StackAr stackAr32 = new org.autotest.StackAr();
    boolean b33 = stackAr32.isFull();
    org.autotest.StackAr stackAr34 = new org.autotest.StackAr();
    boolean b35 = stackAr34.isEmpty();
    org.autotest.StackAr stackAr36 = new org.autotest.StackAr();
    boolean b37 = stackAr36.isEmpty();
    java.lang.String str38 = stackAr36.toString();
    java.lang.String str39 = stackAr36.toString();
    int i40 = stackAr36.size();
    boolean b41 = stackAr34.equals((java.lang.Object)stackAr36);
    stackAr32.push((java.lang.Object)stackAr36);
    int i43 = stackAr32.size();
    stackAr23.push((java.lang.Object)i43);
    boolean b45 = stackAr3.equals((java.lang.Object)stackAr23);
    org.autotest.StackAr stackAr47 = new org.autotest.StackAr((int)'4');
    stackAr23.push((java.lang.Object)'4');
    java.lang.Object obj49 = null;
    boolean b50 = stackAr23.equals(obj49);
    java.lang.String str51 = stackAr23.toString();
    org.autotest.StackAr stackAr52 = new org.autotest.StackAr();
    boolean b53 = stackAr52.isEmpty();
    boolean b54 = stackAr52.isEmpty();
    org.autotest.StackAr stackAr55 = new org.autotest.StackAr();
    boolean b56 = stackAr55.isFull();
    java.lang.String str57 = stackAr55.toString();
    boolean b59 = stackAr55.equals((java.lang.Object)(-1));
    boolean b60 = stackAr52.equals((java.lang.Object)stackAr55);
    org.autotest.StackAr stackAr62 = new org.autotest.StackAr((int)(byte)10);
    java.lang.String str63 = stackAr62.toString();
    stackAr55.push((java.lang.Object)str63);
    org.autotest.StackAr stackAr65 = new org.autotest.StackAr();
    boolean b66 = stackAr65.isFull();
    java.lang.String str67 = stackAr65.toString();
    boolean b68 = stackAr65.isEmpty();
    boolean b69 = stackAr65.isEmpty();
    org.autotest.StackAr stackAr70 = new org.autotest.StackAr();
    boolean b71 = stackAr70.isFull();
    java.lang.String str72 = stackAr70.toString();
    boolean b73 = stackAr70.isEmpty();
    stackAr70.push((java.lang.Object)10);
    java.lang.String str76 = stackAr70.toString();
    stackAr65.push((java.lang.Object)stackAr70);
    java.lang.String str78 = stackAr70.toString();
    org.autotest.StackAr stackAr79 = new org.autotest.StackAr();
    boolean b80 = stackAr79.isFull();
    boolean b81 = stackAr79.isFull();
    java.lang.String str82 = stackAr79.toString();
    boolean b83 = stackAr79.isEmpty();
    stackAr70.push((java.lang.Object)stackAr79);
    org.autotest.StackAr stackAr86 = new org.autotest.StackAr((int)' ');
    boolean b87 = stackAr86.isEmpty();
    stackAr70.push((java.lang.Object)stackAr86);
    boolean b89 = stackAr55.equals((java.lang.Object)stackAr70);
    boolean b90 = stackAr70.isEmpty();
    stackAr23.push((java.lang.Object)stackAr70);
    boolean b92 = stackAr23.isEmpty();
    int i93 = stackAr23.size();
    java.lang.String str94 = stackAr23.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str10 + "' != '" + "[]"+ "'", str10.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "[10]"+ "'", str14.equals("[10]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b18 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b20 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b21 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b22 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b24 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str25 + "' != '" + "[]"+ "'", str25.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str26 + "' != '" + "[]"+ "'", str26.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b28 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b29 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str30 + "' != '" + "[]"+ "'", str30.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b33 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b35 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b37 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str38 + "' != '" + "[]"+ "'", str38.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str39 + "' != '" + "[]"+ "'", str39.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i40 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b41 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i43 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b45 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b50 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str51 + "' != '" + "[1,4]"+ "'", str51.equals("[1,4]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b53 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b54 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b56 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str57 + "' != '" + "[]"+ "'", str57.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b59 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b60 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str63 + "' != '" + "[]"+ "'", str63.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b66 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str67 + "' != '" + "[]"+ "'", str67.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b68 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b69 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b71 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str72 + "' != '" + "[]"+ "'", str72.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b73 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str76 + "' != '" + "[10]"+ "'", str76.equals("[10]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str78 + "' != '" + "[10]"+ "'", str78.equals("[10]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b80 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b81 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str82 + "' != '" + "[]"+ "'", str82.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b83 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b87 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b89 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b90 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b92 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i93 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str94 + "' != '" + "[1,4,[10,[],[]]]"+ "'", str94.equals("[1,4,[10,[],[]]]"));

  }

  @Test
  public void test15() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test15"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isEmpty();
    java.lang.String str4 = stackAr2.toString();
    java.lang.String str5 = stackAr2.toString();
    int i6 = stackAr2.size();
    boolean b7 = stackAr0.equals((java.lang.Object)stackAr2);
    int i8 = stackAr0.size();
    boolean b10 = stackAr0.equals((java.lang.Object)(-1));
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Object obj11 = stackAr0.top();
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException");
    } catch (java.lang.IllegalStateException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.IllegalStateException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "[]"+ "'", str4.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i8 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b10 == false);

  }

  @Test
  public void test16() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test16"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    boolean b4 = stackAr0.isEmpty();
    boolean b5 = stackAr0.isEmpty();
    int i6 = stackAr0.size();
    boolean b7 = stackAr0.isEmpty();
    int i8 = stackAr0.size();
    org.autotest.StackAr stackAr9 = new org.autotest.StackAr();
    boolean b10 = stackAr9.isEmpty();
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isFull();
    boolean b13 = stackAr11.isFull();
    boolean b14 = stackAr9.equals((java.lang.Object)b13);
    org.autotest.StackAr stackAr15 = new org.autotest.StackAr();
    boolean b16 = stackAr15.isEmpty();
    java.lang.String str17 = stackAr15.toString();
    java.lang.String str18 = stackAr15.toString();
    org.autotest.StackAr stackAr19 = new org.autotest.StackAr();
    boolean b20 = stackAr19.isFull();
    boolean b21 = stackAr15.equals((java.lang.Object)stackAr19);
    boolean b22 = stackAr9.equals((java.lang.Object)stackAr15);
    int i23 = stackAr15.size();
    org.autotest.StackAr stackAr24 = new org.autotest.StackAr();
    boolean b25 = stackAr24.isEmpty();
    java.lang.String str26 = stackAr24.toString();
    int i27 = stackAr24.size();
    boolean b28 = stackAr24.isFull();
    boolean b29 = stackAr15.equals((java.lang.Object)stackAr24);
    java.lang.String str30 = stackAr15.toString();
    java.lang.String str31 = stackAr15.toString();
    stackAr0.push((java.lang.Object)str31);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i8 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b10 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b12 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b13 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b14 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b16 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str17 + "' != '" + "[]"+ "'", str17.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str18 + "' != '" + "[]"+ "'", str18.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b20 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b21 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b22 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i23 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b25 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str26 + "' != '" + "[]"+ "'", str26.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b28 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b29 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str30 + "' != '" + "[]"+ "'", str30.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str31 + "' != '" + "[]"+ "'", str31.equals("[]"));

  }

  @Test
  public void test17() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test17"); }


    org.autotest.StackAr stackAr1 = new org.autotest.StackAr((int)(byte)0);
    boolean b2 = stackAr1.isEmpty();
    boolean b4 = stackAr1.equals((java.lang.Object)100);
    int i5 = stackAr1.size();
    java.lang.String str6 = stackAr1.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[]"+ "'", str6.equals("[]"));

  }

  @Test
  public void test18() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test18"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isFull();
    boolean b4 = stackAr2.isFull();
    boolean b5 = stackAr0.equals((java.lang.Object)b4);
    org.autotest.StackAr stackAr6 = new org.autotest.StackAr();
    boolean b7 = stackAr6.isFull();
    java.lang.String str8 = stackAr6.toString();
    boolean b9 = stackAr6.isEmpty();
    org.autotest.StackAr stackAr10 = new org.autotest.StackAr();
    boolean b11 = stackAr10.isEmpty();
    java.lang.String str12 = stackAr10.toString();
    java.lang.String str13 = stackAr10.toString();
    int i14 = stackAr10.size();
    stackAr6.push((java.lang.Object)i14);
    java.lang.Object obj16 = stackAr6.top();
    stackAr0.push((java.lang.Object)stackAr6);
    java.lang.String str18 = stackAr0.toString();
    org.autotest.StackAr stackAr20 = new org.autotest.StackAr((int)(short)10);
    boolean b21 = stackAr20.isEmpty();
    boolean b23 = stackAr20.equals((java.lang.Object)(short)100);
    boolean b24 = stackAr0.equals((java.lang.Object)b23);
    boolean b25 = stackAr0.isFull();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "[]"+ "'", str8.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str12 + "' != '" + "[]"+ "'", str12.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "[]"+ "'", str13.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i14 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj16 + "' != '" + 0+ "'", obj16.equals(0));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str18 + "' != '" + "[[0]]"+ "'", str18.equals("[[0]]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b21 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b23 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b24 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b25 == false);

  }

  @Test
  public void test19() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test19"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    boolean b2 = stackAr0.isFull();
    java.lang.String str3 = stackAr0.toString();
    org.autotest.StackAr stackAr5 = new org.autotest.StackAr((int)(byte)100);
    boolean b6 = stackAr5.isEmpty();
    boolean b7 = stackAr0.equals((java.lang.Object)b6);
    org.autotest.StackAr stackAr8 = new org.autotest.StackAr();
    boolean b9 = stackAr8.isFull();
    java.lang.String str10 = stackAr8.toString();
    boolean b11 = stackAr8.isEmpty();
    org.autotest.StackAr stackAr12 = new org.autotest.StackAr();
    boolean b13 = stackAr12.isEmpty();
    java.lang.String str14 = stackAr12.toString();
    java.lang.String str15 = stackAr12.toString();
    int i16 = stackAr12.size();
    stackAr8.push((java.lang.Object)i16);
    int i18 = stackAr8.size();
    boolean b19 = stackAr8.isFull();
    stackAr0.push((java.lang.Object)b19);
    int i21 = stackAr0.size();
    org.autotest.StackAr stackAr23 = new org.autotest.StackAr((int)(byte)100);
    boolean b24 = stackAr23.isEmpty();
    boolean b25 = stackAr23.isEmpty();
    boolean b27 = stackAr23.equals((java.lang.Object)(-1));
    int i28 = stackAr23.size();
    stackAr23.push((java.lang.Object)"hi!");
    int i31 = stackAr23.size();
    boolean b32 = stackAr23.isFull();
    stackAr0.push((java.lang.Object)stackAr23);
    boolean b34 = stackAr0.isEmpty();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str10 + "' != '" + "[]"+ "'", str10.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b13 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "[]"+ "'", str14.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "[]"+ "'", str15.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i16 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b19 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b24 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b25 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b27 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i28 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i31 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b32 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b34 == false);

  }

  @Test
  public void test20() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test20"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isFull();
    boolean b4 = stackAr2.isFull();
    boolean b5 = stackAr0.equals((java.lang.Object)b4);
    org.autotest.StackAr stackAr6 = new org.autotest.StackAr();
    boolean b7 = stackAr6.isFull();
    java.lang.String str8 = stackAr6.toString();
    boolean b9 = stackAr6.isEmpty();
    org.autotest.StackAr stackAr10 = new org.autotest.StackAr();
    boolean b11 = stackAr10.isEmpty();
    java.lang.String str12 = stackAr10.toString();
    java.lang.String str13 = stackAr10.toString();
    int i14 = stackAr10.size();
    stackAr6.push((java.lang.Object)i14);
    java.lang.Object obj16 = stackAr6.top();
    stackAr0.push((java.lang.Object)stackAr6);
    org.autotest.StackAr stackAr18 = new org.autotest.StackAr();
    boolean b19 = stackAr18.isFull();
    java.lang.String str20 = stackAr18.toString();
    boolean b21 = stackAr18.isEmpty();
    boolean b22 = stackAr18.isEmpty();
    org.autotest.StackAr stackAr23 = new org.autotest.StackAr();
    boolean b24 = stackAr23.isFull();
    java.lang.String str25 = stackAr23.toString();
    boolean b26 = stackAr23.isEmpty();
    stackAr23.push((java.lang.Object)10);
    java.lang.String str29 = stackAr23.toString();
    stackAr18.push((java.lang.Object)stackAr23);
    boolean b31 = stackAr18.isEmpty();
    boolean b32 = stackAr6.equals((java.lang.Object)b31);
    org.autotest.StackAr stackAr34 = new org.autotest.StackAr((int)(byte)100);
    boolean b35 = stackAr34.isEmpty();
    boolean b36 = stackAr34.isEmpty();
    int i37 = stackAr34.size();
    org.autotest.StackAr stackAr38 = new org.autotest.StackAr();
    boolean b39 = stackAr38.isFull();
    java.lang.String str40 = stackAr38.toString();
    boolean b41 = stackAr38.isEmpty();
    org.autotest.StackAr stackAr42 = new org.autotest.StackAr();
    boolean b43 = stackAr42.isFull();
    org.autotest.StackAr stackAr44 = new org.autotest.StackAr();
    boolean b45 = stackAr44.isEmpty();
    org.autotest.StackAr stackAr46 = new org.autotest.StackAr();
    boolean b47 = stackAr46.isEmpty();
    java.lang.String str48 = stackAr46.toString();
    java.lang.String str49 = stackAr46.toString();
    int i50 = stackAr46.size();
    boolean b51 = stackAr44.equals((java.lang.Object)stackAr46);
    stackAr42.push((java.lang.Object)stackAr46);
    boolean b53 = stackAr38.equals((java.lang.Object)stackAr42);
    stackAr34.push((java.lang.Object)b53);
    stackAr6.push((java.lang.Object)stackAr34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "[]"+ "'", str8.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str12 + "' != '" + "[]"+ "'", str12.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "[]"+ "'", str13.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i14 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + obj16 + "' != '" + 0+ "'", obj16.equals(0));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b19 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str20 + "' != '" + "[]"+ "'", str20.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b21 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b22 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b24 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str25 + "' != '" + "[]"+ "'", str25.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b26 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str29 + "' != '" + "[10]"+ "'", str29.equals("[10]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b31 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b32 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b35 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b36 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i37 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b39 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str40 + "' != '" + "[]"+ "'", str40.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b41 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b43 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b45 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b47 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str48 + "' != '" + "[]"+ "'", str48.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str49 + "' != '" + "[]"+ "'", str49.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i50 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b51 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b53 == false);

  }

}
