import javax.media.opengl.GL;

public class Line extends SceneNode {
	public float colorR, colorG, colorB, length;

	Line() {
		super();
	}

	public void setLength(float l) {
		length = l;
	}

	public void setColor(float r, float g, float b) {
		colorR = r;
		colorG = g;
		colorB = b;
	}

	/**
	 * Draws a closed cylinder along the positive y-axis, using GLU quadrics.
	 * During the first time this method is passed it creates a display list,
	 * which afterwards is just called.
	 */
	public void drawMyself(GL gl) {
		gl.glColor3f(colorR, colorG, colorB);
		gl.glBegin(GL.GL_LINES);
		gl.glVertex3f(0, 0, 0);
		gl.glVertex3f(0, length, 0);
		gl.glEnd();
	}
}