package sol;

public class Cuboid {
	private int w;
	private int h;
	private static int z;
	
	public double getArea(int w, int h) {
		return 2*w*h + 2*w*z + 2*z*h;
	}
	
	public double getVolume(int w, int h) {
		return w*h*z;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public static int getZ() {
		return z;
	}

	public static void setZ(int z) {
		Cuboid.z = z;
	}
	
	public Cuboid() {
		
	}
	
	public Cuboid(int w, int h)
	{
		this.w = w;
		this.h = h;
	}
	
	public Cuboid(int w, int h, int z)
	{
		this.w = w;
		this.h = h;
		Cuboid.z= z;
	}
	
}










