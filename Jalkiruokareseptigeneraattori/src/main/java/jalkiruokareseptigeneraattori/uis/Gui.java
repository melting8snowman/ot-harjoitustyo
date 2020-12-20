package jalkiruokareseptigeneraattori.uis;

import jalkiruokareseptigeneraattori.blogic.Recipebook;
import jalkiruokareseptigeneraattori.blogic.Recipe;
import jalkiruokareseptigeneraattori.blogic.Recipebook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;

import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javax.swing.BorderFactory;

/**
 * Grapical UI for Application This provided components, alignment and objects
 * of the Graphical User Interface of the Application
 *
 * @author niemi
 */
public class Gui extends Application {

    Recipebook recipes = new Recipebook();
    Integer selectedIndex = 1;

    /**
     *
     * @param window input value
     * @throws FileNotFoundException normal error handling
     */
    @Override
    public void start(Stage window) throws FileNotFoundException {

        // Pane
        BorderPane bp = new BorderPane();
        FlowPane components = new FlowPane();

        // Scene
        Scene sceneRecipe = new Scene(bp);

        //Screen Components
        // Images
        Image initImage = new Image(new FileInputStream("images/strawberry.jpg"));
        Image newImage = new Image(new FileInputStream("images/strawberry.jpg"));
        ImageView imageRecipe = new ImageView(newImage);
        imageRecipe.setFitWidth(500);
        imageRecipe.setPreserveRatio(true);
        //ImageView Initview = new ImageView(initImage);
        //Initview.setFitWidth(550);
        //Initview.setPreserveRatio(true);
        // TextAreas
        TextArea resultText = new TextArea();
        resultText.setPrefHeight(300);
        resultText.setPrefWidth(500);
        resultText.setWrapText(true);
        resultText.setEditable(false);
        Label labelTop = new Label("Welcome to Dessert generator. "
                + "Please allow a couple seconds for generator to fetch image recipes.");

        // Buttons and their action
        // Get random
        Button buttonGetRand = new Button("Get Random Recipe");
        buttonGetRand.setPrefWidth(180);
        buttonGetRand.setOnAction((onClick) -> {
            resultText.setText("Initiating random recipe generation");
        });

        buttonGetRand.setOnAction((event) -> {
            resultText.setText("Initiating random recipe generation");
            //window.setScene(sceneRecipe);
            // get random recipe and update related screen components
            Recipe randomRecipe = recipes.getRandomRecipe();
            this.updateImage(initImage, newImage, randomRecipe);
            imageRecipe.setImage(this.updateImage(initImage, newImage, randomRecipe));
            resultText.setText(randomRecipe.toString());
        });

        // random recipe of group
        Label comboLabel = new Label("Preferred Recipe Group:");
        // Create a combo box 
        ComboBox comboBox = new ComboBox();
        comboBox.setPrefWidth(130);
        // initialize values
        initComboBoxValues(comboBox);
        comboBox.getSelectionModel().select(0);
        comboBox.setOnAction((event) -> {
            this.selectedIndex = comboBox.getSelectionModel().getSelectedIndex() + 1;
            //String value = (String) comboBox.getValue();
            //System.out.println(selectedIndex);
        });
        // random recipe of group button
        Button buttonRandOfGroup = new Button("Random from Preferred Group");
        buttonRandOfGroup.setPrefWidth(180);
        buttonRandOfGroup.setOnAction((event) -> {
            resultText.setText("Initiating random recipe generation");
            Recipe randomGroupRecipe = recipes.getRandomRecipeFromGroup(selectedIndex);
            this.updateImage(initImage, newImage, randomGroupRecipe);
            imageRecipe.setImage(this.updateImage(initImage, newImage, randomGroupRecipe));
            resultText.setText(randomGroupRecipe.toString());
        });

        // Print Groups
        Button buttonPrintGroups = new Button("List Recipe Groups");
        buttonPrintGroups.setPrefWidth(180);
        buttonPrintGroups.setOnAction((event) -> {
            resultText.setText(recipes.printGroups());
        });

        //list group recipes
        Button buttonListGrouprecipes = new Button("List Preferred Groups Recipes");
        buttonListGrouprecipes.setPrefWidth(180);
        buttonListGrouprecipes.setOnAction((event) -> {
            resultText.setText(recipes.listRecipesOfGroup(selectedIndex));
        });

        //list recipebooks details
        Button buttonBookDetails = new Button("Recipebooks Details");
        buttonBookDetails.setPrefWidth(180);
        buttonBookDetails.setPrefWidth(180);
        buttonBookDetails.setOnAction((event) -> {
            resultText.setText(recipes.recipebookDetails());
        });

        // Close
        Button buttonClose = new Button("Exit Application");
        buttonClose.setPrefWidth(180);
        buttonClose.setOnAction((event) -> {
            this.stop(window);

        });
        // Alignment items
        // Vertical separators
        Separator separatorV = new Separator();
        separatorV.setOrientation(Orientation.HORIZONTAL);
        separatorV.setMaxWidth(180);
        Separator separatorVi = new Separator();
        separatorVi.setOrientation(Orientation.HORIZONTAL);
        separatorVi.setMaxWidth(130);
        Separator separatorVii = new Separator();
        separatorVii.setOrientation(Orientation.HORIZONTAL);
        separatorVii.setMaxWidth(130);

        // Vbox for left
        VBox verticalButtons = new VBox();
        verticalButtons.setSpacing(10);
        verticalButtons.setPadding(new Insets(10));
        verticalButtons.getChildren().add(buttonGetRand);
        verticalButtons.getChildren().add(buttonPrintGroups);
        verticalButtons.getChildren().add(separatorV);
        verticalButtons.getChildren().add(comboLabel);
        verticalButtons.getChildren().add(comboBox);
        verticalButtons.getChildren().add(separatorVi);
        verticalButtons.getChildren().add(buttonListGrouprecipes);
        verticalButtons.getChildren().add(buttonRandOfGroup);
        verticalButtons.getChildren().add(buttonBookDetails);
        verticalButtons.getChildren().add(separatorVii);
        verticalButtons.getChildren().add(buttonClose);

        // BorderPane sceneRecipe alignment
        // left
        bp.setLeft(verticalButtons);
        // top
        labelTop.setPrefWidth(720);
        labelTop.setPadding(new Insets(20, 20, 20, 20));
        labelTop.setStyle("-fx-border-color: grey");
        HBox hbxTop = new HBox();  //contains HBOX with Text
        hbxTop.setAlignment(Pos.CENTER);
        hbxTop.setPadding(new Insets(2, 2, 2, 2));
        hbxTop.getChildren().add(labelTop);

        bp.setTop(hbxTop);

        // center
        HBox hbxResult = new HBox();  //contains HBOX with Text
        hbxResult.setAlignment(Pos.CENTER_LEFT);
        hbxResult.setPadding(new Insets(10));
        hbxResult.getChildren().add(resultText);
        bp.setCenter(hbxResult);

        // bottom
        HBox hbxImgBottom = new HBox(); //contains HBOX with centered image
        hbxImgBottom.setAlignment(Pos.CENTER_LEFT);
        hbxImgBottom.getChildren().add(imageRecipe);
        hbxImgBottom.setMargin(imageRecipe, new Insets(20, 20, 30, 210));
        bp.setBottom(hbxImgBottom);

        // Window
        window.setTitle("Dessert Generator");
        window.setResizable(true);
        window.setScene(sceneRecipe);
        window.show();
    }

    //@Override

    /**
     *
     * @param window input value for Stage
     */
    public void stop(Stage window) {
        System.out.println("exiting application");
        window.close();

    }

    /**
     * Update Image to correspond to new recipe or return initial image
     * if new image not found
     * @param initImage initial image input value
     * @param newImage new image input value
     * @param recipe input value for recipe
     * @return newImage or initImage if new not found
     */
    public Image updateImage(Image initImage, Image newImage, Recipe recipe) {
        // Get image from URL or default if missing
        if (recipe.getImageUrl() == null) {
            return initImage;
        } else {
            try {
                // load from url
                newImage = new Image(recipe.getImageUrl());
                //} catch (FileNotFoundException exception) {
            } catch (Exception e) {
                // sth went wrong with image url, returning initial image
                return initImage;
                //e.printStackTrace();
                // Output expected FileNotFoundExceptions.
            }
        }
        return newImage;
    }

    /**
     * Drop-down for group selection
     * @param combobox Group input value
     * @return prepared combobox
     */
    public ComboBox initComboBoxValues(ComboBox combobox) {
        for (Map.Entry<Integer, String> entry : recipes.getGroups().entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            combobox.getItems().add(key + "-" + value);
        }
        return combobox;

    }
}
