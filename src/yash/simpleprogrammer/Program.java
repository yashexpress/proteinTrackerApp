package yash.simpleprogrammer;

import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;

public class Program {

 public static void main(String args[]){
	 System.out.println("Hello World!");
	 //Now practicing some HQL query
	 //populateSampleData();
	 Session session = HibernateUtilities.getSessionFcatory().openSession();
	 session.beginTransaction();
	 
	 Query query = session.createQuery("from User");
	 List<User> users = query.list();
	 for(User user : users){
		 System.out.println(user.getName());
	 }
	 
	 session.getTransaction().commit();
	 session.close();
	 HibernateUtilities.getSessionFcatory().close();
	 
	 
	 /* Code changes to handle mapping and relationship in Hibernate
	  
	 Session session =  HibernateUtilities.getSessionFcatory().openSession();
	 session.beginTransaction();
	 
	 User user = new User();
	 user.setName("Yash");
	 user.addHistory(new UserHistory(new Date(), "Set name to Yash"));
	 user.getProteinData().setGoal(250);
	 user.getHistory().add(new UserHistory(new Date(), "Set the goal to 250"));
	 user.getGoalAlerts().add(new GoalAlert("Congartulations"));
	 user.getGoalAlerts().add(new GoalAlert("You did it!"));
	 session.save(user);
	 session.getTransaction().commit();
	 
	 session.beginTransaction();
	//User loadedUser = (User)session.get(User.class, 1);//Using 'get', will return null, if index doesn't exist
	 User loadedUser = (User)session.load(User.class, 1);//Using 'load', will throw an Exception, if index doesn't exist
	 System.out.println(loadedUser.getName());
	 //System.out.println(loadedUser.getProteinData().getGoal());
	 for(UserHistory history: loadedUser.getHistory()){
		 System.out.println(history.getEntryTime().toString()+" "+history.getEntry());
	 }
	 loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 50);
	 loadedUser.addHistory(new UserHistory(new Date(), "Added 50 protein"));
	 user.setProteinData(new ProteinData());
	 
	 session.getTransaction().commit();
	 
	 session.close(); */
	 HibernateUtilities.getSessionFcatory().close();
 }
 
 private static void populateSampleData(){
	 
	 Session session = HibernateUtilities.getSessionFcatory().openSession();
	 session.beginTransaction();
	 
	 User joe = createUser("Joe", 500, 50, "Good job", "You made it");
	 session.save(joe);
	 
	 User bob = createUser("Bob", 300, 20, "Taco time!");
	 session.save(bob);
	 
	 User amy = createUser("Amy", 250, 200, "Yes!!!");
	 session.save(amy);
	 session.getTransaction().commit();
	 session.close();
 }
 
 private static User createUser(String name, int goal, int total, String ...alerts){
	 User user = new User();
	 user.setName(name);
	 user.getProteinData().setGoal(goal);
	 user.addHistory(new UserHistory(new Date(), "Set goal to" +goal));
	 user.getProteinData().setTotal(total);
	 user.addHistory(new UserHistory(new Date(), "Set total to" + total));
	 for(String alert: alerts){
		 user.getGoalAlerts().add(new GoalAlert(alert));
	 }
	 return user;
 }
 
 
}
