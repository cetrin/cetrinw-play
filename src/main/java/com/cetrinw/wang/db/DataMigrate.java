package com.cetrinw.wang.db;

import com.cetrinw.util.DatabaseUtil;
import com.cetrinw.util.StrUtils;
import com.mongodb.*;
import org.apache.commons.lang3.StringUtils;

import java.sql.Blob;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cetrin Wang on 2016/4/21.
 * 将Oracle数据迁移到MongDB
 */
public class DataMigrate {

    private Connection conn;
    private List<Object[]> list;

    private DataMigrate() {
        this.conn = DatabaseUtil.getOracleConnection();
        this.getOracleData();
    }

    /**
     * 获得oracle数据
     */
    private void getOracleData() {
        String sql = "select content from bd_analy_xinh_multiclas_corpus";
        list = DatabaseUtil.queryArrayList(conn, sql, null);
    }

    /**
     * 把数据保存到mongodb
     */
    public void saveDataToMongodb() {
        Mongo mg = DatabaseUtil.getMongodbConnection();
        DB db = mg.getDB("local");

        DBCollection cetrinw = db.getCollection("cetrinw");

        List<DBObject> data = new ArrayList<DBObject>();
        int count = 1;

        for (Object[] objs : list) {
            if (objs != null) {
                DBObject dbObject = new BasicDBObject();
                String content = StrUtils.blob2String((Blob) objs[0]);

                if (StringUtils.isNotBlank(content)) {
                    dbObject.put("content", content);
                    data.add(dbObject);
                    if (count % 2000 == 0 || count == list.size()+1) {
                        cetrinw.insert(data);
                        data = new ArrayList<DBObject>();
                        System.out.println(count + "条数据已导入");
                    }
                    count++;
                }
            }
        }

    }

    public static void main(String[] args) {
        DataMigrate d = new DataMigrate();
        d.saveDataToMongodb();
    }
}
