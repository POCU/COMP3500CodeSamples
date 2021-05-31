package academy.pocu.comp3500samples.w12.cheapestflights;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class City {
    private final String name;
    private final HashMap<String, Integer> flights = new HashMap<>();

    public City(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getFlights() {
        return Collections.unmodifiableMap(this.flights);
    }

    public void addFlight(final String to, final int price) {
        this.flights.put(to, price);
    }

    public int getPrice(final String to) {
        return this.flights.get(to);
    }
}
