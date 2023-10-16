package lab2;

public class Test {
	public Test() {

	}
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A"); Node nodeB = new Node("B");
		Node nodeC = new Node("C"); Node nodeD = new Node("D");
		Node nodeE = new Node("E"); Node nodeF = new Node("F");
		Node nodeG = new Node("G"); Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);

		nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
		ISearchAlgo algo1 = new DFS_Function();
		ISearchAlgo algo2 = new BFS_Function();
		ISearchAlgo algo3 = new UniformCostSearchAlgo();
		DepthLimited algo4= new DepthLimited();
//		Node result = algo1.execute(nodeS, "G");
//		Node resultCFS=algo3.execute(nodeS, "A", "H");
//		Node resultBFS= algo2.execute(nodeS, "G");
//		Node resultUCS= algo2.execute(nodeS, "G");
//		Node resultCFS= algo3.execute(nodeS, "A","H");
//		Node resultCFS= algo3.execute(nodeS,"G");
		Node resultDLM= algo4.execute(nodeS,"G",3);
		NodeUtils test1=new NodeUtils();
		System.out.println(test1.printPath(resultDLM));
//		System.out.println(test1.printPath(resultBFSTwo));
//		System.out.println(test1.printPath(result));
//		System.out.println(test1.printPath(resultTwo));
	}
}
