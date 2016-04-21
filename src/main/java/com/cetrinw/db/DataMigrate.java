package com.cetrinw.db;

import com.cetrinw.util.DatabaseUtil;
import com.mongodb.*;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Cetrin Wang on 2016/4/21.
 * 将Oracle数据迁移到MongDB
 */
public class DataMigrate {

    private Connection conn;
    List<Object[]> list;

    /**
     * 获得oracle数据
     */
    private void getOracleData(){
        String sql = "select id,content from bd_analy_xinh_multiclas_corpus";
        list = DatabaseUtil.queryArrayList(conn,sql,null);
    }

    /**
     * 把数据保存到mongodb
     */
    public void saveDataToMongodb(){
        Mongo mg = DatabaseUtil.getMongodbConnection();
        DB db = mg.getDB("local");

        DBCollection cetrinw = db.getCollection("cetrinw");
        DBObject dbObject = new BasicDBObject();

        dbObject.put("name","haha");
        dbObject.put("age","12");

        cetrinw.save(dbObject);
    }
}
