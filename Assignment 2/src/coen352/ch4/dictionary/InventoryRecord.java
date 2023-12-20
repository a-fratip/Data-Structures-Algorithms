package coen352.ch4.dictionary;



public class InventoryRecord implements Comparable<InventoryRecord>, ADTInventoryRecord{
	private String name;
	private String	description;
	private double unitPrice;
	private long qty;
	private double  inventoryValue;
	private int reorderLevel;
	private int reorderTime;
	private int reorderQty;
	private boolean discontinued;

	public InventoryRecord(String s, String s1, double v, long l, double v1, int i1, int i2, int i3, boolean b) {
		this.setName(s);
		this.setDescription(s1);
		this.setUnitPrice(v);
		this.setQty(l);
		this.setInventoryValue(v1);
		this.setReorderLevel(i1);
		this.setReorderTime(i2);
		this.setReorderQty(i3);
		this.setDiscontinued(b);
	}

	public InventoryRecord() {
		this.setName(null);
		this.setDescription(null);
		this.setUnitPrice(0);
		this.setQty(0);
		this.setInventoryValue(0);
		this.setReorderLevel(0);
		this.setReorderTime(0);
		this.setReorderQty(0);
		this.setDiscontinued(false);
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() { return unitPrice; }
	public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
	public long getQty() {
		return qty;
	}
	public void setQty(long qty) {
		this.qty = qty;
	}
	public double getInventoryValue() {
		return inventoryValue;
	}
	public void setInventoryValue(double inventoryValue) {
		this.inventoryValue = inventoryValue;
	}
	public int getReorderLevel() { return reorderLevel; }
	public void setReorderLevel(int reorderLevel) {this.reorderLevel = reorderLevel; }
	public int getReorderTime() { return reorderTime; }
	public void setReorderTime(int reorderTime) { this.reorderTime = reorderTime; }
	public int getReorderQty() { return reorderQty; }
	public void setReorderQty(int reorderQty) {this.reorderQty = reorderQty; }
	public boolean getDiscontinued() {return discontinued;}
	public void setDiscontinued(boolean discontinued) { this.discontinued = discontinued; }

	public int compareTo(InventoryRecord other)
     {
    	 return this.getDescription().compareTo(other.getDescription());
     }

	public String toString()
	{
		return ("\n"
				+ "Name: " + this.name
				+ "\n"
				+ "Description: " + this.description
				+ "\n"
				+ "Unit Price: $" + this.unitPrice
				+ "\n"
				+ "Quantity in stock: " + this.qty
				+ "\n"
				+ "Item inventory value: $" + this.inventoryValue
				+ "\n"
				+ "Reorder Level: " + this.reorderLevel
				+ "\n"
				+ "Reorder Time in Days: " + this.reorderTime
				+ "\n"
				+ "Quantity in reorder: " + this.reorderQty
				+ "\n"
				+ "Discontinued? " + this.discontinued);
	}


	
}
