package angelo.project;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Nave {
	
	private BufferedImage desenho;
	private int x;
	private int y;
	private int velocidade;
	private boolean podeAtirar;
	private int recarregando;
	//construtor da nave
	public Nave() {
		try {
			desenho = ImageIO.read(new File("Imagens/NaveImg.png"));
		} catch (IOException e) {
			System.out.println("nao foi possivel carregar a imagem");
			e.printStackTrace();
		}
		
		// Calcula a posição x inicial para centralizar a nave na tela
	    x = MainJogo.monitor.getWidth() / 2 - desenho.getHeight() / 2;
	    y = MainJogo.monitor.getWidth() / 2 - desenho.getHeight() / 2;
	    velocidade = 3;
	    recarregando = 0;
	}
	

	public void pintar(Graphics2D g) {
		
		g.drawImage(desenho, 
				x, //posicao x na tela
				y, //posicao y na tela
				x + 100, 
				y +  100, 
				0,0,
				desenho.getWidth(), desenho.getHeight(), 
				null);

		
	}
	//nave retorna algum tiroo sempre que alguem apertar space
	public Tiro atirar() {
		podeAtirar = false;
		recarregando = 0;
		Tiro novoTiro = new Tiro (x + 49, 600);
		return novoTiro;
	}
	public void movimenta(int valor) {
		//caso valor negativo <<<
		//caso positivo>>
		
		if (valor == 1) {
			x += velocidade;
		}else if (valor == -1) {
			x -= velocidade;
			podeAtirar = true;
		}
		
		if (recarregando >= 2) {
			podeAtirar = true;
			recarregando = 0;
		}
		recarregando++;
	}
	public boolean podeAtirar() {
		return podeAtirar;
	}

}
