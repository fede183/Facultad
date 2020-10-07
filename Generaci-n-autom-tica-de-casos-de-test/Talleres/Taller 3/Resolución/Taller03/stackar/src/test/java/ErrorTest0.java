
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErrorTest0 {

  public static boolean debug = false;

  @Test
  public void test01() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test01"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    boolean b4 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr5 = new org.autotest.StackAr();
    boolean b6 = stackAr5.isFull();
    java.lang.String str7 = stackAr5.toString();
    boolean b8 = stackAr5.isEmpty();
    stackAr5.push((java.lang.Object)10);
    java.lang.String str11 = stackAr5.toString();
    stackAr0.push((java.lang.Object)stackAr5);
    boolean b13 = stackAr0.isEmpty();
    java.lang.Object obj14 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test02() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test02"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isEmpty();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr();
    boolean b5 = stackAr4.isEmpty();
    java.lang.String str6 = stackAr4.toString();
    java.lang.String str7 = stackAr4.toString();
    int i8 = stackAr4.size();
    boolean b9 = stackAr2.equals((java.lang.Object)stackAr4);
    stackAr0.push((java.lang.Object)stackAr4);
    int i11 = stackAr0.size();
    java.lang.Object obj12 = stackAr0.top();
    java.lang.String str13 = stackAr0.toString();
    java.lang.Object obj14 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test03() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test03"); }


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
    boolean b17 = stackAr0.isFull();
    java.lang.Object obj18 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test04() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test04"); }


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
    boolean b11 = stackAr0.isFull();
    java.lang.Object obj12 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test05() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test05"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    stackAr0.push((java.lang.Object)10);
    java.lang.Object obj6 = stackAr0.top();
    org.autotest.StackAr stackAr8 = new org.autotest.StackAr((int)'4');
    boolean b9 = stackAr8.isFull();
    boolean b10 = stackAr0.equals((java.lang.Object)stackAr8);
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isEmpty();
    java.lang.String str13 = stackAr11.toString();
    java.lang.String str14 = stackAr11.toString();
    org.autotest.StackAr stackAr15 = new org.autotest.StackAr();
    boolean b16 = stackAr15.isFull();
    boolean b17 = stackAr11.equals((java.lang.Object)stackAr15);
    int i18 = stackAr15.size();
    stackAr8.push((java.lang.Object)stackAr15);
    java.lang.Object obj20 = stackAr8.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr8", stackAr8.repOK());

  }

  @Test
  public void test06() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test06"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    stackAr0.push((java.lang.Object)10);
    boolean b6 = stackAr0.isFull();
    boolean b7 = stackAr0.isEmpty();
    java.lang.Object obj8 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test07() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test07"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    java.lang.String str2 = stackAr0.toString();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr((int)(byte)100);
    boolean b5 = stackAr0.equals((java.lang.Object)stackAr4);
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr((int)(short)10);
    java.lang.String str8 = stackAr7.toString();
    stackAr0.push((java.lang.Object)str8);
    java.lang.String str10 = stackAr0.toString();
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isEmpty();
    boolean b13 = stackAr11.isEmpty();
    int i14 = stackAr11.size();
    boolean b15 = stackAr0.equals((java.lang.Object)i14);
    java.lang.Object obj16 = stackAr0.top();
    boolean b17 = stackAr0.isEmpty();
    java.lang.Object obj18 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test08() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test08"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isEmpty();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr();
    boolean b5 = stackAr4.isEmpty();
    java.lang.String str6 = stackAr4.toString();
    java.lang.String str7 = stackAr4.toString();
    int i8 = stackAr4.size();
    boolean b9 = stackAr2.equals((java.lang.Object)stackAr4);
    int i10 = stackAr2.size();
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isEmpty();
    org.autotest.StackAr stackAr13 = new org.autotest.StackAr();
    boolean b14 = stackAr13.isFull();
    boolean b15 = stackAr13.isFull();
    boolean b16 = stackAr11.equals((java.lang.Object)b15);
    org.autotest.StackAr stackAr17 = new org.autotest.StackAr();
    boolean b18 = stackAr17.isEmpty();
    java.lang.String str19 = stackAr17.toString();
    java.lang.String str20 = stackAr17.toString();
    org.autotest.StackAr stackAr21 = new org.autotest.StackAr();
    boolean b22 = stackAr21.isFull();
    boolean b23 = stackAr17.equals((java.lang.Object)stackAr21);
    java.lang.String str24 = stackAr17.toString();
    stackAr11.push((java.lang.Object)stackAr17);
    boolean b26 = stackAr2.equals((java.lang.Object)stackAr11);
    stackAr0.push((java.lang.Object)b26);
    java.lang.Object obj28 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test09() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test09"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isEmpty();
    java.lang.String str4 = stackAr2.toString();
    java.lang.String str5 = stackAr2.toString();
    int i6 = stackAr2.size();
    boolean b7 = stackAr0.equals((java.lang.Object)stackAr2);
    org.autotest.StackAr stackAr9 = new org.autotest.StackAr((int)(byte)100);
    java.lang.String str10 = stackAr9.toString();
    stackAr0.push((java.lang.Object)str10);
    java.lang.Object obj12 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test10() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test10"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isFull();
    java.lang.String str4 = stackAr2.toString();
    boolean b5 = stackAr2.isEmpty();
    boolean b6 = stackAr2.isEmpty();
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr();
    boolean b8 = stackAr7.isFull();
    java.lang.String str9 = stackAr7.toString();
    boolean b10 = stackAr7.isEmpty();
    stackAr7.push((java.lang.Object)10);
    java.lang.String str13 = stackAr7.toString();
    stackAr2.push((java.lang.Object)stackAr7);
    stackAr0.push((java.lang.Object)stackAr7);
    java.lang.Object obj16 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test11() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test11"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    java.lang.String str2 = stackAr0.toString();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr((int)(byte)100);
    boolean b5 = stackAr0.equals((java.lang.Object)stackAr4);
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr((int)(short)10);
    java.lang.String str8 = stackAr7.toString();
    stackAr0.push((java.lang.Object)str8);
    java.lang.String str10 = stackAr0.toString();
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isEmpty();
    boolean b13 = stackAr11.isEmpty();
    int i14 = stackAr11.size();
    boolean b15 = stackAr0.equals((java.lang.Object)i14);
    java.lang.Object obj16 = stackAr0.top();
    boolean b17 = stackAr0.isFull();
    java.lang.Object obj18 = stackAr0.top();
    java.lang.Object obj19 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test12() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test12"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr();
    boolean b5 = stackAr4.isEmpty();
    java.lang.String str6 = stackAr4.toString();
    java.lang.String str7 = stackAr4.toString();
    int i8 = stackAr4.size();
    stackAr0.push((java.lang.Object)i8);
    org.autotest.StackAr stackAr10 = new org.autotest.StackAr();
    boolean b11 = stackAr10.isFull();
    org.autotest.StackAr stackAr12 = new org.autotest.StackAr();
    boolean b13 = stackAr12.isEmpty();
    org.autotest.StackAr stackAr14 = new org.autotest.StackAr();
    boolean b15 = stackAr14.isEmpty();
    java.lang.String str16 = stackAr14.toString();
    java.lang.String str17 = stackAr14.toString();
    int i18 = stackAr14.size();
    boolean b19 = stackAr12.equals((java.lang.Object)stackAr14);
    stackAr10.push((java.lang.Object)stackAr14);
    boolean b21 = stackAr10.isEmpty();
    boolean b22 = stackAr0.equals((java.lang.Object)b21);
    org.autotest.StackAr stackAr23 = new org.autotest.StackAr();
    boolean b24 = stackAr23.isEmpty();
    org.autotest.StackAr stackAr25 = new org.autotest.StackAr();
    boolean b26 = stackAr25.isEmpty();
    java.lang.String str27 = stackAr25.toString();
    java.lang.String str28 = stackAr25.toString();
    int i29 = stackAr25.size();
    boolean b30 = stackAr23.equals((java.lang.Object)stackAr25);
    int i31 = stackAr23.size();
    org.autotest.StackAr stackAr32 = new org.autotest.StackAr();
    boolean b33 = stackAr32.isEmpty();
    org.autotest.StackAr stackAr34 = new org.autotest.StackAr();
    boolean b35 = stackAr34.isFull();
    boolean b36 = stackAr34.isFull();
    boolean b37 = stackAr32.equals((java.lang.Object)b36);
    org.autotest.StackAr stackAr38 = new org.autotest.StackAr();
    boolean b39 = stackAr38.isEmpty();
    java.lang.String str40 = stackAr38.toString();
    java.lang.String str41 = stackAr38.toString();
    org.autotest.StackAr stackAr42 = new org.autotest.StackAr();
    boolean b43 = stackAr42.isFull();
    boolean b44 = stackAr38.equals((java.lang.Object)stackAr42);
    java.lang.String str45 = stackAr38.toString();
    stackAr32.push((java.lang.Object)stackAr38);
    boolean b47 = stackAr23.equals((java.lang.Object)stackAr32);
    stackAr0.push((java.lang.Object)stackAr32);
    java.lang.Object obj49 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test13() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test13"); }


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
    java.lang.String str13 = stackAr6.toString();
    stackAr0.push((java.lang.Object)stackAr6);
    org.autotest.StackAr stackAr15 = new org.autotest.StackAr();
    boolean b16 = stackAr15.isFull();
    org.autotest.StackAr stackAr17 = new org.autotest.StackAr();
    boolean b18 = stackAr17.isEmpty();
    org.autotest.StackAr stackAr19 = new org.autotest.StackAr();
    boolean b20 = stackAr19.isEmpty();
    java.lang.String str21 = stackAr19.toString();
    java.lang.String str22 = stackAr19.toString();
    int i23 = stackAr19.size();
    boolean b24 = stackAr17.equals((java.lang.Object)stackAr19);
    stackAr15.push((java.lang.Object)stackAr19);
    int i26 = stackAr15.size();
    stackAr6.push((java.lang.Object)i26);
    boolean b28 = stackAr6.isEmpty();
    java.lang.Object obj29 = stackAr6.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr6", stackAr6.repOK());

  }

  @Test
  public void test14() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test14"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    boolean b4 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr5 = new org.autotest.StackAr();
    boolean b6 = stackAr5.isFull();
    java.lang.String str7 = stackAr5.toString();
    boolean b8 = stackAr5.isEmpty();
    stackAr5.push((java.lang.Object)10);
    java.lang.String str11 = stackAr5.toString();
    stackAr0.push((java.lang.Object)stackAr5);
    boolean b13 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr14 = new org.autotest.StackAr();
    boolean b15 = stackAr14.isEmpty();
    java.lang.String str16 = stackAr14.toString();
    java.lang.String str17 = stackAr14.toString();
    stackAr14.push((java.lang.Object)(-1.0f));
    stackAr0.push((java.lang.Object)stackAr14);
    java.lang.Object obj21 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test15() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test15"); }


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
    int i33 = stackAr6.size();
    java.lang.Object obj34 = stackAr6.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr6", stackAr6.repOK());

  }

  @Test
  public void test16() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test16"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    stackAr0.push((java.lang.Object)10);
    int i6 = stackAr0.size();
    java.lang.Object obj7 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test17() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test17"); }


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
    int i18 = stackAr0.size();
    java.lang.Object obj19 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test18() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test18"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isFull();
    java.lang.String str4 = stackAr2.toString();
    boolean b5 = stackAr2.isEmpty();
    boolean b6 = stackAr2.isEmpty();
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr();
    boolean b8 = stackAr7.isFull();
    java.lang.String str9 = stackAr7.toString();
    boolean b10 = stackAr7.isEmpty();
    stackAr7.push((java.lang.Object)10);
    java.lang.String str13 = stackAr7.toString();
    stackAr2.push((java.lang.Object)stackAr7);
    stackAr0.push((java.lang.Object)stackAr7);
    java.lang.Object obj16 = stackAr7.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr7", stackAr7.repOK());

  }

  @Test
  public void test19() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test19"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    stackAr0.push((java.lang.Object)10);
    java.lang.String str6 = stackAr0.toString();
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr();
    boolean b9 = stackAr7.equals((java.lang.Object)0);
    org.autotest.StackAr stackAr10 = new org.autotest.StackAr();
    boolean b11 = stackAr10.isFull();
    java.lang.String str12 = stackAr10.toString();
    boolean b13 = stackAr10.isEmpty();
    boolean b14 = stackAr10.isEmpty();
    org.autotest.StackAr stackAr15 = new org.autotest.StackAr();
    boolean b16 = stackAr15.isFull();
    java.lang.String str17 = stackAr15.toString();
    boolean b18 = stackAr15.isEmpty();
    stackAr15.push((java.lang.Object)10);
    java.lang.String str21 = stackAr15.toString();
    stackAr10.push((java.lang.Object)stackAr15);
    stackAr7.push((java.lang.Object)stackAr10);
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
    org.autotest.StackAr stackAr39 = new org.autotest.StackAr();
    boolean b40 = stackAr39.isFull();
    org.autotest.StackAr stackAr41 = new org.autotest.StackAr();
    boolean b42 = stackAr41.isEmpty();
    org.autotest.StackAr stackAr43 = new org.autotest.StackAr();
    boolean b44 = stackAr43.isEmpty();
    java.lang.String str45 = stackAr43.toString();
    java.lang.String str46 = stackAr43.toString();
    int i47 = stackAr43.size();
    boolean b48 = stackAr41.equals((java.lang.Object)stackAr43);
    stackAr39.push((java.lang.Object)stackAr43);
    int i50 = stackAr39.size();
    stackAr30.push((java.lang.Object)i50);
    boolean b52 = stackAr10.equals((java.lang.Object)stackAr30);
    org.autotest.StackAr stackAr54 = new org.autotest.StackAr((int)'4');
    stackAr30.push((java.lang.Object)'4');
    boolean b56 = stackAr0.equals((java.lang.Object)'4');
    int i57 = stackAr0.size();
    java.lang.Object obj58 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test20() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test20"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isEmpty();
    java.lang.String str4 = stackAr2.toString();
    java.lang.String str5 = stackAr2.toString();
    int i6 = stackAr2.size();
    boolean b7 = stackAr0.equals((java.lang.Object)stackAr2);
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
    java.lang.String str22 = stackAr15.toString();
    stackAr9.push((java.lang.Object)stackAr15);
    boolean b24 = stackAr0.equals((java.lang.Object)stackAr9);
    boolean b25 = stackAr9.isEmpty();
    java.lang.Object obj26 = stackAr9.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr9", stackAr9.repOK());

  }

  @Test
  public void test21() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test21"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    java.lang.String str2 = stackAr0.toString();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr((int)(byte)100);
    boolean b5 = stackAr0.equals((java.lang.Object)stackAr4);
    int i6 = stackAr0.size();
    boolean b7 = stackAr0.isFull();
    org.autotest.StackAr stackAr8 = new org.autotest.StackAr();
    boolean b9 = stackAr8.isEmpty();
    java.lang.String str10 = stackAr8.toString();
    java.lang.String str11 = stackAr8.toString();
    boolean b12 = stackAr8.isEmpty();
    org.autotest.StackAr stackAr13 = new org.autotest.StackAr();
    boolean b14 = stackAr13.isEmpty();
    java.lang.String str15 = stackAr13.toString();
    java.lang.String str16 = stackAr13.toString();
    org.autotest.StackAr stackAr17 = new org.autotest.StackAr();
    boolean b18 = stackAr17.isFull();
    boolean b19 = stackAr13.equals((java.lang.Object)stackAr17);
    boolean b20 = stackAr13.isFull();
    stackAr8.push((java.lang.Object)stackAr13);
    stackAr0.push((java.lang.Object)stackAr13);
    java.lang.Object obj23 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test22() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test22"); }


    org.autotest.StackAr stackAr1 = new org.autotest.StackAr((int)(byte)100);
    boolean b2 = stackAr1.isEmpty();
    boolean b3 = stackAr1.isEmpty();
    boolean b5 = stackAr1.equals((java.lang.Object)(-1));
    int i6 = stackAr1.size();
    stackAr1.push((java.lang.Object)"hi!");
    int i9 = stackAr1.size();
    boolean b10 = stackAr1.isFull();
    java.lang.Object obj11 = stackAr1.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr1", stackAr1.repOK());

  }

  @Test
  public void test23() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test23"); }


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
    java.lang.Object obj11 = stackAr4.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr4", stackAr4.repOK());

  }

  @Test
  public void test24() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test24"); }


    org.autotest.StackAr stackAr1 = new org.autotest.StackAr((int)(short)10);
    boolean b2 = stackAr1.isEmpty();
    org.autotest.StackAr stackAr3 = new org.autotest.StackAr();
    boolean b4 = stackAr3.isFull();
    boolean b5 = stackAr3.isFull();
    boolean b7 = stackAr3.equals((java.lang.Object)10.0f);
    int i8 = stackAr3.size();
    int i9 = stackAr3.size();
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr((int)(byte)10);
    boolean b12 = stackAr3.equals((java.lang.Object)stackAr11);
    stackAr1.push((java.lang.Object)b12);
    boolean b14 = stackAr1.isEmpty();
    java.lang.Object obj15 = stackAr1.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr1", stackAr1.repOK());

  }

  @Test
  public void test25() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test25"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    java.lang.String str2 = stackAr0.toString();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr((int)(byte)100);
    boolean b5 = stackAr0.equals((java.lang.Object)stackAr4);
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr((int)(short)10);
    java.lang.String str8 = stackAr7.toString();
    stackAr0.push((java.lang.Object)str8);
    java.lang.String str10 = stackAr0.toString();
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isEmpty();
    boolean b13 = stackAr11.isEmpty();
    int i14 = stackAr11.size();
    boolean b15 = stackAr0.equals((java.lang.Object)i14);
    java.lang.Object obj16 = stackAr0.top();
    boolean b17 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr18 = new org.autotest.StackAr();
    boolean b19 = stackAr18.isEmpty();
    org.autotest.StackAr stackAr20 = new org.autotest.StackAr();
    boolean b21 = stackAr20.isFull();
    boolean b22 = stackAr20.isFull();
    boolean b23 = stackAr18.equals((java.lang.Object)b22);
    org.autotest.StackAr stackAr24 = new org.autotest.StackAr();
    boolean b25 = stackAr24.isFull();
    java.lang.String str26 = stackAr24.toString();
    boolean b27 = stackAr24.isEmpty();
    org.autotest.StackAr stackAr28 = new org.autotest.StackAr();
    boolean b29 = stackAr28.isEmpty();
    java.lang.String str30 = stackAr28.toString();
    java.lang.String str31 = stackAr28.toString();
    int i32 = stackAr28.size();
    stackAr24.push((java.lang.Object)i32);
    java.lang.Object obj34 = stackAr24.top();
    stackAr18.push((java.lang.Object)stackAr24);
    java.lang.String str36 = stackAr18.toString();
    boolean b37 = stackAr0.equals((java.lang.Object)stackAr18);
    java.lang.Object obj38 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test26() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test26"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    boolean b4 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr5 = new org.autotest.StackAr();
    boolean b6 = stackAr5.isFull();
    java.lang.String str7 = stackAr5.toString();
    boolean b8 = stackAr5.isEmpty();
    stackAr5.push((java.lang.Object)10);
    java.lang.String str11 = stackAr5.toString();
    stackAr0.push((java.lang.Object)stackAr5);
    java.lang.String str13 = stackAr5.toString();
    org.autotest.StackAr stackAr14 = new org.autotest.StackAr();
    boolean b15 = stackAr14.isFull();
    boolean b16 = stackAr14.isFull();
    java.lang.String str17 = stackAr14.toString();
    boolean b18 = stackAr14.isEmpty();
    stackAr5.push((java.lang.Object)stackAr14);
    int i20 = stackAr5.size();
    org.autotest.StackAr stackAr21 = new org.autotest.StackAr();
    boolean b22 = stackAr21.isFull();
    java.lang.String str23 = stackAr21.toString();
    boolean b24 = stackAr21.isEmpty();
    stackAr21.push((java.lang.Object)10);
    java.lang.Object obj27 = stackAr21.top();
    stackAr5.push((java.lang.Object)stackAr21);
    java.lang.Object obj29 = stackAr21.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr21", stackAr21.repOK());

  }

  @Test
  public void test27() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test27"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    java.lang.String str2 = stackAr0.toString();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr((int)(byte)100);
    boolean b5 = stackAr0.equals((java.lang.Object)stackAr4);
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr((int)(short)10);
    java.lang.String str8 = stackAr7.toString();
    stackAr0.push((java.lang.Object)str8);
    java.lang.String str10 = stackAr0.toString();
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isEmpty();
    boolean b13 = stackAr11.isEmpty();
    int i14 = stackAr11.size();
    boolean b15 = stackAr0.equals((java.lang.Object)i14);
    java.lang.Object obj16 = stackAr0.top();
    boolean b17 = stackAr0.isFull();
    java.lang.Object obj18 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test28() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test28"); }


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
    boolean b33 = stackAr6.isFull();
    java.lang.Object obj34 = stackAr6.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr6", stackAr6.repOK());

  }

  @Test
  public void test29() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test29"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    stackAr0.push((java.lang.Object)10);
    java.lang.Object obj6 = stackAr0.top();
    org.autotest.StackAr stackAr8 = new org.autotest.StackAr((int)'4');
    boolean b9 = stackAr8.isFull();
    boolean b10 = stackAr0.equals((java.lang.Object)stackAr8);
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isFull();
    java.lang.String str13 = stackAr11.toString();
    boolean b14 = stackAr11.isEmpty();
    stackAr11.push((java.lang.Object)10);
    java.lang.String str17 = stackAr11.toString();
    org.autotest.StackAr stackAr18 = new org.autotest.StackAr();
    boolean b19 = stackAr18.isEmpty();
    java.lang.String str20 = stackAr18.toString();
    java.lang.String str21 = stackAr18.toString();
    boolean b22 = stackAr18.isEmpty();
    org.autotest.StackAr stackAr23 = new org.autotest.StackAr();
    boolean b24 = stackAr23.isEmpty();
    java.lang.String str25 = stackAr23.toString();
    java.lang.String str26 = stackAr23.toString();
    org.autotest.StackAr stackAr27 = new org.autotest.StackAr();
    boolean b28 = stackAr27.isFull();
    boolean b29 = stackAr23.equals((java.lang.Object)stackAr27);
    boolean b30 = stackAr23.isFull();
    stackAr18.push((java.lang.Object)stackAr23);
    boolean b32 = stackAr11.equals((java.lang.Object)stackAr18);
    int i33 = stackAr11.size();
    boolean b34 = stackAr8.equals((java.lang.Object)stackAr11);
    java.lang.Object obj35 = stackAr11.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr11", stackAr11.repOK());

  }

  @Test
  public void test30() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test30"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr();
    boolean b5 = stackAr4.isEmpty();
    java.lang.String str6 = stackAr4.toString();
    java.lang.String str7 = stackAr4.toString();
    int i8 = stackAr4.size();
    stackAr0.push((java.lang.Object)i8);
    int i10 = stackAr0.size();
    boolean b11 = stackAr0.isFull();
    java.lang.Object obj12 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test31() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test31"); }


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
    int i33 = stackAr6.size();
    int i34 = stackAr6.size();
    java.lang.Object obj35 = stackAr6.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr6", stackAr6.repOK());

  }

  @Test
  public void test32() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test32"); }


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
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isEmpty();
    java.lang.String str13 = stackAr11.toString();
    int i14 = stackAr11.size();
    stackAr0.push((java.lang.Object)i14);
    java.lang.String str16 = stackAr0.toString();
    java.lang.Object obj17 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test33() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test33"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isEmpty();
    java.lang.String str4 = stackAr2.toString();
    java.lang.String str5 = stackAr2.toString();
    int i6 = stackAr2.size();
    boolean b7 = stackAr0.equals((java.lang.Object)stackAr2);
    boolean b8 = stackAr2.isFull();
    org.autotest.StackAr stackAr10 = new org.autotest.StackAr((int)'4');
    java.lang.String str11 = stackAr10.toString();
    boolean b12 = stackAr2.equals((java.lang.Object)str11);
    org.autotest.StackAr stackAr13 = new org.autotest.StackAr();
    boolean b14 = stackAr13.isFull();
    java.lang.String str15 = stackAr13.toString();
    boolean b16 = stackAr13.isEmpty();
    stackAr13.push((java.lang.Object)10);
    boolean b19 = stackAr13.isFull();
    boolean b20 = stackAr13.isEmpty();
    stackAr2.push((java.lang.Object)stackAr13);
    java.lang.Object obj22 = stackAr2.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr2", stackAr2.repOK());

  }

  @Test
  public void test34() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test34"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    stackAr0.push((java.lang.Object)10);
    boolean b6 = stackAr0.isFull();
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr();
    boolean b8 = stackAr7.isFull();
    java.lang.String str9 = stackAr7.toString();
    boolean b10 = stackAr7.isEmpty();
    stackAr7.push((java.lang.Object)100.0d);
    boolean b13 = stackAr7.isEmpty();
    stackAr0.push((java.lang.Object)stackAr7);
    java.lang.Object obj15 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test35() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test35"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    boolean b3 = stackAr0.equals((java.lang.Object)100);
    org.autotest.StackAr stackAr5 = new org.autotest.StackAr((int)(byte)100);
    boolean b6 = stackAr5.isEmpty();
    stackAr0.push((java.lang.Object)stackAr5);
    java.lang.Object obj8 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test36() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test36"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isFull();
    java.lang.String str4 = stackAr2.toString();
    boolean b5 = stackAr2.isEmpty();
    boolean b6 = stackAr2.isEmpty();
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr();
    boolean b8 = stackAr7.isFull();
    java.lang.String str9 = stackAr7.toString();
    boolean b10 = stackAr7.isEmpty();
    stackAr7.push((java.lang.Object)10);
    java.lang.String str13 = stackAr7.toString();
    stackAr2.push((java.lang.Object)stackAr7);
    stackAr0.push((java.lang.Object)stackAr7);
    boolean b16 = stackAr0.isEmpty();
    java.lang.Object obj17 = stackAr0.top();
    java.lang.Object obj18 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test37() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test37"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    boolean b4 = stackAr0.isEmpty();
    boolean b5 = stackAr0.isEmpty();
    int i6 = stackAr0.size();
    int i7 = stackAr0.size();
    java.lang.String str8 = stackAr0.toString();
    org.autotest.StackAr stackAr9 = new org.autotest.StackAr();
    boolean b10 = stackAr9.isEmpty();
    java.lang.String str11 = stackAr9.toString();
    java.lang.String str12 = stackAr9.toString();
    int i13 = stackAr9.size();
    int i14 = stackAr9.size();
    stackAr0.push((java.lang.Object)stackAr9);
    java.lang.Object obj16 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test38() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test38"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isEmpty();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr();
    boolean b5 = stackAr4.isEmpty();
    java.lang.String str6 = stackAr4.toString();
    java.lang.String str7 = stackAr4.toString();
    int i8 = stackAr4.size();
    boolean b9 = stackAr2.equals((java.lang.Object)stackAr4);
    stackAr0.push((java.lang.Object)stackAr4);
    int i11 = stackAr0.size();
    java.lang.Object obj12 = stackAr0.top();
    org.autotest.StackAr stackAr13 = new org.autotest.StackAr();
    boolean b14 = stackAr13.isFull();
    org.autotest.StackAr stackAr15 = new org.autotest.StackAr();
    boolean b16 = stackAr15.isEmpty();
    org.autotest.StackAr stackAr17 = new org.autotest.StackAr();
    boolean b18 = stackAr17.isEmpty();
    java.lang.String str19 = stackAr17.toString();
    java.lang.String str20 = stackAr17.toString();
    int i21 = stackAr17.size();
    boolean b22 = stackAr15.equals((java.lang.Object)stackAr17);
    stackAr13.push((java.lang.Object)stackAr17);
    stackAr0.push((java.lang.Object)stackAr13);
    java.lang.Object obj25 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test39() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test39"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr();
    boolean b5 = stackAr4.isEmpty();
    java.lang.String str6 = stackAr4.toString();
    java.lang.String str7 = stackAr4.toString();
    int i8 = stackAr4.size();
    stackAr0.push((java.lang.Object)i8);
    boolean b10 = stackAr0.isFull();
    java.lang.Object obj11 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test40() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test40"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    java.lang.String str2 = stackAr0.toString();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr((int)(byte)100);
    boolean b5 = stackAr0.equals((java.lang.Object)stackAr4);
    int i6 = stackAr0.size();
    boolean b7 = stackAr0.isFull();
    boolean b8 = stackAr0.isFull();
    boolean b9 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr10 = new org.autotest.StackAr();
    boolean b11 = stackAr10.isEmpty();
    org.autotest.StackAr stackAr12 = new org.autotest.StackAr();
    boolean b13 = stackAr12.isFull();
    boolean b14 = stackAr12.isFull();
    boolean b15 = stackAr10.equals((java.lang.Object)b14);
    org.autotest.StackAr stackAr16 = new org.autotest.StackAr();
    boolean b17 = stackAr16.isEmpty();
    java.lang.String str18 = stackAr16.toString();
    java.lang.String str19 = stackAr16.toString();
    org.autotest.StackAr stackAr20 = new org.autotest.StackAr();
    boolean b21 = stackAr20.isFull();
    boolean b22 = stackAr16.equals((java.lang.Object)stackAr20);
    java.lang.String str23 = stackAr16.toString();
    stackAr10.push((java.lang.Object)stackAr16);
    org.autotest.StackAr stackAr25 = new org.autotest.StackAr();
    boolean b26 = stackAr25.isFull();
    org.autotest.StackAr stackAr27 = new org.autotest.StackAr();
    boolean b28 = stackAr27.isEmpty();
    org.autotest.StackAr stackAr29 = new org.autotest.StackAr();
    boolean b30 = stackAr29.isEmpty();
    java.lang.String str31 = stackAr29.toString();
    java.lang.String str32 = stackAr29.toString();
    int i33 = stackAr29.size();
    boolean b34 = stackAr27.equals((java.lang.Object)stackAr29);
    stackAr25.push((java.lang.Object)stackAr29);
    int i36 = stackAr25.size();
    stackAr16.push((java.lang.Object)i36);
    boolean b38 = stackAr16.isEmpty();
    stackAr0.push((java.lang.Object)stackAr16);
    java.lang.String str40 = stackAr0.toString();
    java.lang.Object obj41 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test41() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test41"); }


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
    java.lang.String str38 = stackAr3.toString();
    boolean b39 = stackAr3.isFull();
    java.lang.Object obj40 = stackAr3.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr3", stackAr3.repOK());

  }

  @Test
  public void test42() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test42"); }


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
    boolean b33 = stackAr6.isFull();
    boolean b34 = stackAr6.isEmpty();
    java.lang.Object obj35 = stackAr6.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr6", stackAr6.repOK());

  }

  @Test
  public void test43() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test43"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    boolean b4 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr5 = new org.autotest.StackAr();
    boolean b6 = stackAr5.isFull();
    java.lang.String str7 = stackAr5.toString();
    boolean b8 = stackAr5.isEmpty();
    stackAr5.push((java.lang.Object)10);
    java.lang.String str11 = stackAr5.toString();
    stackAr0.push((java.lang.Object)stackAr5);
    java.lang.String str13 = stackAr5.toString();
    org.autotest.StackAr stackAr14 = new org.autotest.StackAr();
    boolean b15 = stackAr14.isFull();
    boolean b16 = stackAr14.isFull();
    java.lang.String str17 = stackAr14.toString();
    boolean b18 = stackAr14.isEmpty();
    stackAr5.push((java.lang.Object)stackAr14);
    org.autotest.StackAr stackAr20 = new org.autotest.StackAr();
    boolean b21 = stackAr20.isFull();
    org.autotest.StackAr stackAr22 = new org.autotest.StackAr();
    boolean b23 = stackAr22.isEmpty();
    org.autotest.StackAr stackAr24 = new org.autotest.StackAr();
    boolean b25 = stackAr24.isEmpty();
    java.lang.String str26 = stackAr24.toString();
    java.lang.String str27 = stackAr24.toString();
    int i28 = stackAr24.size();
    boolean b29 = stackAr22.equals((java.lang.Object)stackAr24);
    stackAr20.push((java.lang.Object)stackAr24);
    boolean b31 = stackAr20.isEmpty();
    org.autotest.StackAr stackAr32 = new org.autotest.StackAr();
    boolean b34 = stackAr32.equals((java.lang.Object)0);
    boolean b35 = stackAr32.isEmpty();
    stackAr20.push((java.lang.Object)stackAr32);
    stackAr5.push((java.lang.Object)stackAr32);
    org.autotest.StackAr stackAr39 = new org.autotest.StackAr((int)(byte)100);
    boolean b40 = stackAr39.isEmpty();
    boolean b41 = stackAr39.isEmpty();
    boolean b43 = stackAr39.equals((java.lang.Object)(-1));
    int i44 = stackAr39.size();
    stackAr39.push((java.lang.Object)"hi!");
    int i47 = stackAr39.size();
    org.autotest.StackAr stackAr48 = new org.autotest.StackAr();
    java.lang.String str49 = stackAr48.toString();
    boolean b50 = stackAr48.isEmpty();
    int i51 = stackAr48.size();
    boolean b52 = stackAr39.equals((java.lang.Object)i51);
    stackAr32.push((java.lang.Object)stackAr39);
    org.autotest.StackAr stackAr54 = new org.autotest.StackAr();
    boolean b55 = stackAr54.isEmpty();
    boolean b56 = stackAr54.isEmpty();
    org.autotest.StackAr stackAr57 = new org.autotest.StackAr();
    boolean b58 = stackAr57.isFull();
    java.lang.String str59 = stackAr57.toString();
    boolean b61 = stackAr57.equals((java.lang.Object)(-1));
    boolean b62 = stackAr54.equals((java.lang.Object)stackAr57);
    org.autotest.StackAr stackAr63 = new org.autotest.StackAr();
    boolean b64 = stackAr63.isEmpty();
    org.autotest.StackAr stackAr65 = new org.autotest.StackAr();
    boolean b66 = stackAr65.isFull();
    boolean b67 = stackAr65.isFull();
    boolean b68 = stackAr63.equals((java.lang.Object)b67);
    int i69 = stackAr63.size();
    boolean b70 = stackAr63.isEmpty();
    stackAr57.push((java.lang.Object)stackAr63);
    boolean b72 = stackAr39.equals((java.lang.Object)stackAr63);
    java.lang.Object obj73 = stackAr39.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr39", stackAr39.repOK());

  }

  @Test
  public void test44() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test44"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    java.lang.String str2 = stackAr0.toString();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr((int)(byte)100);
    boolean b5 = stackAr0.equals((java.lang.Object)stackAr4);
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr((int)(short)10);
    java.lang.String str8 = stackAr7.toString();
    stackAr0.push((java.lang.Object)str8);
    java.lang.String str10 = stackAr0.toString();
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isEmpty();
    boolean b13 = stackAr11.isEmpty();
    int i14 = stackAr11.size();
    boolean b15 = stackAr0.equals((java.lang.Object)i14);
    boolean b16 = stackAr0.isFull();
    java.lang.Object obj17 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test45() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test45"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isEmpty();
    java.lang.String str2 = stackAr0.toString();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr((int)(byte)100);
    boolean b5 = stackAr0.equals((java.lang.Object)stackAr4);
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr((int)(short)10);
    java.lang.String str8 = stackAr7.toString();
    stackAr0.push((java.lang.Object)str8);
    java.lang.String str10 = stackAr0.toString();
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isEmpty();
    boolean b13 = stackAr11.isEmpty();
    int i14 = stackAr11.size();
    boolean b15 = stackAr0.equals((java.lang.Object)i14);
    java.lang.Object obj16 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test46() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test46"); }


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
    java.lang.Object obj13 = stackAr4.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr4", stackAr4.repOK());

  }

  @Test
  public void test47() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test47"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    stackAr0.push((java.lang.Object)10);
    java.lang.String str6 = stackAr0.toString();
    java.lang.Object obj7 = stackAr0.top();
    java.lang.Object obj8 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test48() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test48"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    boolean b4 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr5 = new org.autotest.StackAr();
    boolean b6 = stackAr5.isFull();
    java.lang.String str7 = stackAr5.toString();
    boolean b8 = stackAr5.isEmpty();
    stackAr5.push((java.lang.Object)10);
    java.lang.String str11 = stackAr5.toString();
    stackAr0.push((java.lang.Object)stackAr5);
    boolean b13 = stackAr0.isEmpty();
    org.autotest.StackAr stackAr14 = new org.autotest.StackAr();
    boolean b15 = stackAr14.isEmpty();
    java.lang.String str16 = stackAr14.toString();
    java.lang.String str17 = stackAr14.toString();
    stackAr14.push((java.lang.Object)(-1.0f));
    stackAr0.push((java.lang.Object)stackAr14);
    boolean b21 = stackAr0.isEmpty();
    java.lang.Object obj22 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test49() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test49"); }


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
    java.lang.String str38 = stackAr3.toString();
    java.lang.Object obj39 = stackAr3.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr3", stackAr3.repOK());

  }

  @Test
  public void test50() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test50"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    org.autotest.StackAr stackAr2 = new org.autotest.StackAr();
    boolean b3 = stackAr2.isEmpty();
    org.autotest.StackAr stackAr4 = new org.autotest.StackAr();
    boolean b5 = stackAr4.isEmpty();
    java.lang.String str6 = stackAr4.toString();
    java.lang.String str7 = stackAr4.toString();
    int i8 = stackAr4.size();
    boolean b9 = stackAr2.equals((java.lang.Object)stackAr4);
    stackAr0.push((java.lang.Object)stackAr4);
    int i11 = stackAr0.size();
    java.lang.Object obj12 = stackAr0.top();
    org.autotest.StackAr stackAr13 = new org.autotest.StackAr();
    boolean b14 = stackAr13.isFull();
    org.autotest.StackAr stackAr15 = new org.autotest.StackAr();
    boolean b16 = stackAr15.isEmpty();
    org.autotest.StackAr stackAr17 = new org.autotest.StackAr();
    boolean b18 = stackAr17.isEmpty();
    java.lang.String str19 = stackAr17.toString();
    java.lang.String str20 = stackAr17.toString();
    int i21 = stackAr17.size();
    boolean b22 = stackAr15.equals((java.lang.Object)stackAr17);
    stackAr13.push((java.lang.Object)stackAr17);
    stackAr0.push((java.lang.Object)stackAr13);
    java.lang.Object obj25 = stackAr0.top();
    java.lang.Object obj26 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test51() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test51"); }


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
    java.lang.Object obj17 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test52() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test52"); }


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
    java.lang.String str11 = stackAr4.toString();
    java.lang.Object obj12 = stackAr4.top();
    java.lang.Object obj13 = stackAr4.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr4", stackAr4.repOK());

  }

  @Test
  public void test53() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test53"); }


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
    java.lang.Object obj46 = stackAr23.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr23", stackAr23.repOK());

  }

  @Test
  public void test54() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test54"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    stackAr0.push((java.lang.Object)10);
    java.lang.String str6 = stackAr0.toString();
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr();
    boolean b8 = stackAr7.isFull();
    org.autotest.StackAr stackAr9 = new org.autotest.StackAr();
    boolean b10 = stackAr9.isEmpty();
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isEmpty();
    java.lang.String str13 = stackAr11.toString();
    java.lang.String str14 = stackAr11.toString();
    int i15 = stackAr11.size();
    boolean b16 = stackAr9.equals((java.lang.Object)stackAr11);
    stackAr7.push((java.lang.Object)stackAr11);
    int i18 = stackAr7.size();
    java.lang.Object obj19 = stackAr7.top();
    stackAr0.push((java.lang.Object)stackAr7);
    java.lang.Object obj21 = stackAr0.top();
    java.lang.String str22 = stackAr0.toString();
    java.lang.Object obj23 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test55() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test55"); }


    org.autotest.StackAr stackAr0 = new org.autotest.StackAr();
    boolean b1 = stackAr0.isFull();
    java.lang.String str2 = stackAr0.toString();
    boolean b3 = stackAr0.isEmpty();
    stackAr0.push((java.lang.Object)10);
    java.lang.String str6 = stackAr0.toString();
    org.autotest.StackAr stackAr7 = new org.autotest.StackAr();
    boolean b8 = stackAr7.isFull();
    org.autotest.StackAr stackAr9 = new org.autotest.StackAr();
    boolean b10 = stackAr9.isEmpty();
    org.autotest.StackAr stackAr11 = new org.autotest.StackAr();
    boolean b12 = stackAr11.isEmpty();
    java.lang.String str13 = stackAr11.toString();
    java.lang.String str14 = stackAr11.toString();
    int i15 = stackAr11.size();
    boolean b16 = stackAr9.equals((java.lang.Object)stackAr11);
    stackAr7.push((java.lang.Object)stackAr11);
    int i18 = stackAr7.size();
    java.lang.Object obj19 = stackAr7.top();
    stackAr0.push((java.lang.Object)stackAr7);
    java.lang.Object obj21 = stackAr0.top();
    java.lang.Object obj22 = stackAr0.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr0", stackAr0.repOK());

  }

  @Test
  public void test56() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test56"); }


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
    boolean b46 = stackAr3.isFull();
    java.lang.Object obj47 = stackAr3.pop();
    
    // Check representation invariant.
    org.junit.Assert.assertTrue("Representation invariant failed: Check rep invariant (method repOK) for stackAr3", stackAr3.repOK());

  }

}
