import java.util.*;

public class SkyscraperConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of floors in the building: ");
        int n = scanner.nextInt();

        List<Stack<Integer>> floorStacks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the floor size given on day " + (i + 1) + ": ");
            int floorSize = scanner.nextInt();

            // Create a new stack for the current floor
            Stack<Integer> currentFloorStack = new Stack<>();

            // Check if the current floor can be assembled
            while (!floorStacks.isEmpty() && floorSize > floorStacks.get(floorStacks.size() - 1).peek()) {
                // If the floor size is larger than the top floor size in any existing stack,
                // pop the top floor and add it to the current floor stack
                currentFloorStack.push(floorStacks.get(floorStacks.size() - 1).pop());
            }

            // Add the current floor to its corresponding stack
            floorStacks.add(currentFloorStack);

            // Print the construction status for the current day
            System.out.println("\nDay: " + (i + 1));
            for (int j = floorStacks.size() - 1; j >= 0; j--) {
                Stack<Integer> floorStack = floorStacks.get(j);
                if (!floorStack.isEmpty()) {
                    while (!floorStack.isEmpty()) {
                        System.out.print(floorStack.pop() + " ");
                    }
                    System.out.println();
                } else {
                    System.out.println();
                }
            }
        }

        scanner.close();
    }
}
