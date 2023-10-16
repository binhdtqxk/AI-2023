package lab2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new
				NodeComparator());
		HashSet<Node> explored= new HashSet<>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current= frontier.poll();
			if(current.getLabel().equals(goal))
				return current;
			explored.add(current);
			List<Edge> children= current.getChildren();
			for(Edge child: children) {
				Node n= child.getEnd();
				double temp= current.getPathCost()+child.getWeight();
				if(!explored.contains(n)||!frontier.contains(n)) {
				frontier.add(n);
				n.setParent(current);
				n.setPathCost(temp);
				}else if(n.getPathCost()>temp) {
					n.setParent(current);
					n.setPathCost(temp);
				}
			}
		}
//		while(!frontier.isEmpty()) {
//			Node temp=frontier.peek();
//			if(temp.getLabel().equals(goal))
//				return temp;
//			frontier.remove();
//		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new
				NodeComparator());
		HashSet<Node> explored= new HashSet<>();
		Node var = execute(root, start);
		var.setParent(null);
		frontier.add(var);
		while(!frontier.isEmpty()) {
			Node current= frontier.poll();
			if(current.getLabel().equals(goal))
				return current;
			explored.add(current);
			List<Edge> children= current.getChildren();
			for(Edge child: children) {
				Node n= child.getEnd();
				double temp= current.getPathCost()+child.getWeight();
				if(!explored.contains(n)&&!frontier.contains(n)) {
				frontier.add(n);
				n.setParent(current);
				n.setPathCost(temp);
				}else if(n.getPathCost()>temp) {
					n.setParent(current);
					n.setPathCost(temp);
				}
			}
		}
//		while(!frontier.isEmpty()) {
//			Node temp=frontier.peek();
//			if(temp.getLabel().equals(goal))
//				return temp;
//			frontier.remove();
//		}
		return null;
	}

}
