package racingcar.model;

public abstract class Car {
    private String name;
    protected int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public abstract void accelerate();
}
