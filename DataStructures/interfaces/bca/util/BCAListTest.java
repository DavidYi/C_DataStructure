package interfaces.bca.util;

import java.util.Random;

public class BCAListTest {
	public static void main (String args[]) {//change the comment to test the according list
		//BCAArrayList l = new BCAArrayList();
		BCALinkedList l = new BCALinkedList();
		Random rand = new Random(1000);

		if (l.isEmpty())
			System.out.println("Passed 0");
		else
			System.out.println("Failed 0");	
		
		l.add(10);
		l.add(15);
		l.add(2);
		l.add(-14);
		l.add(7);
		l.add(14444);
		
		if (l.get(3).equals(-14))
			System.out.println("Passed 1");
		else
			System.out.println("Failed 1");

		try {
			l.get(12);
			System.out.println("Failed 2");			
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Passed 2");			
		}

		try {
			l.add(6, -47);
			System.out.println("Passed 3");			
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Failed 3");			
		}
		
		try {
			l.add(8, 63);
			System.out.println("Failed 4");			
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Passed 4");			
		}

		if (l.contains(15) && !l.contains(99))
			System.out.println("Passed 5");
		else
			System.out.println("Failed 5");		
		
		if (!l.isEmpty())
			System.out.println("Passed 6");
		else
			System.out.println("Failed 6");	
		
		for (int i=0; i<500; i++)
			l.add(rand.nextInt(20000));
		
		if (l.indexOf(-14) == 3)
			System.out.println("Passed 7");
		else
			System.out.println("Failed 7");
		
		if (l.lastIndexOf(14444) == 80)
			System.out.println("Passed 8");
		else
			System.out.println("Failed 8");
			
		if (l.indexOf(14444) == 5)
			System.out.println("Passed 9");
		else
			System.out.println("Failed 9");

		if (l.indexOf(49000) == -1)
			System.out.println("Passed 10");
		else
			System.out.println("Failed 10");

		if (!l.contains(49000))
			System.out.println("Passed 11");
		else
			System.out.println("Failed 11");
		
		int size = l.size();
		
		l.remove(new Integer(15));
		if (l.get(1).equals(2))
			System.out.println("Passed 12");
		else
			System.out.println("Failed 12");
			
		if (l.size() == size-1)
			System.out.println("Passed 13");
		else
			System.out.println("Failed 13");
		
		l.clear();
		
		if (l.size() == 0)
			System.out.println("Passed 12");
		else
			System.out.println("Failed 12");
	}
}
