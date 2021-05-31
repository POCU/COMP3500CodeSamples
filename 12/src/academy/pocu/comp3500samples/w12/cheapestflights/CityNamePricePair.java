package academy.pocu.comp3500samples.w12.cheapestflights;

public final class CityNamePricePair implements Comparable<CityNamePricePair> {
    private final String cityName;
    private final int price;

    public CityNamePricePair(final String cityName, final int price) {
        this.cityName = cityName;
        this.price = price;
    }

    public String getCityName() {
        return this.cityName;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public int compareTo(CityNamePricePair o) {
        return this.getPrice() - o.price;
    }
}
