package com.Pannell;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class ImageProcessing extends GraphicsProgram {

	private GImage image;

	// click the canvas to reverse the image.
	public void run() {
		demonstration();
	}

	public void demonstration() {
		addMouseListeners();
		initializeImage();
	}

	public void initializeImage() {
		image = new GImage("milkMaid.jpg");
	}

	public void flipImage() {
		int[][] oldArray = image.getPixelArray();
		
		
		int imageWidth = oldArray[0].length;
		int imageHeight = oldArray.length;
		
		
		for (int row = 0; row < imageHeight; row++) {
			
			for (int oldPixel = 0; oldPixel < imageWidth / 2; oldPixel++) {
				
				int newPixel = imageWidth - oldPixel - 1;
				int temp = oldArray[row][oldPixel];
				
				oldArray[row][oldPixel] = oldArray[row][newPixel];
				oldArray[row][newPixel] = temp;
			}
		}
		
		image = new GImage(oldArray);
	}

	public void mouseClicked(MouseEvent e) {
		flipImage();
		add(image);
	}

}
