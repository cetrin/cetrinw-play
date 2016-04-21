package com.cetrinw.db;

import org.junit.Test;

/**
 * Created by Cetrin Wang on 2016/4/21.
 */
public class DataMigrateTest {
    @Test
    public void saveDataToMongodb() throws Exception {
        DataMigrate d  = new DataMigrate();
        d.saveDataToMongodb();
    }

}