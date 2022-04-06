import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Suspect implements Serializable, Comparable<Suspect>{
	private String name;
	private String Codename;
	private String city;
	private ArrayList<String> telNumbers;
	private ArrayList<Suspect> coworkers;
	
	//Constructors
	public Suspect(String name, String Codename, String city, ArrayList<String> telNumbers, ArrayList<Suspect> coworkers) {
		super();
		this.name = name;
		this.Codename = Codename;
		this.city = city;
		this.telNumbers = new ArrayList<String>();
		this.coworkers = new ArrayList<Suspect>();
	}
	
	public Suspect(String name, String Codename, String city) {
		super();
		this.name = name;
		this.Codename = Codename;
		this.city = city;
		this.telNumbers = new ArrayList<String>();
		this.coworkers = new ArrayList<Suspect>();
	}
	
	//Prosthikh arithmou
	public void addNumber(String aNumber) {
		this.telNumbers.add(aNumber);
	}
	
	//Prosthikh synergath
	public void addCoworker(Suspect aSuspect) {
		if(!this.isConnectedTo(aSuspect)) {
			this.coworkers.add(aSuspect);
		}
	}
	
	//Elegxei an einai syndedemenoi
	public boolean isConnectedTo(Suspect aSuspect) {
		boolean flag=false;
		for(Suspect sus : this.coworkers) {
			if(sus.getName()==aSuspect.getName()) {
				flag=true;
			}
		}
		return flag;
	}
	
	//Epistrefei lista me proteinomenous synergates
	public ArrayList<Suspect> suggestedPartners () {
		ArrayList<Suspect> suggPertners = new ArrayList<Suspect>();
		for(Suspect s : this.coworkers) {
			for(Suspect sus : s.getCoworkers()) {
				if(!sus.isConnectedTo(this)&&!suggPertners.contains(sus)&&!sus.equals(this)) {
					suggPertners.add(sus);
				}
			}
		}
		Collections.sort(suggPertners);
		return suggPertners;
	}
	
	//Epistrefei lista me koinous pithanous synergates
	public ArrayList<Suspect> getCommonPartners (Suspect aSuspect) {
		ArrayList<Suspect> commonPertners = new ArrayList<Suspect>();
		for(Suspect sus : this.coworkers) {
			if(sus.isConnectedTo(aSuspect)) {
				commonPertners.add(sus);
			}
		}
		
		return commonPertners;
	}
	
	//Typwnei koinous pithanous synergates
	public void printCommonPartners() {
		for(Suspect sus : this.coworkers) {
			System.out.println(sus.getName()+" "+sus.getCodename());
		}
	}
	
	//Getters
	public String getName() {
		return name;
	}

	public String getCodename() {
		return Codename;
	}

	public ArrayList<String> getTelNumbers() {
		return telNumbers;
	}

	public ArrayList<Suspect> getCoworkers() {
		Collections.sort(coworkers);
		return coworkers;
	}

	//Override gia na ginetai sygkrish me bash to onoma
	@Override
	public int compareTo(Suspect o) {
		return this.name.compareTo(o.name);
	}
	
	
	
}
