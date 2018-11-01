package org.gun.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "gun_table")
public class GunDTO implements Serializable {

	@GenericGenerator(name = "gun", strategy = "increment")
	@GeneratedValue(generator = "gun")
	@Id
	@Column(name = "gun_id")
	private int gunId;
	@Column(name = "gun_name")
	private String gunName;
	@Column(name = "gun_price")
	private long price;
	@Column(name = "gun_range")
	private double range;
	@Column(name="gun_type")
	private String gunType;

	public GunDTO() {
		System.out.println(this.getClass().getSimpleName() + " class object is created");
	}

	public int getGunId() {
		return gunId;
	}

	public void setGunId(int gunId) {
		this.gunId = gunId;
	}

	public String getGunName() {
		return gunName;
	}

	public void setGunName(String gunName) {
		this.gunName = gunName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}
}
