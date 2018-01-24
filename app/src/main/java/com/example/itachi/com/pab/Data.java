package com.example.itachi.com.pab;

/**
 * Created by ITACHI on 22-01-2018.
 */

public class Data {
   private String ID,Name,image;
   public Data(){

   }

    public Data(String ID, String Name, String image) {
        this.ID = ID;
        this.Name = Name;
        this.image= image;
    }

    public String getId() {
        return ID;
    }

    public void setId(String id) {

       this.ID = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getimage() {
        return image;
    }

    public void setImg(String image) {
        this.image = image;
    }
}
