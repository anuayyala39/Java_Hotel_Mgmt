package JavaFinalProject;

import java.util.Date;

public class ReservationDetails {
		private int reservationId;
		private String location;
		private  Date startDate;
		private  Date endDate;
		private String roomType;
		private double price;
		private int hotelId;
		private String lastName;
		private String firstName;
		private String hotelName;
		
		//no- args constructor
		public ReservationDetails() {
			
		}
		
		//constructor
		public ReservationDetails(int reservationId, String location, Date startDate, Date endDate, String roomType,
				double price, int hotelId, String lastName) {
			super();
			this.reservationId = reservationId;
			this.location = location;
			this.startDate = startDate;
			this.endDate = endDate;
			this.roomType = roomType;
			this.price = price;
			this.hotelId = hotelId;
			this.lastName = lastName;
		}
		
		
		
		
		public int getHotelId() {
			return hotelId;
		}

		public void setHotelId(int hotelId) {
			this.hotelId = hotelId;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getfirstName() {
			return firstName;
		}
		public void setfirstName(String firstName) {
			this.firstName= firstName;
		}

		public int getReservationId() {
			return reservationId;
		}

		public String getLocation() {
			return location;
		}

		public Date getStartDate() {
			return startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public String getRoomType() {
			return roomType;
		}

		public double getPrice() {
			return price;
		}

		public void setReservationId(int reservationId) {
			this.reservationId = reservationId;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		
}
