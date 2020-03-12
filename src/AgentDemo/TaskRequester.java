package AgentDemo;

public class TaskRequester implements Runnable{
    private ObjectPool server;

    public TaskRequester(ObjectPool p) {
        this.server = p;
    }

    @Override
    public void run() {
        Agent_IF agent = (Agent_IF)server.waitForObject();
        agent.startTask();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        agent.stopTask();
        server.release(agent);
    }


