package ir.coursio.daggertutorial.model.Subs;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Taher on 16/03/2017.
 * Project: RetrofitTutorial
 */

public class JokeStruct implements Serializable {
    @SerializedName("id")
    private int id;

    @SerializedName("joke")
    private String text;

    @SerializedName("categories")
    private ArrayList<String> categories = new ArrayList<>();


    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }
}
