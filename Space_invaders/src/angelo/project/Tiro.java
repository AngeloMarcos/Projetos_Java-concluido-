package angelo.project;

import java.awt.Color;
import java.awt.Graphics2D;

public class Tiro {
	private int x;
	private int y;
	private int velocidade;
	private int tamanhox = 3;
	private int tamanhoy = 15;
	public Tiro(int iniciox, int inicioy){
			
		this.x = iniciox;
		this.y = inicioy;
		velocidade = 10;
	}
	
	public void pintar (Graphics2D g) { 
		
		
	     g.setColor(Color.red);
	     g.fillRect(x, y,tamanhox, tamanhoy);
	}


	public void atualiza() {
		y -= velocidade;
		
	}
	public boolean destroi () {
		return y < 0 ; //retorna verdadeiro ou falso
		
	}

	public boolean colideCom(Inimigo inimigo) {
		if( x >= inimigo.getx() && x + tamanhox <=  inimigo.getx() + inimigo.getTam() ) {
			if (y <= inimigo.gety() + inimigo.getTam()) {
				return true;
			}
		}
		return false;
	}
}        
