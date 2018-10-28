/**
 * 
 */
package com.cmc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
         * Create by: HaNuoc
         * Create date: Oct 27, 2018
         * Modifier: HaNuoc
         * Modified date:  Oct 27, 2018
         * Description: ....
         * Version 1.0
         */
@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleid;
	
	@Column(name="rolename")
	private String rolename;

	/**
	 * @return the roleid
	 */
	public int getRoleid() {
		return roleid;
	}

	/**
	 * @param roleid the roleid to set
	 */
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	/**
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * @return the role
	 */

}
