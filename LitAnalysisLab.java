import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

class LitAnalysisLab {
	public JFrame mainframe;
	public JPanel output;
    public JButton readB;
    public JButton avgB;
    public JButton writeB;
    public JButton remove;
    public JButton least;
    public JButton most;
    public JButton lo;
    public JButton shor;
    public JButton mostv;
    public JButton nov;
    public JButton avgs;
    public JButton sen;

	public static JTextField toRead;
	public static JTextArea resultT;
	public static ArrayList<String> textTokens;
    public static ArrayList<String> allwords;

	public LitAnalysisLab() {

		textTokens = new ArrayList<String>();
        allwords = new ArrayList<String>();

		mainframe = new JFrame("Literature Analysis");
		mainframe.setSize(1400, 600);

		mainframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });

		toRead = new JTextField("sample.txt");
		toRead.setBounds(300, 50, 200, 40);
        mainframe.setLayout(null);
        mainframe.add(toRead);

        output = new JPanel();
        output.setBounds(200, 250, 100, 40);
        mainframe.add(output);

        readB = new JButton("Read File");
        readB.setActionCommand("READ");
        readB.addActionListener(new ButtonClickListener());
        readB.setBounds(100, 150, 100, 100);
        mainframe.add(readB);

        remove = new JButton("Remove start and end");
        remove.setActionCommand("remove");
        remove.addActionListener(new ButtonClickListener());
        remove.setBounds(100, 100, 100, 25);
        mainframe.add(remove);

        least = new JButton("LEAST COMMON");
        least.setActionCommand("low");
        least.addActionListener(new ButtonClickListener());
        least.setBounds(475, 150, 100, 100);
        mainframe.add(least);

        most = new JButton("MOST COMMON");
        most.setActionCommand("most");
        most.addActionListener(new ButtonClickListener());
        most.setBounds(350, 150, 100, 100);
        mainframe.add(most);

        lo = new JButton("LONGEST");
        lo.setActionCommand("lon");
        lo.addActionListener(new ButtonClickListener());
        lo.setBounds(725, 150, 100, 100);
        mainframe.add(lo);

        shor = new JButton("SHORTEST");
        shor.setActionCommand("short");
        shor.addActionListener(new ButtonClickListener());
        shor.setBounds(600, 150, 100, 100);
        mainframe.add(shor);


        avgB = new JButton("Average Word");
        avgB.setActionCommand("AVG");
        avgB.addActionListener(new ButtonClickListener());
        avgB.setBounds(225, 150, 100, 100);
        mainframe.add(avgB);

        mostv = new JButton("MOST VOWELS");
        mostv.setActionCommand("most v");
        mostv.addActionListener(new ButtonClickListener());
        mostv.setBounds(850, 150, 100, 100);
        mainframe.add(mostv);

        writeB = new JButton("Write File");
        writeB.setActionCommand("WRITE");
        writeB.addActionListener(new ButtonClickListener());
        writeB.setBounds(975, 150, 100, 100);
        mainframe.add(writeB);

        nov = new JButton("LEAST VOWELS");
        nov.setActionCommand("least v");
        nov.addActionListener(new ButtonClickListener());
        nov.setBounds(1100, 150, 100, 100);
        mainframe.add(nov);

        avgs = new JButton("Average Sentence Length");
        avgs.setActionCommand("avg sentence");
        avgs.addActionListener(new ButtonClickListener());
        avgs.setBounds(1225, 150, 100, 100);
        mainframe.add(avgs);

        sen = new JButton("Most unique");
        sen.setActionCommand("sentence");
        sen.addActionListener(new ButtonClickListener());
        sen.setBounds(1350, 150, 100, 100);
        mainframe.add(sen);

        resultT = new JTextArea("");
        resultT.setBounds(200, 300, 600, 240);
        mainframe.add(resultT);

        mainframe.setVisible(true);
	}

	public static void main(String[] args) {
		LitAnalysisLab fo = new LitAnalysisLab();
	}

    public static double round(double x, int places) {
        int mult = (int)Math.pow(10, places);
        int y = (int)(x*mult);
        double rounded = y / (double) mult;
        return rounded;
    }

    public static void readFile() {
        String fname = toRead.getText();
        textTokens.clear();

        try {
            File f = new File(fname);
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String data = s.next();
                textTokens.add(data);
            }
            s.close();
        }
        catch (FileNotFoundException err) {
            System.out.println("An error occurred.");
            err.printStackTrace();
        }

        resultT.setText("File Read\nFile has " + textTokens.size() + " tokens");
    }

    public static void parseWords() {
        allwords.clear();
        for (int i = 0; i < textTokens.size(); i++) {
            String[] tempWords = textTokens.get(i).split("\\s|--");
            for (String s : tempWords) {
                s = s.replaceAll("[\\p{P}_]", "");
                s = s.toLowerCase();
                allwords.add(s);
            }
        }
    }

    public static void showAvg() {
        double totLen = 0;
        for (String w : allwords) {
            totLen = totLen + w.length();
        }
        double avgLen = totLen / allwords.size();
        avgLen = round(avgLen, 2);
        String res = "The average word length is:\n";
        res = res + avgLen + " characters";
        resultT.setText(res);
    }
    
    public static void writeFile() {
        // NEED TO CHECK WITH USER FIRST!
        // open a new frame with two buttons -> yes or no

        JFrame checker = new JFrame("Are you sure?");
        JButton Jyes = new JButton("YES");
        JButton Jno = new JButton("NO");

        String fname = toRead.getText();
        String toWrite = resultT.getText();

        try {
            FileWriter w = new FileWriter(fname);
            w.write(toWrite);
            w.close();
        }
        catch (IOException er) {
            System.out.println("Error message:");
            er.printStackTrace();
        }
    }

	private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("WRITE")) {
                writeFile();
            }

            if (command.equals("READ")) {
                readFile();
            }

            if (command.equals("AVG")) {
                parseWords();
                
                showAvg();
            }
            /*
            if (command.equals("remove")){
                String title = "start of the project gutenberg ebook" + toRead.getText();
                String end = "end of the project gutenberg ebook" + toRead.getText();
                for (int i = 0; i < allwords.size(); i++){
                    String h = allwords.get(i);
                    if (allwords.contains()){
                        for (int j = i; j < i; j--){
                            allwords.remove(j);
                        }
    
                    }
                    if (end.contains(h)){
                        for (int h = allwords.size(); h > allwords.get(h); h--){
                            allwords.remove(h);
    
                        }
                    }
            }
            */
            
            if (command.equals("low")){
                
                String mi = "";
                HashMap <String, Integer> leasta = new HashMap<String, Integer>();
                for (int i = 0; i < allwords.size(); i++){
                    String h = allwords.get(i);
                    if (leasta.containsKey(h)){
                        int x = leasta.get(h);
                        x = x + 1;
                        leasta.put(h, x);

                    }
                    else{
                        leasta.put(h, 1);
                    }
                }
                int c = 0;
                String l = "";
                int min = 1;
                for (String j: leasta.keySet()){
                    int p = leasta.get(j);

                    if (p == min){
                        min = min;
                        mi = mi + " " + j;
                        c = c + 1;
                        if (c < 6){
                            l = l + " " + j;
                        }
                    }
                    else if (p < min){
                        min = p;
                        mi = j;
                        c = 1;
                        l = j;
                       

                    }
                    else {
                        min = min;
                        mi = mi;
                    }

                }
                //leasta.put(h, 1);
                    
                resultT.setText("Top five least common is: " + l);
            }
            
            
            if (command.equals("most")){
                int max = 1;
                String ma = "";
                HashMap <String, Integer> mosta = new HashMap<String, Integer>();
                for (int i = 0; i < allwords.size(); i++){
                    String h = allwords.get(i);
                    if (mosta.containsKey(h)){
                        int x = mosta.get(h);
                        x = x + 1;
                        mosta.put(h, x);

                    }
                    else{
                        mosta.put(h, 1);
                    }
                }
                int m = 0;
                String g = "";
                for (String j: mosta.keySet()){
                    int p = mosta.get(j);
                    
                    if (p == max){
                        max = max;
                        ma = ma + " " + j;
                        m = m + 1;
                        if (m < 6){
                            g = g + " " + j;
                        }
                    }
                    else if (p > max){
                        max = p;
                        ma = j;
                        m = 1;
                        g = j;
                    }
                    else{
                        max = max;
                        ma = ma;
                    }

                }
                //leasta.put(h, 1);
                resultT.setText("Top five most common is: " + g);
                    
            }
            
            if (command.equals("lon")){
                String n = "";
                HashMap <String, Integer> longest = new HashMap<String, Integer>();
                for (int i = 0; i < allwords.size(); i++){
                    String h = allwords.get(i);
                    if (longest.containsKey(h)){
                        int x = longest.get(h);
                        x = x + 1;
                        longest.put(h, x);

                    }
                    else{
                        longest.put(h, 1);
                    }
                }
                int lon = 0;
                for (String j : longest.keySet()){

                    int p = j.length();
                    
                    if (lon == p){
                        n = n + " " + j;

                    }
                    else if (lon < p) {
                        n = j;
                        lon = p;
                    }
                }
                resultT.setText("The longest word is: " + n);
            }
            
            if (command.equals("short")){
                String d = "";//all
                String g = "";//one
                HashMap <String, Integer> shortest = new HashMap<String, Integer>();
                for (int i = 0; i < allwords.size(); i++){
                    String h = allwords.get(i);
                    if (shortest.containsKey(h)){
                        int x = shortest.get(h);
                        x = x + 1;
                        shortest.put(h, x);

                    }
                    else{
                        shortest.put(h, 1);
                    }
                }
                int s = g.length();
                for (String j : shortest.keySet()){
                    int p = j.length();
                    if (s == p){
                        d = d + " " + j;
                        g = j;
                    }
                    else if (s == 0){
                        d = j;
                        g = j;
                        s = p;
                    }
                    else if (p < s){
                        d = j;
                        s = p;
                        g = j;
                    }
                }
                g = d;
                resultT.setText("The shortest words are: " + g);
            }
            //set the 
            if (command.equals("most v")){
                String y = "";
                HashMap <String, Integer> hasv = new HashMap<String, Integer>();
                for (int i = 0; i < allwords.size(); i++){
                    String h = allwords.get(i);
                    if (hasv.containsKey(h)){
                        int x = hasv.get(h);
                        x = x + 1;
                        hasv.put(h, x);

                    }
                    else{
                        hasv.put(h, 1);
                    }
                }
                int vowel = 0;
                for (String j : hasv.keySet()){
                    vowel = 0;
                    for (int f = 0; f < j.length(); f++){
                        char k = j.charAt(f);
                        if (k == 'a'){
                            vowel = vowel + 1;
                        }
                        else if (k == 'e'){
                            vowel = vowel + 1;
                        }
                        else if (k == 'i'){
                            vowel = vowel + 1;
                        }
                        else if (k == 'o'){
                            vowel = vowel + 1;
                        }
                        else if (k == 'u'){
                            vowel = vowel + 1;
                        }
                        else if (k == 'y'){
                            vowel = vowel + 1;
                        }
                        
                        

                    }
                    hasv.put(j, vowel);
                    
                    
                }
                int com = 0;
                for (String j : hasv.keySet()){
                    int p = hasv.get(j);
                    if (p == com){
                        y = y + " " + j;
                        

                    }
                    else if (com < p){
                        y = j;
                        com = p;
                    }

                }
                resultT.setText("The word with the most vowels is: " + y);
            }
            if (command.equals("least v")){
                String y = "";
                HashMap <String, Integer> nov = new HashMap<String, Integer>();
                for (int i = 0; i < allwords.size(); i++){
                    String h = allwords.get(i);
                    if (nov.containsKey(h)){
                        int x = nov.get(h);
                        x = x + 1;
                        nov.put(h, x);

                    }
                    else{
                        nov.put(h, 1);
                    }
                }
                int vowel = 0;
                for (String j : nov.keySet()){
                    vowel = 0;
                    for (int f = 0; f < j.length(); f++){
                        char k = j.charAt(f);
                        if (k == 'a'){
                            vowel = vowel + 1;
                        }
                        else if (k == 'e'){
                            vowel = vowel + 1;
                        }
                        else if (k == 'i'){
                            vowel = vowel + 1;
                        }
                        else if (k == 'o'){
                            vowel = vowel + 1;
                        }
                        else if (k == 'u'){
                            vowel = vowel + 1;
                        }
                        else if (k == 'y'){
                            vowel = vowel + 1;
                        }
                        
                        

                    }
                    nov.put(j, vowel);
                    
                    
                }
                int com = 0;
                for (String j : nov.keySet()){
                    int p = nov.get(j);
                    if (p == com){
                        y = y + " " + j;
                        

                    }
                    else if (com > p){
                        y = j;
                        com = p;
                    }

                }
                resultT.setText("The word with the least vowels is: " + y);
            }

            //average sentence length 
            if (command.equals("avg sentence")){
                //int
                String h = "";
                int total = 0;
                //total keeps tracking of the total numbers used in all
                //m represents the total number in each sentences
                int m = 1;
                HashMap <String, Integer> ave = new HashMap <String, Integer>();
                for (String w : textTokens){
                    int l = w.length();
                    for (int f = 0; f < l; f++){
                        char k = w.charAt(f);
                        if (k == '.'){
                            total = total + m;
                            ave.put(h, m);
                            h = "";
                            m = 0;
                        }
                        else if (k == '?'){
                            total = total + m;
                            ave.put(h, m);
                            h = "";
                            m = 0;
                            
                        }
                        else if (k == '!'){
                            total = total + m;
                            ave.put(h, m);
                            h = "";
                            m = 0;

                        }
                        else {
                            h = h + k;
                            
                        }
                    }
                    h = h + " ";
                    m = m + 1;
                    //above will help show the sentences as the string in the hashmap
                    // and the integer shows the number of words


                }
                double avg = 0;
                for (String k : ave.keySet()){
                    int g = ave.get(k);
                    avg = avg + 1;
                }
                avg = ((double) total/avg);
                avg = round(avg, 2);

                resultT.setText("The average sentence is: " + avg);

            //for 
            }
            /*
            if (command.equals("sentence")){
                String y = "";
                    HashMap <String, Integer> nov = new HashMap<String, Integer>();
                    for (int i = 0; i < allwords.size(); i++){
                        String h = allwords.get(i);
                        if (nov.containsKey(h)){
                            int x = nov.get(h);
                            x = x + 1;
                            nov.put(h, x);

                        }
                        else{
                            nov.put(h, 1);
                        }
                    }
                    int total = 0;
                    String h = "";
                    int m = 1;
                //above is all the words in a frequency
                
                String h = "";
                int total = 0;
                //total keeps tracking of the total numbers used in all
                //m represents the total number in each sentences
                int m = 1;
                HashMap <String, Integer> ave = new HashMap <String, Integer>();
                for (String w : textTokens){
                    int l = w.length();
                    for (int f = 0; f < l; f++){
                        char k = w.charAt(f);
                        if (k == '.'){
                            total = total + m;
                            ave.put(h, m);
                            h = "";
                            m = 0;
                        }
                        else if (k == '?'){
                            total = total + m;
                            ave.put(h, m);
                            h = "";
                            m = 0;
                            
                        }
                        else if (k == '!'){
                            total = total + m;
                            ave.put(h, m);
                            h = "";
                            m = 0;

                        }
                        else {
                            h = h + k;
                            
                        }
                    }
                    h = h + " ";
                    m = m + 1;
                    System.out.println(ave);
                    //above will help show the sentences as the string in the hashmap
                    // and the integer shows the number of words


                }
                double avg = 0;
                for (String k : ave.keySet()){
                    int g = ave.get(k);
                    avg = avg + 1;
                }
                avg = ((double) total/avg);
                avg = round(avg, 2);

                resultT.setText("The average sentence is: " + avg);
                    //above is for making the sentences


                }
                int total = 0;
                for (String w : ave.keySet()){
                    String[] tempWords = textTokens.get(i).split("\\s|--");
                for (String s : tempWords) {
                    s = s.replaceAll("[\\p{P}_]", "");
                    s = s.toLowerCase();
                    allwords.add(s);
                }
                    int k = ave.get(w);
                    if (w >= 8){
                        int g = nov.get();
                        total = total + g;
                    }
                    ave.put(w, total);
                }
                resultT.setText("The most unique is: " + total);

                //above will create all the words and how frequent they are
                //after that, i will be use the frequency and compare it to
                //the words in each sentence and the frequency average of each sentence
                        //go through the allwords and then compare to each
                        //word in the sentence and add the value to a total
                        //i think I can create a new hashmap to keep the average 
                        //frequency of each sentence
                        //array list to make the sentence splitted
                    }

                }

            }
            */


        }
    }
}