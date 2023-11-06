import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class AStar implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		int count=0;
		Node root = model.getInitialState();
		Node goal = model.getInitialState();
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new PuzzleUtils().HeuristicComparatorByF);
		frontier.add(root);
		HashSet<Node> explored = new HashSet<>();
		while (!frontier.isEmpty()) {
			Node temp = frontier.poll();
			explored.add(temp);
			if (model.computeH1(root) == 0) {
				return goal;
			}else {
				count++;
				for (Node child : model.getSuccessors(temp)) {
					child.setG(count);
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
	public void computeG(Node child) {
		
	}
}
