package ar.edu.unlp.info.oo1.ej10_jobScheduler;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class JobSchedulerTest {
    protected JobDescription firstJob;
    protected JobDescription highestPriorityJob;
    protected JobDescription mostEffortJob;
    protected JobDescription lastJob;
  
    
    private void initializeJobs() {
    	
    	firstJob = new JobDescription (1, 1, "Este es el primero");
    	highestPriorityJob = new JobDescription (1, 100, "Este es el de m�s prioridad");
    	mostEffortJob = new JobDescription (100, 1, "Este es el de m�s esfuerzo");
    	lastJob = new JobDescription (1, 1, "Este es el �ltimo");
    	
    }
    
    @BeforeEach
    void setUp() {
    	this.initializeJobs();
    } 
    
    private JobSchedulerFIFO newFifoScheduler() {
    	JobSchedulerFIFO fifoScheduler = new JobSchedulerFIFO();
    	fifoScheduler.setStrategy("FIFO");
    	return fifoScheduler;
    }
    
    private JobSchedulerLIFO newLifoScheduler() {
    	JobSchedulerLIFO lifoScheduler = new JobSchedulerLIFO();
    	lifoScheduler.setStrategy("LIFO");
    	return lifoScheduler;
    }
    
    private JobSchedulerHighestPriority newPriorityScheduler() {
    	JobSchedulerHighestPriority priorityScheduler = new JobSchedulerHighestPriority();
    	priorityScheduler.setStrategy("HighestPriority");
    	return priorityScheduler;
    }
    
    private JobSchedulerMostEffort newEffortScheduler() {
    	JobSchedulerMostEffort effortScheduler = new JobSchedulerMostEffort();
    	effortScheduler.setStrategy("MostEffort");
    	return effortScheduler;
    }
    
    private void scheduleJobsIn(JobScheduler aJobScheduler) {
    	aJobScheduler.schedule(firstJob);
    	aJobScheduler.schedule(highestPriorityJob);
    	aJobScheduler.schedule(mostEffortJob);
    	aJobScheduler.schedule(lastJob);
    }
    
    @Test
    void testSchedule() {
    	JobScheduler aScheduler = new JobSchedulerHighestPriority();
    	aScheduler.schedule(highestPriorityJob);
    	assertTrue(aScheduler.getJobs().contains(highestPriorityJob));
    } 
    
    @Test
    void testUnschedule() {
    	JobScheduler aScheduler = new JobSchedulerHighestPriority();
    	this.scheduleJobsIn(aScheduler);
    	aScheduler.unschedule(highestPriorityJob);
    	assertFalse(aScheduler.getJobs().contains(highestPriorityJob));   	
    }
    
    @Test
    void testNext() {
    	JobSchedulerFIFO scheduler0;
    	JobSchedulerLIFO scheduler1;
    	JobSchedulerMostEffort scheduler3;
    	JobSchedulerHighestPriority scheduler2;
    	
    	scheduler0 = this.newFifoScheduler();
    	this.scheduleJobsIn(scheduler0);
    	assertEquals(scheduler0.next(), firstJob);
    	assertEquals(scheduler0.getJobs().size(), 3);
    	
    	scheduler1 = this.newLifoScheduler();
    	this.scheduleJobsIn(scheduler1);
    	assertEquals(scheduler1.next(), lastJob);
    	assertEquals(scheduler1.getJobs().size(), 3);

    	scheduler2 = this.newPriorityScheduler();
    	this.scheduleJobsIn(scheduler2);
    	assertEquals(scheduler2.next(), highestPriorityJob);
    	assertEquals(scheduler2.getJobs().size(), 3);

    	scheduler3 = this.newEffortScheduler();
    	this.scheduleJobsIn(scheduler3);
    	assertEquals(scheduler3.next(), mostEffortJob);
    	assertEquals(scheduler3.getJobs().size(), 3);

    }
}
