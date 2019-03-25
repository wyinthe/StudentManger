package jp.cn.yahoo.util;

public class MuGong {

	public void zuoMen(int qian) {

		int oneMenCost = 500;

		int menShu = qian / oneMenCost;

		System.out.println("wo zuo le " + menShu + "shan men.");

		SuoChang suoChang = new SuoChang();
		suoChang.zuoSuo(menShu * 50);
	}

}
