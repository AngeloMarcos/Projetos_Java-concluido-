
/*JOGO DESENVOLVIDO POR ANGELO MARCOS 
 *GITHUB: https://github.com/
 *WHATSAPP: 11991909106
 * */
package angelo.project;

import java.awt.*;

import javax.swing.JFrame;

	
	public class MainJogo  {
		static DisplayMode monitor =  GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		
		public static void main(String[] args) {
			//instanciando janela do jogo
			JFrame janela = new JFrame("Sapace Invaders");
			//definindo o tamanho da janela
			janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
			janela.setLayout(null);
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			SpaceInvaders invasaoAlienigena = new SpaceInvaders();
			janela.setLocationRelativeTo(null);
			invasaoAlienigena.setBounds(0,0,monitor.getWidth(), monitor.getHeight());
			janela.add(invasaoAlienigena);
			janela.addKeyListener(invasaoAlienigena);
			janela.setVisible(true);
			
		}	
	
	}
