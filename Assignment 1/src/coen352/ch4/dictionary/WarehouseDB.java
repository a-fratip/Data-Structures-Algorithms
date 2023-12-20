package coen352.ch4.dictionary;

import coen352.ch4.list.*;
public class WarehouseDB {

	// data members
	private static ADTDictionary<String, InventoryRecord> sheetIR;
	private double totalInventoryValue;

	// constructor
	public WarehouseDB() {
		sheetIR = new LDictionary<>();
		totalInventoryValue = 0.00;
	}

	// 1. Insert a record
	public void insertRecord(String invID, InventoryRecord inv) {
		sheetIR.insert(invID,inv);
		totalInventoryValue += inv.getInventoryValue();
	}

	// 2. Insert a set of records
	public void insertRecords(String[] invIDs, InventoryRecord[] records) {
		assert (invIDs.length == records.length);
        for (int i = 0; i < records.length; i++) {
            sheetIR.insert(invIDs[i], records[i]);
            totalInventoryValue += records[i].getInventoryValue();
        }
	}

	// 3. Remove a record given a key
	public void removeRecord(String invID) {
		totalInventoryValue -= sheetIR.find(invID).getInventoryValue();
		sheetIR.remove(invID);
	}

	// 4. Clear the database (remove all)
	public void clearDatabase() {
		sheetIR.clear();
		totalInventoryValue = 0.0;
	}

	// 5. Find a record given a key
	public InventoryRecord findRecord(String invID) {
		return sheetIR.find(invID);
	}

	// 6. Retrieve records that have the value "Reordered"
	// It is assumed that a record has value "Reordered" if it is discontinued
	// Return in the form of a LList
	public LList<InventoryRecord> retrieveReorderedRecords() {
		LList<InventoryRecord> reorderedRecords = new LList<>();

		// Use the getKeys method to retrieve the keys

		ADTList<String> keys = ((LDictionary) sheetIR).getKeyList();

		for (int i = 0; i < sheetIR.size(); i++) {
			InventoryRecord record = sheetIR.find(keys.getValue());
			if (record.getDiscontinued()) {
				reorderedRecords.insert(record);
			}
			keys.next();
		}
		return reorderedRecords;
	}

	// 7. Retrieve records of a given field
	// The retrieved field is chosen to be the "quantity in stock"
	// Return in the form of a LList
	public LList<InventoryRecord> retrieveRecordsByQuantity(long qty) {
		LList<InventoryRecord> recordsByQuantity = new LList<>();

		// Use the getKeys method to retrieve the keys
		ADTList<String> keys = ((LDictionary) sheetIR).getKeyList();

		for (int i = 0; i < sheetIR.size(); i++) {
			InventoryRecord record = sheetIR.find(keys.getValue());
			if (record.getQty()== qty) {
				recordsByQuantity.insert(record);
			}
			keys.next();
		}

		return recordsByQuantity;
	}

	// 8. Return the number of records in the database
	public int getNumberOfRecords() {
		return sheetIR.size();
	}

	// 9. Return the total inventory value of all the records
	public double getTotalInventoryValue() { return totalInventoryValue; }

