package lab1_Ex1;

import lab1_Ex1.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		if(p.getLocationState()==LocationState.DIRTY) {
			return new DynamicAction("SUCK");
		}else if(p.getAgentLocation().equals("A")) {
			return new DynamicAction("RIGHT");
		}else if(p.getAgentLocation().equals("B")) {
			return new DynamicAction("LEFT");
		}
		return NoOpAction.NO_OP;
		
	}
}