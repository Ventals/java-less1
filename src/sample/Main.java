package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        ComboBox<String> box = (ComboBox<String>) root.lookup("#someid");
        box.setPromptText("Sort for:");
        box.setItems(FXCollections.observableArrayList(
                "Mark/Group/Name", "Group/Name/Mark"));

        box.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                boolean state;
                if(newValue.equals("Mark/Group/Name")) {
                    state = true;
                }else{
                    state = false;
                }
                try {
                    Controller.start(state);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        primaryStage.setTitle("Student sorting");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
