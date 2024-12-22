import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Tweet {
    private String subject;
    private LocalDate dateOfPost;
    private int views;
    private Set<String> hashtags;

    public Tweet(String subject, LocalDate dateOfPost, int views, Set<String> hashtags) {
        this.subject = subject;
        this.dateOfPost = dateOfPost;
        this.views = views;
        this.hashtags = hashtags;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDate getDateOfPost() {
        return dateOfPost;
    }

    public int getViews() {
        return views;
    }

    public Set<String> getHashtags() {
        return hashtags;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "subject='" + subject + '\'' +
                ", dateOfPost=" + dateOfPost +
                ", views=" + views +
                ", hashtags=" + hashtags +
                '}';
    }
}

class Twitter {
    private List<Tweet> tweets;

    public Twitter() {
        this.tweets = new ArrayList<>();
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public List<Tweet> getTweetsPostedInCurrentMonth() {
        LocalDate now = LocalDate.now();
        return tweets.stream()
                .filter(tweet -> tweet.getDateOfPost().getMonth() == now.getMonth() && tweet.getDateOfPost().getYear() == now.getYear())
                .collect(Collectors.toList());
    }

    public List<Tweet> getTweetsByHashtag(String hashtag) {
        return tweets.stream()
                .filter(tweet -> tweet.getHashtags().contains(hashtag))
                .collect(Collectors.toList());
    }

    public Map<String, Long> countTweetsBySubject() {
        return tweets.stream()
                .collect(Collectors.groupingBy(Tweet::getSubject, Collectors.counting()));
    }

    public List<Tweet> getTweetsWithMoreThan10KViews() {
        return tweets.stream()
                .filter(tweet -> tweet.getViews() > 10000)
                .collect(Collectors.toList());
    }

    public List<Tweet> getTop5TrendingTweets() {
        return tweets.stream()
                .sorted(Comparator.comparingInt(Tweet::getViews).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}

public class Tweeter{
    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // Sample tweets
        twitter.addTweet(new Tweet("Weather Update", LocalDate.of(2024, 10, 1), 15000, new HashSet<>(Arrays.asList("#punerains", "#flood"))));
        twitter.addTweet(new Tweet("Sports Event", LocalDate.of(2024, 9, 28), 8000, new HashSet<>(Arrays.asList("#sports", "#event"))));
        twitter.addTweet(new Tweet("Tech News", LocalDate.of(2024, 10, 5), 20000, new HashSet<>(Arrays.asList("#technology", "#innovation"))));
        twitter.addTweet(new Tweet("Weather Alert", LocalDate.of(2024, 10, 2), 5000, new HashSet<>(Arrays.asList("#punerains"))));
        twitter.addTweet(new Tweet("Breaking News", LocalDate.of(2024, 10, 4), 30000, new HashSet<>(Arrays.asList("#breaking", "#news"))));

        // Operations
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
