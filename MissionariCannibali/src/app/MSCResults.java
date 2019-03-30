package app;

import java.util.HashMap;
import java.util.function.Function;

import aima.core.agent.Action;
import aima.core.search.framework.problem.ResultFunction;


/**
 * MSCResults
 */
public class MSCResults implements ResultFunction {

    private HashMap<Action, Function<MSCState, MSCState>> goFunctions;
    private HashMap<Action, Function<MSCState, MSCState>> returnFunctions;

    public MSCResults(){
        goFunctions = new HashMap<>();
        returnFunctions = new HashMap<>();

        /* Populating the map */
        goFunctions.put(MSCActions.MM, 
                        (MSCState s) ->  new MSCState(s.getMissionari() -2, s.getCannibali(), 1 - s.getPosition()));

        goFunctions.put(MSCActions.MC,
                        (MSCState s) ->  new MSCState(s.getMissionari() - 1, s.getCannibali() - 1, 1 - s.getPosition()));

        goFunctions.put(MSCActions.CC,
                        (MSCState s) ->  new MSCState(s.getMissionari(), s.getCannibali() - 2, 1 - s.getPosition()));

        goFunctions.put(MSCActions.M,
                        (MSCState s) ->  new MSCState(s.getMissionari() - 1, s.getCannibali(), 1 - s.getPosition()));

        goFunctions.put(MSCActions.C,
                        (MSCState s) ->  new MSCState(s.getMissionari(), s.getCannibali() - 1, 1 - s.getPosition()));


        
        returnFunctions.put(MSCActions.MM,
                        (MSCState s) -> new MSCState(s.getMissionari() + 2, s.getCannibali(), 1 - s.getPosition()));

        returnFunctions.put(MSCActions.MC,
                        (MSCState s) -> new MSCState(s.getMissionari() + 1, s.getCannibali() + 1, 1 - s.getPosition()));
                        
        returnFunctions.put(MSCActions.CC,
                        (MSCState s) -> new MSCState(s.getMissionari(), s.getCannibali() + 2, 1 - s.getPosition()));

        returnFunctions.put(MSCActions.M,
                        (MSCState s) -> new MSCState(s.getMissionari() + 1, s.getCannibali(), 1 - s.getPosition()));

        returnFunctions.put(MSCActions.C,
                        (MSCState s) -> new MSCState(s.getMissionari(), s.getCannibali() + 1, 1 - s.getPosition()));
        
    }

    @Override
    public Object result(Object arg0, Action arg1) {
        MSCState state = (MSCState) arg0;
        if(state.getPosition() == 1) {
            MSCState out = this.goFunctions.get(arg1).apply(state);
            return out;
        } else {
            return this.returnFunctions.get(arg1).apply(state);
        }
  }

    
}