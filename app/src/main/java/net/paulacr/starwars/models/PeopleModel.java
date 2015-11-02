package net.paulacr.starwars.models;

/**
 * Created by Paula on 01/11/2015.
 */
public class PeopleModel {

    private String name;
    private String homeworld;
    private String gender;
    private Integer icon;

    public PeopleModel(String name, String homeworld, String gender, Integer icon) {
        this.name = name;
        this.homeworld = homeworld;
        this.gender = gender;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }
}
