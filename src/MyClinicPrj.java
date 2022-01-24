import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("all")

public class MyClinicPrj {
	
	private static ArrayList<Paziente> pazienti;
	private static ArrayList<Materiale> materiali;
	private static ArrayList<Materiale> materialiScelti;
	private static ArrayList<Scheda> schede;
	private static ArrayList<Operazione> operazioni;

	private static ArrayList<SalaOperatoria> sale_operatorie;
	private static ArrayList<Prenotazione> prenotazioni;
	private static StartUp startUp;
	
	public static void main(String[] args) throws IOException {
		startUp=new StartUp();
		carica();
		Scanner scan=new Scanner(System.in);
		logo();
		int scelta = 100;
		
		while(scelta!=0) {
			System.out.println("1 CREA NUOVA OPERAZIONE");
			System.out.println("2 AGGIORNA SCHEDA");
			System.out.println("3 TERMINA OPERAZIONE");
			System.out.println("4 INCREMENTA POSTI IN SALA OPERATORIA");
			System.out.println("5 STAMPA DATI");
			System.out.println("6 SALVA DATI");
			System.out.println("0 ESCI");
			scelta=scan.nextInt();
			switch (scelta) {
			case 1:
				creaOperazione();
				break;
			case 2:
				aggiornaScheda();
				break;
			case 3:
				terminaOperazione();
				break;
			case 4:
				incrementaPosti();
				break;	
			case 5:
				stampa();
				break;
			case 6:
				salva();
				break;
			default:
				break;
			}	
		} 
		System.out.println("GRAZIE PER AVERE USATO MYCLINIC");
		logo(); 
	}
	
	private static void carica() throws IOException {
		pazienti=startUp.caricaPazienti();
		materiali=startUp.caricaMateriali();

		sale_operatorie = startUp.caricaSale();
		schede = new ArrayList<Scheda>();
		operazioni = new ArrayList<Operazione>();
		prenotazioni = new ArrayList<Prenotazione>();
		System.out.println("DATI CARICATI");
	}
	
	private static void stampa() {
		System.out.println("STAMPA");
		System.out.println("PAZIENTI--------------------------------------------------");
		for(int i=0; i<pazienti.size(); i++) {
			System.out.println(pazienti.get(i).toString());		
		}
		System.out.println();
		System.out.println("SCHEDE--------------------------------------------------");
		for(int i=0; i<schede.size(); i++) {
			System.out.println(schede.get(i).toString());		
		}
		System.out.println();
		System.out.println("MATERIALI--------------------------------------------------");
		for(int i=0; i<materiali.size(); i++) {
			System.out.println(materiali.get(i).toString());		
		}
		System.out.println();
		System.out.println("OPERAZIONI--------------------------------------------------");
		for(int i=0; i<operazioni.size(); i++) {
			System.out.println(operazioni.get(i).toString());		
		}
		System.out.println();
		System.out.println("SALE OPERATORIE--------------------------------------------------");
		for(int i=0; i<sale_operatorie.size(); i++) {
			System.out.println(sale_operatorie.get(i).toString());		
		}
		System.out.println();
		System.out.println("PRENOTAZIONI--------------------------------------------------");
		for(int i=0; i<prenotazioni.size(); i++) {
			System.out.println(prenotazioni.get(i).toString());		
		}
	}
	
	private static  void salva() throws FileNotFoundException {
		PrintWriter preno = new PrintWriter("prenotazioni.txt");
		for(int i=0;i<prenotazioni.size();i++) {
			preno.println(prenotazioni.get(i).toString());
		}
		preno.close();

		PrintWriter sc = new PrintWriter("schede.txt");
		for(int i=0;i<schede.size();i++) {
			sc.println(schede.get(i).toString());
		}
		sc.close();
		
		PrintWriter inter = new PrintWriter("operazioni.txt");
		for(int i=0;i<operazioni.size();i++) {
			inter.println(operazioni.get(i).toString());
		}
		inter.close();

		PrintWriter ps = new PrintWriter("prezzi.txt");
		for(int i=0;i<operazioni.size();i++) {
			ps.println("Prezzo del paziente "+ operazioni.get(i).getPaziente().getNome() + " " + operazioni.get(i).getPaziente().getCognome()+ "  " + operazioni.get(i).getScheda().getTotalePrezzo());
			
		}
		ps.close();
		
		PrintWriter pz = new PrintWriter("materiali.txt");
		for(int i=0;i<materiali.size();i++) {
			pz.println(materiali.get(i).toString());
		}
		pz.close();
		
		System.out.println("SALVATO");
	}
	
