package WeatherApp;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class WeatherConditions {
    int id;
    String name;

    @SerializedName("main")
    Map<String, Float> measurements;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Float> getMeasurements () {
        return measurements ;
    }

    public void setMeasurements (Map<String, Float> main) {
        this.measurements  = main;
    }
}
