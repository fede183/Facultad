package org.autotest;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackArTest {
	
	@Test
	public void testDefaultStack()
	{
		StackAr stack = new StackAr();
		assertTrue(stack.isEmpty());
		assertTrue(stack.size() == 0);
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testNegativeCapacityStack()
	{
		try
		{
			StackAr stack = new StackAr(-1);
		}
		catch(IllegalArgumentException ex)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void testPushOneElemStack()
	{
		Object o = new Object();
		StackAr stack = new StackAr();
		stack.push(o);
		assertTrue(stack.size() == 1);
		assertTrue(!stack.isEmpty());
	}
	
	@Test
	public void testPushAndPullOneElemStack()
	{
		Object o = new Object();
		StackAr stack = new StackAr();
		stack.push(o);
		stack.pop();
		assertTrue(stack.size() == 0);
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testPushInFull()
	{
		try
		{
			Object o = new Object();
			StackAr stack = new StackAr(0);
			stack.push(o);
		}
		catch(IllegalStateException ex)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void testPopInEmpry()
	{
		try
		{
			StackAr stack = new StackAr();
			stack.pop();
		}
		catch(IllegalStateException ex)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void testTopInEmpry()
	{
		try
		{
			StackAr stack = new StackAr();
			stack.top();
		}
		catch(IllegalStateException ex)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void testFullStack()
	{
		StackAr stack = new StackAr();
		for(int i = 0; i<10 ;i++)
		{
			stack.push(i);
		}
		assertTrue(stack.isFull());
	}
	
	@Test
	public void testFullAndEmpryStack()
	{
		StackAr stack = new StackAr(0);
		assertTrue(stack.isFull());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testStackEqualToItself()
	{
		StackAr stack = new StackAr();
		assertTrue(stack.equals(stack));
	}
	
	@Test
	public void testStackEqualNull()
	{
		StackAr stack = new StackAr();
		assertTrue(!stack.equals(null));
	}
	
	@Test
	public void testStackDiferentClass()
	{
		Object o = new Object();
		StackAr stack = new StackAr();
		assertTrue(!stack.equals(o));
	}
	
	@Test
	public void testStackDiferentCapacity()
	{
		StackAr stack1 = new StackAr(1);
		StackAr stack2 = new StackAr(2);
		assertTrue(!stack1.equals(stack2));
	}
	
	@Test
	public void testStackSameCapacityDiferentContent()
	{
		Object o = new Object();
		StackAr stack1 = new StackAr();
		StackAr stack2 = new StackAr();
		stack1.push(o);
		assertTrue(!stack1.equals(stack2));
	}
	
	@Test
	public void testStackSameCapacityReadIndex()
	{
		Object o = new Object();
		StackAr stack1 = new StackAr();
		StackAr stack2 = new StackAr();
		stack1.push(o);
		stack1.push(o);
		stack1.pop();
		stack2.push(o);
		assertTrue(!stack1.equals(stack2));
	}
	
	@Test
	public void testStack()
	{
		Object o = new Object();
		StackAr stack1 = new StackAr();
		StackAr stack2 = new StackAr();
		stack1.push(o);
		stack2.push(o);
		assertTrue(stack1.equals(stack2));
	}
	
	@Test
	public void testStackDiferentReadIndex()
	{
		Object o = new Object();
		StackAr stack1 = new StackAr();
		StackAr stack2 = new StackAr();
		stack1.push(o);
		stack1.push(null);
		stack2.push(o);
		assertTrue(!stack1.equals(stack2));
	}
	
	@Test
	public void testStackHashCode()
	{
		Object o = new Object();
		StackAr stack1 = new StackAr();
		StackAr stack2 = new StackAr();
		stack1.push(o);
		stack2.push(o);
		assertTrue(stack1.hashCode() == stack2.hashCode());
	}
	
	@Test
	public void testStacktoStringSimple()
	{
		StackAr stack1 = new StackAr();
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		assertEquals(stack1.toString(), "[1,2,3]");
	}
	
	@Test
	public void testStacktoStringEquals()
	{
		StackAr stack1 = new StackAr();
		StackAr stack2 = new StackAr();
		stack1.push(1);
		stack1.push(1);
		stack2.push(1);
		stack2.push(1);
		assertEquals(stack1.toString(), stack2.toString());
	}
}
