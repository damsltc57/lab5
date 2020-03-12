package AgentDemo;

public class FBI_Agent implements Runnable, Agent_IF{
    private boolean workingInProgress = false;
    private String myFootPrint;

    public FBI_Agent(String footPrint) {
        this.myFootPrint = footPrint;
    }

    @Override
    public void run() {
        while (true) {
            if (workingInProgress) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(myFootPrint);
            } else  {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void startTask() {
        workingInProgress = true;
    }

    @Override
    public void stopTask() {
        workingInProgress = false;
    }

    @Override
    public void setTaskId(int id) {
        System.out.println(id);
    }
}
