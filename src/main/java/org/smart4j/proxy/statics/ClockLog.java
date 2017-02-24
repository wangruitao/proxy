package org.smart4j.proxy.statics;

public class ClockLog implements Animal {

	private Animal animal;
	
	public ClockLog(Animal animal) {
		this.animal = animal;
	}



	@Override
	public void cry() {
		sleep();
		animal.cry();
		eat();

	}

	public void sleep() {
		System.out.println("呼呼呼~~~");
	}
	
	public void eat() {
		System.out.println("呜啊呜啊...");
	}
}
