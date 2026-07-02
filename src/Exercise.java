import java.util.ArrayList;

public class Exercise {
    private String exerciseName;
    private ArrayList<WorkoutRecord> workoutHistory = new ArrayList<>();

    public ArrayList<WorkoutRecord> getWorkoutHistory() {
        return workoutHistory;
    }

    public void addWorkoutRecord(WorkoutRecord record) {
        workoutHistory.add(record);
    }

    public Exercise(String exerciseName) {
        this.exerciseName = exerciseName;
        this.workoutHistory = new ArrayList<>();
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String toString() {
        return exerciseName;
    }

}
