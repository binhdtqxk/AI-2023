package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthLimited {
	public Node execute(Node root, String goal, int limitedDepth) {
		return recursive_DLS(root, goal, limitedDepth);
	}

	public Node recursive_DLS(Node temp, String goal, int limitedDepth) {
		Node end = null;

		if (limitedDepth == 0) {
			return null;
		} else if (temp.getLabel().equals(goal)) {
			return temp;
		} else {
			List<Node> childrenNode = temp.getChildrenNodes();
			for (Node child : childrenNode) {
				child.setParent(temp);
				Node result = recursive_DLS(child, goal, limitedDepth - 1);
				if (result == null) {
					end = null;
				} else if (!result.getLabel().equals(goal)) {
					result.setParent(child);
				} else if (result.getLabel().equals(goal)) {
					return result;
				}
			}
		}
		if (end == null) {
			return null;
		}
		return null;
	}
}