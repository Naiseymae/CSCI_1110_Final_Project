package final_project;

import java.util.ArrayList;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

/* 
 * Author: Renee Linford
 * Date: 9-16-19
 * OOP Final Project: AminoAcid (extends HBox Class)
 * 
 * -------------------------------
 * 		AminoAcid Object
 * -------------------------------
 * -aaList: ArrayList<String>
 * -codonArray: String[]
 * -aminoAcidArray: String[]
 * -------------------------------
 * #AminoAcid()
 * #AminoAcid(aaNames: String[])
 * +graphicAA: HBox
 * +getLength: int
 * +toAminoAcid: String[]
 * +toCodon: String[]
 * -------------------------------
 * 
 */

public class AminoAcid extends HBox {
	// AminoAcidString extends Circle class. 
	// Creates and displays a representation of an amino acid string.

	// Variables for class.
	private ArrayList<String> aaList = new ArrayList<>();
	//private ArrayList<Circle> aaCircles = new ArrayList<>();
	private String [] codonArray = new String[this.aaList.size() / 3];
	private String [] aminoAcidArray = new String[codonArray.length];
	private int repCount;

	// Set no-arg constructor.
	public AminoAcid() {
	}
			
	// Set constructor with array.
	public AminoAcid(String[] stringArray) {
		for (int i = 0; i < stringArray.length; i++) {
			this.aaList.add(stringArray[i]);
		}
		
		// Convert baseSequence with originalRNA into codons.
		codonArray = toCodon(stringArray); 
		
		// Convert codonArray to amino acids. 
		aminoAcidArray = toAminoAcid(codonArray);

	}

	// Set constructor with array and repCount.
		public AminoAcid(String[] stringArray, int count) {
			this.repCount = count;
			
			for (int i = 0; i < stringArray.length; i++) {
				this.aaList.add(stringArray[i]);
			}
			
			// Convert baseSequence with originalRNA into codons.
			codonArray = toCodon(stringArray); 
			
			// Convert codonArray to amino acids. 
			aminoAcidArray = toAminoAcid(codonArray);
		}

	public int getLength() {
		// Get length of AminoAcidString.
		return this.aaList.size();
	}
	
	
	/**
	 * This method takes an ArrayList of codons and returns an HBox with horizontal layout of colored circles. Each circle has label with amino acid abbreviation in the circle, and the corresponding codon sequence underneath. 
	 *
	 * <pre>Example:
	 * {@code	graphicAA(ArrayList<String>) returns HBox
	 *}</pre>
	 *
	 * @param ArrayList (<String>; a string array where each index is three characters long, such as AAA or UGC.)
	 * @return HBox (an HBox displaying the representation of the input codon sequence as a line of labeled circles.)
	 */
	
