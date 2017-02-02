package io;

import java.awt.image.BufferedImage;
import java.io.File;

import http.APODRequest;

public class WallPaperIO {

	public static void setWallpaper() throws Exception {
		APODRequest request = new APODRequest();
		String imageURL = request.getImageURL();

		BufferedImage image = SpaceImageIO.imageFromURL(imageURL);
		System.out.println(imageURL);

		File file = SpaceImageIO.saveImage(image, "png", SpaceImageIO.getNameFromImageURL(imageURL));
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.indexOf("win") >= 0) {
			setWallpaperWindows();
		} else if (osName.indexOf("mac") >= 0) {
			setWallpaperMac(file);
		}
	}

	private static void setWallpaperMac(File file)
	throws Exception {		
		String as[] = {
			"osascript",
			"-e", "tell application \"Finder\"",
			"-e", "set desktop picture to POSIX file \"" + file.getAbsolutePath() + "\"",
			"-e", "end tell"
		};
		Runtime runtime = Runtime.getRuntime();
		runtime.exec(as);
	}

	private static void setWallpaperWindows() {

	}

}
