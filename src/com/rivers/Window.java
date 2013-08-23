package com.rivers;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

public class Window extends JFrame {

	private JLabel icon;

	public Window() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		setBounds(50, 50, 420, 420);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		icon = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, icon, 10,
				SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, icon, 10,
				SpringLayout.WEST, getContentPane());
		getContentPane().add(icon);
	}

	public void setIcon(BufferedImage targetImage) {
		icon.setIcon(new ImageIcon(resize(targetImage, 400)));
	}

	public static BufferedImage resize(BufferedImage image, int width) {
		double scale = (double) width / (double) image.getWidth();
		int height = (int) (scale * image.getHeight());
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) bi.createGraphics();
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY));
		g2d.drawImage(image, 0, 0, width, height, null);
		g2d.dispose();
		return bi;
	}
}
