package context;

public class Context {
	
	Context context = new Context();
	static Global global = new Global();
	static Local local = new Local();
	public Context(){
		
	}
	public static Global global(){
		return global;
	}
	public static Local local(){
		return local;
	}

}
