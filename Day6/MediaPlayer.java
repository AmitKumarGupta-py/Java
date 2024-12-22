package Day6;
import java.util.ArrayList;
import java.util.List;


public class MediaPlayer {

    public void playMyList(List<? extends Media> medialist)
    {
        /*whem wild card is used the
         *      collection can not be modified*/
         // medialist.add(new Video()); doesn't compile

        for(Media m : medialist)
        {
            m.play();
        }
    }

    public static void main(String[] args) {
        
        MediaPlayer player = new MediaPlayer();

        List<Song> songs = new ArrayList<>();
        songs.add(new Song(323,"fwe"));
        songs.add(new Song(453,"fdg"));
        songs.add(new Song(554,"gffh"));
        
        player.playMyList(songs);
    }

    
}
