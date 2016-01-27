package me.cbonilla20.main;

import me.cbonilla20.manager.TweetManager;
import me.cbonilla20.manager.TwitterCriteria;
import me.cbonilla20.model.Tweet;

public class Main {
	
	public static void main(String[] args) {
		/**
		 * Reusable objects
		 */
		TwitterCriteria criteria = null;
		Tweet t = null;
		
		/**
		 *  Example 1 - Get tweets by username
		 **/
		/*
		criteria = TwitterCriteria.create()
				.setUsername("barackobama")
				.setMaxTweets(1);
		t = TweetManager.getTweets(criteria).get(0);
		
		System.out.println("### Example 1 - Get tweets by username [barackobama]");
		System.out.println("Username: " + t.getUsername());
		System.out.println("Retweets: " + t.getRetweets());
		System.out.println("Text: " + t.getText());
		System.out.println("Mentions: " + t.getMentions());
		System.out.println("Hashtags: " + t.getHashtags());
		System.out.println();
		*/
		/**
		 *  Example 2 - Get tweets by query search
		 **/
                /*
		criteria = TwitterCriteria.create()
				.setQuerySearch("europe refugees")
				.setSince("2015-05-01")
				.setUntil("2015-09-30")
				.setMaxTweets(1);
		t = TweetManager.getTweets(criteria).get(0);
		
		System.out.println("### Example 2 - Get tweets by query search [europe refugees]");
		System.out.println("Username: " + t.getUsername());
		System.out.println("Retweets: " + t.getRetweets());
		System.out.println("Text: " + t.getText());
		System.out.println("Mentions: " + t.getMentions());
		System.out.println("Hashtags: " + t.getHashtags());
		System.out.println();
		*/
		/**
		 *  Example 3 - Get tweets by username and bound dates
		 **/
                /*
		criteria = TwitterCriteria.create()
				.setUsername("barackobama")
				.setSince("2015-09-10")
				.setUntil("2015-09-12")
				.setMaxTweets(1);
		t = TweetManager.getTweets(criteria).get(0);
		
		System.out.println("### Example 3 - Get tweets by username and bound dates [barackobama, '2015-09-10', '2015-09-12']");
		System.out.println("Username: " + t.getUsername());
		System.out.println("Retweets: " + t.getRetweets());
		System.out.println("Text: " + t.getText());
		System.out.println("Mentions: " + t.getMentions());
		System.out.println("Hashtags: " + t.getHashtags());
		System.out.println();
                */
                /**
		 *  Example 4 - Get tweets by query search with geolocation
		 **/
		criteria = TwitterCriteria.create()
				.setQuerySearch("medicina necesito")
                                .setNear("Venezuela")
				.setSince("2016-01-01")
				.setUntil("2016-01-26")
				.setMaxTweets(20);
		t = TweetManager.getTweets(criteria).get(0);
		
		System.out.println("### Example 2 - Get tweets by query search [necesito medicina]");
		System.out.println("Username: " + t.getUsername());
		System.out.println("Retweets: " + t.getRetweets());
		System.out.println("Text: " + t.getText());
		System.out.println("Mentions: " + t.getMentions());
		System.out.println("Hashtags: " + t.getHashtags());
		System.out.println();
		
                
	}
	
}