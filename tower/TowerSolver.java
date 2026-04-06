package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver() {
        // Nothing to do here
    }

    public void solve(TowerModel model) {
        this.model = model;
        // Start the recursive process. We want to move all the disks
        // from the starting tower (0) to the destination tower (2),
        // using the middle tower (1) as the helper/auxiliary.
        recursiveSolve(model.height(), 0, 2, 1);
    }

    private void recursiveSolve(int numDisks, int sourcePeg, int destinationPeg, int auxiliaryPeg) {
        // Base Case: If there is only one disk left to move, just move it directly.
        // This is the condition that stops the recursion.
        if (numDisks == 1) {
            model.move(sourcePeg, destinationPeg);
        } else {
            // Recursive Step 1:
            // Move (numDisks - 1) disks from the source peg to the auxiliary peg.
            // Notice the destination and auxiliary pegs swap roles here.
            recursiveSolve(numDisks - 1, sourcePeg, auxiliaryPeg, destinationPeg);

            // Step 2:
            // Move the single, largest disk from the source peg to the destination peg.
            model.move(sourcePeg, destinationPeg);

            // Recursive Step 3:
            // Move the (numDisks - 1) disks from the auxiliary peg to the destination peg.
            // Now the source and auxiliary pegs swap roles.
            recursiveSolve(numDisks - 1, auxiliaryPeg, destinationPeg, sourcePeg);
        }
    }
}