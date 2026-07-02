import java.util.Scanner;
import java.util.ArrayList;

public class TrainingTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Routine> routines = new ArrayList<>();

        Routine pushDay = new Routine("Push Day Lift", "Strength Training");
        pushDay.addExercise(new Exercise("Bench Press"));
        pushDay.addExercise(new Exercise("Shoulder Press"));
        routines.add(pushDay);

        System.out.println("Training Tracker App");

        System.out.println("What kind of training are we doing today?");
        System.out.println("1. Strength Training 💪");
        System.out.println("2. Sparring Day 🥊");
        System.out.println("3. Padwork/Bagwork 🎒");
        System.out.println("4. Cardio Day 🏃‍♂️");
        System.out.println("5. Active Rest Day 😎");

        int trainingType = sc.nextInt();

        String selectedTrainingType = "";

        if (trainingType > 0 && trainingType <= 5)
            System.out.print("Sweet, today is ");

        if (trainingType == 1) {
            selectedTrainingType = "Strength Training";
            System.out.println("Strength Training 💪");
        } else if (trainingType == 2) {
            selectedTrainingType = "Sparring Day";
            System.out.println("Sparring Day 🥊");
        } else if (trainingType == 3) {
            selectedTrainingType = "Padwork/Bagwork";
            System.out.println("Padwork/Bagwork 🎒");
        } else if (trainingType == 4) {
            selectedTrainingType = "Cardio Day";
            System.out.println("Cardio Day 🏃‍♂️");
        } else if (trainingType == 5) {
            selectedTrainingType = "Active Rest Day";
            System.out.println("Active Rest Day 😎");
        } else {
            System.out.println("Choose a training program, it's time to get to work!");
        }

        if (!selectedTrainingType.equals("")) {
            Routine selectedRoutine = null;

            System.out.println("What would you like to do:");
            System.out.println("1. Saved routines");
            System.out.println("2. Create new routine");

            int routineTypeChoice = sc.nextInt();

            if (routineTypeChoice == 1) {
                System.out.println("\nSaved routines for " + selectedTrainingType + ":");

                ArrayList<Routine> matchingRoutines = new ArrayList<>();

                for (Routine routine : routines) {
                    if (routine.getTrainingType().equals(selectedTrainingType)) {
                        matchingRoutines.add(routine);
                    }
                }

                if (matchingRoutines.isEmpty()) {
                    System.out.println("No saved routines for " + selectedTrainingType);
                } else {
                    for (int i = 0; i < matchingRoutines.size(); i++) {
                        System.out.println((i + 1) + ". " + matchingRoutines.get(i));
                    }

                    System.out.print("Choose a routine: ");
                    int selectedRoutineNumber = sc.nextInt();

                    if (selectedRoutineNumber >= 1
                            && selectedRoutineNumber <= matchingRoutines.size()) {

                        selectedRoutine = matchingRoutines.get(selectedRoutineNumber - 1);

                        System.out.println("You chose:");
                        System.out.println(selectedRoutine);

                        boolean managingRoutine = true;

                        while (managingRoutine) {
                            System.out.println("\nWhat would you like to do?");
                            System.out.println("1. View exercises");
                            System.out.println("2. Add exercise");
                            System.out.println("3. Remove exercise");
                            System.out.println("4. Select exercise");
                            System.out.println("5. Start routine");
                            System.out.println("6. Exit");

                            int choice = sc.nextInt();

                            if (choice == 1) {
                                ArrayList<Exercise> exercises = selectedRoutine.getExercises();

                                if (exercises.isEmpty()) {
                                    System.out.println("No exercises added yet.");
                                } else {
                                    System.out.println("Exercises:");

                                    for (int i = 0; i < exercises.size(); i++) {
                                        System.out.println((i + 1) + ". " + exercises.get(i));
                                    }
                                }

                                sc.nextLine();
                                System.out.println("\nPress 'Enter' to return.");
                                sc.nextLine();

                            } else if (choice == 2) {
                                sc.nextLine();

                                System.out.print("Add an exercise: ");
                                String newExercise = sc.nextLine();

                                selectedRoutine.addExercise(new Exercise(newExercise));

                                System.out.println(newExercise + " added to " + selectedRoutine.getRoutineName());

                            } else if (choice == 3) {
                                ArrayList<Exercise> exercises = selectedRoutine.getExercises();

                                if (exercises.isEmpty()) {
                                    System.out.println("No exercises to remove.");
                                } else {
                                    System.out.println("Choose an exercise to remove:");
                                    for (int i = 0; i < exercises.size(); i++) {
                                        System.out.println((i + 1) + ". " + exercises.get(i));
                                    }
                                    int removeChoice = sc.nextInt();

                                    if (removeChoice >= 1 && removeChoice <= exercises.size()) {
                                        Exercise removedExercise = selectedRoutine.removeExercise(removeChoice - 1);

                                        System.out.println(removedExercise.getExerciseName() + " removed.");
                                    } else {
                                        System.out.println("Invalid exercise choice.");
                                    }
                                }

                            } else if (choice == 4) {
                                ArrayList<Exercise> exercises = selectedRoutine.getExercises();
                                System.out.println("Select an exercise: ");

                                for (int i = 0; i < exercises.size(); i++) {
                                    System.out.println((i + 1) + ". " + exercises.get(i));
                                }

                                int exerciseChoice = sc.nextInt();

                                if (exerciseChoice >= 1 && exerciseChoice <= exercises.size()) {
                                    Exercise selectedExercise = exercises.get(exerciseChoice - 1);
                                    System.out.println("Selected exercise: " + selectedExercise.getExerciseName());

                                    boolean managingExercise = true;

                                    while (managingExercise) {
                                        System.out.println("What would you like to do?");
                                        System.out.println("1. View exercise history:");
                                        System.out.println("2. Record workout:");
                                        System.out.println("3. Go back");

                                        int exerciseMenuChoice = sc.nextInt();

                                        if (exerciseMenuChoice == 1) {
                                            // View exercise history
                                            ArrayList<WorkoutRecord> history = selectedExercise.getWorkoutHistory();

                                            if (history.isEmpty()) {
                                                System.out.println("No recorded workouts for this exercise. ");
                                                sc.nextLine();
                                                System.out.println("Press Enter to go back. ");
                                                sc.nextLine();

                                            } else {
                                                System.out.println("\nRecorded workouts for "
                                                        + selectedExercise.getExerciseName() + ": ");

                                                for (int i = history.size() - 1; i >= 0; i--) {
                                                    System.out.println(history.get(i));
                                                }

                                                sc.nextLine();
                                                System.out.println("Press Enter to go back. ");
                                                sc.nextLine();

                                            }
                                        } else if (exerciseMenuChoice == 2) {
                                            // Add workout history
                                            sc.nextLine();

                                            System.out.println("Date (YY/MM/DD): ");
                                            String date = sc.nextLine();

                                            System.out.println("Sets: ");
                                            int sets = sc.nextInt();

                                            System.out.println("Reps: ");
                                            int reps = sc.nextInt();

                                            System.out.println("Weight (KG): ");
                                            double weight = sc.nextDouble();

                                            sc.nextLine();

                                            System.out.println("Notes: ");
                                            String notes = sc.nextLine();

                                            WorkoutRecord newRecord = new WorkoutRecord(date, reps, sets, weight,
                                                    notes);

                                            selectedExercise.addWorkoutRecord(newRecord);

                                            System.out.println("New workout recorded for "
                                                    + selectedExercise.getExerciseName() + ": ");

                                            System.out.println(newRecord);

                                            System.out.println("Press Enter to go back. ");
                                            sc.nextLine();

                                        } else if (exerciseMenuChoice == 3) {
                                            managingExercise = false;

                                        } else {
                                            System.out.println("Invalid option.");
                                        }
                                    }

                                } else {
                                    System.out.println("Invalid exercise choice.");
                                }

                            } else if (choice == 5) {
                                ArrayList<Exercise> exercises = selectedRoutine.getExercises();

                                if (exercises.isEmpty()) {
                                    System.out.println("No exercises in this routine yet.");
                                } else {
                                    System.out.println("Starting routine: " + selectedRoutine.getRoutineName());

                                    sc.nextLine();

                                    for (int i = 0; i < exercises.size(); i++) {
                                        Exercise currentExercise = exercises.get(i);

                                        System.out.println();
                                        System.out.println("Exercise " + (i + 1) + "/" + exercises.size() + ": "
                                                + currentExercise.getExerciseName());

                                        ArrayList<WorkoutRecord> history = currentExercise.getWorkoutHistory();

                                        if (history.isEmpty()) {
                                            System.out.println("No workout records yet.");

                                        } else {
                                            WorkoutRecord latestRecord = history.get(history.size() - 1);

                                            System.out.println("Latest workout: ");
                                            System.out.println(latestRecord);
                                        }
                                        System.out.println("Press Enter when finished with this exercise.");
                                        sc.nextLine();

                                        System.out.println("Did you complete this exercise as planned? ");
                                        System.out.println("1. Completed");
                                        System.out.println("2. Partially Completed");
                                        System.out.println("3. Not Completed");

                                        int completion = sc.nextInt();
                                        sc.nextLine();

                                        if (completion == 1) {
                                            System.out.println("Marked as completed.");
                                        } else if (completion == 2) {
                                            System.out.println("Marked as partially completed.");
                                        } else if (completion == 3) {
                                            System.out.println("Marked as not completed.");
                                        } else {
                                            System.out.println("Invalid option. Skipping status.");
                                        }
                                    }
                                }
                                System.out.println("Routine finished.");

                            } else if (choice == 6) {
                                managingRoutine = false;
                            } else {
                                System.out.println("Invalid option.");
                            }
                        }
                    } else {
                        System.out.println("Invalid routine choice.");
                    }
                }

            } else if (routineTypeChoice == 2) {
                sc.nextLine();

                System.out.print("Enter new routine name: ");
                String newRoutineName = sc.nextLine();

                Routine newRoutine = new Routine(newRoutineName, selectedTrainingType);

                routines.add(newRoutine);
                selectedRoutine = newRoutine;

                System.out.println("New routine added:");
                System.out.println(selectedRoutine);

            } else {
                System.out.println("Invalid option.");
            }

            if (selectedRoutine != null) {
                System.out.println("Selected routine: " + selectedRoutine);
            }

        }
        sc.close();
    }
}