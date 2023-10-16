package lab2;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		if(o1.getPathCost()==o2.getPathCost()) {
			return o1.getLabel().compareTo(o2.getLabel());
		}
		return Double.compare(o1.getPathCost(), o2.getPathCost());
	}
	
}
