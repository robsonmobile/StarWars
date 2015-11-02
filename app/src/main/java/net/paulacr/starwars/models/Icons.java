package net.paulacr.starwars.models;

/**
 * Created by Paula on 24/10/2015.
 */
public class Icons {

    private Integer icon;
    private Integer title;

    public Icons(Integer icon, Integer title) {
        this.icon = icon;
        this.title = title;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }
}
