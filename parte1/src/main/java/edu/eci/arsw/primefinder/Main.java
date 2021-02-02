package edu.eci.arsw.primefinder;

import java.awt.EventQueue;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class Main {


	public static void main(String[] args) throws InterruptedException {
		Scanner scanner= new Scanner(System.in);
		String continuar="";
		PrimeFinderThread pft1 = new PrimeFinderThread(0, 10000000);
		PrimeFinderThread pft2 = new PrimeFinderThread(10000000, 20000000);
		PrimeFinderThread pft3 = new PrimeFinderThread(20000000, 30000000);

		pft1.start();
		pft2.start();
		pft3.start();
		try {
			Thread.sleep(5000);
			pft1.suspenderHilo();
			pft2.suspenderHilo();
			pft3.suspenderHilo();
			System.out.println("Presione ENTER si desea continuar:");
			do {
				continuar=scanner.nextLine();
			}
			while(!continuar.equals(""));
			pft1.reaundarHilo();
			pft2.reaundarHilo();
			pft3.reaundarHilo();
		} catch (InterruptedException e) {
		}

	}
}
