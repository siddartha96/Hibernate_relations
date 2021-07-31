
package com.jsp.onetomany.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


	@Entity
	@Table(name = "hallticket_table")
	public class HallTicket implements Serializable {

		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private int hId;
		private String USNNO;
		private String center;
		private String subjectcode;
		
		@OneToOne(mappedBy="hallticket")
		private UserDto user;
		
		
		public UserDto getUser() {
			return user;
		}

		public void setUser(UserDto user) {
			this.user = user;
		}

		public HallTicket() {
			super();
			
		}

		public int gethId() {
			return hId;
		}

		public void sethId(int hId) {
			this.hId = hId;
		}

		public String getUSNNO() {
			return USNNO;
		}

		public void setUSNNO(String uSNNO) {
			USNNO = uSNNO;
		}

		public String getCenter() {
			return center;
		}

		public void setCenter(String center) {
			this.center = center;
		}

		public String getSubjectcode() {
			return subjectcode;
		}

		public void setSubjectcode(String subjectcode) {
			this.subjectcode = subjectcode;
		}
		

	}



