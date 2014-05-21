/**JavaDocs
 * Author: Hongsen He
 * SCU ID: W1079638
 * Email: hhe@scu.edu
 * Course: COEN 275
 * Section: WF
 * Assignment: 01
 * Date of submission: 1/30/2014
 */
package auction;

public class Money {
	// data members
	private String currencyUnits = "dollars";
	private double amount;

	// constructor
	public Money(double amount) {
		this.amount = amount;
	}

	public Money() {
	}

	// method getter and setter
	public double getAmout() {
		return amount;
	}

	public void setAmout(double amount) {
		this.amount = amount;
	}

	// auto code
	public String getCurrencyUnits() {
		return currencyUnits;
	}

	public void setCurrencyUnits(String currencyUnits) {
		this.currencyUnits = currencyUnits;
	}

	// return amount in euros
	public double getAmountInEuro() {
		return 0.7 * getAmout();
	}
}