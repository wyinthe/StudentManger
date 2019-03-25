package jp.cn.yahoo.test;

import jp.cn.yahoo.util.MuGong;
import jp.cn.yahoo.util.WaGong;

public class Me {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      //
		gaiFangZi();
	}

	public static void gaiFangZi() {

		System.out.println("wo yao gai fang zi");

		WaGong waGong = new WaGong();
		waGong.gaiqiang(4000);

		MuGong muGong = new MuGong();
		muGong.zuoMen(2400);
	}
}
