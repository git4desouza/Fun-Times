package com.henry.app;

import java.time.LocalDate;
import java.time.YearMonth;

public class PriceCalculation {

	double bread_tot_amount = 0.0;

	public double breadDiscountCalculation(double price, int breadQty, int soupQty, LocalDate currDate,
			LocalDate purDate, double breadDiscountPrice) {

		LocalDate breadDiscountStartDate = currDate.minusDays(1);
		LocalDate breadDiscountEndDate = breadDiscountStartDate.plusDays(7);

		if (soupQty > 2
				&& ValidationSystem.discountDateValidation(purDate, breadDiscountStartDate, breadDiscountEndDate)) {
			int breadDiscount = (int) Math.floor((soupQty / 2));
			if (breadQty <= breadDiscount) {
				breadDiscountPrice = breadDiscountPrice + (breadQty * 0.40);
			}
			if (breadQty > breadDiscount) {
				breadDiscountPrice = breadDiscountPrice
						+ ((breadDiscount * 0.40) + ((breadQty - breadDiscount) * price));
			}
		} else {
			breadDiscountPrice = totalCaluculation(breadDiscountPrice, price, breadQty);
		}

		return breadDiscountPrice;
	}

	public double appleDiscountCalculation(double price, int appleQty, LocalDate currDate, LocalDate purDate,
			double appleDiscountPrice) {

		LocalDate appleDiscountStartDate = currDate.plusDays(3);
		LocalDate appleDiscountEndDate = YearMonth.from(appleDiscountStartDate.plusMonths(1)).atEndOfMonth();

		if (ValidationSystem.discountDateValidation(purDate, appleDiscountStartDate, appleDiscountEndDate)) {
			appleDiscountPrice = appleDiscountPrice + (appleQty * (price - (price * 10 / 100)));
		} else {
			appleDiscountPrice = totalCaluculation(appleDiscountPrice, price, appleQty);
		}

		return appleDiscountPrice;
	}

	/*
	 * Method to calculate subtotal of purchased item
	 */
	public double totalCaluculation(double totAmt, double price, int qty) {
		totAmt = totAmt + (qty * price);
		return totAmt;
	}

	public double totalAmount(double soup_totalAmt,double bread_totalAmt,double milk_totalAmt,double apple_totalAmt,int soupQty, int breadQty)
	{
		double total = soup_totalAmt + bread_totalAmt + milk_totalAmt + apple_totalAmt;
		if(soupQty>2 && breadQty>1)
		{
			total = total - 0.4;
		}
		return total;
	}

	public double soupTotalCaluculation(double price, int qty) {
		// TODO Auto-generated method stub
		double totAmt = qty * price;
		return totAmt;
	}

	public double milkTotalCaluculation(double price, int qty) {
		// TODO Auto-generated method stub
		double totAmt = qty * price;
		return totAmt;
	}
	
	public double breadTotalCaluculation(double price, int qty) {
		// TODO Auto-generated method stub
		double totAmt = qty * price;
		return totAmt;
	}
}
