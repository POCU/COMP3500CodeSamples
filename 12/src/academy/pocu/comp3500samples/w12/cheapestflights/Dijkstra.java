package academy.pocu.comp3500samples.w12.cheapestflights;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    private Dijkstra() {
    }

    public static HashMap<String, Integer> findMinimumPrices(final ArrayList<City> cities, final String from, final HashMap<String, String> outPrevious) {
        final HashMap<String, Integer> minPrices = new HashMap<>();

        final HashMap<String, City> citiesMap = new HashMap<>();

        for (int i = 0; i < cities.size(); ++i) {
            final City city = cities.get(i);
            final String name = city.getName();

            citiesMap.put(name, city);
            minPrices.put(name, Integer.MAX_VALUE);
        }

        minPrices.put(from, 0);
        outPrevious.put(from, null);

        PriorityQueue<AbstractMap.SimpleEntry<String, Integer>> candidates = new PriorityQueue<>(Map.Entry.comparingByValue());

        candidates.add(new AbstractMap.SimpleEntry<>(from, 0));

        while (!candidates.isEmpty()) {
            AbstractMap.SimpleEntry<String, Integer> current = candidates.remove();
            final String currentCity = current
                    .getKey();
            final int currentPrice = current
                    .getValue();

            final int minPrice = minPrices
                    .get(currentCity);

            if (minPrice < currentPrice) {
                continue;
            }

            final City city = citiesMap
                    .get(currentCity);
            final Map<String, Integer> flights = city.getFlights();

            for (Map.Entry<String, Integer> entry : flights.entrySet()) {
                String nextCity = entry.getKey();
                final int nextPrice = entry.getValue();

                final int nextMinPrice = minPrices
                        .get(nextCity);

                final int newPrice = minPrice + nextPrice;

                if (newPrice < nextMinPrice) {
                    minPrices.put(nextCity, newPrice);

                    final AbstractMap.SimpleEntry<String, Integer> newEntry = new AbstractMap.SimpleEntry<>(nextCity, newPrice);

                    candidates.add(newEntry);

                    outPrevious.put(nextCity, currentCity);
                }
            }
        }

        return minPrices;
    }
}
