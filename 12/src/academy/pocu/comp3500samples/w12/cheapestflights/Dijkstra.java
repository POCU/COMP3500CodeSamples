package academy.pocu.comp3500samples.w12.cheapestflights;

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
            minPrices.put(name,
                    Integer.MAX_VALUE);
        }

        minPrices.put(from, 0);
        outPrevious.put(from, null);

        PriorityQueue<CityNamePricePair> candidates = new PriorityQueue<>();

        CityNamePricePair startCity = new CityNamePricePair(from, 0);

        candidates.add(startCity);

        while (!candidates.isEmpty()) {
            CityNamePricePair candidate = candidates.poll();

            final String cityName = candidate
                    .getCityName();

            final int price = candidate
                    .getPrice();

            final int minPrice = minPrices
                    .get(cityName);

            if (minPrice < price) {
                continue;
            }

            final City city = citiesMap
                    .get(cityName);

            final Map<String, Integer> flights = city.getFlights();

            for (Map.Entry<String, Integer> entry : flights.entrySet()) {
                final String nextCity = entry
                        .getKey();

                final int nextPrice = entry
                        .getValue();

                final int nextMinPrice = minPrices
                        .get(nextCity);

                final int newPrice = minPrice + nextPrice;

                if (newPrice < nextMinPrice) {
                    minPrices.put(nextCity, newPrice);

                    final CityNamePricePair newEntry = new CityNamePricePair(nextCity, newPrice);

                    candidates.add(newEntry);

                    outPrevious.put(nextCity, cityName);
                }
            }
        }

        return minPrices;
    }
}
