package org.gun.tester;

import org.gun.dao.GunDAO;
import org.gun.dto.GunDTO;

public class TesterMain {
	public static void main(String[] args) {

		// GunDTO gunDTO = new GunDTO();
		// gunDTO.setGunName("AK47");
		// gunDTO.setPrice(6565656L);
		// gunDTO.setRange(450);
		//
		// GunDAO gunDAO = new GunDAO();
		// Integer identifier = gunDAO.saveGun(gunDTO);
		//
		// System.out.println("The identifiers is " + identifier);

		GunDAO gunDAO = new GunDAO();
		String gunType = gunDAO.getGunPriceByName("AK47");
		System.out.println("Gun type is " + gunType);

		System.out.println("------------------------------------------------------------------");

		String gunType1 = gunDAO.getGunPriceByName("AK47");
		System.out.println("Gun type is " + gunType1);

		System.out.println("------------------------------------------------------------------");

		GunDTO gunDetails = gunDAO.getGunByName1("AK47");
		if (gunDetails != null) {
			System.out.println("Id is " + gunDetails.getGunId());
			System.out.println("Name is " + gunDetails.getGunName());
			System.out.println("price is " + gunDetails.getPrice());
		}
	}
}
