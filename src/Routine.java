import java.util.ArrayList;;

public class Routine {
    private String routineName;
    private String trainingType;
    private ArrayList<Exercise> exercises;

    public Routine(String routineName, String trainingType) {
        this.routineName = routineName;
        this.trainingType = trainingType;
        this.exercises = new ArrayList<>();
    }

    public String getRoutineName() {
        return routineName;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public Exercise removeExercise(int index) {
        return exercises.remove(index);
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public String toString() {
        return routineName + " - " + trainingType;
    }

    public int getNumExercises() {
        return exercises.size();
    }
}
