import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GreedyBest implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		Node root = model.getInitialState();
		Node goal = model.getGoalState();
		
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		Set<Node> explored = new HashSet<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node temp = frontier.poll();
			explored.add(temp);
			if (model.computeH1(root) == 0) {
				return goal;
			} else {
				for (Node child : model.getSuccessors(temp)) {
					System.out.println(child);
					child.setH(model.computeH1(child));
					System.out.println(child.getH());
					if(model.computeH1(child)==0) {
						return goal;
					}
					if (!explored.contains(child) && !frontier.contains(child)) {
						frontier.add(child);
						System.out.println(child);
					}
				}
			}
		}
		return goal;

	}
}
