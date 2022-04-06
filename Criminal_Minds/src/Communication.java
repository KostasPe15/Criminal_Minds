public abstract class Communication {
	protected String num1;
	protected String num2;
	protected int day;
	protected int month;
	protected int year;
	
	//Constructor
	public Communication(String num1, String num2, int day, int month, int year) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	//Getters
	public String getNum1() {
		return num1;
	}

	public String getNum2() {
		return num2;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
	
	public abstract int getDuration();
	
	public abstract String getContent();

}
