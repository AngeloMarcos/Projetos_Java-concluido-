package angelo.project;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Inimigo {
	private BufferedImage desenho;
	private int x;
	private int y;
	private int velocidade;
	private int direcao;
	//variaveis para inimigos andar aleatoriamente pela tela
	private int tempoTrocaDirecao;
	private int tempoTrocaDirecaoMax;
	private Random random;
	
	
	public Inimigo(BufferedImage imagem, int iniciox, int inicioy, int direcao) {
		this.desenho = imagem;
		this.direcao = direcao;
		this.x = iniciox;
		this.y = inicioy;
		
		//instanciando variavel para trocar direcao
		this.tempoTrocaDirecao = 0;
		this.tempoTrocaDirecaoMax = 80;
		this.random = new Random();
		
		this.velocidade = 5;
	}
	public void atualizar () {
		
		if (tempoTrocaDirecao == 0) {
			direcao = random.nextInt(3) -1;
			tempoTrocaDirecao = tempoTrocaDirecaoMax;
		}else {
			tempoTrocaDirecao --;
			
		}
		
		x += velocidade * direcao;
	}
	public void trocaDirecao() {
		direcao = direcao * -1;
	}
	public int getx() {
		return x;
	}
	public int gety() {
		
		return y;
	}
	public void pintar (Graphics2D g) { 
		
		
		g.drawImage(desenho, x , y , x + 100, y + 100,  0, 0, desenho.getWidth(), desenho.getHeight(), null);
	}
	public int getTam() {
		
		return 50;
	}
	
	
}