	// Initialize database according to sample file given
	// manually store information from inventory list using objects and warehouse functions
	public void initializeDB() {
		// create inventory records
		InventoryRecord ir1 = new InventoryRecord("Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, false);
		InventoryRecord ir2 = new InventoryRecord("Item 2","Desc 2",93.00,132,12276.00,231,4,50,false);
		InventoryRecord ir3 = new InventoryRecord("Item 3","Desc 3",57.00,151,8607.00,114,11,150,false);
		InventoryRecord ir4 = new InventoryRecord("Item 4","Desc 4",19.00,186,3534.00,158,6,50,false);
		InventoryRecord ir5 = new InventoryRecord("Item 5","Desc 5",75.00,62,4650.00,39,12,50,false);
		InventoryRecord ir6 = new InventoryRecord("Item 6","Desc 6",11.00,5,55.00,9,13,150,false);
		InventoryRecord ir7 = new InventoryRecord("Item 7","Desc 7",56.00,58,3248.00,109,7,100,true);
		InventoryRecord ir8 = new InventoryRecord("Item 8","Desc 8",38.00,101,3838.00,162,3,100,false);
		InventoryRecord ir9 = new InventoryRecord("Item 9","Desc 9",59.00,122,7198.00,82,3,150,false);
		InventoryRecord ir10 = new InventoryRecord("Item 10","Desc 10",50.00,175,8750.00,283,8,150,false);
		InventoryRecord ir11 = new InventoryRecord("Item 11","Desc 11",59.00,176,10384.00,229,1,100,false);
		InventoryRecord ir12 = new InventoryRecord("Item 12","Desc 12",18.00,22,396.00,36,12,50,false);
		InventoryRecord ir13 = new InventoryRecord("Item 13","Desc 13",26.00,72,1872.00,102,9,100,false);
		InventoryRecord ir14 = new InventoryRecord("Item 14","Desc 14",42.00,62,2604.00,83,2,100,false);
		InventoryRecord ir15 = new InventoryRecord("Item 15","Desc 15",32.00,46,1472.00,23,15,50,false);
		InventoryRecord ir16 = new InventoryRecord("Item 16","Desc 16",90.00,96,8640.00,180,3,50,false);
		InventoryRecord ir17 = new InventoryRecord("Item 17","Desc 17",97.00,57,5529.00,98,12,50,true);
		InventoryRecord ir18 = new InventoryRecord("Item 18","Desc 18",12.00,6,72.00,7,13,50,false);
		InventoryRecord ir19 = new InventoryRecord("Item 19","Desc 19",82.00,143,11726.00,164,12,150,false);
		InventoryRecord ir20 = new InventoryRecord("Item 20","Desc 20",16.00,124,1984.00,113,14,50,false);
		InventoryRecord ir21 = new InventoryRecord("Item 21","Desc 21",19.00,112,2128.00,75,11,50,false);
		InventoryRecord ir22 = new InventoryRecord("Item 22","Desc 22",24.00,182,4368.00,132,15,150,false);
		InventoryRecord ir23 = new InventoryRecord("Item 23","Desc 23",29.00,106,3074.00,142,1,150,true);
		InventoryRecord ir24 = new InventoryRecord("Item 24","Desc 24",75.00,173,12975.00,127,9,100,false);
		InventoryRecord ir25 = new InventoryRecord("Item 25","Desc 25",14.00,28,392.00,21,8,50,false);

		// store inventory records in array
//		InventoryRecord[] records = new InventoryRecord[25];
//		records[0] = ir1;
//		records[1] = ir2;
//		records[2] = ir3;
//		records[3] = ir4;
//		records[4] = ir5;
//		records[5] = ir6;
//		records[6] = ir7;
//		records[7] = ir8;
//		records[8] = ir9;
//		records[9] = ir10;
//		records[10] = ir11;
//		records[11] = ir12;
//		records[12] = ir13;
//		records[13] = ir14;
//		records[14] = ir15;
//		records[15] = ir16;
//		records[16] = ir17;
//		records[17] = ir18;
//		records[18] = ir19;
//		records[19] = ir20;
//		records[20] = ir21;
//		records[21] = ir22;
//		records[22] = ir23;
//		records[23] = ir24;
//		records[24] = ir25;

		// clear database and insert records
		this.clearDatabase();

		this.insertRecord("IN0001",ir1);
		this.insertRecord("IN0002",ir2);
		this.insertRecord("IN0003",ir3);
		this.insertRecord("IN0004",ir4);
		this.insertRecord("IN0005",ir5);
		this.insertRecord("IN0006",ir6);
		this.insertRecord("IN0007",ir7);
		this.insertRecord("IN0008",ir8);
		this.insertRecord("IN0009",ir9);
		this.insertRecord("IN0010",ir10);
		this.insertRecord("IN0011",ir11);
		this.insertRecord("IN0012",ir12);
		this.insertRecord("IN0013",ir13);
		this.insertRecord("IN0014",ir14);
		this.insertRecord("IN0015",ir15);
		this.insertRecord("IN0016",ir16);
		this.insertRecord("IN0017",ir17);
		this.insertRecord("IN0018",ir18);
		this.insertRecord("IN0019",ir19);
		this.insertRecord("IN0020",ir20);
		this.insertRecord("IN0021",ir21);
		this.insertRecord("IN0022",ir22);
		this.insertRecord("IN0023",ir23);
		this.insertRecord("IN0024",ir24);
		this.insertRecord("IN0025",ir25);

	}

}
