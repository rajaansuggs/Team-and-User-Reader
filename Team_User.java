import java.util.Scanner;

public class Team_User {
	//====================================Properties
		private int teamId, userId;
		private boolean isAssistantCoach, hasBeenHonored;
		//====================================Constructor
		public Team_User(int teamId, int userId, boolean isAssistantCoach, boolean hasBeenHonored) {
			super();
			setTeamId(teamId);
			setUserId(userId);
			setAssistantCoach(isAssistantCoach);
			setHasBeenHonored(hasBeenHonored);
		}
		
		public Team_User(String[] s) {
			this(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Boolean.parseBoolean(s[2]), Boolean.parseBoolean(s[3]));
		}
		
		public Team_User(Scanner fin) {
			this(fin.nextLine().split("\t"));
		}
		
		//====================================Methods
		@Override
		public String toString() {
			return "Team_User [teamId=" + teamId + ", userId=" + userId + ", isAssistantCoach=" + isAssistantCoach
					+ ", hasBeenHonored=" + hasBeenHonored + "]";
		}
		
		
		//====================================Getters/setters
		public int getTeamId() {
			return teamId;
		}

		public void setTeamId(int teamId) {
			this.teamId = teamId;
		}
		
		public int getUserId() {
			return userId;
		}
		
		public void setUserId(int userId) {
			this.userId = userId;
		}
		
		public boolean isAssistantCoach() {
			return isAssistantCoach;
		}
		
		public void setAssistantCoach(boolean isAssistantCoach) {
			this.isAssistantCoach = isAssistantCoach;
		}
		
		public boolean isHasBeenHonored() {
			return hasBeenHonored;
		}
		
		public void setHasBeenHonored(boolean hasBeenHonored) {
			this.hasBeenHonored = hasBeenHonored;
		}
		
}
