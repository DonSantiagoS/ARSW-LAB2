package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread{

	
	int a,b;
	boolean suspender, pausar;
	
	private List<Integer> primes=new LinkedList<Integer>();
	
	public PrimeFinderThread(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		suspender=false;
		pausar=false;
	}

	public void run(){
		try{
			for (int i=a;i<=b;i++){
				if (isPrime(i)) {
					primes.add(i);
					System.out.println(i);



				}
				synchronized (this){
					while(suspender){
						wait();

					}
					if (pausar)break;
				}

			}
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		
		
	}
	synchronized void pausarHilo(){
		pausar=true;
		suspender=false;
		notify();
	}

	synchronized void suspenderHilo(){

		suspender=true;
	}

	synchronized void reaundarHilo(){
		suspender=false;
		notify();
	}
	
	boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public List<Integer> getPrimes() {
		return primes;
	}
	
	
	
	
}
