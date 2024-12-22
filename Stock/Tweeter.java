import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

public class Tweeter{
    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        
        twitter.addTweet(new Tweet("Weather Update", LocalDate.of(2024, 10, 1), 15000, new HashSet<>(Arrays.asList("#punerains", "#flood"))));
        twitter.addTweet(new Tweet("Sports Event", LocalDate.of(2024, 9, 28), 8000, new HashSet<>(Arrays.asList("#sports", "#event"))));
        twitter.addTweet(new Tweet("Tech News", LocalDate.of(2024, 10, 5), 20000, new HashSet<>(Arrays.asList("#technology", "#innovation"))));
        twitter.addTweet(new Tweet("Weather Alert", LocalDate.of(2024, 10, 2), 5000, new HashSet<>(Arrays.asList("#punerains"))));
        twitter.addTweet(new Tweet("Breaking News", LocalDate.of(2024, 10, 4), 30000, new HashSet<>(Arrays.asList("#breaking", "#news"))));

        
        System.out.println("Tweets posted in current month:");
        System.out.println(twitter.getTweetsPostedInCurrentMonth());

        System.out.println("\nTweets with hashtag #punerains:");
        System.out.println(twitter.getTweetsByHashtag("#punerains"));

        System.out.println("\nCount of tweets by subject:");
        System.out.println(twitter.countTweetsBySubject());

        System.out.println("\nTweets with more than 10K views:");
        System.out.println(twitter.getTweetsWithMoreThan10KViews());

        System.out.println("\nTop 5 trending tweets:");
        System.out.println(twitter.getTop5TrendingTweets());
    }
}
