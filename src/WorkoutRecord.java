public class WorkoutRecord {
    private String date;
    private int sets;
    private int reps;
    private double weight;
    private WorkoutStatus status;
    private String notes;

    public WorkoutRecord(String date, int reps, int sets, double weight, String notes) {
        this.date = date;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.notes = notes;
        this.status = WorkoutStatus.PLANNED;
    }

    public void markCompleted() {
        status = WorkoutStatus.COMPLETED;
    }

    public void markPartiallyCompleted() {
        status = WorkoutStatus.PARTIALLY_COMPLETED;
    }

    public void markNotCompleted() {
        status = WorkoutStatus.NOT_COMPLETED;
    }

    @Override
    public String toString() {
        return "Date: " + date + " | " + "Sets: " + sets + " | " + "Reps: " + reps + " | " + "Weigth: " + weight + "KG "
                + " | " + "Status: " + status + " | "
                + "Notes: " + notes;
    }

}
