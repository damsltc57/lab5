package AgentDemo;

import PoolPattern.ObjectPool;

public class TaskRequester implements Runnable {
    private ObjectPool server;


    public TaskRequester(ObjectPool server) {
        this.server = server;
    }

    @Override
    public void run() {
        Agent_IF agent = null;
        try {
            agent = (Agent_IF) server.waitForObject();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        agent.startTask();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        agent.stopTask();
        server.release(agent);
    }
}


