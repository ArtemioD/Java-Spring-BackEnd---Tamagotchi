package clases;

public class Tamagotchi {

	private String nombre;
	private int nivel;
	private Estado estado;
	private int tiempo;
	private final String ANSI_WHITE = "\u001B[37m";
	private final String ANSI_YELLOW = "\u001B[33m";

	public Tamagotchi(String nombre) {
		this.nombre = nombre;
		this.nivel = 0;
		this.estado = Estado.hambrienta;
		this.tiempo = 0;
		System.out.println(ANSI_WHITE + "Hola, Soy tu Mascota Virtual, mi nombre es " + ANSI_YELLOW + nombre);
	}

	public void comer() {
		System.out.println(ANSI_YELLOW + "Estoy comiendo");
		if (estado == Estado.hambrienta)
			cambieEstado(1, 20, Estado.contenta);
		else if (estado == Estado.aburrida && tiempo > 80)
			cambieEstado(1, 20, Estado.contenta);
		System.out.println(ANSI_YELLOW + "ya comi... ahora quero jugar");
		System.out.println("Tiempo " + tiempo + ", nivel " + nivel);
		estado = Estado.aburrida;
	}

	public void jugar() {
		switch (estado) {
			case contenta:
			case aburrida:
				cambieEstado(2, 60, Estado.hambrienta);
				System.out.println(ANSI_YELLOW + "jagando...");
				break;
			case hambrienta:
				System.out.println(ANSI_YELLOW + "NO PUEDO JUGAR, TENGO HAMBRE... MUCHO!!");
				break;
		}
		System.out.println("Tiempo " + tiempo + ", nivel " + nivel);
	}

	private void cambieEstado(int a, int b, Estado es) {
		estado = es;
		nivel += a;
		tiempo += b;
		System.out.println(ANSI_YELLOW + "estoy contenta");
	}

	@Override
	public String toString() {
		return "Tamagotchi [nombre=" + nombre + ", nivel=" + nivel + ", estado=" + estado + ", tiempo=" + tiempo + "]";
	}

}
