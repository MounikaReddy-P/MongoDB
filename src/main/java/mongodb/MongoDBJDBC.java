package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.List;

public class MongoDBJDBC {

	public static void main(String[] args) {

		try {

			// To connect to mongodb server
			MongoClient mongoClient = new MongoClient("localhost", 27017);

			// Now connect to your databases
			DB db = mongoClient.getDB("myDatabase");
			System.out.println("Connect to database successfully");
			// boolean auth = db.authenticate(myUserName, myPassword);
			// System.out.println("Authentication: "+auth);

			// creating collection
			DBCollection mycol = db.getCollection("mycol");
			System.out.println("Collection created successfully");
			//System.out.println(mycol);

			//Retrieving DB Names
			List<String> dbs = mongoClient.getDatabaseNames();
			for (String dbName : dbs) {
				System.out.println(dbName);
			}

			BasicDBObject doc = new BasicDBObject("title", "MongoDB").append("likes", 100)
					.append("description", "Database").append("url", "http://www.tutorialspoint.com/mongodb/")
					.append("by", "Mounika Pullagurla");
			mycol.insert(doc);
			
			//retrieving all documents
			DBCursor cursor=mycol.find();
			int i=1;
			while(cursor.hasNext()){
				System.out.println("inserted doument"+i);
				System.out.println(cursor.next());
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

}
