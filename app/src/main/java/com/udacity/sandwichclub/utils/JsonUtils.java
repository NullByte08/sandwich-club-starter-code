package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        String jsonFormattedString = json.replaceAll("\\\\", "");
        Log.i("json", jsonFormattedString);
        JSONObject jsonObject = new JSONObject(jsonFormattedString);
        String mainName = jsonObject.getJSONObject("name").getString("mainName");

        List<String> alsoKnownAs = new ArrayList<>();
        JSONArray alsoKnownArray = jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs");
        for (int i = 0; i < alsoKnownArray.length(); i++) {
            String aka = (String) alsoKnownArray.get(i);
            Log.i("AKA", aka);
            alsoKnownAs.add(aka);
        }

        String placeOfOrigin = jsonObject.getString("placeOfOrigin");
        String description = jsonObject.getString("description");
        String image = jsonObject.getString("image");

        List<String> ingredients = new ArrayList<>();
        JSONArray ingredientsArray = jsonObject.getJSONArray("ingredients");
        for (int i = 0; i < ingredientsArray.length(); i++) {
            String ingredient = (String) ingredientsArray.get(i);
            Log.i("ingredient", ingredient);
            ingredients.add(ingredient);
        }

        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }
}
