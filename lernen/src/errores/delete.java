package errores;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class delete {

	public static void main(String[] args) {

		JFrame marco = new JFrame("errores");
		marco.setBounds(50, 50, 500, 500);
		marco.setDefaultCloseOperation(3);
		xPanel panel = new xPanel();
		marco.add(panel);
		marco.setVisible(true);

	}

}

class xPanel extends JPanel {
	Image imagen;

	public xPanel() {

		try {
			imagen = ImageIO.read(new File("C:\\Users\\andreabee90\\Documents\\AppJar\\Jar\\src\\jar\\log.png"));
		} catch (Exception e) {
			System.out.println("no hay figura");
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		try {
			int ancho = imagen.getWidth(this);
			int alto = imagen.getHeight(this);
			g.drawImage(imagen, 0, 0, null);

			for (int i = 0; i < 500; i++) {

				for (int j = 0; j < 500; j++) {

					g.copyArea(0, 0, ancho, alto, ancho * i, ancho * j);

				}
			}
		} catch (Exception e) {
			g.drawString("no hay imagen", 20, 20);
		}
	}
}