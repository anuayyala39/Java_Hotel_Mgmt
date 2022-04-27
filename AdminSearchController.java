package JavaFinalProject;
import java.io.IOException;
import java.util.List;

import edu.unlv.mis768.labwork15.CustomerTotalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminSearchController {

    @FXML
    private Button addReservationButton;

    @FXML
    private TextField hotelIDTextField;

    @FXML
    private Label hotelIdLabel;

    @FXML
    private Label reservationIdLabel;

    @FXML
    private TextField reservationIdtextField;

    @FXML
    private Button searchHotelIdButton;

    @FXML
    private Button searchReservationIdButton;



   
   /**
    * Event handler for the "SearchByReservationId" Button 
    * It will determined which service is selected and pass it to the next scene
    * @throws IOException 
    */
   public void changeSceneToSearchByReservationId(ActionEvent e) throws IOException {
   	
   	FXMLLoader loader = new FXMLLoader();
   	// specify the file location for the FXML file for the next window
   	loader.setLocation(getClass().getResource("SearchByReservationId.fxml"));
   	// load the UI for the next window
   	Parent parent = loader.load();
   	// set the scene
   	Scene scene = new Scene(parent);
   	
   	HotelManagementAdminDAOImpl obj = new HotelManagementAdminDAOImpl();	
   	List<ReservationDetails> getAllReservations=	obj.getAllReservations(Integer.parseInt(reservationIdtextField.getText()),true);

   	// access the controller class for the next window via the FXML loader
   	SearchByReservationIdController controller = loader.getController();
    // call the method in the controller class for the next window
    // so that the data can be passed
    controller.initData(getAllReservations);
   	// get the current stage, using the ActionEvent object
   	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
   	// change the title
   	stage.setTitle(" Search by Reservation ID ");
   	// set the new scene to the stage
   	stage.setScene(scene);
   	// show the stage
   	stage.show();
   }

   /**
    * Event handler for the "SearchByHotelId" Button 
    * It will determined which service is selected and pass it to the next scene
    * @throws IOException 
    */
   public void changeSceneToSearchByHotelId(ActionEvent e) throws IOException {
   	
   	FXMLLoader loader = new FXMLLoader();
   	// specify the file location for the FXML file for the next window
   	loader.setLocation(getClass().getResource("SearchByHotelId.fxml"));
   	// load the UI for the next window
   	Parent parent = loader.load();
   	// set the scene
   	Scene scene = new Scene(parent);
   	HotelManagementAdminDAOImpl objHotel = new HotelManagementAdminDAOImpl();	
   	List<ReservationDetails> getAllReservations=	objHotel.getAllReservations(Integer.parseInt(hotelIDTextField.getText()),false);

   	// access the controller class for the next window via the FXML loader
   	SearchHotelIdController controller = loader.getController();
    // call the method in the controller class for the next window
    // so that the data can be passed
    controller.initData(getAllReservations);
   	// get the current stage, using the ActionEvent object
   	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
   	// change the title
   	stage.setTitle(" Search By Hotel ID ");
   	// set the new scene to the stage
   	stage.setScene(scene);
   	// show the stage
   	stage.show();
   }

   /**
    * Event handler for the "Add new reservations" Button 
    * It will determined which service is selected and pass it to the next scene
    * @throws IOException 
    */
   public void changeSceneToAddNewReservations(ActionEvent e) throws IOException {
   	
   	FXMLLoader loader = new FXMLLoader();
   	// specify the file location for the FXML file for the next window
   	loader.setLocation(getClass().getResource("AddNewReservations.fxml"));
   	// load the UI for the next window
   	Parent parent = loader.load();
   	// set the scene
   	Scene scene = new Scene(parent);
   	// access the controller class for the next window via the FXML loader
   	//AddNewReservationController controller = loader.getController();
   	// call the method in the controller class for the next window
   	// so that the data can be passed
   	//controller.initData();

   	// get the current stage, using the ActionEvent object
   	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
   	// change the title
   	stage.setTitle(" Add new Reservations ");
   	// set the new scene to the stage
   	stage.setScene(scene);
   	// show the stage
   	stage.show();
   }
   
   

}

