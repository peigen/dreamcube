package com.dreamcube.core.dal.mongo;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * 
 * Filename: MongoDBStore.java
 * 
 * Description: 考虑到以后会是用mongodb作为我们的键值数据库，缓存数据库。 先做点技术储备。
 * 
 * Version: 0.1
 * 
 * Author: peigen
 * 
 * Email: peigen123@gmail.com
 * 
 * Blog: http://peigen.info
 * 
 * 
 * History:<br>
 *<li>Author: peigen</li> <li>Date: 2010-4-12</li> <li>Version: 0.1</li> <li>
 * Content: create</li>
 * 
 */
public class MongoDBStore {

    /**
     * @param args
     * @throws MongoException
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException, MongoException {

        Mongo mongo = new Mongo("localhost", 1983);
        DB db = mongo.getDB("dreamcube");

        DBCollection coll = db.getCollection("dreamcubeConllection");

        //        coll.drop();
        //        insertObject(coll);
        //        insertObject(coll);

        //        remove(coll);

        long start = System.currentTimeMillis();

        DBObject dbObject = new BasicDBObject();
        dbObject.put("category", "DC_SQUAD");

        DBCursor cur = coll.find(dbObject);

        while (cur.hasNext()) {
            System.out.println(cur.next());
        }

        System.out.println("总共有几个：" + coll.getCount());

        long end = System.currentTimeMillis();

        System.out.println("总耗时:" + (end - start) + "毫秒");

        showCollections(db);
    }

    private static void showCollections(DB db) {
        Set<String> colls = db.getCollectionNames();

        System.err.println("showCollections");
        System.out.println(colls);

        for (String s : colls) {
            System.out.println(s);
        }
    }

    private static void insertObject(DBCollection coll) {
        BasicDBObject doc = new BasicDBObject();

        doc.put("name", "MongoDB");
        doc.put("type", "database");
        doc.put("count", 1);
        doc.put("name", "peigen");

        BasicDBObject info = new BasicDBObject();

        info.put("x", 203);
        info.put("y", 102);
        info.put("z", 152);

        doc.put("info", info);

        coll.insert(doc);

    }

    private static void findOne(DBCollection coll) {
        DBObject myDoc = coll.findOne();
        System.out.println(myDoc);
    }

    private static void remove(DBCollection coll) {
        BasicDBObject doc = new BasicDBObject("name", "peigen");
        coll.remove(doc);
    }

}
