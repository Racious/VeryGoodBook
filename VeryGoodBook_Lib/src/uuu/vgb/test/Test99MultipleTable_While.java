package uuu.vgb.test;

public class Test99MultipleTable_While {

	public static void main(String[] args) {
		int q = 1;
		while (q < 10) {
			int w = 1;
			while (w < 10) {
				System.out.print(q + "×" + w + "=" + q * w);
				System.out.print(w < 9 ? "\t" : "\n");
				w++;
			}
			q++;
		}
		System.out.println();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (j == 9) {
					System.out.println(i + "×" + j + "=" + i * j);
				} else {
					System.out.print(i + "×" + j + "=" + i * j + "\t");
				}

			}

		}
		System.out.println("\n");
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (j == 9) {
					System.out.println(j + "×" + i + "=" + i * j);
				} else {
					System.out.print(j + "×" + i + "=" + i * j + "\t");
				}

			}

		}
		System.out.println("\n");
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; i <= j; j--)
				System.out.print("　");
			for (int j = 1; j <= i; j++)
				System.out.print("＊");
			for (int j = 1; j < i; j++)
				System.out.print("＊");
			System.out.println();
		}
		for (int x = 4; x >= 1; x--) {
			for (int y = 5; y >= x; y--)
				System.out.print("　");
			for (int y = 1; y <= x; y++)
				System.out.print("＊");
			for (int y = 1; y < x; y++)
				System.out.print("＊");
			System.out.println();
		}
		System.out.println("\n");
		int no = 10;
		for (int i = 1; i <= no; i++) {
			for (int j = no; j >= i; j--)
				System.out.print(" ");
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			for (int j = 1; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
		for (int x = no - 1; x >= 1; x--) {
			for (int y = no; y >= x; y--)
				System.out.print(" ");
			for (int y = 1; y <= x; y++)
				System.out.print("*");
			for (int y = 1; y < x; y++)
				System.out.print("*");
			System.out.println();
		}

	}

}
