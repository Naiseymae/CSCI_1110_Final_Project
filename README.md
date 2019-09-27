# CSCI_1110_Final_Project

## Synopsis

This is the final project code for the Object Oriented Programming course.  When the program runs, a GUI window loads displaying a button pane and a display pane.  A user inputs RNA nucleotide base characters by pressing the corresponding A, U, G, C buttons, and the program will display the RNA sequence.  The use can then click the START button to convert the RNA sequence and display its amino acid string.  The amino acid strings are displayed as colored circles with their corresponding RNA codons underneath.  The CONSERVE and MUTATE buttons on the bottom of the screen allow the user to mutate or conserve their sequence, and each new (or conserved) sequence is displays a new amino acid string.  The user may choose to mutate or conserve as many times as they like, and can click the START button to restart the program with the previous RNA sequence or click the CLEAR button to start over and input a new RNA sequence.

## Code Example 1

The following code shows how the replication method is called when the START button is pressed.  Any nodes in the display pane from the previous run are cleared and the RNA sequence is copied into an ArrayList for future use in the mutate method.  This ensures the original RNA is remains unchanged in case the user would like to use that same sequence for future runs.  

```java
		// "START" button	
		btStart.setOnAction(e -> { // Starts new run using sequence saved in rnaPane.
			// Clear nodes from aaPane for new run.
			aaPane.getChildren().clear(); 

			// Clear rnaArray for new run.
			rnaArray.clear(); 		
			for (int i = 0; i < originalRNA.size(); i++) {
				rnaArray.add(originalRNA.get(i));
			}

			// Ready pane for calling replication method.
			Label aaLabel = new Label("", replication(originalRNA));
			aaPane.getChildren().add(aaLabel); // Add to aaPane.
			aaPane.setAlignment(Pos.CENTER); // Center in aaPane.

			// Conserve/Mutate buttons appear.
			pane.setBottom(btPane); // Add buttons to bottom of pane after Start button pressed.
			btPane.setAlignment(Pos.CENTER); // Center mutate/conserve buttons.
		});		   
```

[After START button pressed.](Code_Example_1.png)
   
## Code Example 2

The code below is a portion of the graphicAA method inside the AminoAcid class which returns an HBox filled with amino acid circles that will be displayed in the main pane.  This method requires an ArrayList where each index is a codon (3 characters such as “AAA” or “UAG”).  It will match the codon in the ArrayList to its amino acid and create a new label with a circle object while also displaying the codon sequence underneath the circle.  When the sequence for a STOP codon is found, a rectangle instead of an amino acid circle is created, and the method ends.

```java
		// Match the amino acid name to a circle of the corresponding color for the whole ArrayList.
		for (int i = 0; i < this.codonArray.length; i++) {
			
			// STOP codons.
			if (codonArray[i].equals("UAA") || codonArray[i].equals("UAG") || codonArray[i].equals("UGA")) { 
				// Stop adding amino acid circles & display STOP label.
				Rectangle rectangle = new Rectangle(50, 25, Color.valueOf("WHITE"));
				rectangle.setStroke(Color.BLACK);
				Label lblSTOP = new Label("STOP", rectangle);
				lblSTOP.setContentDisplay(ContentDisplay.CENTER);
				//StackPane stackPane = new StackPane();
				//stackPane.getChildren().addAll(lblSTOP);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("UAA")){
					Label lblUAA = new Label("UAA", lblSTOP);
					lblUAA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUAA);
					break;
				}
				if (codonArray[i].equals("UAG")){
					Label lblUAG = new Label("UAG", lblSTOP);
					lblUAG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUAG);
					break;
				}
				if (codonArray[i].equals("UGA")){
					Label lblUGA = new Label("UGA", lblSTOP);
					lblUGA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUGA);
					break;
				}
			}
			// PHENYLALANINE
			if (codonArray[i].equals("UUU") || codonArray[i].equals("UUC")) {
				Label lblPHE = new Label("PHE", new Circle(20, Color.rgb(180, 134, 194)));
				lblPHE.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("UUU")){
					Label lblUUU = new Label("UUU", lblPHE);
					lblUUU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUUU);
				}
				if (codonArray[i].equals("UUC")){
					Label lblUUC = new Label("UUC", lblPHE);
					lblUUC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUUC);
				}
			}
```

[Program after multiple CONSERVE and MUTATE buttons pressed.](Code_Example_2.png)

## Motivation

I wanted to build on the project from my Intro to Programming Final Project and create a new program that actually displays the amino acids coded for in the RNA sequence.  In this way I hoped to make the translation process (converting RNA into an amino acid string, which is used to build a protein) more interesting, fun, and easy for the user.  A user can create their own RNA sequence and watch how that string can change and affect (or not affect) the output of amino acids.  I hope to continue to build upon this idea to make cell biology education more engaging and fun. 
