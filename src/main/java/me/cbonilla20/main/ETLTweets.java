/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.cbonilla20.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import me.cbonilla20.manager.TweetManager;
import me.cbonilla20.manager.TwitterCriteria;
import me.cbonilla20.model.Tweet;


/**
 *
 * @author Cesar Bonilla
 */
public class ETLTweets {
        private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    	
        public static List<String> StringQueryBuilder() {
            List<String> wordsNeeds = new ArrayList<String>();
                wordsNeeds.add("necesito");               
                wordsNeeds.add("requiero");
                wordsNeeds.add("solicito");
                wordsNeeds.add("necesita");
                wordsNeeds.add("requiere");
                wordsNeeds.add("busca");
                wordsNeeds.add("busco");
                wordsNeeds.add("ayuda");
                
                List<String> specialNeeds = new ArrayList<String>();
                specialNeeds.add("");
                specialNeeds.add("urgente");
                specialNeeds.add("urgencia");
                specialNeeds.add("#ServicioPublico");
                
                List<String> wordsMed = new ArrayList<String>();
                wordsMed.add("medicamento");
                wordsMed.add("medicina");
                
                List<String> querys = new ArrayList<String>();
                for (String med : wordsMed)
                    for (String need : wordsNeeds)
                        for (String spe : specialNeeds)
                                querys.add(spe+" "+ need +" "+med);
        return querys;
    }
        
        public static void main(String[] args) {
		/**
		 * Reusable objects
		 */
		Tweet t0 = null;
                List<Tweet> tweets = null;  
		
                List<String> querys = StringQueryBuilder();
                
                for (String query : querys){
                    TwitterCriteria criteria = null;
                    criteria = TwitterCriteria.create()
                                    .setQuerySearch(query)
                                    .setNear("Venezuela")
                                    .setSince("2015-12-01")
                                    .setUntil("2015-12-31");
                    if (tweets == null)
                        tweets = TweetManager.getTweets(criteria);
                    else
                        tweets.addAll(TweetManager.getTweets(criteria));

                    //t0 = tweets.get(0);
                }
                /*
		System.out.println("### Example 2 - Get tweets by query search [necesito medicina]");
		System.out.println("Username: " + t0.getUsername());
		System.out.println("Retweets: " + t0.getRetweets());
		System.out.println("Text: " + t0.getText());
		System.out.println("Mentions: " + t0.getMentions());
		System.out.println("Hashtags: " + t0.getHashtags());
		System.out.println();
                */
                try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("output_got_diciembre.csv"));
				bw.write("username;date;retweets;favorites;text;geo;mentions;hashtags;id;permalink");
				bw.newLine();
				
				System.out.println("Searching... \n");
				for (Tweet t : tweets) {
					bw.write(String.format("%s;%s;%d;%d;\"%s\";%s;%s;%s;\"%s\";%s", t.getUsername(), sdf.format(t.getDate()), t.getRetweets(), t.getFavorites(), t.getText(), t.getGeo(), t.getMentions(), t.getHashtags(), t.getId(), t.getPermalink()));
					bw.newLine();
				}
				
				bw.close();
				
				System.out.println("Done. Output file generated \"output_got.csv\".");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
                
	}
    
}
