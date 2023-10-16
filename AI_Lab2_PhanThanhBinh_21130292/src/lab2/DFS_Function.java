package lab2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS_Function implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		ArrayList<Node> visit = new ArrayList<>();
		Stack<Node> frontier = new Stack<Node>();
		frontier.push(root);
		while (!frontier.empty()) {
			Node temp = frontier.pop();
			if (!visit.contains(temp)) {
				visit.add(temp);
				if (temp.getLabel().equals(goal))
					break;
				List<Node> tempChild = temp.getChildrenNodes();
				Collections.reverse(tempChild);
				for (Node child : tempChild) {
					if (!visit.contains(child)) {
						child.setParent(temp);
						frontier.push(child);
						if (child.getLabel().equals(goal)) {
							break;
						}
					}
				}
			}
		}
		return visit.get(visit.size() - 1);
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		ArrayList<Node> visit = new ArrayList<>();
		Stack<Node> frontier = new Stack<Node>();
		Node newStart = execute(root, start);
		newStart.setParent(null);
		frontier.push(newStart);
		while (!frontier.empty()) {
			Node temp = frontier.pop();
			if (!visit.contains(temp)) {
				visit.add(temp);
				if (temp.getLabel().equals(goal))
					break;
				List<Node> tempChild = temp.getChildrenNodes();
				Collections.reverse(tempChild);
				for (Node child : tempChild) {
					if (!visit.contains(child)) {
						child.setParent(temp);
						frontier.push(child);
						if (child.getLabel().equals(goal)) {
							break;
						}
					}
				}
			}
		}
		return visit.get(visit.size() - 1);
	}

}
