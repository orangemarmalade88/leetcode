import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class JavaTest {

	public static void main(String[] args) throws IOException {

		int size = 1000000;
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = new Random().nextInt(2000);
		}

		int count = 0;
		long start = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			if (array[i] == 1000) {
				count++;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(((double) count) / size);

		System.exit(1);

		if (null == null)
			System.out.println("yes");

		File fout = new File(
				"/scratch/pinjhuan/projects/ml/MachineLearning/resources/iris_score_5k.csv");
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		int i = 0;
		while (i < 5000) {
			try (BufferedReader br = new BufferedReader(
					new FileReader(
							"/scratch/pinjhuan/projects/ml/MachineLearning/resources/iris_score.csv"))) {
				String line;
				while ((line = br.readLine()) != null) {
					String l2 = line.substring(line.indexOf(','));
					String l1 = "\"" + i + "\"";
					bw.write(l1 + l2);
					bw.newLine();
					i++;
				}
			}
		}
		System.out.println(i);
	}
}
