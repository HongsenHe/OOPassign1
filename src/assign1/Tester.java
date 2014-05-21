/**
 * JavaDocs
 * Author: Hongsen He
 * SCU ID: W1079638
 * Email: hhe@scu.edu
 * Course: COEN 275
 * Section: WF
 * Assignment: 01
 * Date of submission: 1/30/2014
 * 
 * Project Information:
 * You will define and develop a small application 
 * consisting of classes for an auction-based sale.
 * In this application, you will define classes to represent 
 * AuctionItems on which potential buyers can make bids and 
 * Auction objects which can maintain and manage a list of AuctionItems.
 * 
 */

package assign1;

import auction.*;

public class Tester {

	public static void main(String[] args) {
		// these are my personal test
		// //test Money class
		// Money m = new Money(100);
		// System.out.println("Euro: " + m.getAmountInEuro());
		// System.out.println("Dollar: " + m.getAmout());
		// Money m1 = new Money();
		// m1.setAmout(90);
		// System.out.println("Dollar: " + m1.getAmout());
		//
		// //test SaleItem class
		// SaleItem si = new SaleItem("Desk", 50);
		// System.out.println("Price: " + si.getPrice());
		// si.sell();
		// si.showItemStatus();

		// these are tests from the instructor, test auctionItem class
		AuctionItem item1 = new AuctionItem("Carnations - A Painting", 780.00,
				500.00);
		item1.showItemStatus();
		item1.makeABid(300.00, "smith@decor.com");
		item1.showItemStatus();
		item1.makeABid(510.00, "smith@decor.com");
		item1.showItemStatus();

		//just set the different soldDate
		try {
			Thread.sleep(1000); // pause 3s
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		item1.makeABid(600.00, "jones@interiors.com");
		item1.showItemStatus();
		item1.sell();
		item1.showSaleInfo();
		item1.showItemStatus();
		item1.sell(item1.getItemPrice(), "david@decor.com");
		item1.showItemStatus();

		// myself test
		item1.showPriceInEuro();
		item1.showPrice();

		item1.cancelSale();
		item1.makeABid(520.00, "jones@interiors.com");
		item1.showItemStatus();
		item1.sell(item1.getItemPrice(), "clark@museums.com");
		item1.showSaleInfo();
		item1.showItemStatus();

		
		System.out
				.println("**********Following is testing Auction Class**********");
		// test the Auction class
		//create a new instance
		Auction auction1 = new Auction();
		auction1.addAuctionItem(item1);

		//test following four items: iPad1, iPad4, iPhone5s, iPhone5c
		auction1.addAuctionItem(new AuctionItem("IPAD 1", 100.00, 70.00));
		auction1.aucItem.makeABid(200, "iPAD1Buyer01@gmail.com");
		auction1.aucItem.makeABid(300, "iPAD1Buyer02@gmail.com");
		auction1.aucItem.sell();
		auction1.aucItem.showItemStatus();
		auction1.aucItem.showSaleInfo();

		auction1.addAuctionItem(new AuctionItem("IPAD 4", 400.00, 100.00));
		auction1.aucItem.makeABid(500, "iPAD4Buyer01@gmail.com");
		auction1.aucItem.makeABid(600, "iPAD4Buyer02@gmail.com");
		auction1.aucItem.sell();
		auction1.aucItem.showItemStatus();
		auction1.aucItem.showSaleInfo();
		
		auction1.addAuctionItem("iPhone5s", 800.00, 600.00);
		auction1.aucItem.showItemStatus();
		auction1.aucItem.makeABid(900, "iPhone5sBuyer01@gmail.com");
		auction1.aucItem.makeABid(1000, "iPhone5sBuyer02@gmail.com");
		auction1.aucItem.showItemStatus();

		auction1.addAuctionItem("iPhone5c", 600.00, 500.00);
		auction1.aucItem.showItemStatus();
		auction1.aucItem.makeABid(700, "iPhone5cBuyer01@gmail.com");
		auction1.aucItem.makeABid(800, "iPhone5cBuyer02@gmail.com");
		auction1.aucItem.sell(); // just sell iPhone 5c
		auction1.aucItem.showItemStatus();
		auction1.aucItem.showSaleInfo();
		
		//test methods
		auction1.showAllAuctionItems();
		auction1.showAuctionItemsByStatus("SOLD");
		auction1.showAuctionItemsByStatus("AVAILABLE");
		auction1.showAuctionItemStatus("carnations - a painting");
		auction1.showAuctionItemwithHighestBid();
	}

}
