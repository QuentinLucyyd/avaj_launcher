find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt -d .
java simulator.Simulator misc/scenario.txt
