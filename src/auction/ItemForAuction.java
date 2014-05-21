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

public interface ItemForAuction {

	public boolean makeABid(double bidAmount, String email);

	public boolean makeABidInEuro(double bidAmountInEuro, String email);

	public void sell();

	public void sell(double amount, String email);

	public void cancelSale();

	public void showPrice();

	public void showPriceInEuro();

	public void showItemStatus();

	public double getSoldPrice();

	public void showSaleInfo();

	public String currentStatus();

	public String currentItemName();

	public double highestBid();
}