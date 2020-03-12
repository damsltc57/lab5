package AgentDemo;

public class CIA_Agent_Creator {
    private String[] footPrints = {"@", "#", "$", "*", ".", "?"};
    private int index = 0;

    public Object create() {
        CIA_Agent agent = new CIA_Agent(footPrints[index++]);
        new Thread(agent).start();
        return agent;
    }
}
