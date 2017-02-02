package main;

import io.WallPaperIO;
import scheduler.Scheduler;

public class Main {
	
	final static Runnable wallpaperUpdate = new Runnable() {
		public void run() {
			try {
				WallPaperIO.setWallpaper();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	public static void main(String[] args) throws Exception {
		Scheduler s = new Scheduler(wallpaperUpdate);
	}

}
