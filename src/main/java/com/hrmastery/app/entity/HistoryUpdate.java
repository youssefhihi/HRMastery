package com.hrmastery.app.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "history_update")
public class HistoryUpdate {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)

        private UUID id;

        private LocalDateTime updatedAt;
        private String updatedColumn;
        private String oldValue;
        private String newValue;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "employee_id")
        private Employee employee;


    public HistoryUpdate(LocalDateTime updatedAt, String updatedColumn, String oldValue, String newValue, Employee employee) {
        this.updatedAt = updatedAt;
        this.updatedColumn = updatedColumn;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.employee = employee;
    }
    public HistoryUpdate() {}

}
