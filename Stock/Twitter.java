import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Twitter {
    private List<Tweet> tweets;

    public Twitter() {
        this.tweets = new ArrayList<>();
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public List<Tweet> getTweetsPostedInCurrentMonth() {
        LocalDate now = LocalDate.now();
        return tweets.stream().filter(tweet -> tweet.getDateOfPost().getMonth() == now.getMonth() && tweet.getDateOfPost().getYear() == now.getYear()).collect(Collectors.toList());
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
