import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.ne;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class ConsultaE {

	public static void main(String[] args) {
		Bson filter = and(eq("name", Pattern.compile("the")), ne("genres", "Comedy"));
		Bson project = and(eq("name", 1L), eq("genres", 1L));

	String user = "root"; // the user name
	String source = "admin"; // the name of the database in which the user is defined
	char[] password = {'r','o','o','t'}; // the password as a character array
	// ...
	MongoCredential credential = MongoCredential.createCredential(user, source, password);
	MongoClient mongoClient = MongoClients.create(
	        MongoClientSettings.builder()
	                .applyToClusterSettings(builder -> 
	                        builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
	                .credential(credential)
	                .build());
	MongoDatabase database = mongoClient.getDatabase("movieData");
	MongoCollection<Document> collection = database.getCollection("movies");
	MongoCursor<Document> result = collection.find(filter)
	    .projection(project).iterator();
	try {
	    while (result.hasNext()) {
	        System.out.println(result.next().toJson());
	    }
	} finally {
	    result.close();
	}

	}

}


