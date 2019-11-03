import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Tester{
	static Scanner in = new Scanner(System.in);
	static HashMap<Integer, User> users = new HashMap<Integer, User>();
	static HashMap<Integer, Team> teams = new HashMap<Integer, Team>();

	public static void main(final String[] args) throws Exception {
		loadData();
		menu: {
			while(true) {
				switch(getMenuChoice()) {
				case 1: lookUpUsersByTeamId();			break; 
				case 2: lookUpTeamsByUserId();			break;
				case 3: listTeamsWithNoUsers();			break;
				case 4: listUsersThatAreNotOnTeam();	break;
				case 5: 								break menu;
				}
			}
		}
		System.out.println("Good bye...");
	}

	private static void lookUpUsersByTeamId() {
		System.out.print("Enter teamId: ");
		Team t = teams.get(userInput());
		if(t == null) {
			System.out.println("No team exists with that teamId");
			lookUpUsersByTeamId();
		} else {
			System.out.println("\n" + t.getUniversityTeamName());
			if(t.getUsers().size() == 0)	System.out.println("\tNo users on this team");
			for(TeamUser tu : t.getUsers())
				System.out.println("\t" + users.get(tu.getUserId()));
		}
	}

	private static void lookUpTeamsByUserId() {
		System.out.print("Enter userId: ");
		User u = users.get(userInput());
		if(u == null) {
			System.out.println("No user exists with that userId");
			lookUpTeamsByUserId();
		} else {
			System.out.println("\n" + u.fullName());
			if(u.getTeams().size() == 0)	System.out.println("\tUser is not on any teams");
			for(TeamUser tu : u.getTeams())
				System.out.println("\t" + teams.get(tu.getTeamId()));
		}
	}

	private static void listTeamsWithNoUsers() {
		for(Team t : teams.values())
			if(t.getUsers().size() == 0)		System.out.println(t);
	}

	private static void listUsersThatAreNotOnTeam() {
		for(User u : users.values())
			if(u.getTeams().size() == 0)		System.out.println(u);
	}

	private static int userInput() {
		while(true) 
			try {	return Integer.parseInt(in.nextLine());		} catch (Exception e) {
				System.out.println("\n========== >> Invalid Input << ==========\n");
			}	
	}

	private static int getMenuChoice() {
		while(true) {
			System.out.println("\n========================================");
			System.out.println("1.	Look up users by teamId");
			System.out.println("2.	Look up teams by userId");
			System.out.println("3.	List teams with no users");
			System.out.println("4.	List users that are not on a team");
			System.out.println("5.	Exit");
			System.out.print(">> ");
			int ret = userInput();
			if(ret >= 1 && ret <= 5) 
				return ret;
			else
				System.out.println("\n====================== Input Error ======================");
		}
	}

	private static void loadData() {
		Scanner fin = null;
		try {
			fin = new Scanner(new File("users.txt"));		fin.nextLine();		//......... Users
			while(fin.hasNextLine()) {
				User u = new User(fin);
				users.put(u.getUserId(), u);
			} fin.close();

			fin = new Scanner(new File("teams.txt"));		fin.nextLine();		//......... Teams
			while(fin.hasNextLine()) {
				Team t = new Team(fin);
				teams.put(t.getTeamId(), t);
			} fin.close();

			fin = new Scanner(new File("team_users.txt"));	fin.nextLine();		//......... Team Users
			while(fin.hasNextLine()) {
				TeamUser tu = new TeamUser(fin);
				users.get(tu.getUserId()).getTeams().add(tu); //user's arraylist of teams
				teams.get(tu.getTeamId()).getUsers().add(tu);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {	try { fin.close(); } catch(Exception e) {}	}
	}
}

