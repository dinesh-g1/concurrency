package futuresynchronizer;

public class Person {
    private String name;
    private String city;
    private boolean isInterestedInYog;

    public Person(String name, String city, boolean isInterestedInYog) {
        this.name = name;
        this.city = city;
        this.isInterestedInYog = isInterestedInYog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isInterestedInYog() {
        return isInterestedInYog;
    }

    public void setInterestedInYog(boolean interestedInYog) {
        isInterestedInYog = interestedInYog;
    }
}
