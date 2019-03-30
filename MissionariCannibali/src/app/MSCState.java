package app;

import aima.core.agent.Action;
import aima.core.search.framework.evalfunc.HeuristicFunction;
import aima.core.search.framework.problem.GoalTest;
import aima.core.search.framework.problem.StepCostFunction;

public class MSCState implements GoalTest, StepCostFunction, HeuristicFunction {

    private int cannibali;
    private int missionari;
    private int position;

    public MSCState() {
        this.cannibali = 3;
        this.missionari = 3;
        this.position = 1;
    }

    public MSCState(int missionari, int cannibali, int position) {
        this.cannibali = cannibali;
        this.missionari = missionari;
        this.position = position;
    }

    /**
     * @return the cannibali
     */
    public int getCannibaliPos() {
        if (this.position == 1) {
            return this.cannibali;
        } else {
            return 3 - this.cannibali;
        }

    }

    /**
     * @return the missionari
     */
    public int getMissionariPos() {
        if (this.position == 1) {
            return this.missionari;
        } else {
            return 3 - this.missionari;
        }
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @return the cannibali
     */
    public int getCannibali() {
        return cannibali;
    }

    /**
     * @return the missionari
     */
    public int getMissionari() {
        return missionari;
    }

    @Override
    public boolean isGoalState(Object arg0) {
        MSCState state = (MSCState) arg0;
        return state.getCannibali() == 0 
            && state.getMissionari() == 0 
            && state.getPosition() == 0;
    }

    @Override
    public double h(Object arg0) {
        MSCState state = (MSCState) arg0;
        if(state.getCannibali() == 1 && state.getMissionari() == 1 && state.position == 1) {
            return 1;
        }
        return state.getCannibali() + state.getMissionari();
        
    }

    @Override
	public double c(Object arg0, Action arg1, Object arg2) {
		return 1;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(this.getMissionariPos());
        sb.append(" ");
        sb.append(this.getCannibaliPos());
        sb.append(" ");
        sb.append(this.position);
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        MSCState state = (MSCState) obj;
        return state.getPosition() == this.getPosition() 
            && state.getCannibali() == this.getCannibali()
            && state.getMissionari() == this.getMissionari();
    }

}