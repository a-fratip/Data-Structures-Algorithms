package coen352.ch4.dictionary;

import coen352.ch4.list.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coen352.ch4.list.ADTList;

public class WarehouseJUnitTest {
    private static WarehouseDB wh;

    @BeforeAll
    public static void setUp() {
        wh = new WarehouseDB();
    }

    @Test
    void testInitializeDB() {
        // test database initialization
        wh.initializeDB();
        assertEquals(25,wh.getNumberOfRecords(), "initialize failed, size is not 25");
    }

    @Test
    void testInsertRecord() {
        // test single record insertion
        wh.clearDatabase();
        InventoryRecord ir1 = new InventoryRecord("Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, false);
        InventoryRecord ir2 = new InventoryRecord("Item 2","Desc 2",93.00,132,12276.00,231,4,50,false);
        InventoryRecord ir3 = new InventoryRecord("Item 3","Desc 3",57.00,151,8607.00,114,11,150,false);
        InventoryRecord ir4 = new InventoryRecord("Item 4","Desc 4",19.00,186,3534.00,158,6,50,false);
        wh.insertRecord("IN0001",ir1);
        wh.insertRecord("IN0002",ir2);
        wh.insertRecord("IN0003",ir3);
        wh.insertRecord("IN0004",ir4);
        assertEquals(4,wh.getNumberOfRecords(), "insertRecord failed, size is not as expected");
    }

    @Test
    void testInsertRecords() {
        // test insertion of an array of records
        wh.clearDatabase();
        InventoryRecord ir1 = new InventoryRecord("Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, false);
        InventoryRecord ir2 = new InventoryRecord("Item 2","Desc 2",93.00,132,12276.00,231,4,50,false);
        InventoryRecord ir3 = new InventoryRecord("Item 3","Desc 3",57.00,151,8607.00,114,11,150,false);
        InventoryRecord ir4 = new InventoryRecord("Item 4","Desc 4",19.00,186,3534.00,158,6,50,false);
        InventoryRecord[] records = new InventoryRecord[4];
        records[0] = ir1;
        records[1] = ir2;
        records[2] = ir3;
        records[3] = ir4;
        String[] invIDs = {"IN0001","IN0002","IN003","IN0004"};

        wh.insertRecords(invIDs,records);
        assertEquals(4,wh.getNumberOfRecords(), "insertRecords failed, size is not as expected");
    }

    @Test
    void testRemoveRecord() {
        // test removal of a record
        wh.clearDatabase();
        InventoryRecord ir1 = new InventoryRecord("Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, false);
        InventoryRecord ir2 = new InventoryRecord("Item 2","Desc 2",93.00,132,12276.00,231,4,50,false);
        InventoryRecord ir3 = new InventoryRecord("Item 3","Desc 3",57.00,151,8607.00,114,11,150,false);
        InventoryRecord ir4 = new InventoryRecord("Item 4","Desc 4",19.00,186,3534.00,158,6,50,false);
        wh.insertRecord("IN0001",ir1);
        wh.insertRecord("IN0002",ir2);
        wh.insertRecord("IN0003",ir3);
        wh.insertRecord("IN0004",ir4);

        wh.removeRecord("IN0001");

        assertNull(wh.findRecord("IN0001"), "removal failed");

        assertNotEquals(null,wh.findRecord("IN0002"), "improper removal");
        assertNotEquals(null,wh.findRecord("IN0003"), "improper removal");
        assertNotEquals(null,wh.findRecord("IN0004"), "improper removal");
    }

    @Test
    void testClearDatabase() {
        // test clearing of database
        wh.clearDatabase();
        InventoryRecord ir1 = new InventoryRecord("Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, false);
        InventoryRecord ir2 = new InventoryRecord("Item 2","Desc 2",93.00,132,12276.00,231,4,50,false);
        InventoryRecord ir3 = new InventoryRecord("Item 3","Desc 3",57.00,151,8607.00,114,11,150,false);
        InventoryRecord ir4 = new InventoryRecord("Item 4","Desc 4",19.00,186,3534.00,158,6,50,false);
        wh.insertRecord("IN0001",ir1);
        wh.insertRecord("IN0002",ir2);
        wh.insertRecord("IN0003",ir3);
        wh.insertRecord("IN0004",ir4);

        wh.clearDatabase();

        assertEquals(0,wh.getNumberOfRecords(), "clear failed, size is non zero");
    }

    @Test
    void testFindRecord() {
        // test find method of warehouseDB
        wh.clearDatabase();
        InventoryRecord ir1 = new InventoryRecord("Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, false);
        InventoryRecord ir2 = new InventoryRecord("Item 2","Desc 2",93.00,132,12276.00,231,4,50,false);
        InventoryRecord ir3 = new InventoryRecord("Item 3","Desc 3",57.00,151,8607.00,114,11,150,false);
        InventoryRecord ir4 = new InventoryRecord("Item 4","Desc 4",19.00,186,3534.00,158,6,50,false);
        wh.insertRecord("IN0001",ir1);
        wh.insertRecord("IN0002",ir2);
        wh.insertRecord("IN0003",ir3);
        wh.insertRecord("IN0004",ir4);

        assertNull(wh.findRecord("IN0006"), "found a record that shouldn't exist");

        assertNotEquals(null, wh.findRecord("IN0002"), "find failed");
    }

    @Test
    void testRetrieveReorderedRecords() {
        // test retrieval of reordered records
        wh.clearDatabase();
        InventoryRecord ir1 = new InventoryRecord("Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, false);
        InventoryRecord ir2 = new InventoryRecord("Item 2","Desc 2",93.00,132,12276.00,231,4,50,true);
        InventoryRecord ir3 = new InventoryRecord("Item 3","Desc 3",57.00,151,8607.00,114,11,150,false);
        InventoryRecord ir4 = new InventoryRecord("Item 4","Desc 4",19.00,186,3534.00,158,6,50,true);
        wh.insertRecord("IN0001",ir1);
        wh.insertRecord("IN0002",ir2);
        wh.insertRecord("IN0003",ir3);
        wh.insertRecord("IN0004",ir4);

        LList<InventoryRecord> expectedReorderedRecords = new LList<>();
        expectedReorderedRecords.insert(ir2);
        expectedReorderedRecords.insert(ir4);

        assertEquals(expectedReorderedRecords.length(),wh.retrieveReorderedRecords().length());
    }

    @Test
    void testRetrieveRecordsByQuantity() {
        // test retrieval of records by quantity
        wh.clearDatabase();
        InventoryRecord ir1 = new InventoryRecord("Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, false);
        InventoryRecord ir2 = new InventoryRecord("Item 2","Desc 2",93.00,132,12276.00,231,4,50,false);
        InventoryRecord ir3 = new InventoryRecord("Item 3","Desc 3",57.00,25,8607.00,114,11,150,false);
        InventoryRecord ir4 = new InventoryRecord("Item 4","Desc 4",19.00,25,3534.00,158,6,50,false);
        wh.insertRecord("IN0001",ir1);
        wh.insertRecord("IN0002",ir2);
        wh.insertRecord("IN0003",ir3);
        wh.insertRecord("IN0004",ir4);

        LList<InventoryRecord> expectedRecords = new LList<>();
        expectedRecords.insert(ir2);
        expectedRecords.insert(ir3);
        expectedRecords.insert(ir4);

        assertEquals(expectedRecords.length(),wh.retrieveRecordsByQuantity(25).length(), "retrieval of records by quantity failed");
    }

    @Test
    void testGetNumberOfRecords() {
        // test size method of WarehouseDB
        wh.clearDatabase();
        InventoryRecord ir1 = new InventoryRecord("Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, false);
        wh.insertRecord("IN0001",ir1);

        assertEquals(1,wh.getNumberOfRecords(), "getNumberOfRecords, size is not as expected");
    }

    @Test
    void testGetTotalInventoryValue() {
        // test getTotalInventoryValue of WarehouseDB
        wh.clearDatabase();
        InventoryRecord ir1 = new InventoryRecord("Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, false);
        InventoryRecord ir2 = new InventoryRecord("Item 2","Desc 2",93.00,132,12276.00,231,4,50,false);
        wh.insertRecord("IN0001",ir1);
        wh.insertRecord("IN0002",ir2);

        double expected = ir1.getInventoryValue() + ir2.getInventoryValue();

        assertEquals(expected, wh.getTotalInventoryValue(), "Total inventory value is not as expected");
    }




}
