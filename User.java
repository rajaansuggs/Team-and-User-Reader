import java.util.ArrayList;
import java.util.Scanner;

public class User {
	//====================================Properties
		private int userId;
		private String firstName, lastName, userName, password;
		private ArrayList<Team_User> teams = new ArrayList<Team_User>();
		//====================================Constructor
		public User(int userId, String firstName, String lastName, String userName, String password) {
			super();
			setUserId(userId);
			setFirstName(firstName);
			setLastName(lastName);
			setUserName(userName);
			setPassword(password);
		}
		
		public User(String[] s) {
			this(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4]);
		}
		
		public User(Scanner fin) throws Exception{
			this(fin.nextLine().split("\t"));
		}
		
		//====================================Methods
		public String toString() {
			return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
					+ userName + ", password=" + password + ", teams=" + teams + "]";
		}
		
		//====================================Getters/setters
		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public String getUserName() {
			return userName;
		}
		
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}

		public ArrayList<Team_User> getTeams() {
			return teams;
		}

		public void setTeams(ArrayList<Team_User> teams) {
			this.teams = teams;
		}
		
		
}
