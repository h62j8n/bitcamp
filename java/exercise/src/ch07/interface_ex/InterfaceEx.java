package ch07.interface_ex;

class Audio {
	void autoPlay(Crying i) {
		i.cries();
	}
}

interface Crying {
	public abstract void cries();
}

class Dog implements Crying {
	public void cries() {
		System.out.println("bow-wow!");
	}
}

class Cat implements Crying {
	public void cries() {
		System.out.println("meow!");
	}
}

public class InterfaceEx {
	public static void main(String[] args) {
		Audio audio = new Audio();
		audio.autoPlay(new Dog());
		audio.autoPlay(new Cat());
	}
}
