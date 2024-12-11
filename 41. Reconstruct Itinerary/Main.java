
import java.util.*;

public class Main {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> flightMap = new HashMap<>();
        List<String> result = new LinkedList<>();

        // Populate the flight map with each departure and arrival
        for (List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);
            flightMap.putIfAbsent(departure, new ArrayList<>());
            flightMap.get(departure).add(arrival);
        }

        // Sort each list of destinations in reverse lexicographical order
        for (Map.Entry<String, List<String>> entry : flightMap.entrySet()) {
            Collections.sort(entry.getValue(), Collections.reverseOrder());
        }

        // Perform DFS traversal
        dfsTraversal("JFK", flightMap, result);

        return result;
    }

    private static void dfsTraversal(String current, Map<String, List<String>> flightMap, List<String> result) {
        List<String> destinations = flightMap.get(current);

        // Traverse all destinations in the order of their lexicographical
        // sorting
        while (destinations != null && !destinations.isEmpty()) {
            String nextDestination = destinations.remove(destinations.size() - 1);
            dfsTraversal(nextDestination, flightMap, result);
        }

        // Append the current airport to the result after all destinations are
        // visited
        result.add(0, current);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = List.of(
                List.of("JFK", "KUL"),
                List.of("JFK", "NRT"),
                List.of("NRT", "SFO"),
                List.of("JFK", "KUL"));

        System.out.println(findItinerary(tickets));
    }
}