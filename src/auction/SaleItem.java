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

import java.util.Date;

public class SaleItem {
	// data members
	String itemName;
	Money price;
	String status = "AVAILABLE";
	Date dateSold;

	// constructor
	public SaleItem(String itemName, double price) {
		this.itemName = itemName;
		this.price = new Money(price);
	}

	// other necessary constructor for initialization
	public SaleItem(String itemName, double price, String status, Date dateSold) {
		this.itemName = itemName;
		this.price = new Money(price);
		this.status = "AVAILABLE";
		this.dateSold = new Date();
	}

	// methods
	public double getPrice() {
		return price.getAmout();
	}

	public void sell() {
		status = "SOLD";
		// DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// Date date = new Date();
		// dateSold = dateFormat.format(date); //if dateSold is a String type,
		// then use.

		// set dateSold to current date
		dateSold = new Date();
	}

	// display the following info.
	public void showItemStatus() {
		System.out.println("Item Name: " + itemName + "\nPrice: " + getPrice()
				+ "\nStatus: " + status + "\nDate Sold: " + dateSold);
	}
}