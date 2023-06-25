package com.kce.bean;

import java.util.List;

public class Teams {
	int clubId;
	String clubName;
	List<String> players;
	String Origin;
	String ManagerName;

	public Teams(int clubId, String clubName, List<String> players, String origin, String managerName) {
		super();
		this.clubId = clubId;
		this.clubName = clubName;
		this.players = players;
		Origin = origin;
		ManagerName = managerName;
	}

	public Teams() {

	}

	public int getClubId() {
		return clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public List<String> getPlayers() {
		return players;
	}

	public String getOrigin() {
		return Origin;
	}

	public String getManagerName() {
		return ManagerName;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public void setPlayers(List<String> players) {
		this.players = players;
	}

	public void setOrigin(String origin) {
		Origin = origin;
	}

	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}
}
