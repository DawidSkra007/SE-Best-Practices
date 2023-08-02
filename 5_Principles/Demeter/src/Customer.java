package src;

class Customer {
  public Customer(Wallet wallet){
    myWallet = wallet;
  }
  
  public Wallet getWallet() {
    return myWallet;
  }

  public float getBalance() {
    return myWallet.getValue();
  }

  public void subtractMoney(float amount) {
    myWallet.subtractMoney(amount);
  }
  
  private Wallet myWallet;
}
	