package com.te.MavinProject2.login.register;

import java.util.Scanner;

public class MainAccount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("1.logiin\n2.Register\n3.exit");
			int a = sc.nextInt();
			switch (a) {
			case 1:
				new LoginRegister().login();
				break;
			case 2:
				new LoginRegister().Register();
				break;
			default:
				System.exit(a);

			}

		}

	}

}
