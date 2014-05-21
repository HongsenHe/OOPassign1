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

import java.util.ArrayList;

public class Auction {
	// data members
	ArrayList<ItemForAuction> auctionList;
	public AuctionItem aucItem;

	// a default constructor
	public Auction() {
		auctionList = new ArrayList<ItemForAuction>();
	}

	// methods
	public void addAuctionItem(String itemName, double price, double minbid) {
		aucItem = new AuctionItem(itemName, price, minbid);
		auctionList.add(aucItem);
	}

	public void addAuctionItem(ItemForAuction item) {
		aucItem = (AuctionItem) item; // DOWNCASTING FROM INTERFACE TO CLASS
		auctionList.add(item); // cool
	}

	public void showAllAuctionItems() {
		System.out.println("Show All Auction Items");
		// for each loop
		for (ItemForAuction items : auctionList)
			items.showSaleInfo();
	}

	public void showAuctionItemsByStatus(String status) {
		// show items by a specific status
		System.out.println("These are " + status + " items" + "\n");

		for (ItemForAuction items : auctionList) {
			if (items.currentStatus() == status) {
				items.showItemStatus();
			}
		}
	}

	public void showAuctionItemStatus(String itemName) {
		System.out.println("This is the " + itemName + " Information");

		// convert itemName to upperCase then compare
		String itemName1 = itemName.toUpperCase();

		// for all items in the arrayList
		for (ItemForAuction items : auctionList) {
			if (items.currentItemName().toUpperCase().equals(itemName1)) {
				items.showItemStatus();
			}
		}
	}

	public void showAuctionItemwithHighestBid() {
		System.out.println("--------Show Highest Bid--------");

		// for all items in the arrayList
		for (ItemForAuction items : auctionList) {
			System.out.println("Item is: " + items.currentItemName());
			System.out.println("Highest bid is: " + items.highestBid());
		}
	}
}
