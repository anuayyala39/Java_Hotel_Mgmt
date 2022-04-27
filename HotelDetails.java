package JavaFinalProject;

import java.util.Date;

public class HotelDetails {

	
	private int  hotelID;
	private String hotelName;
	private String address;
	private String contactDetails;
	private String area;
	private int reservationId;
	private String lastName;
	private  Date startDate;
	private  Date endDate;
	private double price;
	
	//no args constructor
	public HotelDetails() {
		
	}
	
	//constructor
	public HotelDetails(int hotelID, String hotelName, String address, String contactDetails,
			String area, int reservationId, String lastName, Date startDate, Date endDate,
			double price) {
		//super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.address = address;
		this.contactDetails = contactDetails;
		this.area = area;
		this.reservationId = reservationId;
		this.lastName = lastName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getHotelID() {
		return hotelID;
	}
	public String getHotelName() {
		return hotelName;
	}
	public String getAddress() {
		return address;
	}
	public String getContactDetails() {
		return contactDetails;
	}
	public String getArea() {
		return area;
	}
	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	
	
	
	
}
