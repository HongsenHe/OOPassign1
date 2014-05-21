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

public class AuctionItem extends SaleItem implements ItemForAuction {

	// inner class
	public class AuctionBid {
		// data members
		private Money bidAmount;
		private final Money MINBID;
		private String bidderEmail;
		private Date bidDate;

		// constructors of inner class
		

		public AuctionBid(double minBid) {
			this.MINBID = new Money(minBid);
		}
		
//		public AuctionBid() {
//		}

		// methods
		public void showBidStatus() {
			System.out.println("********SHOW BID STATUS********");
			if (!result) { // result from makeABid method
				System.out.println("No current bids");
				System.out.println();
			} else {
				System.out.println("Bid Amount: " + bidAmount.getAmout()
						+ "\nMinBid Amount: " + MINBID.getAmout()
						+ "\nBidder Email: " + bidderEmail);
				bidDate = new Date();
				System.out.println("Bid Date: " + bidDate);
				System.out.println();
			}
		}

		public void clear() {
			bidAmount = null;
			bidderEmail = null;
			bidDate = null;
			MINBID.setAmout(0.0);
		}
	}

	// data members in AuctionItem class
	private AuctionBid currentBid; // current one
	private Money soldPrice; // at last sold price
	private String buyerInfo;

	// constructor of Outer Class
	public AuctionItem(String itemName, double price, double minBid) {
		super(itemName, price);
		currentBid = new AuctionBid(minBid);
		currentBid.bidAmount = new Money();
		currentBid.MINBID.setAmout(minBid);;
		soldPrice = new Money();
		currentBid.bidderEmail = null;
		currentBid.bidDate = null;
		buyerInfo = null;
	}

	boolean result = false; // this result is just for makeABid method

	double highestBid = 0;

	public boolean makeABid(double bidAmount, String email) {

		if ((bidAmount >= currentBid.MINBID.getAmout())
				&& (bidAmount > currentBid.bidAmount.getAmout())) {
			highestBid = bidAmount;
			currentBid.bidAmount.setAmout(bidAmount);
			currentBid.bidderEmail = email;
			currentBid.bidDate = new Date();
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	public double highestBid() {
		return highestBid;
	}

	public boolean makeABidInEuro(double bidAmountInEuro, String email) {
		if ((bidAmountInEuro >= currentBid.MINBID.getAmountInEuro())
				&& (bidAmountInEuro > currentBid.bidAmount.getAmountInEuro())) {
			highestBid = bidAmountInEuro;
			currentBid.bidAmount.setAmout(bidAmountInEuro);
			currentBid.bidderEmail = email;
			currentBid.bidDate = new Date();
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public void sell() {
		if (status == "AVAILABLE") {
			super.sell(); // change status and date to current

			// update price and info.
			soldPrice = currentBid.bidAmount;
			buyerInfo = currentBid.bidderEmail;
		} else {
			System.out.println("Item name is: " + itemName
					+ "\nItem not available");
		}
	}

	public void sell(double amount, String buyeremail) {
		if (status == "SOLD") {
			System.out.println("Item name: " + itemName + " is not Available");
		} else {
			super.sell();
			soldPrice = new Money(amount);
			buyerInfo = buyeremail;

			currentBid.bidAmount.setAmout(amount);
			currentBid.bidderEmail = buyeremail;
			currentBid.bidDate = new Date();
			if (amount >= highestBid) {
				highestBid = amount;
			}
		}

		System.out.println();
	}

	// show information
	public void showItemStatus() {
		System.out.println("********SHOW ITEM STATUS********");
		System.out.println("Item name: " + itemName + "\nPrice: " + getPrice()
				+ "\nStatus: " + status);
		currentBid.showBidStatus();
	}

	public double getSoldPrice() {
		return soldPrice.getAmout();
	}

	public double getItemPrice() {
		return super.getPrice();
	}

	public void cancelSale() {
		// currentBid.clear(); I cannot use this because MINBID is 0
		// should clear the data in currentBid and set the buyerInfo and
		// soldPrice to null
		super.status = "AVAILABLE";
		currentBid.bidAmount.setAmout(0);
		currentBid.bidDate = null;
		currentBid.bidderEmail = null;
		buyerInfo = null;
		soldPrice = null;
	}

	public void showPriceInEuro() {
		System.out.println("Price in Euro is: "
				+ currentBid.bidAmount.getAmountInEuro() + "\n");
	}

	public void showPrice() {
		System.out.println("Price in dollar is: "
				+ currentBid.bidAmount.getAmout() + "\n");
	}

	public String getBuyerInfo() {
		return buyerInfo;
	}

	public void showSaleInfo() {
		System.out.println("********SHOW SALE INFO********");
		System.out.println("Item name: " + currentItemName() + "\nSold Price: "
				+ getSoldPrice() + "\nStatus: " + currentStatus()
				+ "\nBuyer's info: " + getBuyerInfo() + "\nSold Date: "
				+ dateSold);
		System.out.println();
	}

	public String currentStatus() {
		return status;
	}

	public String currentItemName() {
		return itemName;
	}
}
