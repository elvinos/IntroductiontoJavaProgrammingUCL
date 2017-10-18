package elvinos.java;

public class Currency {

    String name;
    Double rate;

    Currency(String name, Double rate){
        this.name= name;
        this.rate= rate;
    }

    public Double getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
