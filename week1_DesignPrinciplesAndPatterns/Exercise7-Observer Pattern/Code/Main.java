interface Observer {
    void update(float price);
}

interface Stock {
    void register(Observer o);
    void remove(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private float price;

    public void register(Observer o) { observers.add(o); }
    public void remove(Observer o) { observers.remove(o); }
    public void notifyObservers() {
        for (Observer o : observers) o.update(price);
    }

    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }
}

class MobileApp implements Observer {
    public void update(float price) {
        System.out.println("Mobile App - Stock Price: " + price);
    }
}

public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer app = new MobileApp();
        market.register(app);
        market.setPrice(100.5f);
    }
}
