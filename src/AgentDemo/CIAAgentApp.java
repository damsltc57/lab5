package AgentDemo;

public class CIAAgentApp {

    public static void main(String[] args) {
	  ObjectPool server = ObjectPoolGetInstance(new CIA_Agent_Creator(), 5);
	  for (int i = 0; i < 10; i++) {
	      Thread client = new Thread(new TaskRequester(server));
	      client.start();
      }
    }
}
