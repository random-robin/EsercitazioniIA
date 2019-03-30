package app;

import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.informed.AStarSearch;

import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;

public class App {
    public static void main(String[] args) throws Exception {
        MSCState initState = new MSCState();
        Problem problem = new Problem(initState,
                                        new MSCActions(),
                                        new MSCResults(),
                                        initState,
                                        initState );

        SearchAgent agent = new SearchAgent(problem, new AStarSearch(new GraphSearch(), initState));
        printActions(agent.getActions());
        printIntrument(agent.getInstrumentation());

    }

    public static void printActions(List<Action> list){
        for(Action x : list){
            System.out.println(x);
        }
    }

    public static void printIntrument(Properties properties){
        StringBuilder sb = new StringBuilder();
        for(Object x: properties.keySet()){
            sb.append((String)x);
            sb.append(":");
            sb.append(properties.get((String)x));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}