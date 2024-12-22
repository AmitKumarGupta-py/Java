import java.time.LocalDate;
import java.util.Set;

public class Tweet {
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
