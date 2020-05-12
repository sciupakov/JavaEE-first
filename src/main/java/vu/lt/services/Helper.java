package vu.lt.services;

import lombok.Getter;
import lombok.Setter;
import org.h2.util.json.JSONArray;
import org.h2.util.json.JSONObject;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Named
@SessionScoped
@Getter
@Setter
public class Helper implements Serializable {


    public Integer generateJerseyNumber() {
        try {
            Thread.sleep(1000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        Integer generatedJerseyNumber = new Random().nextInt(100);
        return generatedJerseyNumber;
    }

}
