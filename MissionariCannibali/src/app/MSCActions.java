package app;

import java.util.HashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ActionsFunction;

/**
 * MSCActions
 */
public class MSCActions implements ActionsFunction {

    public static Action MM = new DynamicAction("MM");
    public static Action MC = new DynamicAction("MC");
    public static Action CC = new DynamicAction("CC");
    public static Action M = new DynamicAction("M");
    public static Action C = new DynamicAction("C");

    @Override
    public Set<Action> actions(Object arg0) {
        HashSet<Action> output = new HashSet<>();
        MSCState state = (MSCState) arg0;


        //Trasporto di due cannibali e se dall'altra sponda non ci sono missionari amen
        if(state.getCannibaliPos() >=2 && ((3-state.getMissionariPos() == 0) || (3 - state.getCannibaliPos() + 2) - (3-state.getMissionariPos()) >= 0)){
            output.add(CC);
        }
        //Trasporto di due missionari e se rimangono da soli i cannibali, che ci rimangano
        if(state.getMissionariPos() >= 2 && ((state.getMissionariPos() == 2) ||(state.getMissionariPos() - 2) >= state.getCannibaliPos())) {
            output.add(MM);
        }
        //Trasporto un missionario e un cannibale
        if(state.getMissionariPos() >= 1 && state.getCannibaliPos() >= 1) {
            output.add(MC);
        }
        //Trasporto un missionario e se non rimangono più missionari, who cares 
        if(state.getMissionariPos() >= 1 && ((state.getMissionariPos() == 1) ||(state.getMissionariPos() - 1) >= state.getCannibaliPos())) {
            output.add(M);
        }
        //Trasporto un cannibale occhhio i cannibali possono stare da soli !!
        if(state.getCannibaliPos() >= 1 && ((3-state.getMissionari() == 0) ||(3 - state.getMissionari()) >= (3-state.getCannibaliPos()+1))) {
            output.add(C);
        }
        System.out.println(state);
        System.out.println(output);
        return output;
    }

    
}