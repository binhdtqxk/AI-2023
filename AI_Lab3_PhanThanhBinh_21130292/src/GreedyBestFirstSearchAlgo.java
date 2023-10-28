import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier= new PriorityQueue<Node>(new NodeComparatorByGn());
		frontier.add(root);
		HashSet<Node> explored=new HashSet<>();
		while(!frontier.isEmpty()) {
			Node start= frontier.poll();
			if(start.getLabel().equals(goal)) {
				return start;
			}
			explored.add(start);
			List<Edge> childNode= start.getChildren();
			for(Edge child: childNode) {
				Node n= child.getEnd();
				double temp= n.getH();
				if(!explored.contains(n)&&!frontier.contains(n)) {
					n.setParent(start);
					n.setH(temp);
					frontier.add(n);
					}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new
				NodeComparatorByAn());
		HashSet<Node> explored= new HashSet<>();
		Node var = execute(root, start);
		var.setParent(null);
		frontier.add(var);
		while(!frontier.isEmpty()) {
			Node tempo= frontier.poll();
			if(tempo.getLabel().equals(goal)) {
				return tempo;
			}
			explored.add(tempo);
			List<Edge> childNode= tempo.getChildren();
			for(Edge child: childNode) {
				Node n= child.getEnd();
				double temp= n.getH();
				if(!explored.contains(n)&&!frontier.contains(n)) {
					n.setParent(tempo);
					n.setH(temp);
					frontier.add(n);
					}
			}
		}
		return null;
	}

	@Override
	public boolean isAdmissibleH(Node root, String goal) {
		// TODO Auto-generated method stub
		return false;
	}

}
