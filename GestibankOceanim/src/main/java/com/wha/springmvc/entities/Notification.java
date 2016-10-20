package com.wha.springmvc.entities;

public class Notification {

//	TOI
	   private String notifId;
     
	    private String notificationName;
	 
	    private String status;
	     
	    private Client InfoClient;

		public String getNotifId() {
			return notifId;
		}

		public void setNotifId(String notifId) {
			this.notifId = notifId;
		}

		public String getNotificationName() {
			return notificationName;
		}

		public void setNotificationName(String notificationName) {
			this.notificationName = notificationName;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Client getInfoClient() {
			return InfoClient;
		}

		public void setInfoClient(Client infoClient) {
			InfoClient = infoClient;
		}

		@Override
		public String toString() {
			return "Notification [notifId=" + notifId + ", notificationName=" + notificationName + ", status=" + status
					+ ", InfoClient=" + InfoClient + "]";
		}
	    
	    
	    
}
