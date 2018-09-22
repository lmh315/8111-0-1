package q8111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int T;
	static int N;
	static boolean[] visited;
	static String[] ds = { "0", "1" };

	public static String bfs(int n) {
		Queue<Element> q = new LinkedList<>();
		q.add(new Element(1, "1"));
		visited[1] = true;

		while (!q.isEmpty()) {

			Element x = q.poll();

			if (x.s.length() > 100) {
				return "BRAK";
			}

			for (int i = 0; i < 2; i++) {
				int temp_n = (x.n * 10 + Integer.parseInt(ds[i])) % n;
				if (visited[temp_n])
					continue;
				if (temp_n == 0) {
					return x.s + ds[i];
				}
				q.add(new Element(temp_n, x.s + ds[i]));
				visited[temp_n] = true;
			}
		}
		return "BRAK";
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N+1];
			System.out.println(bfs(N));
		}
	}

	static class Element {
		int n;
		String s;

		Element(int n, String s) {
			this.n = n;
			this.s = s;
		}
	}
}
