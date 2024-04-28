package com.capstone.GhumDoZa.entity;

import com.capstone.GhumDoZa.enums.TicketStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "ticket", schema = "public")
@Entity
@Getter
@Setter
public class TicketEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "serial_id", nullable = false)
  private String serialId;

  @Column(name = "headline", nullable = false)
  private String headline;

  @Column(name = "body")
  private String body;

  @Column(name = "assignee_id")
  private Long assigneeId;

  @Column(name = "creator_id", nullable = false)
  private Long creatorId;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private TicketStatus status;
}