	private static void incrementaPosti() {
		Scanner scan = new Scanner(System.in);
		int scelta = 1000;
		int posti = 0;
		while (scelta != 0) {
			System.out.println("Scegliere sala operatoria da modificare, 0 per terminare");
			for(int i=0; i<sale_operatorie.size(); i++) {
				System.out.println(sale_operatorie.get(i).toString());		
			}
			scelta = scan.nextInt();
			System.out.println(scelta);
			if(scelta>0 && scelta<sale_operatorie.size()+1) {
				System.out.println("Sala scelta : "+sale_operatorie.get(scelta-1).toString());
				System.out.println("Quanti posti aggiungere?");
				posti=scan.nextInt();
				System.out.println(posti);
				sale_operatorie.get(scelta-1).incrementaPostiDisponibili(posti);
			}
			else if(scelta==0){
				System.out.println("Hai scelto di uscire!"); 
			}
		}
	}
	
	
	private static void creaOperazione() {
		boolean x = false;
		boolean y = false;
		Scanner scan = new Scanner(System.in);
		int scelta = 1000;
		while (scelta != 0 && !y) {
			System.out.println("Scegliere sala operatoria per l'operazione, 0 per terminare");
			for(int i=0; i<sale_operatorie.size(); i++) {
				System.out.println(sale_operatorie.get(i).toString());		
			}
			scelta = scan.nextInt();
			System.out.println(scelta);
			if(scelta>0 && scelta<sale_operatorie.size()+1) {
				System.out.println("Sala  scelta : "+sale_operatorie.get(scelta-1).toString());
				boolean z = verificaPostiSala(sale_operatorie.get(scelta-1));
				if(z)
					break;
				else {
					Paziente paziente = scegliPaziente();
					creaPrenotazione(prenotazioni.size()+2,sale_operatorie.get(scelta-1), paziente);
					x = true;
					y = true;
				}
			} else if(scelta!=0){
				System.err.println("Scelta non corretta");
			} else if(scelta==0) 
				System.out.println("Hai scelto di uscire!");
		}
		if(!x) {
			Paziente paziente = scegliPaziente();
			if(paziente != null) {
				materialiScelti = new ArrayList<Materiale>();
				materialiScelti = scegliMateriali();
				Scheda scheda = creaScheda(materialiScelti, String.valueOf(paziente.getCF()));
				Operazione operazione = new Operazione(scheda, paziente, sale_operatorie.get(scelta-1).getId_sala());
				operazioni.add(operazione);
			}
		}
	}
	
	private static boolean verificaPostiSala(SalaOperatoria so) {
		if(so.assegnaPosto())
			return true;
		else
			return false;
	}
	
	private static Scheda creaScheda(ArrayList<Materiale> p, String cf) {
		Scheda scheda = new Scheda(schede.size()+1, cf, p);
		schede.add(scheda);
		return scheda;
	}
	
	private static void creaPrenotazione(int op, SalaOperatoria so, Paziente pa) {
		Prenotazione p = new Prenotazione(prenotazioni.size()+1, prenotazioni.size()+2, so, pa);
		prenotazioni.add(p);
		System.err.println("Prenotazione effettuata, il cliente " + pa.getNome() + " " + pa.getCognome() + " sarà avvisato dopo la liberazione di un posto");
	}

	private static void creaPrenotazioneSuccessiva(SalaOperatoria so, Paziente pa) {
		Scanner scan = new Scanner(System.in);
		int id_operazione = 0;
		id_operazione = scan.nextInt();
		//l'id inserito manualmente dovrà corrispondere all'id creato randomicamente al momento della creazione della prima prenotazione
		Prenotazione p = new Prenotazione(prenotazioni.size()+1, id_operazione, so, pa);
		prenotazioni.add(p);
		System.err.println("Prenotazione effettuata, il cliente " + pa.getNome() + " " + pa.getCognome() + " sarà avvisato dopo la liberazione di un posto");
	}
	
