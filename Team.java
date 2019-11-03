import java.util.ArrayList;
import java.util.Scanner;

public class Team {
	//====================================Properties
	private int teamId;
	private String universityTeamName;
	private int ownerUserId;
	private boolean isActive;
	private ArrayList<Team_User> users = new ArrayList<Team_User>();
	//====================================Constructor
	public Team(int teamId, String universityTeamName, int ownerUserId, boolean isActive) {
		super();
		setTeamId(teamId);
		setUniversityTeamName(universityTeamName);	
		setOwnerUserId(ownerUserId);
		setActive(isActive);
	}
	
	public Team(String s[]) {
		this(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]), Boolean.parseBoolean(s[3]));
	}
	
	public Team(Scanner fin) throws Exception{
		this(fin.nextLine().split("\t"));
	}
	
	
	//====================================Methods
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", universityTeamName=" + universityTeamName + ", ownerUserId=" + ownerUserId
				+ ", isActive=" + isActive + ", users=" + users + "]";
	}
	
	//====================================Getters/setters
	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
	public String getUniversityTeamName() {
		return universityTeamName;
	}
	
	public void setUniversityTeamName(String universityTeamName) {
		this.universityTeamName = universityTeamName;
	}
	
	public int getOwnerUserId() {
		return ownerUserId;
	}
	
	public void setOwnerUserId(int ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public ArrayList<Team_User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Team_User> users) {
		this.users = users;
	}
	
	
	
}
