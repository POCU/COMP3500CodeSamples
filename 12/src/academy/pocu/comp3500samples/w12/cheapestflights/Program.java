package academy.pocu.comp3500samples.w12.cheapestflights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
        final ArrayList<City> cities = createCities();

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

    private static ArrayList<City> createCities() {
        City vancouver = new City("Vancouver");
        City toronto = new City("Toronto");
        City seattle = new City("Seattle");
        City newYork = new City("New York");
        City losAngeles = new City("Los Angeles");
        City miami = new City("Miami");
        City london = new City("London");
        City paris = new City("Paris");

        vancouver.addFlight("Toronto", 255);
        vancouver.addFlight("Seattle", 100);
        vancouver.addFlight("New York", 660);

        seattle.addFlight("Vancouver", 112);
        seattle.addFlight("Los Angeles", 150);
        seattle.addFlight("Miami", 500);

        toronto.addFlight("Vancouver", 240);
        toronto.addFlight("London", 612);
        toronto.addFlight("Paris", 250);

        paris.addFlight("London", 220);

        london.addFlight("Toronto", 720);
        london.addFlight("Los Angeles", 1200);
        london.addFlight("Miami", 580);

        losAngeles.addFlight("Seattle", 150);

        miami.addFlight("New York", 400);
        miami.addFlight("London", 580);

        newYork.addFlight("Miami", 400);
        newYork.addFlight("Seattle", 350);


        ArrayList<City> cities = new ArrayList<>();

        cities.add(vancouver);
        cities.add(toronto);
        cities.add(seattle);
        cities.add(newYork);
        cities.add(losAngeles);
        cities.add(miami);
        cities.add(london);
        cities.add(paris);

        return cities;
    }
}
