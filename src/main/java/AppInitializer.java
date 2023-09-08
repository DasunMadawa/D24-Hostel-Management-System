import entity.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.Arrays;
import java.util.List;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/dashboard_form.fxml"))));
        primaryStage.setResizable(false);
        primaryStage.setTitle("D24");
        primaryStage.getIcons().add(new Image("view/img/icons8-hostel-100.png"));
        primaryStage.show();

        FactoryConfiguration.getInstance().getSession();

        new Thread(() -> {
            Session session = FactoryConfiguration.getInstance().getSession();
            session.close();
        }).start();
    }

}
