package busRev;

public class Bus {
			
			private int busNo;
			private boolean ac;
			private int capacity;
			public Bus(int busNo, boolean ac, int capacity) {
				this.busNo = busNo;
				this.ac = ac;
				this.capacity = capacity;
			}
			public int getCapacity() {
				return capacity;
			}
			public void setCapacity(int cap) {
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
			}
	}
