package com.costaisa.bootcamp.domain;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.server.NotAcceptableStatusException;

import com.costaisa.bootcamp.exceptions.InvalidNoteException;

@Entity(name="note")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column
	private String text;
	
	@Column
	private ZonedDateTime date;
	
	@Column
	private Boolean active = Boolean.TRUE;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ZonedDateTime getDate() {
		return date;
	}
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}	
	
	public boolean validate() throws InvalidNoteException {		
		if (getText() == null || getText().equals("")) {
			throw new InvalidNoteException("una nota debe contener texto, subnormal");
		}
		if (getDate() == null) {
			throw new InvalidNoteException("una nota debe tener una fecha, imbécil");
		}		
		return true;
	}
}
