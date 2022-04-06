
public class SMS extends Communication {
	private String content;

	//Constructor
	public SMS(String num1, String num2, int day, int month, int year, String content) {
		super(num1, num2, day, month, year);
		this.content=content;
	}

	//Ektypwsh plhroforiwn
	public void printInfo() {
		System.out.println("This SMS has the following info");
		System.out.println("Between "+num1+" --- "+num2);
		System.out.println("on "+day+"/"+month+"/"+year);
		System.out.println("Text: "+content);
	}

	//Getters
	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return this.content;
	}


}
