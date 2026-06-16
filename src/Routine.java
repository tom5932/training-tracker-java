public class Routine {
    private String routineName;
    private String trainingType;

    public Routine(String routineName, String trainingType) {
        this.routineName = routineName;
        this.trainingType = trainingType;
    }

    public String getRoutineName() {
        return routineName;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public String toString() {
        return routineName + " - " + trainingType;
    }
}
