package academy.pocu.comp3500samples.w12.cheapestflights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
        City vancouver = new City("Vanvouver");
        City toronto = new City("Toronto");
        City seattle = new City("Seattle");
        City newYork = new City("New York");
        City losAngeles = new City("Los Angeles");
        City miami = new City("Miami");
        City london = new City("London");
        City paris = new City("Paris");

        // TODO: Finish drawing graph
        vancouver.addFlight("Toronto", 255);
        vancouver.addFlight("Seattle", 100);
        vancouver.addFlight("New York", 660);

        seattle.addFlight("Vancouver", 112);
        seattle.addFlight("Los Angeles", 150);
        seattle.addFlight("Miami", 500);

        ArrayList<City> cities = new ArrayList<>();

        cities.add(vancouver);
        cities.add(toronto);
        cities.add(seattle);
        cities.add(newYork);
        cities.add(losAngeles);
        cities.add(miami);
        cities.add(london);
        cities.add(paris);

        final HashMap<String, String> previous = new HashMap<>();

        HashMap<String, Integer> prices = Dijkstra
                .findMinimumPrices(cities,
                        "Vancouver",
                        previous);

        System.out.println(prices.get("London"));

        System.out.println(prices.get("New York"));

        System.out.println(prices.get("Miami"));

        String destination = "London";

        LinkedList<String> path = new LinkedList<>();

        while (destination != null) {
            path.addFirst(destination);
            destination = previous
                    .get(destination);
        }

        System.out.println(String.join(" -> ", path));
    }
}
