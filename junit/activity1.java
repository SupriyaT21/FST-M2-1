package Activities;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class activity1 
{
	static ArrayList<String> list ;
	
	@BeforeEach
	void setup()
	{
	list = new ArrayList<String>();
	list.add("Alpha");
	list.add("Beta");
	}
	
	@Test
	public void insertTest()
	{
		assertEquals(2, list.size(), "Correct value");
		list.add("Lamda");
		assertEquals(3, list.size(), "Correct value");
		assertEquals("Alpha", list.get(0), "Correct value");
		assertEquals("Beta", list.get(1), "Correct value");
		assertEquals("Lamda", list.get(2), "Correct value");
		
	}
	
	@Test
	public void replaceTest()
	{
		assertEquals(2, list.size(), "Correct value");
		list.add("Lamda");
		list.set(1, "Ghama");
		assertEquals("Ghama", list.get(1), "Correct value");
		
	}
	
	
	
}

	


