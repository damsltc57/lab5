package AgentDemo;

public class FBIAgentApp {

    public static void main(String[] args) {
	  ObjectPool server = ObjectPoolGetInstance(new FBI_Agent_Creator(), 5);
	  for (int i = 0; i < 10; i++) {
	      Thread client = new Thread(new TaskRequester(server));
	      client.start();
      }
    }
}
