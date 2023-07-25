package angelo.project;
import java.util.Random;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import javax.swing.JPanel;

public class SpaceInvaders extends JPanel implements Runnable, KeyListener{
	private Font minhaFonte = new Font ("Consolas" , Font.BOLD, 20);
	//Construtor da nave
	private Nave nave;
	private int direcao;
	private ArrayList<Tiro> tiros;	
	private ArrayList<Inimigo> inimigos;
	private PlanoDeFundo fundo;
	private boolean ganhou;
	private boolean perdeu;
	private Random random;
	
	public SpaceInvaders() {
		System.out.println("Largura da tela: " + MainJogo.monitor.getHeight());
		nave = new Nave();
		tiros = new ArrayList<Tiro>();
		inimigos = new ArrayList<Inimigo>();
		fundo = new PlanoDeFundo();
		random = new Random();
		ganhou = false;
		perdeu = false;
		BufferedImage imagemInimigo = null;;
		try {
			imagemInimigo = ImageIO.read(new File("Imagens/Inimigo.png"));
		} catch (IOException e) {
			System.out.println("nao foi possivel carregar a imagem");
			e.printStackTrace();
		}
		
		//desenha quantidade de inimigo na tela
		for (int i = 0; i <60; i++) {
			int iniciox = random.nextInt(MainJogo.monitor.getWidth() - 100); // Limita a posição inicial dentro da largura da tela - 100
		    int inicioy = random.nextInt(MainJogo.monitor.getHeight() / 3); // Limita a posição inicial na metade superior da tela
		    inimigos.add(new Inimigo(imagemInimigo, iniciox, inicioy, 1));
		}
		
		Thread lacoDoJogo = new Thread(this);
		lacoDoJogo.start();
	}

	@Override
	public void run() {
		while (true) {	
			
			long tempoInicial = System.currentTimeMillis();
			
			update();
			repaint();
			
			long tempoFinal = System.currentTimeMillis();
			long diferenca = 12 -(tempoFinal - tempoInicial);
			if (diferenca > 0) {
			dorme(diferenca);
			}
			
			
		}
		
	}
	
	private void update() {
		nave.movimenta(direcao);
		 	
		for(int i=0; i < inimigos.size(); i++) {
			inimigos.get(i).atualizar();
		}
		//verificar se jogador ganhou
		if (inimigos.size() == 0) {
			ganhou = true;
		}
		for (int i = 0; i < inimigos.size(); i++) {
		
			
			if (inimigos.get(i).gety() >= MainJogo.monitor.getHeight() -150) {
				perdeu = true;
			}
		}
		for (int i= 0; i < tiros.size(); i++) {
			 tiros.get(i).atualiza();
		
			 if (tiros.get(i).destroi()) {
				 tiros.remove(i);
				 i--;
			 }else {
			 for (int j = 0; j < inimigos.size(); j++) {
					if(tiros.get(i).colideCom(inimigos.get(j))) {
						
						inimigos.remove(j);
						tiros.remove(i);
						j--; 
						
						break;
					}
				}
			 }
				
		}
		for (int i = 0; i < inimigos.size(); i++) {
			
			if (inimigos.get(i).getx() == 0  || inimigos.get(i).getx() == MainJogo.monitor.getWidth()  - 50) {
				for (int j = 0; j < inimigos.size(); j++) {
					inimigos.get(j).trocaDirecao();
				}
				break;
			}
		}
	}
    protected void paintComponent(Graphics g2) {
    	super.paintComponent(g2);
    	
        Graphics2D g = (Graphics2D) g2.create();
        g.setRenderingHint(
        		RenderingHints.KEY_ANTIALIASING,
        		RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(
        		RenderingHints.KEY_TEXT_ANTIALIASING,
        		RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //carrega o plano de fundo
        fundo.pinta(g);
        //desenha inimigo
        for (int i = 0; i < inimigos.size(); i++) {
        inimigos.get(i).pintar(g);
        }
        //desenha nave
        nave.pintar(g);
       
        for (int i= 0; i < tiros.size(); i++) {
			 tiros.get(i).pintar(g);
		}
        if (ganhou) {
        	g.setColor(Color.white);
        	g.setFont(minhaFonte);
        	g.drawString("Voce ganhou!", MainJogo.monitor.getHeight()/2 -100 , MainJogo.monitor.getHeight()/2);
        }
        
        if (perdeu) {
        	g.setColor(Color.white);
        	g.setFont(minhaFonte);
        	g.drawString("Voce é muito ruim!", MainJogo.monitor.getHeight()/2 -100 , MainJogo.monitor.getHeight()/2);
        }
    }
	private void dorme(long duracao) {
		try {
			Thread.sleep(duracao);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D) {
			 direcao  = 1;
		  }
		if (e.getKeyCode() == KeyEvent.VK_A) {
			direcao = -1;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE && nave.podeAtirar()) {
			tiros.add(nave.atirar());
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D) {
			direcao = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			direcao = 0;
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
	  
		
		
	}
	
}
