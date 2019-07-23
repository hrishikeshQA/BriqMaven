package context;

import utils.SeleniumUtils;
import workflow.MapWorkflow;

public class Global {
	protected Global(){
		
	}

	SeleniumUtils seleniumUtils = new SeleniumUtils();
	MapWorkflow mapWorkflow = new MapWorkflow();
	
	public SeleniumUtils getSeleniumUtils(){
		return this.seleniumUtils;
	}
	
	public MapWorkflow getMapWorkflow(){
		return this.mapWorkflow;
	}
}
