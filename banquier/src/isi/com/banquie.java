package isi.com;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;



import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class banquie {

	private JFrame frmImplementationDeLalgorithme;
	int libre;
	int tester=0;
	int position;
	JLabel lblE;
	JLabel lblA;
	JLabel lblC;
	JLabel lblR;
	JLabel exe;
	static int libred;
	String chaine2="";
	String cheminE=" ",cheminA=" ",cheminC=" ",cheminR=" ",chemin;
	JPanel panel1;
	JRadioButton box2;
	JRadioButton box1;
	ArrayList<Integer> E=new ArrayList<Integer>();
	ArrayList<Integer> A=new ArrayList<Integer>();
    int nbp=0;
    List<List<Integer>> C = new ArrayList<List<Integer>>();
    List<List<Integer>> max = new ArrayList<List<Integer>>();
	List<Integer> l=new ArrayList<Integer>();
	List<Integer> l2=new ArrayList<Integer>();

    List<List<Integer>> R = new ArrayList<List<Integer>>();
    JLabel lblImporterC;
    JLabel lblImporterA;
    JLabel lblImporterR;
    JLabel lblImporterE;
    JButton btnExcuter;
    static int test=1;
    
    static int tst=0;
    static int tst2=0;
    static int tstR=0,tstC=0,tstAR=0;
    static String etat="la 1er affectation était prudente";
    static int pos;
    static String chaine="{";
    JTextArea txt;
    static String resultat="";
    static String resultat2="";
    private JTextField txte;
    int m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					banquie window = new banquie();
					window.frmImplementationDeLalgorithme.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public banquie() {
		initialize();
		executer();
	}
	public void executer() {
		box2.setSelected(false);
		box1.setSelected(true);
		txte.setVisible(false);
		exe.setVisible(false);
		lblImporterE.setVisible(true);
		lblImporterC.setVisible(true);
		lblImporterR.setVisible(true);
		lblE.setVisible(true);
		lblC.setVisible(true);
		lblR.setVisible(true);
		lblImporterA.setText("importer A");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImplementationDeLalgorithme = new JFrame();
		frmImplementationDeLalgorithme.setIconImage(Toolkit.getDefaultToolkit().getImage("lib/logo.png"));
		frmImplementationDeLalgorithme.setTitle("Implementation de l'algorithme de Banquier");
		frmImplementationDeLalgorithme.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblE.setIcon(new ImageIcon("lib/attachec.png"));
				lblA.setIcon(new ImageIcon("lib/attachec.png"));
				lblR.setIcon(new ImageIcon("lib/attachec.png"));
				lblC.setIcon(new ImageIcon("lib/attachec.png"));
				btnExcuter.setForeground(Color.BLACK);


			}
		});
		frmImplementationDeLalgorithme.setBounds(250, 20, 732, 675);
		frmImplementationDeLalgorithme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImplementationDeLalgorithme.getContentPane().setLayout(null);
		
		box1 = new JRadioButton("Plusieur Resources/plusieurs exemplaires");
		box1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				executer();
				
			}
		});
		box1.setSelected(true);
		box1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		box1.setBounds(10, 24, 263, 23);
		frmImplementationDeLalgorithme.getContentPane().add(box1);
		
		box2 = new JRadioButton("une seul Ressource/plusieurs exemplaires");
		box2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				box1.setSelected(false);
				box2.setSelected(true);
				lblImporterE.setVisible(false);
				lblImporterC.setVisible(false);
				lblImporterR.setVisible(false);
				lblE.setVisible(false);
				lblC.setVisible(false);
				lblR.setVisible(false);
				txte.setVisible(true);
				exe.setVisible(true);
				lblImporterA.setText("importer det/max");
				
			}
		});
		box2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		box2.setBounds(293, 24, 279, 23);
		frmImplementationDeLalgorithme.getContentPane().add(box2);
		
		panel1 = new JPanel();
		panel1.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panel1.setBounds(0, 64, 729, 70);
		frmImplementationDeLalgorithme.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		lblE = new JLabel(new ImageIcon("lib/attachec.png"));
		lblE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser fc=new JFileChooser();
				int var=fc.showOpenDialog(null);
				if(var==0) {
					cheminE=fc.getSelectedFile().getAbsolutePath();
					String nom=fc.getSelectedFile().getName();
					String ext = nom.substring(nom.lastIndexOf("."));
					if(ext.equals(".txt")) {
						lblImporterE.setText("E("+nom+")");
					}else {
						JOptionPane.showMessageDialog(null, "veuillez selsectionez un fichier text","error" , JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		lblE.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblE.setIcon(new ImageIcon("lib/attachef.png"));
			}
		});
		lblE.setBounds(154, 11, 46, 39);
		panel1.add(lblE);
		
		lblA = new JLabel(new ImageIcon("lib/attachec.png"));
		lblA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fc=new JFileChooser();
				int var=fc.showOpenDialog(null);
				if(var==0) {
					cheminA=fc.getSelectedFile().getAbsolutePath();
					String nom=fc.getSelectedFile().getName();
					String ext = nom.substring(nom.lastIndexOf("."));
					if(ext.equals(".txt")) {
						if(box1.isSelected()) {
						lblImporterA.setText("A("+nom+")");
						}else {
							lblImporterA.setText("det/max("+nom+")");
						}
					}else {
						JOptionPane.showMessageDialog(null, "veuillez selectionez un fichier text","error" , JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		lblA.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblA.setIcon(new ImageIcon("lib/attachef.png"));
			}
		});
		lblA.setBounds(264, 11, 46, 39);
		panel1.add(lblA);
		
		lblC = new JLabel(new ImageIcon("lib/attachec.png"));
		lblC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fc=new JFileChooser();
				int var=fc.showOpenDialog(null);
				if(var==0) {
					cheminC=fc.getSelectedFile().getAbsolutePath();
					String nom=fc.getSelectedFile().getName();
					String ext = nom.substring(nom.lastIndexOf("."));
					if(ext.equals(".txt")) {
						lblImporterC.setText("C("+nom+")");
					}else {
						JOptionPane.showMessageDialog(null, "veuillez selsectionez un fichier text","error" , JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		lblC.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblC.setIcon(new ImageIcon("lib/attachef.png"));
			}
		});
		lblC.setBounds(370, 11, 46, 39);
		panel1.add(lblC);
		
		lblR = new JLabel(new ImageIcon("lib/attachec.png"));
		lblR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fc=new JFileChooser();
				int var=fc.showOpenDialog(null);
				if(var==0) {
					cheminR=fc.getSelectedFile().getAbsolutePath();
					String nom=fc.getSelectedFile().getName();
					String ext = nom.substring(nom.lastIndexOf("."));
					if(ext.equals(".txt")) {
						lblImporterR.setText("R("+nom+")");
					}else {
						JOptionPane.showMessageDialog(null, "veuillez selsectionez un fichier text","error" , JOptionPane.ERROR_MESSAGE);
					}
               
					
				}
			}
		});
		lblR.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblR.setIcon(new ImageIcon("lib/attachef.png"));
			}
		});
		lblR.setBounds(471, 11, 46, 39);
		panel1.add(lblR);
		
		lblImporterE = new JLabel("importer E");
		lblImporterE.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblImporterE.setBounds(154, 46, 67, 14);
		panel1.add(lblImporterE);
		
		lblImporterA = new JLabel("importer A");
		lblImporterA.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblImporterA.setBounds(256, 46, 100, 14);
		panel1.add(lblImporterA);
		
		lblImporterC = new JLabel("importer C");
		lblImporterC.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblImporterC.setBounds(360, 46, 67, 14);
		panel1.add(lblImporterC);
		
		lblImporterR = new JLabel("importer R");
		lblImporterR.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblImporterR.setBounds(460, 46, 67, 14);
		panel1.add(lblImporterR);
		
		btnExcuter = new JButton("Ex\u00E9cuter");
		btnExcuter.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnExcuter.setForeground(Color.WHITE);
			}
		});
		btnExcuter.setBackground(new Color(0, 102, 204));
		btnExcuter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tester=0;
				max = new ArrayList<List<Integer>>();
				R = new ArrayList<List<Integer>>();
				C = new ArrayList<List<Integer>>();
				E=new ArrayList<Integer>();
				A=new ArrayList<Integer>();
				tst=0;
			    tst2=0;
			    tstR=0;
			    tstC=0;
			    tstAR=0;
			    chaine="{";
			    etat="la 1er affectation était prudente";
				 l=new ArrayList<Integer>();
				try {
                    String ligne;
					if(!cheminE.equals(null)) {
					InputStream ips1=new FileInputStream(cheminE);
					InputStreamReader ipsr1=new InputStreamReader(ips1);
					BufferedReader br1=new BufferedReader(ipsr1);
					
					while((ligne=br1.readLine())!=null) {
						//String[] result = ligne.split("");

						for (String retval: ligne.split(" ")) {
							int val=Integer.parseInt(retval);
							E.add(val);
					      }
						}
					}
					
					
					}catch(Exception e) {
							
				
			}
				try {
					if(!cheminA.equals(null)) {

					InputStream ips2=new FileInputStream(cheminA);
					InputStreamReader ipsr2=new InputStreamReader(ips2);
					BufferedReader br2=new BufferedReader(ipsr2);
					String ligne;
					while((ligne=br2.readLine())!=null) {
                       if(box1.isSelected()) {
						for (String retval: ligne.split(" ")) {
							int val=Integer.parseInt(retval);
							A.add(val);
						}}else {
							 l=new ArrayList<Integer>();
							 for (String retval: ligne.split(" ")) {
									int val=Integer.parseInt(retval);
									l.add(val);
								}
							max.add(l);
						}
					      
						}
					}
				}catch(Exception e) {
					
				}
				try {
					if(!cheminC.equals(null)) {
						InputStream ips3=new FileInputStream(cheminC);
						InputStreamReader ipsr3=new InputStreamReader(ips3);
						BufferedReader br3=new BufferedReader(ipsr3);
                        String ligne;
						List<Integer> e = null;
						while((ligne=br3.readLine())!=null) {
							 l=new ArrayList<Integer>();
							for (String retval: ligne.split(" ")) {
								int val=Integer.parseInt(retval);
								l.add(val);
						      }
                            C.add(l);						
						}
						}
				}catch(Exception e) {
					
				}
				
				try {
					if(!cheminR.equals(null)) {
						InputStream ips4=new FileInputStream(cheminR);
						InputStreamReader ipsr4=new InputStreamReader(ips4);
						BufferedReader br4=new BufferedReader(ipsr4);
						String ligne;
						

						while((ligne=br4.readLine())!=null) {
							 l=new ArrayList<Integer>();
								for (String retval: ligne.split(" ")) {
									int val=Integer.parseInt(retval);
									l.add(val);
							      }
	                            R.add(l);						
							}
							}

				}catch(Exception e) {
					
				}
				//code source Banquier
			if(box1.isSelected() && (cheminE.equals(" ") || cheminA.equals(" ") || cheminC.equals(" ") || cheminR.equals(" "))) {
				JOptionPane.showMessageDialog(null, "veuillez charger tout les fichiers","avertissement",  JOptionPane.WARNING_MESSAGE);
			}else {
				if(box1.isSelected()) {
			
				
			//*************************************************************************
				int i=0;
				int n=0;
	
				  resultat="                             Algorithme de Banquier  \r\n";

					 do {
						 i=0;
				  do {
					  
					for(int k=0;k<R.get(0).size();k++) {//tester s'il y'a des demandes
						if(R.get(i).get(k)!=0) {
							tst2=1;
						}
					}
		            if(tst2==1) {
		  			  tst=0;
					for(int j=0;j<R.get(0).size();j++) {//tester s'il y'a des exemplaires du ressource disponible 
						if(R.get(i).get(j)>A.get(j)) {
							tst=1;
						}
					
						
					}
					pos=i;
		            }
					i++;
					tst2=0;
				  }while(i<R.size() && tst==1);
				  
				  if(tst==0) {
				  resultat=resultat+"\r\n                          ====================================== \r\n";
				  if(n==0) {
					  int p=pos+1;
					  chaine=chaine+"P"+p;
					  resultat=" "+resultat+chaine+"\r\n";
				  }else {
				  int p=pos+1;
				  chaine=chaine+",P"+p;
				  resultat=" "+resultat+chaine+"\r\n";
				  
				  }
					 l=new ArrayList<Integer>();
					 l2=new ArrayList<Integer>();

				  for(int k=0;k<R.get(0).size();k++) {//le processus prend les ressources qu'il a besoin 
					  l.add(C.get(pos).get(k)+R.get(pos).get(k));
					  A.set(k, (A.get(k))-R.get(pos).get(k));
					  l2.add(0);	
					  
				  }
				  C.set(pos, l);
				  R.set(pos,l2);
				  
				                     //afficher E et A
				  resultat=" "+resultat+"E=(";
				 for(int k=0;k<E.size();k++) {
					 resultat=resultat+E.get(k)+" ";
				 }
				  resultat=resultat+")                  ";
				  resultat=resultat+"A=(";
				 for(int k=0;k<A.size();k++) {
					 resultat=resultat+A.get(k)+" ";
				 }
				  resultat=resultat+") \r\n ";
				  
				                    //afficher matrice R et C
				 resultat=" "+resultat+"C=";
				 resultat=resultat+"                    R= \r\n";
				 for(int k=0;k<R.size();k++) {
			   	 resultat=resultat+"     ";
			   		  for(int j=0;j<R.get(0).size();j++) {
			   	   		  resultat=resultat+C.get(k).get(j)+" ";		  
			   		  }
			   			  resultat=resultat+"                ";
			   		  for(int j=0;j<R.get(0).size();j++) {
			   	   	      resultat=resultat+" "+R.get(k).get(j)+" ";
			   		  }
				  		 resultat=resultat+"\r\n";
			   		  }
		  		 resultat=resultat+"\r\n \r\n";
				 resultat=resultat+"         aprés libération \r\n \r\n";
		  		                          //libération 
		  		 for(int k=0;k<R.get(0).size();k++) {
					  A.set(k,A.get(k)+C.get(pos).get(k));  
				  }
				 l=new ArrayList<Integer>();
				  for(int k=0;k<R.get(0).size();k++) {
					  l.add(0);
				  }
				  C.set(pos, l);
				                           //Affichage aprés la libération
				     //afficher E et A
					 resultat=" "+resultat+"E=(";
					 for(int k=0;k<E.size();k++) {
						 resultat=resultat+E.get(k)+" ";
					 }
					 resultat=resultat+")";
					 resultat=resultat+"                  A= (";
					 for(int k=0;k<A.size();k++) {
				     resultat=resultat+A.get(k)+" ";
					 }
					 resultat=resultat+") \r\n";
					 //afficher matrice R et C
					 resultat=" "+resultat+"C= ";
					 resultat=resultat+"                    R=   \r\n";
					 for(int k=0;k<R.size();k++) {
						 resultat=resultat+"   ";
				   		  for(int j=0;j<R.get(0).size();j++) {
				   	   		  resultat=resultat+C.get(k).get(j)+" ";		  
				   		  }
				   			  resultat=resultat+"                  ";
				   		  for(int j=0;j<R.get(0).size();j++) { 
				   	   	      resultat=resultat+R.get(k).get(j)+" ";
				   		  }
                            resultat=resultat+"\r\n";
				   		  }
                     resultat=resultat+"\r\n";
				  }else {
					  etat="affectation non prudente";
				  }
		   		 

				  for(int k=0;k<R.size();k++) {//tester s'il y'a des demande 
			   		  for(int j=0;j<R.get(0).size();j++) {
			   			  if(R.get(k).get(j)!=0) {
			   				tstR=1;
			   			  }
			   		  }}
				 
				 for(int k=0;k<C.size();k++) {
			   		  for(int j=0;j<C.get(0).size();j++) {//tester s'il y'a des processus qui sont  détenus les ressources 
			   			  if(C.get(k).get(j)!=0) {
			   				tstC=1;
			   			  }
			   		  }}
					for(int k=0;k<A.size();k++) {//tester si le vecteur E(Ressource Existantes) = vecteur A(Ressource disponible)
						if(A.get(k)!=E.get(k)) {
							tstAR=1;
						}
					}
				  n++;
				 }while(n<R.size() && (tstR==1 || tstC==1 || tstAR==1) && tst==0);
					
					      //la fin de prgramme 
					 
		         if(etat.equals("la 1er affectation était prudente")) {
		        	 resultat=" "+resultat+"C=[0]     R=[0] \r\n";
		        	 resultat=" "+resultat+"E=A \r\n ";
		        	 resultat=" "+resultat+"donc l'ordonnancement est: "+chaine+"} \r\n ";
		         }else {
		        	 resultat=" "+resultat+"il y'a des processus non marqué ";
		        	 resultat=resultat+"==> situation d'interblocage \r\n \r\n";
		         }
		         resultat=resultat+etat;
		         txt.setText(resultat);
		         }}
			if(box2.isSelected()) {
			if(cheminA.equals(" ")) {
				JOptionPane.showMessageDialog(null, "veulliez choisir un fichier qui contient la matrice détient/max", "avertissement", JOptionPane.WARNING_MESSAGE);
			}else if(!txte.getText().equals("")){
			
		        	resultat2="                     Algorithme de Banquier \r\n";
		        	resultat2=resultat2+"========================================== \r\n  \r\n";
		        	m=0;
		        	for(int i=0;i<max.size();i++) {
		        		m=m+(max.get(i).get(0));
		        	}
                    
		        	libre=Integer.parseInt(txte.getText())-m;
		        	libred=libre;
		        	int h=0;
        	while(tester==0 && h<max.size()) {
        		        h++;
        		        int p;
		        		tester=1;
		        		int n=0;
		        		while(n<max.size() && test==1) {
		        			if((max.get(n).get(1)-max.get(n).get(0))<=libre && (max.get(n).get(0)!=0 || max.get(n).get(1)!=0)){
		        				tester=0;
		        				test=0;
		        				position= n;
		        				libre=libre-(max.get(position).get(1)-max.get(position).get(0));
		        			}
		        			n++;
		        			}
		        		if(test==0) {
		        			test=1;
		        		    p=position+1;
	        				chaine2=chaine2+" P"+p;
	   					 l=new ArrayList<Integer>();
		        				 for(int r=0;r<max.size();r++) {
		        				   		  for(int j=0;j<max.get(0).size();j++) {
		        				   			  resultat2=resultat2+max.get(r).get(j)+"  "; 
		        				   			        				   		  }
	        				   			  if(r==position) {
     				   			         resultat2=resultat2+"        ==> p"+p+"       ";
	        				   			  }else {
				        				 resultat2=resultat2+"                            ";	  
	        				   			  }

		        				   		for(int j=0;j<max.get(0).size();j++) {
		        				   			  if(r==position) {
			        				   	   	    resultat2=resultat2+max.get(r).get(1)+"  ";  
		        				   			  }else {
			        				   			resultat2=resultat2+max.get(r).get(j)+"  "; 
		        				   			  }

		        				   		}
	        				   			  if(r==position) {
  		        				   		 resultat2=resultat2+"     libération ==>      ";	
	        				   			  }else {
	 				        		     resultat2=resultat2+"                                    ";	    
	        				   			  }

		        				   		for(int j=0;j<max.get(0).size();j++) {
		        				   			  if(r==position) {
		        				   	   	          resultat2=resultat2+"0"+"  ";
	        				   			          l.add(0);
		        				   			  }else {
				        				   	      resultat2=resultat2+max.get(r).get(j)+"  "; 
		        				   			  }

		        				   		}
			        				   		 resultat2=resultat2+"\r\n";
		        				 }
        				   		 resultat2=resultat2+"\r\n";		 
		        				 resultat2=resultat2+"libre= "+libred;
		        				 resultat2=resultat2+"                  ";	
		        				 resultat2=resultat2+"libre= "+libre;
				        		 resultat2=resultat2+"                             ";	    
   				   		         libre=libre+max.get(position).get(1);
   				   		         libred=libre;
		        				 resultat2=resultat2+"libre= "+libre;
		        				 max.set(position, l);
		        				 resultat2=resultat2+"\r\n \r\n \r\n";
		        			}}
		        		
        	if(libre==Integer.parseInt(txte.getText())){
        		resultat2=resultat2+" libre= "+libred+ " ==>";
        		resultat2=resultat2+" pas d'interblocage \r\n";
        		resultat2=resultat2+" l'ordonnancement est: "+chaine2;
        		
        	}else {
        		resultat2=resultat2+"il y'a un interblocage";
        		
        	}
        	txt.setText(resultat2);
			}else {
				JOptionPane.showMessageDialog(null, "veuillez donner le nombre des exemplaires", "avertissement", JOptionPane.WARNING_MESSAGE);
			}}
				
//***************************************************************************
				}
		});
		btnExcuter.setBounds(632, 0, 87, 70);
		panel1.add(btnExcuter);
		
		txte = new JTextField();
		txte.setBounds(435, 11, 45, 31);
		panel1.add(txte);
		txte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txte.setColumns(10);
		
		exe = new JLabel("nbr exemplaires");
		exe.setBounds(417, 45, 100, 14);
		panel1.add(exe);
		exe.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConsole.setBounds(10, 160, 66, 14);
		frmImplementationDeLalgorithme.getContentPane().add(lblConsole);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 185, 671, 424);
		frmImplementationDeLalgorithme.getContentPane().add(scrollPane);
		
		txt = new JTextArea();
		scrollPane.setViewportView(txt);
	}
}
