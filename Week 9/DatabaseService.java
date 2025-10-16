package com.filex.service;

import com.filex.model.FileEvent;
import com.filex.model.Alert;
import com.filex.util.DatabaseConfig;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DatabaseService {
    
    private static DatabaseService instance;
    private Connection connection;
    
    /**
     * Private constructor to prevent instantiation
     */
    private DatabaseService() {
        // Private constructor to prevent instantiation
    }
    
    /**
     * Get the singleton instance of DatabaseService
     * 
     * @return The singleton instance
     */
    public static synchronized DatabaseService getInstance() {
        if (instance == null) {
            instance = new DatabaseService();
        }
        return instance;
    }
    
    /**
     * Initialize the database connection and create tables if they don't exist.
     */
    public synchronized void initialize() {
        try {
            // Load SQLite JDBC Driver
            Class.forName("org.sqlite.JDBC");
            
            // Establish connection only if not already established
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DatabaseConfig.DB_URL);
                // Create tables if they don't exist
                createTables();
                System.out.println("Database connection initialized successfully!");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error initializing database connection!");
            e.printStackTrace();
        }
    }
    
    /**
     * Create database tables if they don't exist.
     */
    private synchronized void createTables() throws SQLException {
        // Create file_events table
        String createFileEventsTable = """
            CREATE TABLE IF NOT EXISTS file_events (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                file_name TEXT NOT NULL,
                event_type TEXT NOT NULL,
                timestamp TIMESTAMP NOT NULL,
                sha256 TEXT,
                suspicious BOOLEAN DEFAULT FALSE,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            )
            """;
            
        // Create alerts table
        String createAlertsTable = """
            CREATE TABLE IF NOT EXISTS alerts (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                file_event_id INTEGER,
                severity TEXT NOT NULL,
                acknowledged BOOLEAN DEFAULT FALSE,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                actions_taken TEXT,
                FOREIGN KEY (file_event_id) REFERENCES file_events(id)
            )
            """;
            
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createFileEventsTable);
            stmt.execute(createAlertsTable);
            System.out.println("Database tables created/verified successfully!");
        }
    }
    
    /**
     * Save a file event to the database.
     * 
     * @param event The file event to save
     */
    public synchronized void saveEvent(FileEvent event) {
        String sql = "INSERT INTO file_events (file_name, event_type, timestamp, sha256, suspicious) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, event.getFileName());
            stmt.setString(2, event.getEventType());
            stmt.setTimestamp(3, Timestamp.valueOf(event.getTimestamp()));
            stmt.setString(4, event.getSha256());
            stmt.setBoolean(5, event.isSuspicious());
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("File event saved successfully: " + event.getFileName());
            }
        } catch (SQLException e) {
            System.err.println("Error saving file event: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Get all file events from the database.
     * 
     * @return List of all file events
     */
    public synchronized List<FileEvent> getAllEvents() {
        List<FileEvent> events = new ArrayList<>();
        String sql = "SELECT * FROM file_events ORDER BY timestamp DESC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                FileEvent event = new FileEvent();
                event.setFileName(rs.getString("file_name"));
                event.setEventType(rs.getString("event_type"));
                event.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
                event.setSha256(rs.getString("sha256"));
                event.setSuspicious(rs.getBoolean("suspicious"));
                events.add(event);
            }
            System.out.println("getAllEvents() returned " + events.size() + " events");
        } catch (SQLException e) {
            System.err.println("Error retrieving file events: " + e.getMessage());
            e.printStackTrace();
        }
        
        return events;
    }
    
    /**
     * Get file events within a specific date range from the database.
     * 
     * @param startDate The start date of the range
     * @param endDate The end date of the range
     * @return List of file events within the date range
     */
    public synchronized List<FileEvent> getEventsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<FileEvent> events = new ArrayList<>();
        String sql = "SELECT * FROM file_events WHERE timestamp BETWEEN ? AND ? ORDER BY timestamp DESC";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setTimestamp(1, Timestamp.valueOf(startDate));
            stmt.setTimestamp(2, Timestamp.valueOf(endDate));
            
            System.out.println("Executing query: " + sql);
            System.out.println("Parameters: " + startDate + " to " + endDate);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FileEvent event = new FileEvent();
                    event.setFileName(rs.getString("file_name"));
                    event.setEventType(rs.getString("event_type"));
                    event.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
                    event.setSha256(rs.getString("sha256"));
                    event.setSuspicious(rs.getBoolean("suspicious"));
                    events.add(event);
                }
            }
            System.out.println("getEventsByDateRange() returned " + events.size() + " events");
        } catch (SQLException e) {
            System.err.println("Error retrieving file events by date range: " + e.getMessage());
            e.printStackTrace();
        }
        
        return events;
    }
    
    /**
     * Get suspicious file events from the database.
     * 
     * @return List of suspicious file events
     */
    public synchronized List<FileEvent> getSuspiciousEvents() {
        List<FileEvent> events = new ArrayList<>();
        String sql = "SELECT * FROM file_events WHERE suspicious = TRUE ORDER BY timestamp DESC";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                FileEvent event = new FileEvent();
                event.setFileName(rs.getString("file_name"));
                event.setEventType(rs.getString("event_type"));
                event.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
                event.setSha256(rs.getString("sha256"));
                event.setSuspicious(rs.getBoolean("suspicious"));
                events.add(event);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving suspicious file events: " + e.getMessage());
            e.printStackTrace();
        }
        
        return events;
    }
    
    /**
     * Save an alert to the database.
     * 
     * @param alert The alert to save
     */
    public synchronized void saveAlert(Alert alert) {
        String sql = "INSERT INTO alerts (file_event_id, severity, acknowledged, actions_taken) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, alert.getFileEventId());
            stmt.setString(2, alert.getSeverity());
            stmt.setBoolean(3, alert.isAcknowledged());
            stmt.setString(4, alert.getActionsTaken());
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Alert saved successfully with severity: " + alert.getSeverity());
            }
        } catch (SQLException e) {
            System.err.println("Error saving alert: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Get all alerts from the database.
     * 
     * @return List of all alerts
     */
    public synchronized List<Alert> getAllAlerts() {
        List<Alert> alerts = new ArrayList<>();
        String sql = "SELECT * FROM alerts ORDER BY created_at DESC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Alert alert = new Alert();
                alert.setId(rs.getInt("id"));
                alert.setFileEventId(rs.getInt("file_event_id"));
                alert.setSeverity(rs.getString("severity"));
                alert.setAcknowledged(rs.getBoolean("acknowledged"));
                alert.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                alert.setActionsTaken(rs.getString("actions_taken"));
                alerts.add(alert);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving alerts: " + e.getMessage());
            e.printStackTrace();
        }
        
        return alerts;
    }
    
    /**
     * Close the database connection.
     */
    public synchronized void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing database connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}