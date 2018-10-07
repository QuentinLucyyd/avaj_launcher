find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt -d .
java simulator.Simulator _scenarios/_scenario_1.txt
