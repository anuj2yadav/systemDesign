package taskSchduler;

import java.util.concurrent.TimeUnit;

public class ScheduledTask {
	private final Runnable runable;
	private long schduledTime;
	private final int taskType;
	public final long period;
	public final long delay;
	private final TimeUnit unit;
	public ScheduledTask(Runnable runable, long schduledTime, int taskType, long period, long delay, TimeUnit unit) {
		super();
		this.runable = runable;
		this.schduledTime = schduledTime;
		this.taskType = taskType;
		this.period = period;
		this.delay = delay;
		this.unit = unit;
	}
	public long getSchduledTime() {
		return schduledTime;
	}
	public void setSchduledTime(long schduledTime) {
		this.schduledTime = schduledTime;
	}
	public Runnable getRunable() {
		return runable;
	}
	public int getTaskType() {
		return taskType;
	}
	public long getPeriod() {
		return period;
	}
	public long getDelay() {
		return delay;
	}
	public TimeUnit getUnit() {
		return unit;
	}
	
	

}
