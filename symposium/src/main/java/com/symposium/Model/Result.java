package com.symposium.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "event_id")
    private String eventId;

    @Column(name = "winner_name")
    private String winnerName;

    private String position;
    private String score;

    @Column(name = "total_mark")
    private String totalMark;

    @Column(name = "judge_Remark")
    private String judgeRemark;

    private String certificate;

    // Getters & Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getEventId() { return eventId; }
    public void setEventId(String eventId) { this.eventId = eventId; }

    public String getWinnerName() { return winnerName; }
    public void setWinnerName(String winnerName) { this.winnerName = winnerName; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getScore() { return score; }
    public void setScore(String score) { this.score = score; }

    public String getTotalMark() { return totalMark; }
    public void setTotalMark(String totalMark) { this.totalMark = totalMark; }

    public String getJudgeRemark() { return judgeRemark; }
    public void setJudgeRemark(String judgeRemark) { this.judgeRemark = judgeRemark; }

    public String getCertificate() { return certificate; }
    public void setCertificate(String certificate) { this.certificate = certificate; }
}
