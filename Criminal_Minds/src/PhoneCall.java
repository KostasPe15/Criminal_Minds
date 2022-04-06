public class PhoneCall extends Communication {
	private int duration;

	//Constructor
	public PhoneCall(String num1, String num2, int day, int month, int year,int duration) {
		super(num1, num2, day, month, year);
		this.duration=duration;
	}

	//Ektypwsh plhroforiwn gia thn klhsh
	public void printInfo() {
		System.out.println("This phone call has the following info");
		System.out.println("Between "+num1+" --- "+num2);
		System.out.println("on "+day+"/"+month+"/"+year);
		System.out.println("Duration: "+duration);
	}

	//Getters
	public int getDuration() {
		return duration;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
