package Test;

import Controller.GiaoVienConTroler;
import DAO.GiaovienDAO;
import DAO.LopHocDAO;
import Model.Lophoc;

public class ktconrtroller {
	public static void main(String[] args) {
		for (Lophoc lh : LopHocDAO.getInstance().selectAll()) {
			System.out.println(lh.toString());
		}
				
	
	}

}
