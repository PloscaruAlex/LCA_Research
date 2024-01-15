build:
	javac Main.java TestCreator.java

run-p1:
	java Main p1

run-p2:
	java Main p2

run-p3:
	java Main p3

run-best:
	java Main p2

tests:
	java TestCreator

run:
	java Main

clean:
	rm -rf *.class