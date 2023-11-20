import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		initPopulation();
		int temp=0;
		int min=Integer.MAX_VALUE;
		Node result=new Node();
		List<Node>new_population=new ArrayList<Node>();
		while(temp<MAX_ITERATIONS) {
			for(int i=0;i<POP_SIZE;i++) {
				Node x=getParentByRandomSelection();
				Node y=getParentByRandomSelection();
				Node child=reproduce(x, y);
				if(rd.nextDouble()<MUTATION_RATE) {
					mutate(child);
				}
				if(child.getH()==0) {
					return child;
				}
				new_population.add(child);
				temp++;
			}
			population=new_population;
		}
		Collections.sort(population);
		return population.get(0);
	}

// Mutate an individual by selecting a random Queen and
//move it to a random row.
	public void mutate(Node node) {
		int c=rd.nextInt(Node.N);
		int newRow=rd.nextInt(Node.N);
		node.getState()[c].setRow(newRow);
	}

//Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		Node result = new Node();
		Queen[] fa = x.getState();
		Queen[] mo = y.getState();
		int c = rd.nextInt(Node.N);
		for (int i = 0; i < c; i++) {
			result.getState()[i] = new Queen(fa[i].getRow(), fa[i].getColumn());
		}
		for (int i = c; i <Node.N ; i++) {
			result.getState()[i] = new Queen(mo[i].getRow(), mo[i].getColumn());
		}
		return result;
	}

//Select K individuals from the population at random and
//select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		int max = Integer.MAX_VALUE;
		Node result = new Node();
		List<Node> arr = new ArrayList<Node>();
		for (int i = 0; i < 5; i++) {
			int temp = rd.nextInt(POP_SIZE);
			arr.add(population.get(temp));
		}
		for (Node child : arr) {
			if (child.getH() < max) {
				max = child.getH();
				result = child;
			}
		}
		return result;
	}

//Select a random parent from the population
	public Node getParentByRandomSelection() {
		int temp = rd.nextInt(POP_SIZE);
		return population.get(temp);
	}
}
