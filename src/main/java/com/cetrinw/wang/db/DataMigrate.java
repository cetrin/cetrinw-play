package com.cetrinw.wang.db;

import com.cetrinw.util.DatabaseUtil;
import com.cetrinw.util.StrUtils;
import com.mongodb.*;

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
        String sql = "select id,content,title,key_wd,industry,cxxx,fwcb,fmxw,sxykb,xsxs,nonefivesub from bd_analy_xinh_multiclas_corpus";
        list = DatabaseUtil.queryArrayList(conn, sql, null);
    }

    /**
     * 把数据保存到mongodb
     */
    public void saveDataToMongodb() {
        Mongo mg = DatabaseUtil.getMongodbConnection();
        DB db = mg.getDB("inlp");

        DBCollection inlp = db.getCollection("corpus");

        List<DBObject> data = new ArrayList<DBObject>();
        int count = 1;

        for (Object[] objs : list) {
            if (objs != null) {
                DBObject dbObject = new BasicDBObject();

                String content = objs[1] == null ? "":StrUtils.blob2String((Blob) objs[1]);
                String title = objs[2] == null ? "":objs[2].toString();
                String keyWd = objs[3] == null ? "":objs[3].toString();
                String industry = objs[4] == null ? "":objs[4].toString();
                String cxxx = objs[5] == null ? "":objs[5].toString();
                String fwcb = objs[6] == null ? "":objs[6].toString();
                String fmxw = objs[7] == null ? "":objs[7].toString();
                String sxykb = objs[8] == null ? "":objs[8].toString();
                String xsxs = objs[9] == null ? "":objs[9].toString();
                String nonefivesub = objs[10] == null ? "":objs[10].toString();

                dbObject.put("id",objs[0].toString());
                dbObject.put("content", content);
                dbObject.put("key_wd",keyWd);
                dbObject.put("industry",industry);
                dbObject.put("cxxx",cxxx);
                dbObject.put("fwcb",fwcb);
                dbObject.put("fmxw",fmxw);
                dbObject.put("sxykb",sxykb);
                dbObject.put("xsxs",xsxs);
                dbObject.put("nonefivesub",nonefivesub);

                data.add(dbObject);
                if (count % 2000 == 0 || count == list.size() + 1) {
                    inlp.insert(data);
                    data = new ArrayList<DBObject>();
                    System.out.println(count + "条数据已导入");
                }
                count++;
            }
        }

    }

    public static void main(String[] args) {
        DataMigrate d = new DataMigrate();
        d.saveDataToMongodb();
    }
}
