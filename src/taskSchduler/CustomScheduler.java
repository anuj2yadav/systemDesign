package taskSchduler;

import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class CustomScheduler {
	private final PriorityQueue<ScheduledTask> taskQueue;
	private final Lock lock =new ReentrantLock();
	private final Condition newTaskAdded=lock.newCondition();
	private final ExecutorService workerExecutor;
	
	public CustomScheduler(int workerThreadSize) 
		{
			taskQueue=new PriorityQueue<ScheduledTask>((a,b)->Long.compare(a.getSchduledTime(),b.getSchduledTime()));
			workerExecutor=Executors.newFixedThreadPool(workerThreadSize);
		}
		
	 // Method to run scheduler
		public void start()
		{
			long timeToSleep=0;
			while(true) {
				lock.lock();
				try {
					if(taskQueue.isEmpty())
					{
						newTaskAdded.await();
					}
					while(!taskQueue.isEmpty())
					{
						timeToSleep=taskQueue.peek().getSchduledTime()-System.currentTimeMillis();
						if(timeToSleep<=0)
						{
							break;
						}
						newTaskAdded.await(timeToSleep,TimeUnit.MILLISECONDS);
					}
					ScheduledTask task=taskQueue.poll();
					workerExecutor.submit(task.getRunable());
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		}
		/**
		*
		*Create and execute a one shot action that becomes enabled after the given delay
		**/
		public void schedule(Runnable command,long delay,TimeUnit unit)
		{
			lock.lock();
			try {
				
				long scheduledTime=System.currentTimeMillis()+unit.toMillis(delay);
				ScheduledTask newTask =new ScheduledTask(command,scheduledTime,1,0l,0l,unit);
				taskQueue.add(newTask);
				newTaskAdded.signalAll();
			}
			catch(Exception ex)
			{
				System.out.println("SomeThing went wrong in Scheduling task Type");
				
			}
			finally {
				lock.unlock();
			}
		}
	

}