	private static void aggiornaScheda() {
		Scanner scan = new Scanner(System.in);
		int scelta = 1000;
		boolean x = false;
		while (scelta != 0 && ! x) {
			System.out.println("Scegliere la scheda da aggiornare, 0 per terminare");
			for(int i=0; i<schede.size(); i++) {
				System.out.println(schede.get(i).toString());		
			}
			scelta = scan.nextInt();
			System.out.println(scelta);
			if(scelta>0 && scelta<schede.size()+1) {
				System.out.println("Scheda scelta : "+schede.get(scelta-1).toString());
				materialiScelti = new ArrayList<Materiale>();
				materialiScelti = scegliMateriali();
				schede.get(scelta-1).addMateriali(materialiScelti);
				schede.get(scelta-1).calcolaTotale();
				for(Operazione in: operazioni) {
					if(in.getScheda().equals(schede.get(scelta-1)))
						in.setScheda(schede.get(scelta-1));
				}
				x = true;
			} else if(scelta!=0){
				System.err.println("Scelta non corretta");
			} else if(scelta==0) 
				System.out.println("Hai scelto di uscire!");
		}
	}
	
	private static void terminaOperazione() {
		System.out.println("Quante sedute sono state necessarie per l'operazione?");
		Scanner scan = new Scanner(System.in);
		int n_sedute = scan.nextInt();
		int scelta = 1000;
		boolean x = false;
		while (scelta != 0 && !x) {
			System.out.println("Scegliere la scheda da definire, 0 per terminare");
			for(int i=0; i<schede.size(); i++) {
				System.out.println(schede.get(i).toString());		
			}
			scelta = scan.nextInt();
			System.out.println(scelta);
			if(scelta>0 && scelta<schede.size()+1) {
				System.out.println("Scheda scelta : "+schede.get(scelta-1).toString());
				schede.get(scelta-1).setNumero_sedute(n_sedute);
				schede.get(scelta-1).calcolaTotale();
				for(Operazione in: operazioni) {
					if(in.getScheda().equals(schede.get(scelta-1)))
						in.setScheda(schede.get(scelta-1));
				}
				x = true;
			} else if(scelta!=0){
				System.err.println("Scelta non corretta");
			} else if(scelta==0) 
				System.out.println("Hai scelto di uscire!");
		}

	}
	

	
	private static Paziente scegliPaziente() {
		Scanner scan = new Scanner(System.in);
		int scelta = 1000;
		while(scelta>pazienti.size() || scelta==0) {
			System.out.println("Scegliere un paziente in base al codice fiscale");
			for(int i=0; i<pazienti.size(); i++) {
				System.out.println(pazienti.get(i).toString());		
			}
			scelta = scan.nextInt();
			System.out.println(scelta);
			if(scelta>0 && scelta<pazienti.size()+1) {
				System.out.println("Paziente scelto : "+pazienti.get(scelta-1).toString());
			}else if(scelta!=0){
				System.err.println("Scelta non corretta");
			}else if(scelta==0) {
				System.out.println("Hai scelto di uscire!");
				return null;
			}
		}
		return pazienti.get(scelta-1);
	}
	
	private static ArrayList<Materiale> scegliMateriali(){
		Scanner scan = new Scanner(System.in);
		int scelta=10000;
		while(scelta!=0) {
			System.out.println("Scegliere un materiale in base al suo codice, 0 per terminare");
			for(int i=0; i<materiali.size(); i++) {
				System.out.println(materiali.get(i).toString());		
			}
			scelta = scan.nextInt();
			if(scelta<materiali.size()+1) {
				if(scelta>0) {
					if(materiali.get(scelta-1).getDisponibilità() > 0) {
						System.out.println("Materiale scelto : "+materiali.get(scelta-1).toString());
						materialiScelti.add(materiali.get(scelta-1));
						materiali.get(scelta-1).setDisponibilità((materiali.get(scelta-1).getDisponibilità())-1);
					}
					else {
						System.err.println("Materiale non disponibile!");
					}
				}
				else if(scelta==0){
					System.out.println("Hai scelto di uscire!"); 
				}
			} else {System.err.println("Codice non esistente!");}
		}
		
		return materialiScelti;
	}
	
	private static void logo() {
		int width=50;
		int height=23;
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g= image.getGraphics();
		g.setFont(new Font("SansSerif",Font.BOLD,24));
		Graphics2D g2=(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.drawString("MC", 1, 20);
		
		for(int y=0;y<height;y++) {
			StringBuilder builder= new StringBuilder(); 
		
			for(int x=0;x<width;x++) {
				builder.append(image.getRGB(x, y) == -16777216 ? " ":"#");
			}
			System.out.println(builder);
		}
	}

}
