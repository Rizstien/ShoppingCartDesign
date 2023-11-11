package org.shoppingcart.user;

public class User {

    public User(Integer ID, String name, boolean underAge) {
        this.ID = ID;
        this.name = name;
        this.underAge = underAge;
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public boolean getUnderAge() {
        return underAge;
    }

    private Integer ID;
    private String name;
    private boolean underAge;
}
