package MeiTuanCrawler;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MeiTuanCrawler {
			
	/**
	 * 传入美团商户cd.meituan.com/shop/ID 获取网页内电话号码并打印到控制台
	 * @param shop
	 * @throws IOException
	 */
	public static void crawMeiTuan(int shop) throws IOException {
		URL url = new URL("http://cd.meituan.com/shop/"+shop+"?acm=UwunyailsW1832073378613538237.767678.2&mtt=1.index%2Fdefault%2Fpoi.pz.8.iljisrua&cks=63208#smh:bdw");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.connect();
		
		InputStream in = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(in,"utf-8");
		BufferedReader buffReader = new BufferedReader(reader);
		
		//输入匹配
		StringBuilder builder = new StringBuilder();
		String result;
		while((result = buffReader.readLine()) != null){
			builder.append(result);
		}
		//System.out.println(builder);
		
		Pattern pattern = Pattern.compile("美食");   //匹配“美食”关键字
		Matcher matcher= pattern.matcher(builder);
		Pattern pattern2 = Pattern.compile("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d./p.");  //匹配电话号码
		Matcher matcher2= pattern2.matcher(builder);   

		if(matcher2.find()){
			System.out.println(matcher2.group());
		}
		
		buffReader.close();

	}
}
