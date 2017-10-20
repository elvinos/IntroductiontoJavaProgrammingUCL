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

}
