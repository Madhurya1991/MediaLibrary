package finalproject;

import java.util.ArrayList;
import java.util.HashMap;

public class New_Database {

	public String movies(String s1){
		HashMap<String,ArrayList<String>> movies= new HashMap<String,ArrayList<String>>();
		ArrayList<String> drama=new ArrayList<>();
		ArrayList<String> fiction=new ArrayList<>();
		ArrayList<String> bollywood=new ArrayList<>();
		ArrayList<String> romantic=new ArrayList<>();
		
		drama.add("12 Years a Slave(2013).avi");
		drama.add("Argo(2012).mp4");
		drama.add("Carrie(2013).avi");
		drama.add("The Da Vinci Code(2006).avi");
		drama.add("The Social Network(2010).avi");
		drama.add("The Wolf of Wall Street(2013).avi");
		drama.add("Zero Dark Thirty (2012).mkv");
		
		fiction.add("Angels an Demons.mkv\"");
		fiction.add("Harry Potter and the Deathly Hallows Part 1.avi");
		fiction.add("Harry Potter and the Deathly Hallows Part 2 .avi");
		fiction.add("Pirates Of The Caribbean On Stranger Tides.mkv");
		fiction.add("The Twilight Saga Breaking Dawn Part 1 (2011).avi");
		fiction.add("The.Twilight.Saga.Breaking.Dawn.Part.2.2012.mp4");
		fiction.add("Twilight New  Moon(2009).mkv");
		
		bollywood.add("HighWay (2014).mkv");
		bollywood.add("Lunch Box (2013).avi");
		bollywood.add("Wake Up Sid.avi");
		bollywood.add("Yeh Jawaani Hai Deewani.avi");
		
		romantic.add("A Lot Like Love.avi");
		romantic.add("He's Just Not That Into You[2009].avi");
		romantic.add("Life as we Know it (2010).mkv");
		romantic.add("No Strings Attached {2011}.mp4");
		romantic.add("One Day[2011].avi");
		romantic.add("The Holiday[2006].mkv");
		romantic.add("The Proposal[2009].avi");
		romantic.add("The Romantic.avi");
		romantic.add("The Wedding Date [2005].avi");
		
		movies.put("Drama",drama);
		movies.put("Fiction",fiction);
		movies.put("Bollywood",bollywood);
		movies.put("Romantic",romantic);
		
		String Str1 = "";
		
		if(s1.equals("Drama"))
		{
			for(String s: movies.get("Drama"))
                        {
			Str1=Str1+","+s;
                        }
                        return Str1;
		}
		if(s1.equals("Fiction"))
		{
			for(String s: movies.get("Fiction"))
			{
			Str1=Str1+","+s;
                        }
                        return Str1;
		}
		if(s1.equals("Bollywood"))
		{
			for(String s: movies.get("Bollywood"))
			{
			Str1=Str1+","+s;
                        }
                        return Str1;
		}
		if(s1.equals("Romantic"))
		{
			for(String s: movies.get("Romantic"))
			{
			Str1=Str1+","+s;
                        }
                        return Str1;
		}
            return null;
	
	}

}
