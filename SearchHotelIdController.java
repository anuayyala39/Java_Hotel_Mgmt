package JavaFinalProject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

	public class SearchHotelIdController {

	    @FXML
	    private TableColumn<ReservationDetails, Double> amountColumn;

	    @FXML
	    private Button deleteButton;

	    @FXML
	    private Button editButton;

	    @FXML
	    private TableColumn<ReservationDetails, Date> endDateColumn;

	    @FXML
	    private TableColumn<ReservationDetails, Integer> hotelIdCoulmn;

	    @FXML
	    private TableColumn<ReservationDetails, String> nameColumn;

	    @FXML
	    private TableColumn<ReservationDetails, Integer> reservationIdColumn;

	    @FXML
	    private TableColumn<ReservationDetails, Date> startDateColumn;

	    @FXML
	    private TableView<ReservationDetails> tableView;
	    public int rowSelect=0;
	    public ReservationDetails selectedReservation=new ReservationDetails();
	    
	    /** For setting up initial values
		 */

		public void initialize() { // set up the columns in the table
			reservationIdColumn.setCellValueFactory(new PropertyValueFactory<ReservationDetails, Integer>("reservationId"));
		  startDateColumn.setCellValueFactory(new PropertyValueFactory<ReservationDetails, Date>("startDate"));
		  endDateColumn.setCellValueFactory(new PropertyValueFactory<ReservationDetails, Date>("endDate"));
		  amountColumn.setCellValueFactory(new  PropertyValueFactory<ReservationDetails, Double>("Price"));
		  hotelIdCoulmn.setCellValueFactory(new PropertyValueFactory<ReservationDetails, Integer>("hotelId"));
		  nameColumn.setCellValueFactory(new  PropertyValueFactory<ReservationDetails, String>("lastName"));
	  }

	public void initData(	List<ReservationDetails> hotelList) {
		tableView.setRowFactory(tv -> {
            TableRow<ReservationDetails> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                	ReservationDetails rowData = row.getItem();
                	rowSelect=rowData.getReservationId();
                    System.out.println("Double click on: "+rowSelect);
                    selectedReservation=rowData;
                }
            });
            return row ;
        });
		tableView.getItems().add(new ReservationDetails(hotelList.get(0).getReservationId(),
				hotelList.get(0).getLocation(), hotelList.get(0).getStartDate(),
				hotelList.get(0).getEndDate(),hotelList.get(0).getRoomType(),
				hotelList.get(0).getPrice(),hotelList.get(0).getHotelId(),
				hotelList.get(0).getLastName()));
	}

	    
	    /**
	     * Move back to the Admin Search scene.
	     * @param e
	     */
	    
	    public void startOverButtonListener(ActionEvent e) {
	    	// the FXML loader object to load the UI design
	    	FXMLLoader loader = new FXMLLoader();
	    	// specify the file location
	    	loader.setLocation(getClass().getResource("AdminSearch.fxml"));
	    	
			// try-catch for possible errors in reading the FXML file.
	    	try {
	    		// the object representing the root node of the scene; load the UI
	    		Parent parent = loader.load();
	   	
				// set the scene
				Scene scene = new Scene(parent);
	    	   	
		    	// get the current window; i.e. the stage
		    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		    	// change the title of the window
		    	stage.setTitle("Admin Search");
		    	// set the scene for the stage
		    	stage.setScene(scene);
		    	// show the stage
		    	stage.show();
				} catch (IOException e1) {
					
					System.out.print(e1.getMessage());
				}
	    }
	    public void deleteButtonListener() {
	    	HotelManagementAdminDAOImpl kb = new HotelManagementAdminDAOImpl();
	    	System.out.println(rowSelect);
	    	kb.deleteReservation(rowSelect );
	       	List<ReservationDetails> getAllReservations= new ArrayList<ReservationDetails>();
	       	getAllReservations=kb.getAllReservations(rowSelect,true);
	       	//if(getAllReservations)
	       	if(getAllReservations.size()==0) {
	       	tableView.getItems().clear();
	       	}else {
	       		initData(getAllReservations);
	       	}
	    
	    	
	    }
	    
	    public void changeSceneToUpdateRecord(ActionEvent e) throws IOException {
	    	// the FXML loader object to load the UI design
	    	FXMLLoader loader = new FXMLLoader();
	    	// specify the file location
	    	loader.setLocation(getClass().getResource("UpdateRecord.fxml"));
	    	
			// try-catch for possible errors in reading the FXML file.
	    	try {
	    		// the object representing the root node of the scene; load the UI
	    		Parent parent = loader.load();
	   	
				// set the scene
				Scene scene = new Scene(parent);
				
				// access the controller class for the next window via the FXML loader
				UpdateRecordController controller = loader.getController();
			    // call the method in the controller class for the next window
			    // so that the data can be passed
				
			    controller.initialize(selectedReservation,false); 
			    System.out.println("hotelid=="+selectedReservation.getHotelId());
		    	// get the current window; i.e. the stage
		    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		    	// change the title of the window
		    	stage.setTitle("Update Record");
		    	// set the scene for the stage
		    	stage.setScene(scene);
		    	// show the stage
		    	stage.show();
				} catch (IOException e1) {
					
					System.out.print(e1.getMessage());
				}
	}
	}

