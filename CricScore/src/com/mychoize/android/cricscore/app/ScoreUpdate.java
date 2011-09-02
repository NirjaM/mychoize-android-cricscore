package com.mychoize.android.cricscore.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import android.content.Context;

public class ScoreUpdate{
	private int matchId;
	private String team1;
	private String team2;

	private String scoret1s1;
	private String scoret1s2;
	private String scoret2s1;
	private String scoret2s2;
	private byte innsPlay;

	private String playingTeam;
	private String playingOver;
	private String playingScore;

	private String batsman1;
	private String batsman2;
	private String batsman1score;
	private String batsman2score;
	private String bowler;
	private String bowlerEco;

	private String place;
	private String matchInfo;
	private String date;

	private String status;
	private boolean error;
	private boolean notCurrent;
	
	private int version;
	
	private Date timestamp;

	public ScoreUpdate() {
		this.timestamp = new Date();
	}
	
	public ScoreUpdate(boolean error){
		this.error = error;
		this.timestamp = new Date();
	}

	public ScoreUpdate(int id, long ts, int version) {
		this.matchId = id;
		this.timestamp = new Date(ts);
		this.version = version;
	}

	public void setScores(String team1, String team2, String t1s1, String t1s2,
			String t2s1, String t2s2, Byte innsPlay) {
		this.team1 = team1;
		this.team2 = team2;
		this.scoret1s1 = t1s1;
		this.scoret1s2 = t1s2;
		this.scoret2s1 = t2s1;
		this.scoret2s2 = t2s2;
		this.innsPlay = innsPlay;
	}

	public void setCurrentScore(String playingTeam, String playingScore,
			String playingOver) {
		this.playingTeam = playingTeam;
		this.playingScore = playingScore;
		this.playingOver = playingOver;
	}

	public boolean setCurrentInfo(List<String> listArray) {
		int size = listArray.size();
		if (size == 6) {
			this.batsman1 = listArray.get(0);
			this.batsman1score = listArray.get(1);

			this.batsman2 = listArray.get(2);
			this.batsman2score = listArray.get(3);

			this.bowler = listArray.get(4);
			this.bowlerEco = listArray.get(5);
		} else if (size == 4) {
			this.batsman1 = listArray.get(0);
			this.batsman1score = listArray.get(1);

			this.bowler = listArray.get(2);
			this.bowlerEco = listArray.get(3);
		} else if (size == 2) {
			this.batsman1 = listArray.get(0);
			this.batsman1score = listArray.get(1);
		} else {
			return false;
		}
		return true;
	}

	public void setFuturePlayInfo(String place, String matchInfo, String date) {
		this.place = place;
		this.matchInfo = matchInfo;
		this.date = date;
		this.notCurrent = true;
	}
	
	public String getUpdateTimeString(Context context){
		DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
		DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
		return "Updated : "+ dateFormat.format(this.timestamp)+" "+ timeFormat.format(this.timestamp);
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMatchId() {
		return matchId;
	}

	public String getTeam1() {
		return team1;
	}

	public String getTeam2() {
		return team2;
	}

	public String getScoret1s1() {
		return scoret1s1;
	}

	public String getScoret1s2() {
		return scoret1s2;
	}

	public String getScoret2s1() {
		return scoret2s1;
	}

	public String getScoret2s2() {
		return scoret2s2;
	}

	public String getPlayingTeam() {
		return playingTeam;
	}

	public String getPlayingOver() {
		return playingOver;
	}

	public String getPlayingScore() {
		return playingScore;
	}

	public String getBatsman1() {
		return batsman1;
	}

	public String getBatsman2() {
		return batsman2;
	}

	public String getBatsman1score() {
		return batsman1score;
	}

	public String getBatsman2score() {
		return batsman2score;
	}

	public String getBowler() {
		return bowler;
	}

	public String getBowlerEco() {
		return bowlerEco;
	}

	public String getStatus() {
		return status;
	}

	public byte getInnsPlay() {
		return innsPlay;
	}

	public String getPlace() {
		return place;
	}

	public String getDate() {
		return date;
	}

	public String getMatchInfo() {
		return matchInfo;
	}

	public boolean isError() {
		return error;
	}
	
	public void setError(boolean error){
		this.error = error;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isNotCurrent() {
		return notCurrent;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}