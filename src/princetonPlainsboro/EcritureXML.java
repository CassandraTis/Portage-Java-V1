/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;

/**
 *
 * @author DULAC Julia, MUSCIO Cassandra, RAINAUT Jennifer, TREBOSSEN Lucie
 */
public class EcritureXML {

    public EcritureXML(DossierMedical dm) {

        this.dm = dm;

    }

    private DossierMedical dm;

    public void setXML() throws XMLStreamException, IOException {

        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(
                    new FileWriter("src/donnees/dossiers.xml"));
            writer.writeStartDocument();

            writer.writeStartElement("dossiers");

            for (int i = 0; i < dm.getFiches().size(); i++) {
                writer.writeStartElement("ficheDeSoins");
                writer.writeStartElement("date");
                // ecrire la date de la fiche de soin 
                writer.writeCharacters(dm.getFiches().get(i).getDate().toString());
                writer.writeEndElement();

                writer.writeStartElement("medecin"); // start medecin 

                writer.writeStartElement("nom");
                writer.writeCharacters(dm.getFiches().get(i).getMedecin().getNom());
                writer.writeEndElement();

                writer.writeStartElement("prenom");
                writer.writeCharacters(dm.getFiches().get(i).getMedecin().getPrenom());
                writer.writeEndElement();

                writer.writeStartElement("specialite");
                writer.writeCharacters(dm.getFiches().get(i).getMedecin().getSpecialite());
                writer.writeEndElement();

                writer.writeStartElement("identifiant");
                writer.writeCharacters(dm.getFiches().get(i).getMedecin().getIdentifiant());
                writer.writeEndElement();

                writer.writeStartElement("mdp");
                writer.writeCharacters(dm.getFiches().get(i).getMedecin().getMdp());
                writer.writeEndElement();

                writer.writeStartElement("telephone");
                writer.writeCharacters(dm.getFiches().get(i).getMedecin().getTel());
                writer.writeEndElement();

                writer.writeEndElement(); // end de medecin 

                writer.writeStartElement("patient"); // start patient 

                writer.writeStartElement("nom");
                writer.writeCharacters(dm.getFiches().get(i).getPatient().getNom());
                writer.writeEndElement();

                writer.writeStartElement("prenom");

                writer.writeCharacters(dm.getFiches().get(i).getPatient().getPrenom());
                writer.writeEndElement();

                writer.writeStartElement("secu");

                writer.writeCharacters(dm.getFiches().get(i).getPatient().getSecu());
                writer.writeEndElement();

                writer.writeStartElement("adresse");

                writer.writeCharacters(dm.getFiches().get(i).getPatient().getAdresse());
                writer.writeEndElement();

                writer.writeEndElement(); // end patient

                for (int j = 0; j < dm.getFiches().get(i).getActes().size(); j++) {
                    writer.writeStartElement("acte"); // start acte 

                    writer.writeStartElement("code");
                    writer.writeCharacters(dm.getFiches().get(i).getActes().get(j).getCode().toStringInit());
                    writer.writeEndElement();

                    Integer coef1 = dm.getFiches().get(i).getActes().get(j).getCoef();

                    writer.writeStartElement("coef");
                    writer.writeCharacters(coef1.toString());
                    writer.writeEndElement();

                    writer.writeEndElement(); // end acte 
                }

                    writer.writeEndElement(); // end fiche de soins 
                }

                writer.writeStartElement("listeSecretaire"); // Start secretaire
                for (int j = 0; j < dm.getListeSecretaire().size(); j++) {

                    writer.writeStartElement("secretaire");

                    writer.writeStartElement("nom");
                    writer.writeCharacters(dm.getListeSecretaire().get(j).getNom());
                    writer.writeEndElement();

                    writer.writeStartElement("prenom");
                    writer.writeCharacters(dm.getListeSecretaire().get(j).getPrenom());
                    writer.writeEndElement();

                    writer.writeStartElement("identifiant");
                    writer.writeCharacters(dm.getListeSecretaire().get(j).getIdentifiant());
                    writer.writeEndElement();

                    writer.writeStartElement("mdp");
                    writer.writeCharacters(dm.getListeSecretaire().get(j).getMdp());
                    writer.writeEndElement();

                    writer.writeEndElement(); // End Secretaire

                }
                writer.writeEndElement(); // Fin dossiers 

                writer.writeEndDocument();

                writer.flush();
                writer.close();
                
                } catch (XMLStreamException e) {
        } catch (IOException e) {
        }
            }

        

    }

