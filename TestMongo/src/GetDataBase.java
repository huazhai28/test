import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.client.MongoDatabase;

/**
 * @author Mr Lin
 * 获取连接池
 */
public class GetDataBase {
	
	private static MongoClient mongoClient;
	protected static MongoSession session;
	
	public GetDataBase(){
		session = new MongoSession(getDataBase());
	}

	public MongoDatabase getDataBase(){
		//连接池选项
    	ArrayList<ServerAddress> serverAddressList = new ArrayList();
    	ServerAddress record = new ServerAddress("192.168.1.232", 27017); //IP、端口
        serverAddressList.add(record);
        Builder builder = new MongoClientOptions.Builder();//选项构建者  
        builder.connectTimeout(5000);//设置连接超时时间
        builder.socketTimeout(5000);//读取数据的超时时间
        builder.connectionsPerHost(30);//每个地址最大请求数    
        builder.writeConcern(WriteConcern.NORMAL);
        MongoClientOptions options = builder.build();
        List<MongoCredential> credentialList = new ArrayList();
        MongoCredential credential = MongoCredential.createScramSha1Credential("aovm", "aovm", "111111".toCharArray());
        credentialList.add(credential);
        mongoClient=new MongoClient(serverAddressList,credentialList,options); 
        MongoDatabase database = mongoClient.getDatabase("aovm");
        return database;
	}
	
	
}
