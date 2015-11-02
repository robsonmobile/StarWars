package net.paulacr.starwars.utils;

import android.content.Context;
import android.content.Intent;

import net.paulacr.starwars.activities.PeopleListActivity;

/**
 * Created by Paula on 01/11/2015.
 */
public class Intents {
    public static final Intent toPeople(Context context) {
        return new Intent(context, PeopleListActivity.class);
    }


}
