package com.batsonator.stockcontrol.api.domain;

public interface StockItem {

	String getItemCode();
	String getName();
	String getUnit();
	Long getStockedQuantity();
	Long getDesiredQuantity();
	Long getWarnQuantity();

	default Long getMissingQuantity() {

		return getDesiredQuantity() - getStockedQuantity();
	}

	default boolean needsRestock() {

		return getStockedQuantity() < getWarnQuantity();
	}
}