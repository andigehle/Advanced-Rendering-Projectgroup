import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import com.sun.opengl.util.GLUT;

@SuppressWarnings("serial")
public class Train extends AdvancedTemplate {

	/**
	 * Object index-list
	 */
	private int[] objectList;
	
	private final static int OBJECT_TRAIN = 0; 
	private final static int OBJECT_WAGGON1 = 1; 
	private final static int OBJECT_WAGGON2 = 2; 
	private final static int OBJECT_WAGGON3 = 3; 

	/**
	 * Animation time counter
	 */
	private long startAnimation = 0;

	// ------------------------------------------------------------

	/**
	 * Main method
	 * 
	 * Start your application
	 */
	public static void main(String[] args) {
		Train template = new Train();
		template.setVisible(true);
	}

	// ------------------------------------------------------------

	/**
	 * Constructor
	 * 
	 * Setup window-title
	 */
	public Train() {
		super();
		setTitle("The little ugly train");
	}

	// ------------------------------------------------------------

	/**
	 * Initialization
	 * 
	 * Load object-files
	 */
	public void init(GLAutoDrawable drawable) {
		super.init(drawable);
		
		//Set time for animations
		startAnimation = System.currentTimeMillis();

		//Load objects
		OBJLoader objLoader;
		objLoader = new OBJLoader("assets/objects/train", 1.0f,
				drawable.getGL());
		objectList[OBJECT_TRAIN] = objLoader.getDisplayList();
		
		objLoader = new OBJLoader("assets/objects/waggon1_michi", 1.0f,
				drawable.getGL());
		objectList[OBJECT_WAGGON1] = objLoader.getDisplayList();
		
		objLoader = new OBJLoader("assets/objects/waggon2_andi", 1.0f,
				drawable.getGL());
		objectList[OBJECT_WAGGON2] = objLoader.getDisplayList();
	}

	// ------------------------------------------------------------

	/**
	 * Draw your stuff
	 */
	public void displayDraw(GLAutoDrawable drawable) {
		GL gl = drawable.getGL();
		GLUT glut = getGlut();

		// Debug
		// drawCoord(gl, 10);

		int size = 4;

		// Center the graphic a bit
		gl.glPushMatrix();
		{
			gl.glTranslatef(-size / 2, -size / 2, -size / 2);

			// Load model: bunny
			gl.glPushMatrix();
			{
				gl.glColor3f(139 / 255f, 90 / 255f, 43 / 255f);
				gl.glTranslatef(size + 1, 0, size + 1);
				gl.glCallList(objectList[OBJECT_TRAIN]);
			}
			gl.glPopMatrix();
		}
		// To center graphic
		gl.glPopMatrix();
	}

	// ------------------------------------------------------------

	/**
	 * Get delay for animations
	 * 
	 * @return float time delay in milliseconds 
	 */
	private float getDelay() {
		return (System.currentTimeMillis() - startAnimation);
	}

}
