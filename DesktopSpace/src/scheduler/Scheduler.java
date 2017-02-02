package scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.WallPaperIO;

public class Scheduler {

	private final ScheduledExecutorService scheduler =
     Executors.newScheduledThreadPool(1);

	public Scheduler(Runnable task) {
		scheduleWallpaperChange(task);
	}

	private void scheduleWallpaperChange(Runnable task) {
		scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.MINUTES);
	}

}
