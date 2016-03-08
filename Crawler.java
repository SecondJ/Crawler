package BaseCrawler;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Crawler {
			
	/**
	 * ´«ÈëÍøÖ·uri·ÃÎÊÍøÖ· ·µ»ØhtmlµÄ×Ö·û´®
	 * @param webUrl
	 * @throws IOException
	 */
	public static void craw(String webUrl) throws IOException {
		URL url = new URL(webUrl);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.connect();
		
		InputStream in = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(in,"utf-8");
		BufferedReader buffReader = new BufferedReader(reader);
		
		//ÊäÈëÆ¥Åä
		StringBuilder builder = new StringBuilder();
		String result;
		while((result = buffReader.readLine()) != null){
			builder.append(result);
		}
		//System.out.println(builder);
		
		buffReader.close();

	}
}
