import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * @author Mr Lin
 * 封装增删改查方法
 */
public class MongoSession extends AbstractMongoSession {
    public MongoSession(MongoDatabase db) {
        this.setDb(db);
    }

    @Override
    public void save(Object obj) {
    	
    	this.Collection(obj.getClass());
        try {
            this.getCollection().insertOne(BsonUtil.toBson(obj));
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object obj) throws Exception {
    	this.Collection(obj.getClass());
        try {
            this.getCollection().deleteOne(
                    BsonUtil.toBson(obj));
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public void deleteAll(Object obj) throws Exception {
    	this.Collection(obj.getClass());
        try {
            this.getCollection().deleteMany(
                    BsonUtil.toBson(obj));
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void saveMany(List<Object> obj) {
        try {
            this.getCollection().insertMany(BsonUtil.toBsons(obj));
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public long delete(Bson bson) throws Exception {
        DeleteResult deleteResult = this.getCollection().deleteOne(bson);
        return deleteResult.getDeletedCount();
    }

    @Override
    public long deleteMany(List<Object> objs) {
        List<Document> documents;
        int count = 0;
        try {
            documents = BsonUtil.toBsons(objs);
            for (int i = 0; null != documents && i < documents.size(); i++) {
                DeleteResult deleteResult = this.getCollection().deleteOne(
                        documents.get(i));
                count += deleteResult.getDeletedCount();
            }
            return count;
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long deleteMany(Bson bson) {
        DeleteResult deleteResult = this.getCollection().deleteMany(bson);
        return deleteResult.getDeletedCount();
    }

    @Override
    public long upate(Bson bson, Object obj) {
        try {
            UpdateResult result = this.getCollection().updateOne(bson,
                    new Document("$set", BsonUtil.toBson(obj)));
            return result.getMatchedCount();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void update(Object obj) {
    	this.Collection(obj.getClass());
        Document document;
        try {
            document = BsonUtil.toBson(obj);
            this.getCollection().updateOne(
                    Filters.eq("_id", document.get("_id")),
                    new Document("$set", document));
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void updateAll(Object arg,Object val) {
    	this.Collection(arg.getClass());
        Document document;
        try {
            document = BsonUtil.toBson(arg);
            this.getCollection().updateMany(document,
            		new Document("$set", BsonUtil.toBson(val)));
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public long upateMany(Bson bson, Object obj) {
        try {
            UpdateResult updateResult = this.getCollection().updateMany(bson,
                    new Document("$set", BsonUtil.toBson(obj)));
            return updateResult.getMatchedCount();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public long upateMany(Bson bson, List<Object> obj) {
        for (int i = 0; null != obj && i < obj.size(); i++) {
            try {
                UpdateResult result = this.getCollection().updateMany(bson,
                        new Document("$set", BsonUtil.toBson(obj)));
                return result.getMatchedCount();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public long upateMany(List<Object> objs) {
        long count = 0;
        for (int i = 0; null != objs && i < objs.size(); i++) {
            try {
                UpdateResult result = this.getCollection().updateMany(
                        Filters.eq("_id",
                                BsonUtil.toBson(objs.get(i)).get("_id")),
                        new Document("$set", BsonUtil.toBson(objs.get(i))));
                count += result.getMatchedCount();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public Object find(Object obj) {
    	this.Collection(obj.getClass());
        try {
            Document document = this.getCollection()
                    .find(Filters.eq("_id", BsonUtil.toBson(obj).get("_id")))
                    .first();
            return BsonUtil.toBean(document, this.getClazz());
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> findAll(Object obj) {
    	this.Collection(obj.getClass());
    	List<Object> objects = null;
    	try {
        FindIterable<Document> doIterable = this.getCollection().find(BsonUtil.toBson(obj));
        MongoCursor<Document> cursor = doIterable.iterator();
        objects = new ArrayList<Object>();
        
        while (cursor.hasNext()) {
            Document document = cursor.next();
                objects.add(BsonUtil.toBean(document, this.getClazz()));
        }
    	}catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return objects;
    }
    @Override
    public List<Object> finds(Object obj) {
    	this.Collection(obj.getClass());
        FindIterable<Document> doIterable = this.getCollection().find();
        MongoCursor<Document> cursor = doIterable.iterator();
        List<Object> objects = new ArrayList<Object>();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            try {
                objects.add(BsonUtil.toBean(document, this.getClazz()));
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return objects;
    }

    @Override
    public List<Object> query(Bson bson) {
        FindIterable<Document> doIterable = this.getCollection().find(bson);
        MongoCursor<Document> cursor = doIterable.iterator();
        List<Object> objects = new ArrayList<Object>();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            try {
                objects.add(BsonUtil.toBean(document, this.getClazz()));
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return objects;
    }

    @Override
    public Object queryOne(Bson bson) {
        Document document = this.getCollection().find(bson).first();
        try {
            return BsonUtil.toBean(document, this.getClazz());
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> query(Bson bson, Bson sort) {
        FindIterable<Document> doIterable = this.getCollection().find(bson)
                .sort(sort);
        MongoCursor<Document> cursor = doIterable.iterator();
        List<Object> objects = new ArrayList<Object>();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            try {
                objects.add(BsonUtil.toBean(document, this.getClazz()));
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return objects;
    }

    @Override
    public Object queryOne(Bson bson, Bson sort) {
        Document document = this.getCollection().find(bson).sort(sort).first();
        try {
            return BsonUtil.toBean(document, this.getClazz());
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> query(Bson bson, Bson sort, int limit) {
        FindIterable<Document> doIterable = this.getCollection().find(bson)
                .sort(sort);
        if (limit > 0) {
            doIterable = doIterable.limit(limit);
        }
        MongoCursor<Document> cursor = doIterable.iterator();
        List<Object> objects = new ArrayList<Object>();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            try {
                objects.add(BsonUtil.toBean(document, this.getClazz()));
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return objects;
    }

    @Override
    public List<Object> query(Bson bson, Bson sort, int limit, int skip) {
        FindIterable<Document> doIterable = this.getCollection().find(bson)
                .sort(sort);
        if (limit > 0) {
            doIterable = doIterable.limit(limit);
        }
        if (skip > 0) {
            doIterable = doIterable.skip(skip);
        }
        MongoCursor<Document> cursor = doIterable.iterator();
        List<Object> objects = new ArrayList<Object>();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            try {
                objects.add(BsonUtil.toBean(document, this.getClazz()));
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return objects;
    }

    @Override
    public List<Object> query(Bson bson, Bson sort, Bson filter) {
        FindIterable<Document> doIterable = this.getCollection().find(bson)
                .sort(sort).filter(filter);
        MongoCursor<Document> cursor = doIterable.iterator();
        List<Object> objects = new ArrayList<Object>();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            try {
                objects.add(BsonUtil.toBean(document, this.getClazz()));
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return objects;
    }

    @Override
    public Object queryOne(Bson bson, Bson sort, Bson Filter) {
        Document document = this.getCollection().find(bson).sort(sort)
                .filter(Filter).first();

        try {
            return BsonUtil.toBean(document, this.getClazz());
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long count(Object obj) {
    	this.Collection(obj.getClass());
        return this.getCollection().count();
    }

    @Override
    public long count(Bson bson) {
        // TODO Auto-generated method stub
        return this.getCollection().count(bson);
    }
}