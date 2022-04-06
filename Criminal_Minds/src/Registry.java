import java.util.ArrayList;

//Kentriko arxeio
public class Registry {
	private ArrayList<Suspect> suspectsList = new ArrayList<Suspect>();
	private ArrayList<Communication> commList = new ArrayList<Communication>();
	
	//Epistrefei ola ta mhmymata metaxy 2 arithmwn
	public ArrayList<SMS> getMessagesBetween(String number1, String number2) {
		ArrayList<SMS> smsList = new ArrayList<SMS>();
		for(Communication c : this.commList) {
			if((c.getNum1()==number1)&&(c.getNum2()==number2))	{
				if((c.getContent().contains("Bomb"))||(c.getContent().contains("Attack"))||(c.getContent().contains("Explosives"))||(c.getContent().contains("Gun"))) {
					smsList.add((SMS) c);
				}
			}
		}
		return smsList;
	}
	
	//Epistrefei thn megalyterh klish
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2) {
		int max=0;
		Communication maxComm = null;
		for(Communication c : this.commList) {
			if((c.getNum1()==number1)&&(c.getNum2()==number2))	{
				if(c.getDuration()>max) {
					max = c.getDuration();
					maxComm = c;
				}
			}
		}
		return (PhoneCall) maxComm;
	}
	
	//Epistrefei ton ypopto me toys perissoteroys synergates
	public Suspect getSuspectWithMostPartners() {
		int max=0;
		Suspect maxSus = null;
		for(Suspect s : this.suspectsList) {
			if(s.getCoworkers().size()>=max) {
				max = s.getCoworkers().size();
				maxSus = s;
			}
		}
		return maxSus;
	}
	
	//Prosthetei ypopto
	public void addSuspect(Suspect aSuspect) {
		this.suspectsList.add(aSuspect);
	}
	
	//Prosthetei epikoinwnia
	public void addCommunication(Communication aCommunication) {
		this.commList.add(aCommunication);
		Suspect sus1, sus2;
		sus1 = sus2 = null;
		for(Suspect sus : this.suspectsList) {
			if(sus.getTelNumbers().contains(aCommunication.getNum1())) {
				sus1 = sus;
			}
		}
		
		for(Suspect susp : this.suspectsList) {
			if(susp.getTelNumbers().contains(aCommunication.getNum2())) {
				sus2 = susp;
			}
		}
		
		if(!sus1.isConnectedTo(sus2)) {
			sus1.addCoworker(sus2);
			sus2.addCoworker(sus1);
		}
	}

	//Getters
	public ArrayList<Suspect> getSuspectsList() {
		return suspectsList;
	}

	public ArrayList<Communication> getCommList() {
		return commList;
	}

}


