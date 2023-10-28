import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;


public class AStarSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier= new PriorityQueue<Node>(new NodeComparatorByAn());
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
				double temp= child.getWeight()+n.getH()+start.getG();
				double pathCost= child.getWeight()+start.getG();
				if(!explored.contains(n)||!frontier.contains(n)) {
					n.setParent(start);
					n.setG(pathCost);
					frontier.add(n);
					}else if((child.getWeight()+n.getParent().getG())>temp) {
						frontier.remove(n);
						n.setParent(start);
						n.setG(pathCost);
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
		var.setG(0);
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
				double temp= child.getWeight()+n.getH()+tempo.getG();
				double pathCost= child.getWeight()+tempo.getG();
				if(!explored.contains(n)||!frontier.contains(n)) {
					n.setParent(tempo);
					n.setG(pathCost);
					frontier.add(n);
					}else if((child.getWeight()+n.getParent().getG())>temp) {
						frontier.remove(n);
						n.setParent(tempo);
						n.setG(pathCost);
						frontier.add(n);
					}
			}
		}
		return null;
	}

	@Override
	public boolean isAdmissibleH(Node root, String goal) {	
		boolean result;
		HashSet<Node> NodeList=findNodeList(root);
		for(Node child: NodeList) {
			Node temp=execute(child, goal);
			List<String> end = new ArrayList<String>();
			end.add(temp.getLabel());
			Node tmp;
			while ((tmp = temp.getParent()) != null) {

				end.add(tmp.getLabel());
				temp = tmp;
			}
			result= child.getH()<=(end.size()-2);
			if(result==false) 
				return false;		
		}
		return true;
	}
	public HashSet<Node> findNodeList(Node root){
		HashSet<Node> NodeList=new HashSet<>();
		NodeList.add(root);
		Node start=root;
		List<Node> children= start.getChildrenNodes();
		for(Node child: children) {
		}
		if(!children.isEmpty()) {
			NodeList.addAll(children);
			for(Node child: children) {
				findNodeList(child);
			}
		}
		return NodeList;
	}
}
