package org.autotest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class AvlTreeKoratTest {

	private Set<AvlTree> readAvlTrees(String filename)
			throws IOException, FileNotFoundException, ClassNotFoundException {
		Set<AvlTree> generatedTrees = new HashSet<AvlTree>();
		File out = new File(filename);
		if (!out.exists()) {
			throw new FileNotFoundException();
		}
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(out));
		try {
			while (true) {
				try {
					AvlTree tree = (AvlTree) in.readObject();
					generatedTrees.add(tree);
				} catch (EOFException ex) {
					break;
				}
			}
			return generatedTrees;
		} finally {
			in.close();
		}
	}

	private void generateTrees(int minSize, int maxSize){
		String[] args = new String[] { "--class", AvlTree.class.getName(), "--args", maxSize + "," + minSize + "," + maxSize, "--serialize",
				"avltree.ser" };
		korat.Korat.main(args);
	}

	@org.junit.Test
	public void runKorat0_4Nodes() throws FileNotFoundException, IOException, ClassNotFoundException {
		generateTrees(0, 4);

		assertTrue(new File("avltree.ser").exists());

		Set<AvlTree> generatedTrees = readAvlTrees("avltree.ser");
		assertTrue(generatedTrees.stream().allMatch(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.repOK();
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_Contains() throws FileNotFoundException, IOException, ClassNotFoundException {
		runKorat0_4Nodes();

		assertTrue(new File("avltree.ser").exists());

		Set<AvlTree> generatedTrees = readAvlTrees("avltree.ser");

		assertTrue(runKorat0_4Nodes_InsertCero(new Predicate<AvlTree>() {
			public boolean test(final AvlTree avlTree) {
				Set<Integer> possibleValues = new HashSet<Integer>();
				possibleValues.add(0);
				possibleValues.add(1);
				possibleValues.add(2);
				possibleValues.add(3);
				possibleValues.add(4);
				return avlTree.size() == possibleValues.stream().filter(new Predicate<Integer>() {
					public boolean test(Integer integer) {
						return avlTree.contains(integer);
					}
				}).count();
			}
		}));
	}

	private boolean runKorat0_4Nodes_InsertCero(Predicate<AvlTree> predicate) throws FileNotFoundException, IOException, ClassNotFoundException {
		generateTrees(0, 4);

		assertTrue(new File("avltree.ser").exists());

		Set<AvlTree> generatedTrees = readAvlTrees("avltree.ser");

		generatedTrees.forEach(new Consumer<AvlTree>() {
			public void accept(AvlTree avlTree) {
				avlTree.insert(0);
			}
		});

		return generatedTrees.stream().allMatch(predicate);
	}

	private boolean runKorat0_4Nodes_DeleteCero(Predicate<AvlTree> predicate) throws FileNotFoundException, IOException, ClassNotFoundException {
		generateTrees(0, 4);

		assertTrue(new File("avltree.ser").exists());

		Set<AvlTree> generatedTrees = readAvlTrees("avltree.ser");

		generatedTrees.forEach(new Consumer<AvlTree>() {
			public void accept(AvlTree avlTree) {
				avlTree.delete(0);
			}
		});
		return generatedTrees.stream().allMatch(predicate);
	}

	@org.junit.Test
	public void runKorat0_4Nodes_InsertCero_Contains() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_InsertCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.contains(0);
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_InsertCero_CorrectSize() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_InsertCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.correctSize();
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_InsertCero_CorrectHeight() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_InsertCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.correctHeight();
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_InsertCero_isBinaryTree() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_InsertCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.isBinaryTree();
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_InsertCero_isOrdened() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_InsertCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.isOrdened();
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_InsertCero_isBalanced() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_InsertCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.isBalanced();
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_InsertCero_noRepetition() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_InsertCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.noRepetition();
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_DeleteCero_ContainsCero() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_DeleteCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.contains(0);
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_DeleteCero_CorrectSize() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_DeleteCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.correctSize();
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_DeleteCero_CorrectHeight() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_DeleteCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.correctHeight();
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_DeleteCero_isBinaryTree() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_DeleteCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.isBinaryTree();
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_DeleteCero_isOrdened() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_DeleteCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.isOrdened();
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_DeleteCero_isBalanced() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_DeleteCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.isBalanced();
			}
		}));
	}

	@org.junit.Test
	public void runKorat0_4Nodes_DeleteCero_noRepetition() throws FileNotFoundException, IOException, ClassNotFoundException {
		assertTrue(runKorat0_4Nodes_DeleteCero(new Predicate<AvlTree>() {
			public boolean test(AvlTree avlTree) {
				return avlTree.noRepetition();
			}
		}));
	}
}
