package net.paulacr.starwars.repositories;

import android.graphics.drawable.Icon;

import net.paulacr.starwars.R;
import net.paulacr.starwars.models.Icons;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paula on 31/10/2015.
 */
public class GridMenuItems {

    public static List<Icons> gridMenuItems;

    public static List<Icons> getGridMenuItems() {
        if(gridMenuItems == null) {
            gridMenuItems = new ArrayList<>();
            gridMenuItems.add(new Icons(R.drawable.starwars_people_copia, R.string.people));
            gridMenuItems.add(new Icons(R.drawable.starwars_people_copia, R.string.planets));
            gridMenuItems.add(new Icons(R.drawable.starwars_people_copia, R.string.spacesships));
            gridMenuItems.add(new Icons(R.drawable.starwars_people_copia, R.string.vehicles));
            gridMenuItems.add(new Icons(R.drawable.starwars_people_copia, R.string.species));
            gridMenuItems.add(new Icons(R.drawable.starwars_people_copia, R.string.films));
        }
        return gridMenuItems;
    }
}
