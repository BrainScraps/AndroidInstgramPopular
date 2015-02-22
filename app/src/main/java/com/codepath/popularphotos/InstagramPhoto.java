package com.codepath.popularphotos;

import org.json.JSONException;
import org.json.JSONObject;

public class InstagramPhoto {
    public String username;
    public String caption;
    public String imageUrl;
    public int imageHeight;
    public int likeCount;

    public InstagramPhoto(JSONObject json) {
        try {
            if (json.getJSONObject("caption") == null) {
                this.caption = "";
            } else {
                this.caption = json.getJSONObject("caption").getString("text");
            }
            this.username = json.getJSONObject("user").getString("username");
            this.imageUrl = json.getJSONObject("images").getJSONObject("standard_resolution").getString("url");
            this.imageHeight = json.getJSONObject("images").getJSONObject("standard_resolution").getInt("height");
            this.likeCount = json.getJSONObject("likes").getInt("count");

        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}
