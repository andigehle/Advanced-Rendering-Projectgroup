import java.util.LinkedList;
import javax.media.opengl.GL;

public abstract class SceneNode {

	public float rotX, rotY, rotZ, transX, transY, transZ = 0;
	public LinkedList<SceneNode> children;

	public SceneNode() {
		children = new LinkedList<SceneNode>();
	}

	public void setTranslation(float x, float y, float z) {
		transX = x;
		transY = y;
		transZ = z;
	}

	public void setRotation(float x, float y, float z) {
		rotX = x;
		rotY = y;
		rotZ = z;
	}

	public void addChild(SceneNode child) {
		children.add(child);
	}

	public void draw(GL gl) {
		gl.glPushMatrix(); // save transformation
		gl.glTranslatef(transX, transY, transZ);
		gl.glRotatef(rotX, 1, 0, 0);
		gl.glRotatef(rotY, 0, 1, 0);
		gl.glRotatef(rotZ, 0, 0, 1);
		drawMyself(gl);
		for (int i = 0; i < children.size(); i++) {
			children.get(i).draw(gl);
		}
		gl.glPopMatrix(); // revert transformation
	}

	abstract public void drawMyself(GL gl);
}