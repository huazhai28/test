package test;



import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class BDao {


    
    public String test;

//private static MongoClient mongoClient=null;
    
    //对mongoClient初始化
//    public BDao(){
//        //连接池选项
//    	ArrayList<ServerAddress> serverAddressList = new ArrayList();
//    	ServerAddress record = new ServerAddress("192.168.1.232", 27017); //IP、端口
//        serverAddressList.add(record);
//        Builder builder = new MongoClientOptions.Builder();//选项构建者  
//        builder.connectTimeout(5000);//设置连接超时时间
//        builder.socketTimeout(5000);//读取数据的超时时间
//        builder.connectionsPerHost(30);//每个地址最大请求数      
//        MongoClientOptions options = builder.build();
//        List<MongoCredential> credentials = new ArrayList();
//        MongoCredential credential = MongoCredential.createScramSha1Credential("aovm", "aovm", "111111".toCharArray());
//        credentials.add(credential);
//        mongoClient=new MongoClient(serverAddressList,credentials,options);  
//    	
//}

    public static void main(String[] args) {
//    	BDao b = new BDao();
//    	MongoDatabase database = b.mongoClient.getDatabase("aovm");
//    	MongoCollection<Document> collection = database.getCollection("USER");
//    	BasicDBObject bson= new BasicDBObject("userName", "5345");
//    	BasicDBObject bson2 = new BasicDBObject("$set",  new BasicDBObject("passWord", "7678"));
//    	collection.updateOne(bson, bson2);
    	
//    	GetDataBase gd = new GetDataBase();
    	
    	
	}
    
}