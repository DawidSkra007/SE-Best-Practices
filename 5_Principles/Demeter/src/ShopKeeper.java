package src;


public class ShopKeeper {
  // ...
  public void chargeCustomer(Customer cust, float amount){
    if (cust.getBalance() > amount) {
      cust.subtractMoney(amount);
      } else {
          // get the baseball bat...
      }   
  }
  // ...
}
