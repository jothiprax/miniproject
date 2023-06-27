package busRev;

public class Bus {

		// TODO Auto-generated method stub
		private int busNo;
		private boolean ac;
		private int capacity;
		public Bus(int busNo, boolean ac, int capacity) {
			
			this.busNo = busNo;
			this.ac = ac;
			this.capacity = capacity;
		}
		public int getCapacity() {//accessor Method
			return capacity;
		}
		public void setCapacity(int cap) {//Mutator Method
			capacity = cap;
		}
		public int getBusNo() {
			return busNo;
		}
		public void setBusNo(int busNo) {
			this.busNo = busNo;
		}
		public boolean isAc() {
			return ac;
		}
		public void setAc(boolean ac) {
			this.ac = ac;
		}
	
	  void 	displayBusInformation() {
		  System.out.println("Bus No: "+busNo+"\nAC: "+ac+"\nTotal Capacity : "+capacity);
		  System.out.println("___________________________________________________");
	  }
	

}