	public HBox graphicAA() {
		// Adds colored circle and label for each amino acid in aaNames arrayList.
		
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
			// LEUCINE
			if (codonArray[i].equals("UUA") || codonArray[i].equals("UUG") || 
				codonArray[i].equals("CUU") || codonArray[i].equals("CUC") ||
				codonArray[i].equals("CUA") || codonArray[i].equals("CUG")) {
				Label lblLEU = new Label("LEU", new Circle(20, Color.rgb(147, 134, 194)));
				lblLEU.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("UUA")){
					Label lblUUA = new Label("UUA", lblLEU);
					lblUUA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUUA);
				}
				if (codonArray[i].equals("UUG")){
					Label lblUUG = new Label("UUG", lblLEU);
					lblUUG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUUG);
				}
				if (codonArray[i].equals("CUU")){
					Label lblCUU = new Label("CUU", lblLEU);
					lblCUU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCUU);
				}
				if (codonArray[i].equals("CUC")){
					Label lblCUC = new Label("CUC", lblLEU);
					lblCUC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCUC);
				}
				if (codonArray[i].equals("CUA")){
					Label lblCUA = new Label("CUA", lblLEU);
					lblCUA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCUA);
				}
				if (codonArray[i].equals("CUG")){
					Label lblCUG = new Label("CUG", lblLEU);
					lblCUG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCUG);
				}
			}
			// ISOLEUCINE
			if (codonArray[i].equals("AUU") || codonArray[i].equals("AUC") || codonArray[i].equals("AUA")) {
				Label lblILE = new Label("ILE", new Circle(20, Color.rgb(134, 149, 194)));
				lblILE.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("AUU")){
					Label lblAUU = new Label("AUU", lblILE);
					lblAUU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblAUU);
				}
				if (codonArray[i].equals("AUC")){
					Label lblAUC = new Label("AUC", lblILE);
					lblAUC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblAUC);
				}
				if (codonArray[i].equals("AUA")){
					Label lblAUA = new Label("AUA", lblILE);
					lblAUA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblAUA);
				}
			}
			// METHIONINE
			if (codonArray[i].equals("AUG")) {
				Label lblMET = new Label("MET", new Circle(20, Color.rgb(134, 174, 194)));
				lblMET.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				Label lblAUG = new Label("AUG", lblMET);
				lblAUG.setContentDisplay(ContentDisplay.TOP);
				this.getChildren().add(lblAUG);
			}
			// VALINE
			if (codonArray[i].equals("GUU") || codonArray[i].equals("GUC") ||
				codonArray[i].equals("GUA") || codonArray[i].equals("GUG")) {
				Label lblVAL = new Label("VAL", new Circle(20, Color.rgb(134, 194, 192)));
				lblVAL.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("GUU")){
					Label lblGUU = new Label("GUU", lblVAL);
					lblGUU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGUU);
				}
				if (codonArray[i].equals("GUC")){
					Label lblGUC = new Label("GUC", lblVAL);
					lblGUC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGUC);
				}
				if (codonArray[i].equals("GUA")){
					Label lblGUA = new Label("GUA", lblVAL);
					lblGUA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGUA);
				}
				if (codonArray[i].equals("GUG")){
					Label lblGUG = new Label("GUG", lblVAL);
					lblGUG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGUG);
				}
			}
			// SERINE
			if (codonArray[i].equals("UCU") || codonArray[i].equals("UCC") ||
				codonArray[i].equals("UCA") || codonArray[i].equals("UCG") ||
				codonArray[i].equals("AGU") || codonArray[i].equals("AGC")) {
				Label lblSER = new Label("SER", new Circle(20, Color.rgb(158, 79, 120)));
				lblSER.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("UCU")){
					Label lblUCU = new Label("UCU", lblSER);
					lblUCU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUCU);
				}
				if (codonArray[i].equals("UCC")){
					Label lblUCC = new Label("UCC", lblSER);
					lblUCC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUCC);
				}
				if (codonArray[i].equals("UCA")){
					Label lblUCA = new Label("UCA", lblSER);
					lblUCA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUCA);
				}
				if (codonArray[i].equals("UCG")){
					Label lblUCG = new Label("UCG", lblSER);
					lblUCG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUCG);
				}
				if (codonArray[i].equals("AGU")){
					Label lblAGU = new Label("AGU", lblSER);
					lblAGU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblAGU);
				}
				if (codonArray[i].equals("AGC")){
					Label lblAGC = new Label("AGC", lblSER);
					lblAGC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblAGC);
				}
			}
			// PROLINE
			if (codonArray[i].equals("CCU") || codonArray[i].equals("CCC") ||
				codonArray[i].equals("CCA") || codonArray[i].equals("CCG")) {
				Label lblPRO = new Label("PRO", new Circle(20, Color.rgb(124, 90, 184)));
				lblPRO.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("CCU")){
					Label lblCCU = new Label("CCU", lblPRO);
					lblCCU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCCU);
				}
				if (codonArray[i].equals("CCC")){
					Label lblCCC = new Label("CCC", lblPRO);
					lblCCC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCCC);
				}
				if (codonArray[i].equals("CCA")){
					Label lblCCA = new Label("CCA", lblPRO);
					lblCCA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCCA);
				}
				if (codonArray[i].equals("CCG")){
					Label lblCCG = new Label("CCG", lblPRO);
					lblCCG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCCG);
				}
			}
			// THREONINE
			if (codonArray[i].equals("ACU") || codonArray[i].equals("ACC") ||
				codonArray[i].equals("ACA") || codonArray[i].equals("ACG")) {
				Label lblTHR = new Label("THR", new Circle(20, Color.rgb(71, 114, 173)));
				lblTHR.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("ACU")){
					Label lblACU = new Label("ACU", lblTHR);
					lblACU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblACU);
				}
				if (codonArray[i].equals("ACC")){
					Label lblACC = new Label("ACC", lblTHR);
					lblACC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblACC);
				}
				if (codonArray[i].equals("ACA")){
					Label lblACA = new Label("ACA", lblTHR);
					lblACA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblACA);
				}
				if (codonArray[i].equals("ACG")){
					Label lblACG = new Label("ACG", lblTHR);
					lblACG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblACG);
				}
			} 
			// ALANINE
			if (codonArray[i].equals("GCU") || codonArray[i].equals("GCC") || 
				codonArray[i].equals("GCA") || codonArray[i].equals("GCG")) {
				Label lblALA = new Label("ALA", new Circle(20, Color.rgb(134, 194, 162)));
				lblALA.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("GCU")){
					Label lblGCU = new Label("GCU", lblALA);
					lblGCU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGCU);
				}
				if (codonArray[i].equals("GCC")){
					Label lblGCC = new Label("GCC", lblALA);
					lblGCC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGCC);
				}
				if (codonArray[i].equals("GCA")){
					Label lblGCA = new Label("GCA", lblALA);
					lblGCA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGCA);
				}
				if (codonArray[i].equals("GCG")){
					Label lblGCG = new Label("GCG", lblALA);
					lblGCG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGCG);
				}
			}
			// TYROSINE
			if (codonArray[i].equals("UAU") || codonArray[i].equals("UAC")) {
				Label lblTYR = new Label("TYR", new Circle(20, Color.rgb(237, 157, 181)));
				lblTYR.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("UAU")){
					Label lblUAU = new Label("UAU", lblTYR);
					lblUAU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUAU);
				}
				if (codonArray[i].equals("UAC")){
					Label lblUAC = new Label("UAC", lblTYR);
					lblUAC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUAC);
				}
			}
			// HISTIDINE
			if (codonArray[i].equals("CAU") || codonArray[i].equals("CAC")) {
				Label lblHIS = new Label("HIS", new Circle(20, Color.rgb(189, 119, 126)));
				lblHIS.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("CAU")){
					Label lblCAU = new Label("CAU", lblHIS);
					lblCAU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCAU);
				}
				if (codonArray[i].equals("CAC")){
					Label lblCAC = new Label("CAC", lblHIS);
					lblCAC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCAC);
				}
			}
			// GLUTAMINE
			if (codonArray[i].equals("CAA") || codonArray[i].equals("CAG")) {
				Label lblGLN = new Label("GLN", new Circle(20, Color.rgb(166, 73, 73)));
				lblGLN.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("CAA")){
					Label lblCAA = new Label("CAA", lblGLN);
					lblCAA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCAA);
				}
				if (codonArray[i].equals("CAG")){
					Label lblCAG = new Label("CAG", lblGLN);
					lblCAG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCAG);
				}
			}
			// ASPARAGINE
			if (codonArray[i].equals("AAU") || codonArray[i].equals("AAC")) {
				Label lblASN = new Label("ASN", new Circle(20, Color.rgb(204, 141, 114)));
				lblASN.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("AAU")){
					Label lblAAU = new Label("AAU", lblASN);
					lblAAU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblAAU);
				}
				if (codonArray[i].equals("AAC")){
					Label lblAAC = new Label("AAC", lblASN);
					lblAAC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblAAC);
				}
			}
			// LYSINE
			if (codonArray[i].equals("AAA") || codonArray[i].equals("AAG")) {
				Label lblLYS = new Label("LYS", new Circle(20, Color.rgb(194, 165, 103)));
				lblLYS.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("AAA")){
					Label lblAAA = new Label("AAA", lblLYS);
					lblAAA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblAAA);
				}
				if (codonArray[i].equals("AAG")){
					Label lblAAG = new Label("AAG", lblLYS);
					lblAAG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblAAG);
				}
			}
			// ASPARTIC ACID
			if (codonArray[i].equals("GAU") || codonArray[i].equals("GAC")) {
				Label lblASP = new Label("ASP", new Circle(20, Color.rgb(181, 181,74)));
				lblASP.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("GAU")){
					Label lblGAU = new Label("GAU", lblASP);
					lblGAU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGAU);
				}
				if (codonArray[i].equals("GAC")){
					Label lblGAC = new Label("GAC", lblASP);
					lblGAC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGAC);
				}
			}
			// GLUTAMIC ACID
			if (codonArray[i].equals("GAA") || codonArray[i].equals("GAG")) {
				Label lblGLU = new Label("GLU", new Circle(20, Color.rgb(196, 214, 114)));
				lblGLU.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("GAA")){
					Label lblGAA = new Label("GAA", lblGLU);
					lblGAA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGAA);
				}
				if (codonArray[i].equals("GAG")){
					Label lblGAG = new Label("GAG", lblGLU);
					lblGAG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGAG);
				}
			} 
			// CYSTEINE
			if (codonArray[i].equals("UGU") || codonArray[i].equals("UGC")) {
				Label lblCYS = new Label("CYS", new Circle(20, Color.rgb(222, 112, 100)));
				lblCYS.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("UGU")){
					Label lblUGU = new Label("UGU", lblCYS);
					lblUGU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUGU);
				}
				if (codonArray[i].equals("UGC")){
					Label lblUGC = new Label("UGC", lblCYS);
					lblUGC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblUGC);
				}
			}
			// TRYPTOPHAN
			if (codonArray[i].equals("UGG")) {
				Label lblTRP = new Label("TRP", new Circle(20, Color.rgb(232, 138, 97)));
				lblTRP.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				Label lblUGG = new Label("UGG", lblTRP);
				lblUGG.setContentDisplay(ContentDisplay.TOP);
				this.getChildren().add(lblUGG);
			} 
			// ARGININE
			if (codonArray[i].equals("CGU") || codonArray[i].equals("CGC") || 
				codonArray[i].equals("CGA") || codonArray[i].equals("CGG") ||
				codonArray[i].equals("AGA") || codonArray[i].equals("AGG")) {
				Label lblARG = new Label("ARG", new Circle(20, Color.rgb(179, 114, 77)));
				lblARG.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("CGU")){
					Label lblCGU = new Label("CGU", lblARG);
					lblCGU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCGU);
				}
				if (codonArray[i].equals("CGC")){
					Label lblCGC = new Label("CGC", lblARG);
					lblCGC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCGC);
				}
				if (codonArray[i].equals("CGA")){
					Label lblCGA = new Label("CGA", lblARG);
					lblCGA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCGA);
				}
				if (codonArray[i].equals("CGG")){
					Label lblCGG = new Label("CGG", lblARG);
					lblCGG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblCGG);
				}
				if (codonArray[i].equals("AGA")){
					Label lblAGA = new Label("AGA", lblARG);
					lblAGA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblAGA);
				}
				if (codonArray[i].equals("AGG")){
					Label lblAGG = new Label("AGG", lblARG);
					lblAGG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblAGG);
				}
			}
			// GLYCINE
			if (codonArray[i].equals("GGU") || codonArray[i].equals("GGC") ||
				codonArray[i].equals("GGA") || codonArray[i].equals("GGG")) {
				Label lblGLY = new Label("GLY", new Circle(20, Color.rgb(237, 233, 119)));
				lblGLY.setContentDisplay(ContentDisplay.CENTER);
				// Each codon variation label is displayed below aa circle.
				if (codonArray[i].equals("GGU")){
					Label lblGGU = new Label("GGU", lblGLY);
					lblGGU.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGGU);
				}
				if (codonArray[i].equals("GGC")){
					Label lblGGC = new Label("GGC", lblGLY);
					lblGGC.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGGC);
				}
				if (codonArray[i].equals("GGA")){
					Label lblGGA = new Label("GGA", lblGLY);
					lblGGA.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGGA);
				}
				if (codonArray[i].equals("GGG")){
					Label lblGGG = new Label("GGG", lblGLY);
					lblGGG.setContentDisplay(ContentDisplay.TOP);
					this.getChildren().add(lblGGG);
				}
			} 
		}
		// return HBox
		return this;
	}


	/* The toAminoAcid() method. */

		/**
		 * This method is used to change an array of codons to an array of amino acids. Each index of the codon array is matched to its corresponding amino acid, and that amino acid is copied to a new array. Strings should be in uppercase.
		 *
		 * <pre>Example:
		 * {@code	toAminoAcid(codonSequence[]) returns aminoAcidSequence[]
		 *}</pre>
		 *
		 * @param codonSeq (String []; a string array where each index is three characters long, such as AAA or UGC.)
		 * @return aaSeq (String []; a string array where each index is a string representing an amino acid, such as LYS for the codon AAA, or CYS for the codon UGC.)
		 */
		
	public static String [] toAminoAcid(String [] codonSeq) {
			/* Method takes array of codons (indices of 3 characters) and compares to table of amino acids.
			 * Returns string array with indices of amino acids (i.e., UCC returns SER, UAA returns STOP). */

			// Create amino acid table. Includes Stop codons.
			String [][] aaTable = { // [64][2]
					{"UUU", "PHE"}, {"UUC", "PHE"}, {"UUA", "LEU"}, {"UUG", "LEU"}, {"CUU", "LEU"}, {"CUC", "LEU"}, {"CUA", "LEU"}, {"CUG", "LEU"}, 
					{"AUU", "ILE"}, {"AUC", "ILE"}, {"AUA", "ILE"}, {"AUG", "MET"}, {"GUU", "VAL"}, {"GUC", "VAL"}, {"GUA", "VAL"}, {"GUG", "VAL"},
					{"UCU", "SER"}, {"UCC", "SER"}, {"UCA", "SER"}, {"UCG", "SER"}, {"CCU", "PRO"}, {"CCC", "PRO"}, {"CCA", "PRO"}, {"CCG", "PRO"}, 
					{"ACU", "THR"}, {"ACC", "THR"}, {"ACA", "THR"}, {"ACG", "THR"}, {"GCU", "ALA"}, {"GCC", "ALA"}, {"GCA", "ALA"}, {"GCG", "ALA"},
					{"UAU", "TYR"}, {"UAC", "TYR"}, {"UAA", "STOP"}, {"UAG", "STOP"}, {"CAU", "HIS"}, {"CAC", "HIS"}, {"CAA", "GLN"}, {"CAG", "GLN"}, 
					{"AAU", "ASN"}, {"AAC", "ASN"}, {"AAA", "LYS"}, {"AAG", "LYS"}, {"GAU", "ASP"}, {"GAC", "ASP"}, {"GAA", "GLU"}, {"GAG", "GLU"},
					{"UGU", "CYS"}, {"UGC", "CYS"}, {"UGA", "STOP"}, {"UGG", "TRP"}, {"CGU", "ARG"}, {"CGC", "ARG"}, {"CGA", "ARG"}, {"CGG", "ARG"}, 
					{"AGU", "SER"}, {"AGC", "SER"}, {"AGA", "ARG"}, {"AGG", "ARG"}, {"GGU", "GLY"}, {"GGC", "GLY"}, {"GGA", "GLY"}, {"GGG", "GLY"},
			};

			// Compare codon sequence to amino acid table. Place matching amino acids into new array.
			String [] aaSeq = new String [codonSeq.length]; // New amino acid sequence array.

			for (int i = 0; i < aaSeq.length; i++) { // Loop compares codon to aaTable.
				for (int j = 0; j < 64; j++) { 
					if (codonSeq[i].equals(aaTable[j][0])) {  
						// If find matching codon, put corresponding amino acid into new array.
						aaSeq[i] = aaTable [j][1];
					}	
				}
			}

			// Return amino acid sequence array. (Includes STOP codons.)
			return aaSeq;
		}

	
		/* The toCodon() method. */

			/** This method is used to concat strings in an array. Method concats 3 indices at a time (i.e., array with index values of "A A A A A A" becomes "AAA AAA").  Best for changing a string array of RNA characters to an array of codons.
			 * <pre>Examples: 
			 * {@code	toCodon(baseSequence[]) returns codonSequence[]
			 *} </pre>
			 *
			 * @param baseSequence (String []; an array of strings where each index is one character such as A, C, G, or U)
			 * @return codonSequence (String []; an array of strings where each index is three characters such as AAA)
			 */

			public static String [] toCodon(String [] baseSequence) {
				/* Method takes array of single character strings and converts it to new string array where each index has three characters (i.e. a codon). */

				// Assign base sequence length to codonSeq array.
				int arrayLength = ((baseSequence.length)/3);
				String [] codonSequence = new String[arrayLength]; 

				// Loop assigns 3 characters of 3 indices in base sequence to one index in a new codon array.
				for (int i = 0, j = 0; i < codonSequence.length; i++, j+=3) { // Where i = codonSeq array index, & j = sequence string index.
					if (baseSequence[j] != "" && baseSequence[j+1] != "" && baseSequence[j+2] != "") { 
						// Only concat 3 character codon if there are 3 characters in sequence to use.
						codonSequence[i] = baseSequence[j] + baseSequence[j+1] + baseSequence[j+2];
					}
				}
				return codonSequence;
			}

			public static String [] toCodon(ArrayList<String> baseSequence) {
				/* Helper method converts arrayList into string Array. */
				
				String [] stringArray = new String [baseSequence.size()];
				for (int i = 0; i < baseSequence.size(); i++) {
					stringArray[i] = baseSequence.get(i);
				}
				return stringArray;
			}

}
