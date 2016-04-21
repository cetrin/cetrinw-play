package com.cetrinw.wang.db;

import com.cetrinw.util.DatabaseUtil;
import com.cetrinw.wang.entity.Cetrinw;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * Created by Cetrin Wang on 2016/4/21.
 */
public class SelectData {

    private MongoTemplate template;

    private SelectData(){
        template = new MongoTemplate(DatabaseUtil.getMongodbConnection(),"local");
    }

    private void getData(){
        List<Cetrinw>  list =  template.findAll(Cetrinw.class);
        for (Cetrinw content : list) {
            System.out.println(content.getContent());
        }

    }

    public static void main(String[] args) {
        SelectData s = new SelectData();
        s.getData();
    }
}
