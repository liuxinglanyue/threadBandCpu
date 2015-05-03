public class ThreadBandCpu {
	static {
		System.loadLibrary("bandCpu");
	}
	public static native void bandCpu(Runnable r, int cpu);
}

