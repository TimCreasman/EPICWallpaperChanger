package io;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class SpaceImageIO {

	public static BufferedImage imageFromURL(String stringUrl) {
		BufferedImage image = null;
		URL url = null;
		try {
			url = new URL(stringUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}

	public static String getNameFromImageURL(String imageURL) {
		return imageURL.substring(imageURL.lastIndexOf("/") + 1,
			imageURL.indexOf(".jpg"));
	}

	public static File saveImage(BufferedImage image, String ext, String name) {
		String fileName = name;
		File file = new File(fileName + "." + ext);
		try {
			ImageIO.write(image, ext, file);  // ignore returned boolean
		} catch (IOException e) {
			System.out.println("Write error for " + file.getPath() +
			                   ": " + e.getMessage());
		}
		return file;
	}

}
