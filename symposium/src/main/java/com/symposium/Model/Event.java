package com.symposium.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "event") // ensures table name in MySQL is lowercase
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String date;
    private String time;
    private String venue;
    private String category;        // lowercase for consistency
    private double maxParticipates; // camelCase

    // Constructors
    public Event() {}

    public Event(String title, String description, String date, String time, String venue, String category, double maxParticipates) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.category = category;
        this.maxParticipates = maxParticipates;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getMaxParticipates() { return maxParticipates; }
    public void setMaxParticipates(double maxParticipates) { this.maxParticipates = maxParticipates; }
}
