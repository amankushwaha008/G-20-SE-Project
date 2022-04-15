import com.mongodb.client.FindIterable;
import java.util.Iterator;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;


public class MongoMain {
    public static void main(String[] args) {
        String uri = "mongodb+srv://mmsDatabaseAdmin:mmsDatabaseAdmin%40123@mmsdatabase.wkimz.mongodb.net/test";
        MongoClientURI clientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(clientURI);


        MongoDatabase mongoDatabase = mongoClient.getDatabase("commonDatabase");
        MongoCollection<Document> collection = mongoDatabase.getCollection("messRates");
        FindIterable<Document> iterDoc = collection.find();
        // Iterator it = iterDoc.iterator();
        int[] arr;
        arr = new int[3];
        int i = 0;
        
        for(Document doc : iterDoc){
            arr[i] = (int)doc.get("rate");
            i++;
            // System.out.println(doc.get("rate"));
        }
        for( i=0; i<3; i++){
            System.out.println(arr[i]);
        }

    }
}
