package lab2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS_Function implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		ArrayList<Node> visit=new ArrayList<>();
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		visit.add(root);
		while(!frontier.isEmpty()) {
			Node begin= frontier.poll();
			if(begin.getLabel().equals(goal))
				break;
			
			for(Node child: begin.getChildrenNodes()) {
				if(!visit.contains(child)) {
					child.setParent(begin);
					frontier.add(child);
					visit.add(child);
					if(child.getLabel().equals(goal))
						return visit.get(visit.size()-1);
				}
			}
		}
		return visit.get(visit.size()-1);
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node newStart= execute(root, start);
		newStart.setParent(null);
		ArrayList<Node> visit=new ArrayList<>();
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(newStart);
		visit.add(newStart);
		while(!frontier.isEmpty()) {
			Node begin= frontier.poll();
			if(begin.getLabel().equals(goal))
				break;
			
			for(Node child: begin.getChildrenNodes()) {
				if(!visit.contains(child)) {
					child.setParent(begin);
					frontier.add(child);
					visit.add(child);
					if(child.getLabel().equals(goal))
						return visit.get(visit.size()-1);
				}
			}
		}
		return visit.get(visit.size()-1);
	}

}
