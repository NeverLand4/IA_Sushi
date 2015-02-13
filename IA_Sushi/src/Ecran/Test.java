package Ecran;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

//Test Adrien123

public class Test{
	// Indiquer le delay dans la variable jeu ??
	public static void main (String [] args) throws AWTException, IOException, URISyntaxException{

		// On crée un objet robot de la classe Robot
		Robot robot = new Robot();
		/* Ouvre le lien dans le navigateur par défaut. Si le navigateur est ouvert avant
		 * l'éxéction, il reste en arrière-plan et il faut cliquer soi-même pour le mettre
		 * au premier plan (il peut y avoir des erreurs qui s'affichent dans la console
		 * mais le prog fonctionne) . Si le navigateur n'est pas ouvert avant l'exécution, le programme
		 * ouvre le navigateur et le passe au premier plan.
		 */
		//Desktop.getDesktop().browse(new URI("http://www.miniclip.com/games/sushi-go-round/fr/focus/"));

		// Le programme attend 30 secondes, (le temps que la page charge, de cliquer pour
		// passer la pub ..)
		robot.delay(30000);

		/* On récupère la taille de l'écran.
		 * Si le prog ne fonctionne pas sous LINUX, c'est peut être à cause d'un problème
		 * de reconnaissance de la taille de l'écran. Dans ce cas utiliser la ligne suivante,
		 * en indiquant la largeur et la hauteur de l'écran.*/

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//Dimension screenSize = new Dimension(1366,768);

		// On fait un screenshot de l'ecran
		BufferedImage Screenshot = robot.createScreenCapture(new Rectangle (screenSize));

		// On lit l'image à reconnaître dans l'écran
		/**!!!!!!!!!!!!!!!!!*/
		/* Ici remplacer l'argument par le chemin pour accèder à l'image Init_recon.png, qui est dans le repértoire IA_Sushi */
		BufferedImage ToID = ImageIO.read(new File("/home/kishore-asus-linux/IdeaProjects/IA_Sushi/IA_Sushi"));

		// On crée deux images à partir des deux BufferedImage.
		Image screenshot = new Image (Screenshot.getRGB(0, 0, Screenshot.getWidth(), Screenshot.getHeight(), null, 0,Screenshot.getWidth()),
				Screenshot.getWidth(), Screenshot.getHeight());
		Image toID = new Image (ToID.getRGB(0, 0, ToID.getWidth(), ToID.getHeight(), null, 0, ToID.getWidth()),
				ToID.getWidth(), ToID.getHeight());

		// Cette fonction trouve dans le screenshot le pixel à partir duquel l'image est reconnue, et renvoie sa position,
		// si l'image n'est pas trouvée elle renvoie -1
		int  corner_px = screenshot.trouveDansImage(toID);

		// Si on trouve l'image
		if (corner_px != -1){
		// Cette fonction calcule la postition du coin du jeu à partir du pixel calculé ci dessus.
		int [] coin = Image.computeImageCorner(corner_px, toID, screenshot);
		// On crée un objet repère
		Repere r = new Repere (coin[0], coin[1]);

		// On clique sur les différents boutons, en attendant deux secondes entre chaque clic.
		robot.mouseMove(coin[0], coin[1]);
		// Ici, on crée un objet Bouton, les deux premiers arguments indiquent la distance x,y par rapport au repère ( coin
		// supérieur gauche) du jeu.
		Bouton jouer = new Bouton (320,195,r);
		jouer.clicGauche(robot,2000);
		Bouton continuer = new Bouton (328,389,r);
		continuer.clicGauche(robot,2000);
		Bouton skip = new Bouton (540, 450, r);
		skip.clicGauche(robot,2000);
		continuer.clicGauche(robot,2000);
		}


	}





}
