package com.henry.app;

import java.time.LocalDate;
import java.util.Scanner;
import java.text.DecimalFormat;

public class HenryShopBillingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DecimalFormat df = new DecimalFormat("#.##");
		Scanner input = new Scanner(System.in);		
		LocalDate currDate = LocalDate.now();
		// Cost for product
		double soupPrice = 0.65;
		double breadPrice = 0.80;
		double milkPrice = 1.30;
		double applePrice = 0.10;	
		//Count item quantity	
		int groceryItems = 1;
		int soupQty = 0;
		int breadQty = 0;
		int milkQty = 0;
		int appleQty = 0;
		//count total amount
		double soup_totalAmt = 0;
		double bread_totalAmt = 0;
		double milk_totalAmt = 0;
		double apple_totalAmt = 0;
		double price = 0;
		
		PriceCalculation productPrice = new PriceCalculation();
		LocalDate purDate = null;
		System.out.println("Enter Purchase Date with the format yyyy-MM-dd");
		String date = input.next();
		purDate = ValidationSystem.DateValidation(date);
		
		
          
		
		do{
			System.out.println("Welcome to Henry's GroceryStore"+"\n"+"\n");
			//System.out.println();
			System.out.println("Product   |  unit    |  cost");
			System.out.println("---------------------------");
			System.out.println("1.soup    |  tin     |" + soupPrice);
			System.out.println("2.bread   | loaf     |" + breadPrice);
			System.out.println("3.milk    |  bottle  |" + milkPrice);
			System.out.println("4.apples  |  single  |" + applePrice);
			System.out.println();
			System.out.println("0. Quit");
			System.out.println("");

			System.out.println("Please Select Product Number or Enter 0 to exit");
			groceryItems = input.nextInt();
			ValidationSystem.prdtInputValidation(groceryItems, input);
			if (groceryItems == 0)
				break;
			
			
			System.out.println("Please enter the Quantity");
			int qty = input.nextInt();
			ValidationSystem.prdtQtyValidation(qty, input);
			
			switch (groceryItems) {
			case 1:
				soupQty = qty;
				price = soupPrice;
				soup_totalAmt = productPrice.soupTotalCaluculation( price, soupQty);
				//System.out.println(soup_totalAmt);
				break;
			case 2:
				breadQty = qty;	  
				price = breadPrice;
				bread_totalAmt = productPrice.breadTotalCaluculation(price, breadQty);
				//System.out.println(bread_totalAmt);
				break;
			case 3:
			    milkQty = qty;
				price = milkPrice;		
				milk_totalAmt = productPrice.milkTotalCaluculation(price, milkQty);
				//System.out.println(milk_totalAmt);
				break;
			case 4:
				appleQty = qty;
				price = applePrice;
				apple_totalAmt = productPrice.appleDiscountCalculation(price, appleQty, currDate, purDate,  apple_totalAmt);
				//System.out.println(apple_totalAmt);
				break;
			default:
				break;
			}
			
		}while(groceryItems != 0);
		
		if(groceryItems >=0)
			System.out.println("Total Amount for your purchase: "+df.format(productPrice.totalAmount(soup_totalAmt,bread_totalAmt,milk_totalAmt,apple_totalAmt,soupQty,breadQty)));
		
		
	}
	
}
