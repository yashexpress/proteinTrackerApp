package yash.simpleprogrammer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

	private int id;
	private String name;
	//Value type relationship, using 'component' in mapping file
	private ProteinData proteinData;
	
	//Value type relationship, using 'component' in mapping file
	//private Map<String,UserHistory> history = new HashMap<String,UserHistory>();//using map implementation
	//private Collection<UserHistory> history = new ArrayList<UserHistory>();//using Hibernate Bag implementation
	
	//Entity type relationship
	private List<UserHistory> history = new ArrayList<UserHistory>();
	
	private Set<GoalAlert> goalAlerts = new HashSet<GoalAlert>();
	
	public User(){
		setProteinData(new ProteinData());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProteinData getProteinData() {
		return proteinData;
	}
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
		proteinData.setUser(this);
	}
	public List<UserHistory> getHistory() {
		return history;
	}
	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}
	
	public void addHistory(UserHistory historyItem){
		historyItem.setUser(this); //having relationship setup from UserHistory to User
		history.add(historyItem);//Setting relationship from User to UserHistory
	}

	public Set<GoalAlert> getGoalAlerts() {
		return goalAlerts;
	}

	public void setGoalAlerts(Set<GoalAlert> goalAlerts) {
		this.goalAlerts = goalAlerts;
	}

	
		
}
