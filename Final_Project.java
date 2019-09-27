/* 
 * Author: Renee Linford
 * Date: 9-27-19
 * OOP Final Project: RNA translation to Amino Acid Sequence displayed in GUI.
 * 
 */

import java.util.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.collections.*;
import javafx.scene.control.Button;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.event.*;

public class Final_Project extends Application {
	/* User inputs RNA sequence into GUI.   
	For each iteration of the amino acid string, user chooses to conserve or mutate.  
	Amino acid strings visually displayed.*/

	public static void main(String[] args) {
		Application.launch(args);
	}

	/* Start Method */
	@Override // Override the start method in the Application Class.
	public void start(Stage primaryStage) {

		// Create String array for original DNA sequence.
		ArrayList<String> originalRNA = new ArrayList<>(); // Original array to be cleared when START button pressed.
		ArrayList<String> rnaArray = new ArrayList<>(); // Copy of rnaArray for mutation.
		ArrayList<String> rnaCopy = new ArrayList<>(); // Copy of rnaArray for final display.

		/* Create main pane. */
		BorderPane pane = new BorderPane();

		// Create buttons.		
		Button btA = new Button("A");
		Button btU = new Button("U");
		Button btC = new Button("C");
		Button btG = new Button("G");
		Button btStart = new Button("START");
		Button btClear = new Button("CLEAR");
		Button btMutate = new Button("MUTATE SEQUENCE"); 
		Button btConserve = new Button("CONSERVE SEQUENCE");;

		// Create panes for buttons and textfield.
		GridPane topPane = new GridPane();
		HBox topButtons = new HBox();
		FlowPane rnaPane = new FlowPane();

		// Set alignment, spacing and style for topPane.
		topButtons.setSpacing(10);
		topButtons.setPadding(new Insets(5, 5, 5, 5));
		topButtons.getChildren().addAll(btStart, btClear);
		topButtons.setAlignment(Pos.BASELINE_CENTER);
		pane.setBottom(topButtons); // Add buttons to bottom topPane.
		topPane.setStyle("-fx-border-color: black");
		topPane.setPadding(new Insets(10, 5, 10, 5));
		topPane.setHgap(10);
		topPane.setVgap(5);
		rnaPane.setAlignment(Pos.BASELINE_CENTER);

		// Add text, rnaPane and topButtons to topPane.
		Text textBT = new Text("Click to create neucleotide base sequence (min 3 bases):"); 
		topPane.add(textBT, 0, 0);
		topPane.add(btA, 1, 0);
		topPane.add(btU, 2, 0);
		topPane.add(btC, 3, 0);
		topPane.add(btG, 4, 0);
		topPane.add(topButtons, 6, 1);
		topPane.add(rnaPane, 6, 0);

		// Create pane for amino acid display pane.
		VBox aaPane = new VBox(20); // Amino Acid pane.
		StackPane stackPane = new StackPane();
		stackPane.setMinWidth(900);
		stackPane.getChildren().add(aaPane); // Wrap aaPane in stackPane to center it.

		// Add stackPane to scrollPane and place in center of main pane.
		ScrollPane scrollPane = new ScrollPane(stackPane); 
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		pane.setCenter(scrollPane);

		// Add pane at top to display buttons and originalRNA sequence.
		HBox btPane = new HBox();
		btPane.setSpacing(10);
		btPane.setPadding(new Insets(5, 5, 5, 5));
		btPane.getChildren().addAll(btConserve, btMutate); // Buttons will be at bottom of scene.

		// Add topPane to main pane.
		pane.setTop(topPane);

		/* Add action handlers (using lambda expressions) for A, C, G, U, and Start buttons. */

		// "A" button
		btA.setOnAction(e -> { 
			originalRNA.add("A"); // Adds "A" to originalRNA array.
			rnaPane.getChildren().add(new Label("A "));
		}); 

		// "U" button
		btU.setOnAction(e -> {
			originalRNA.add("U"); // Adds "U" to originalRNA array.
			rnaPane.getChildren().add(new Label("U "));
		});

		// "C" button	
		btC.setOnAction(e -> {
			originalRNA.add("C"); // Adds "C" to originalRNA array.
			rnaPane.getChildren().add(new Label("C "));
		});

		// "G" button
		btG.setOnAction(e -> {
			originalRNA.add("G"); // Adds "G" to originalRNA array.
			rnaPane.getChildren().add(new Label("G "));
		});

		// "START" button	
		btStart.setOnAction(e -> { // Starts new run using sequence saved in rnaPane.
			// Clear nodes from aaPane for new run.
			aaPane.getChildren().clear(); 
			//System.out.println("______________________________");
			//System.out.println("originalRNA when START pressed: " + originalRNA);
			//System.out.println("rnaArray when START pressed: " + rnaArray);

			// Clear rnaArray for new run.
			rnaArray.clear(); 		
			for (int i = 0; i < originalRNA.size(); i++) {
				rnaArray.add(originalRNA.get(i));
			}
			//System.out.println("_");
			//System.out.println("originalRNA after originalRNA copied to rnaArray: " + originalRNA);
			//System.out.println("rnaArray after originalRNA copied to rnaArray: " + rnaArray);

			// Ready pane for calling replication method.
			Label aaLabel = new Label("", replication(originalRNA));
			aaPane.getChildren().add(aaLabel); // Add to aaPane.
			aaPane.setAlignment(Pos.CENTER); // Center in aaPane.

			// Conserve/Mutate buttons appear.
			pane.setBottom(btPane); // Add buttons to bottom of pane after Start button pressed.
			btPane.setAlignment(Pos.CENTER); // Center mutate/conserve buttons.

			//System.out.println("_");
			//System.out.println("originalRNA at end of START handler: " + originalRNA);
			//System.out.println("rnaArray at end of START handler: " + rnaArray);

		});		

		// "CLEAR" button	
		btClear.setOnAction(e -> { // Completely clears everything to start new sequence.
			// Clear nodes from aaPane.
			aaPane.getChildren().clear(); 

			// Clear arrays.
			rnaArray.clear(); 
			originalRNA.clear();

			// Clear sequence from rnaPane.
			rnaPane.getChildren().clear();

		});
		/* Handlers for when mutate/conserve buttons pressed. */

		// "MUTATE" button
		btMutate.setOnAction(e -> { // Return aa graphic, then replace rnaArray with mutated version.

			ArrayList<String> tempArray = new ArrayList<String>(); // Create temporary array.

			for (int i = 0; i < rnaArray.size(); i++) { // Copy rnaArray
				tempArray.add(rnaArray.get(i)); // tempArray == rnaArray
			}

			tempArray = mutate(tempArray); // tempArray(mutated) != rnaArray
			rnaArray.clear(); // rnaArray(empty)

			for (int i = 0; i < tempArray.size(); i++) { // Copy tempArray
				rnaArray.add(tempArray.get(i)); // tempArray(mutated) == rnaArray(mutated)
			}

			// Display new mutated replication in pane.
			tempArray.clear();
			Label aaLabel = new Label("", replication(rnaArray));
			aaPane.getChildren().add(aaLabel);
			//System.out.println("*");
			//System.out.println("rnaArray after MUTATE: " + rnaArray);
		});

		// "CONSERVE" button
		btConserve.setOnAction(e -> { // Return aa graphic using unchanged rnaArray.
			aaPane.getChildren().add(new Label("", replication(rnaArray)));
		});

		/* Create scene & place it in stage. */
		Scene scene = new Scene(pane, 1000, 700);
		primaryStage.setTitle("CSCI 1110 Final Project"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		scrollPane.requestFocus();
	}


	/** The replication() method. */

	/** This method takes an ArrayList<String> and returns an HBox with amino acid circle labels. Each circle represents a different amino acid and is displayed with the amino acid abbreviation and the corresponding rna codon sequence. 
	 *
	 * <pre>Example:
	 *{@code	replication(ArrayList<String>) returns HBox
	 *}</pre>
	 *
	 * @param (ArrayList<String>; an ArrayList string with indices of 3 base characters (i.e., "UUU", "AAA", "CAU", etc) that will be matched to the corresponding amino acid.)
	 * @return HBox (Hbox; object with amino acid circle labels. Each amino acid is labeled with abbrevation on circle and rna codon sequence below the circle.) 
	 */

	public static HBox replication(ArrayList<String> baseSequence) {

		// New string array from arrayList.
		String [] stringArray = new String [baseSequence.size()];

		// Put content from arrayList into string array.
		for (int i = 0; i < baseSequence.size(); i++) {
			stringArray[i] = baseSequence.get(i);
		}

		// Create colored circles for amino acids.
		AminoAcid aminoAcidCircles = new AminoAcid(stringArray);

		return aminoAcidCircles.graphicAA(); // Return pane with colored circles for each amino acid index.
	}


	/** The mutate() method. **/

	/** This method takes a string array containing indices of single characters (A, C, G, or U), and randomly selects a random number of indices to change.  It will change the index character to a randomly selected A, C, G or U character.  Returns mutated array containgin indices of single characters (A, C, G, or U).
	 *
	 * <pre>Example:
	 *{@code	mutate(sequence[]) returns mutatedSequence[]
	 *}</pre>
	 *
	 * @param sequence (String []; a string array of single base characters to be randomly altered.)
	 * @return mutatedSeq (String []; a string array of single base characters with indices randomly changed.) 
	 */

	public static ArrayList<String> mutate(ArrayList<String> sequence) {
		/* Method will randomly mutate contents of a random number of indices in a string array, and return a randomly mutated string array.
		 * Needs single-dimension array containing one character per index. */	

		// Copy original sequence to new array.
		String [] mutatedSeq = new String [sequence.size()];
		for (int i = 0; i < mutatedSeq.length; i++) {
			mutatedSeq[i] = sequence.get(i);
		}

		// Randomly selects total number of mutations.
		int numberOfMutations = (int)(Math.random() * mutatedSeq.length);

		// Randomly select index from new array.
		for (int j = 0; j < numberOfMutations; j++) {
			int randomIndex = (int)(Math.random() * mutatedSeq.length);
			//System.out.println("j is " + j + " and randomIndex is " + randomIndex);

			// Select random base for replacement.
			String randomBase = Integer.toString((int)(Math.random() * 4));

			if (randomBase.equals("0")) { // If random number is 0, mutation is base A.
				randomBase = "A";
			}
			if (randomBase.equals("1")) { // If random number is 1, mutation is base C.
				randomBase = "C";
			}
			if (randomBase.equals("2")) { // If random number is 2, mutation is base G.
				randomBase = "G";
			}
			if (randomBase.equals("3")) { // If random number is 3, mutation is base U.
				randomBase = "U";
			}

			// Mutate random index to random nucleotide base (A, C, G, U).
			mutatedSeq[randomIndex] = randomBase;
		}
		// Convert String array to ArrayList<String> for return.
		ArrayList<String> mutatedArray = new ArrayList<String>();
		for (int i = 0; i < mutatedSeq.length; i++) {
			mutatedArray.add(mutatedSeq[i]);
		}
		// Return mutated array. 
		return mutatedArray;
	}


}
