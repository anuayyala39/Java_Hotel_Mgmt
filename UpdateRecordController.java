package JavaFinalProject;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateRecordController {



    @FXML
    private TextField AmountTextBox;

    @FXML
    private Label HotelIdLabel;

    @FXML
    private TextField HotelIdTextBox;

    @FXML
    private Label amountLabel;

    @FXML
    private Label checkInLabel;

    @FXML
    private TextField checkInTextBox;

    @FXML
    private Label checkoutLabel;

    @FXML
    private TextField checkoutTextBox;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextBox;

    @FXML
    private Label reservationIdLabel;

    @FXML
    private TextField reservationIdTextBox;

    @FXML
    private Button submitButton;
    boolean isValidReservation;
    public int reservationID;
    public int hotelID;
    
    
    public void initialize(ReservationDetails updateObj, boolean isReservation) {
    	
    	isValidReservation = isReservation;
    	 reservationIdTextBox.setText(String.valueOf(updateObj.getReservationId()));
    	 HotelIdTextBox.setText(String.valueOf(updateObj.getHotelId()));
    	 nameTextBox.setText(String.valueOf(updateObj.getLastName()));
    	 checkoutTextBox.setText(String.valueOf(updateObj.getEndDate()));
    	 checkInTextBox.setText(String.valueOf(updateObj.getStartDate()));
    	 AmountTextBox.setText(String.valueOf(updateObj.getPrice()));
    	 reservationID = updateObj.getReservationId();
    	 hotelID = updateObj.getHotelId();
    }
    
    /**
     * Move back to the Admin Search scene.
     * @param e
     * @throws ParseException 
     */
    
    public void startOverButtonListener(ActionEvent e) throws ParseException {
     	
    	ReservationDetails update = new ReservationDetails();
    	update.setReservationId(reservationID);
    	update.setHotelId(hotelID);
    	update.setPrice(Double.parseDouble(AmountTextBox.getText()));
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    	Date checkoutdate = null;
    	
		try {
			checkoutdate = formatter.parse(checkoutTextBox.getText());
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	Date checkindate = formatter.parse(checkoutTextBox.getText());
    	System.out.println("===="+checkoutdate);
    	update.setEndDate(checkoutdate);
    	update.setStartDate(checkindate);
    	if (isValidReservation==true) {
    	// the FXML loader object to load the UI design
    	FXMLLoader loader = new FXMLLoader();
    	// specify the file location
    	loader.setLocation(getClass().getResource("SearchByReservationId.fxml"));
   
    	

    	// try-catch for possible errors in reading the FXML file.
    	try {
    		// the object representing the root node of the scene; load the UI
    		Parent parent = loader.load();
   	
			// set the scene
			Scene scene = new Scene(parent);
			// access the controller class for the next window via the FXML loader
			SearchByReservationIdController controller = loader.getController();
		    // call the method in the controller class for the next window
		    // so that the data can be passed
			HotelManagementAdminDAOImpl objReservation = new HotelManagementAdminDAOImpl();
			
			objReservation.updateReservation(update,checkInTextBox.getText(),checkoutTextBox.getText());
		   	List<ReservationDetails> getAllReservations = objReservation.getAllReservations(reservationID,true);

		    controller.initData(getAllReservations ); 
	    	// get the current window; i.e. the stage
	    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
	    	// change the title of the window
	    	stage.setTitle(" Search by Reservation ID");
	    	// set the scene for the stage
	    	stage.setScene(scene);
	    	// show the stage
	    	stage.show();
			} catch (IOException e1) {
				
				System.out.print(e1.getMessage());
			}
    }
    	else {
    		// the FXML loader object to load the UI design
        	FXMLLoader loader = new FXMLLoader();
        	// specify the file location
        	loader.setLocation(getClass().getResource("SearchByHotelId.fxml"));
        	
    		// try-catch for possible errors in reading the FXML file.
        	try {
        		// the object representing the root node of the scene; load the UI
        		Parent parent = loader.load();
       	
    			// set the scene
    			Scene scene = new Scene(parent);
    			SearchHotelIdController controller = loader.getController();
    			// call the method in the controller class for the next window
    		    // so that the data can be passed
    			HotelManagementAdminDAOImpl objHotel = new HotelManagementAdminDAOImpl();	
    			objHotel.updateReservation(update,checkInTextBox.getText(),checkoutTextBox.getText());
    		   	
    		   	List<ReservationDetails> getAllReservations = objHotel.getAllReservations(hotelID,false);

    		    controller.initData(getAllReservations ); 
    	    	// get the current window; i.e. the stage
    	    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	    	// change the title of the window
    	    	stage.setTitle(" Search by Hotel ID");
    	    	// set the scene for the stage
    	    	stage.setScene(scene);
    	    	// show the stage
    	    	stage.show();
    			} catch (IOException e1) {
    				
    				System.out.print(e1.getMessage());
    			}
    		}
    	}

}
