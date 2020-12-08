/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkiruokareseptigeneraattori;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import jalkiruokareseptigeneraattori.blogic.Recipe;
import jalkiruokareseptigeneraattori.blogic.Recipebook;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import javafx.geometry.Pos;
import java.io.InputStream;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;

/**
 * Under construction - Grapical UI
 * @author niemi
 */
public class NewFXMain extends Application {

    Recipebook recipes = new Recipebook();

    /**
     *
     * @param window input value
     * @throws FileNotFoundException normal error handling
     */
    @Override
    public void start(Stage window) throws FileNotFoundException {
        //Button selRandom = new Button("Tämä on nappi");

        //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //String path = classLoader.getResource("/strawberry.jpg").getPath();
        //FlowPane components = new FlowPane();
        //components.getChildren().add(selRandom);
        //new FileInputStream(path);
        //InputStream content= classLoader.getResourceAsStream("/images/logo.jpg");
        //InputStream in = getClass().getResourceAsStream("images/strawberry.jpg");

        //Image berry = new Image("https://images.pexels.com/photos/934066/pexels-photo-934066.jpeg");
Image berry = new Image(new FileInputStream("images/strawberry.jpg"));  
        //Image img = new Image(in);
        ImageView view = new ImageView(berry);
        view.setFitHeight(200);
        view.setPreserveRatio(true);

        BorderPane bp = new BorderPane();
        TextField resultText = new TextField();
        resultText.setMinHeight(300);
        resultText.setMinWidth(600);

        Button bGetRand = new Button("Get Random Recipe");

        bGetRand.setOnAction((event) -> {
            resultText.setText(recipes.getRandomRecipe().toString());
            //img = 
        });
        Button bPrintGroups = new Button("Print Recipe Groups");
        bPrintGroups.setOnAction((event) -> {
            resultText.setText(recipes.printGroups());
            String huu = "";
        });

        VBox vbuttons = new VBox();
        vbuttons.setSpacing(10);
        vbuttons.getChildren().add(bGetRand);
        vbuttons.getChildren().add(bPrintGroups);
        vbuttons.getChildren().add(new Button("TBC"));

        bp.setLeft(vbuttons);
        bp.setTop(view);
        bp.setCenter(resultText);

        //Scene scn = new Scene(components);
        Scene scn = new Scene(bp);
        window.setTitle("Dessert Generator");
        window.setResizable(true);
        window.setScene(scn);
        window.show();
    }

    /**
     * @param args the command line arguments 
     */
    public static void main(String[] args) {
        launch(NewFXMain.class);
    }

}
