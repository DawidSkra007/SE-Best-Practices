import java.util.ArrayList;

class Clerk {
  // ...

  public void createAccount(ClerkInterface account) {
	  accounts.add(account);
  }
	
  // ...
  private ArrayList<ClerkInterface> accounts;
}
