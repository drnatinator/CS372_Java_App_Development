/**
 * HW04_02 Web Spider
 * @author Nate Williams
 * @version 1.00, 22 January 2019
 */

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.*;


public class FindURL {
	
	private static Map <String, Boolean> myHMap = new HashMap<String, Boolean>();
	
	public static void main(String[] args) {
		String oldUrl="";
		boolean goOn=true;
		int counter = 25;
		
		//a couple of alternate starting places:
		
		//String s = "https://www.usaswimming.org/home";
		String s = "https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap";
		//String s = "http://lotr.wikia.com/wiki/T%C3%BArin";
		myHMap.put(s, false);
		
		while (counter >0&&goOn==true) {
			counter--;//so we don't go forever
			try {
				oldUrl=s;//save the URL to compare later
				URL u = new URL (s);//set the URL
				System.out.printf("\n\nNEW URL: %s\n\n\n", s);//announce that a new page is being combed for sites
				BufferedReader rdr = new BufferedReader(new InputStreamReader(u.openStream()));
				String line;
				
				while ((line = rdr.readLine())!=null) {//iterate through each line of HTML
					Pattern url = Pattern.compile("http(.*?)\"");//look for things with http that end in a double quote
					Matcher matcher = url.matcher(line);
					//System.out.println("here");//for debugging
					if (matcher.find()) {//if we find something that fits the pattern, it's most likely a URL
						s= "http"+matcher.group(1);
						myHMap.put(s, false);//put the new URL in the hashmap
						System.out.printf("URL: %s; %s\n",  myHMap.get(s),s);}//output in the console the newly found URL
					}
				
			}
			catch(Exception ex) {
				System.out.printf("Failed url: %s\n", s);
				//ex.printStackTrace(System.out);
				myHMap.put(s, true);
			}
			for (Entry<String, Boolean> entry : myHMap.entrySet()) {//iterate through the hashmap until we find a URL that hasn't been tried yet
			    String key = entry.getKey();
			    Boolean visited = entry.getValue();
			    //System.out.printf("%s; %s\n",visited, key);
			    if(visited==false) {//if the URL hasn't been tried, it'll be the next one
			    	s=key;
			    	myHMap.put(s, true);//change the value to true, so we know to pick a different one next time
			    	break;//no need to examine any other elements of the hashmap for now
			    }
			}	
			if (s==oldUrl&&counter>0) {//if no new link was selected by the above for-loop, we've exhausted all the links in this system, so we end the program.
				System.out.printf("No more links! Spider is done!\n");
				goOn=false;
			}
		}
	}
		
}
