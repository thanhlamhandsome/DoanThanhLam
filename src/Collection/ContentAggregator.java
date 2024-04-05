package Collection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContentAggregator {
    public static void main(String[] args) {
        // Suppose we have streams of content from different sources
        Stream<String> netflixStream = Stream.of("Netflix movie 1", "Netflix movie 2");
        Stream<String> huluStream = Stream.of("Hulu show 1", "Hulu show 2");
        Stream<String> spotifyStream = Stream.of("Spotify song 1", "Spotify song 2");

        // Aggregate content from all sources into a single list
        List<String> allContent = Stream.concat(netflixStream, Stream.concat(huluStream, spotifyStream))
                .collect(Collectors.toList());

        System.out.println("All content: " + allContent);
    }
}
