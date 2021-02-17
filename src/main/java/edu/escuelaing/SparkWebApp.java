package edu.escuelaing;


import com.google.gson.Gson;
import edu.escuelaing.services.Converter;
import edu.escuelaing.services.ConverterImpl;

import java.util.List;

import static spark.Spark.*;

/**
 * Spark Web App that calculates the mean and the standard deviation of a set of numbers
 *
 * @author Nicolás Aguilera Contreras
 */
public class SparkWebApp {

    /**
     * Main Function For The App
     *
     * @param args List of the arguments needed for run the program.
     */
    public static void main(String[] args) {
        Gson gson = new Gson();
        port(getPort());
        staticFiles.location("static");
        get("/", (req, res) -> {
            res.redirect("index.html");
            res.status(200);
            return null;
        });
        post("/calculate/sort/", (req, res) -> {
            res.type("application/json");
            Converter converter = new ConverterImpl();
            List<Double> numbersToList = converter.getStringConvertedToList(req.body());
            List<Double> numbersSorted = converter.getListSorted(numbersToList);
            Double sum = converter.getSumOfAList(numbersSorted);
            Double average = converter.getAverageOfAList(numbersSorted);
            String json ="{\"List\":"+numbersSorted.toString()+",\"avg\":"+average+",\"sum\":"+sum+"}";
            return gson.toJson(json);
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
