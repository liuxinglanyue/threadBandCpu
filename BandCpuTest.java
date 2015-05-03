public class BandCpuTest {
	public static void main(String[] args) {
		ThreadBandCpu.bandCpu(new Runnable() {
			
			@Override
			public void run() {
				for(;;){}
			}
		}, 2);
	}
}

