/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import princetonPlainsboro.DossierMedical;
import princetonPlainsboro.LectureXML;
import princetonPlainsboro.Medecin;
import princetonPlainsboro.Patient;

/**
 *
 * @author Cassandra
 */
public class Login extends javax.swing.JFrame {
    
    private String id;
    private String mdpasse;
    private ArrayList<Medecin> mdpsMedecin;
    
    public Login() {
        //JFrame login = new JFrame();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 250);//On lui donne une taille
        setTitle("Connexion"); //On lui donne un titre

        JPanel connexion = new JPanel();
        connexion.setLayout(new BoxLayout(connexion, Y_AXIS));
        add(connexion);
        JTextField identifiant = new JTextField();
        id = identifiant.getText();
        JTextField mdp = new JTextField();
        mdpasse = mdp.getText();
        JButton validation = new JButton("Se connecter");
        
        connexion.add(identifiant);
        connexion.add(mdp);
        connexion.add(validation);
        
        mdpsMedecin = new ArrayList<Medecin>();
        LectureXML pat = new LectureXML("dossiers.xml");
        DossierMedical dm = pat.getDossier();
        for (int i = 0; i < dm.getFiches().size(); i++) {
            
            Medecin m = new Medecin(dm.getFiches().get(i).getMedecin().getNom(), dm.getFiches().get(i).getMedecin().getPrenom(), dm.getFiches().get(i).getMedecin().getSpecialite(), dm.getFiches().get(i).getMedecin().getTel(), dm.getFiches().get(i).getMedecin().getIdentifiant(), dm.getFiches().get(i).getMedecin().getMdp());
            mdpsMedecin.add(m);
            
            
      
        }
        
          validation.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        validationActionPerformed(evt);
                    }
                });    
        
    }
    
    public void validationActionPerformed(java.awt.event.ActionEvent evt){
        System.out.println("OK avant if");
        new Fenetre().setVisible(true);
        if (this.checkId()){
            System.out.println("OK");        
            new Fenetre().setVisible(true);
                    
                }
        this.dispose();
    }
    
    public String getIdentifiant() {
        return id;
    }
    
    public String getMdp() {
        return mdpasse;
    }
    
    public boolean checkId() {
        boolean res = false;
        //return res;

        for (int i = 0; i < mdpsMedecin.size(); i++) {
            if (mdpsMedecin.get(i).getIdentifiant().toString().equals(this.id)) {
                if (mdpsMedecin.get(i).getMdp().toString().equals(this.mdpasse)) {;
                    res = true;
                }
                res = false;
            }
        }
        return res;
    }

    // Pouvoir r�cup�rer tous les mots de passe des m�decins issus de l'XML
    // Mettre dans l'arrayList mdpsMedecin
}
