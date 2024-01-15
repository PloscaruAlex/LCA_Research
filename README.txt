	Ploscaru Alexandru - 321CD - LCA

	The algorithms which I used for this project are:
- lca by storing paths from root to node:
https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
- lca using parent pointer:
https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-using-parent-pointer/
- lca using binary lifting:
https://www.geeksforgeeks.org/lca-in-a-tree-using-binary-lifting-technique/

	The files in this archive represent:
- Main.java : the main program where each algorithm is executed and where the
	output files are created.
- TestCreator.java : a program that creates the tests used in this project.
- BinarySearchTree.java : a java class that implements the code for a binary
	searching tree.
- BSTWithParent.java : a java class that implements the code for a binary
	searching tree with a parent pointer.
- FirstAlgorithm.java : the implementation of the first algorithm, source code
	taken from the first link.
- SecondAlgorithm.java : the implementation of the second algorithm, source code
	taken from the second link.
- ThirdAlgorithm.java : the implementation of the third algorithm, source code
	taken from the third link.
- Makefile : the makefile which will be used for testing the algorithms.
- in/ : all the tests are located in this folder.
- out/ : the results from one algorithm will be created here.
- RESULTS/ : the results for all three algorithms, used for statistics and comparing.
- TIME_PROGRAMS/ : here I stored the time it takes every algorithm to perform each
	test, used for statistics.
- TIME_INTERROGATIONS/ : here I stored the time it takes every algorithm to perform
	an interrogation, for every test, used for statistics.
- MEMORY_PROGRAMS/ : here I stored the memory used by every algorithm when performing
	each individual test.

	In the Makefile, the algorithms are in order, "run-p1" is the first algorithm,
lca by storing paths from root to node, "run-p2" is the second algorithm, 
lca using parent pointer and "run-p3" is the third algorithm, lca using binary lifting.
The rule "run-best" is associated to the second algorithm because it performed best.

	The java version I used to compile this project is: openjdk 17.0.2.

	In conclusion, I choose the second algorithm, lca using parent pointer, 
for computing the lca because it was the best from the algorithms I chose for this project. 