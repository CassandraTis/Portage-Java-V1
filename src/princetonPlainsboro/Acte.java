package princetonPlainsboro;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * La classe Acte permet de décrire un Acte de soin pratiqué sur un Patient
 * @author DULAC Julia, MUSCIO Cassandra, RAINAUT Jennifer, TREBOSSEN Lucie
 */

public class Acte implements Printable {
    private Code code;
    private int coef;
    
    /**
     * Constructeur de la classe Acte
     * @param code
     * le code de l'acte
     * @param coef 
     * le coefficient de l'acte
     */
    public Acte(Code code, int coef) {
        this.code = code;
        this.coef = coef;
        }
    
    /**
     * 
     * @return une chaîne de caractères prenant en compte l'acte et son coefficient
     */
    public String toString() {
        return getCode().toString() + ", coefficient : " + getCoef() + "\n";
        }
    
    /**
     * 
     * @return retourne le coût de l'acte
     */
    public double cout() {
        return getCode().calculerCout(getCoef());
        }

    /**
     * @return retourne le code de l'acte
     */
    public Code getCode() {
        return code;
    }

    /**
     * @param code 
     * permet de régler le code de l'acte
     */
    public void setCode(Code code) {
        this.code = code;
    }

    /**
     * @return retourne le coefficient de l'acte
     */
    public int getCoef() {
        return coef;
    }

    /**
     * @param coef
     * permet de régler le coefficient de l'acte
     */
    public void setCoef(int coef) {
        this.coef = coef;
    }

    /**
     * 
     * @param graphics
     * @param pageFormat
     * @param pageIndex
     * @return
     * @throws PrinterException 
     */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
       
        if (pageIndex != 0)
 if (pageIndex > 0) {
			return NO_SUCH_PAGE;
		}
		/* On définit une marge pour l'impression */
		int marge=30;

		/* On récupère les coordonnées des bords de la page */
		int x = (int)pageFormat.getImageableX();
		int y = (int)pageFormat.getImageableY();
		int w = (int)pageFormat.getImageableWidth();
		int h = (int)pageFormat.getImageableHeight();

		/* Dessin d'un cadre gris clair*/
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(x+10, y+10, w-20, h-20);

		/* On écrit une ligne de titre en rouge, en gras de taille 18 */
		graphics.setFont(new Font("Arial", Font.BOLD, 18));
		graphics.setColor(Color.RED);
		graphics.drawString("Acte\r \n", x + marge, y+marge);

		/* On écrit une ligne en noir de taille 14 */
		graphics.setFont(new Font("Arial", Font.PLAIN, 14));
		graphics.setColor(Color.BLACK);
		graphics.drawString(this.toString(), x+marge, y+marge+20);

		return PAGE_EXISTS;
        
        
    }
    }
