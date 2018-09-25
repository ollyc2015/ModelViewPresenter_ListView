package uk.co.oliverbcurtis.ModelViewPresenter_Listview.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductColor implements Serializable {


    @SerializedName("hex_value")
    @Expose
    private String hexValue;
    @SerializedName("colour_name")
    @Expose
    private String colourName;

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        this.hexValue = hexValue;
    }

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }
}
