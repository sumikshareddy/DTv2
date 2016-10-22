package com.peer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

	@Entity
	@Component
	public class UserRole {
		@Id
		private Integer rid;
		private String authority;
		public Integer getRid() {
			return rid;
		}
		public void setRid(Integer integer) {
			this.rid = integer;
		}
		public String getAuthority() {
			return authority;
		}
		public void setAuthority(String authority) {
			this.authority = authority;
		}
		public void setRid(String string) {
			// TODO Auto-generated method stub
			
		}
		
		
			}

