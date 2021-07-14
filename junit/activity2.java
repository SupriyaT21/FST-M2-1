package Activity2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class activity2 
{
	
	@Test
	public void notEnoughFunds()
	{
		BankAccount Account = new BankAccount(10);
		assertThrows(NotEnoughFundsException.class, () -> Account.withdraw(12),
                "Balance must be greater than amount of withdrawal");
	}
	
	@Test
	public void EnoughFunds()
	{
		BankAccount Account = new BankAccount(100);
		assertDoesNotThrow(() -> Account.withdraw(99));
	}

}
