package html;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		final String urlString = "http://zapisy.ultimasport.pl/lista/290";
		List<Runner> data = getdataFromPage(new URL(urlString));

		System.out.println("Ilosc zawodnikow:  " + data.size());
		
		// search all woman which run 5KM and live near (or in) Kamieniec Zabkowicki
		int licznik = 0;
		for (Runner runner : data) {
			if(runner.resident.equalsIgnoreCase("Tak") &&
					runner.distance.equalsIgnoreCase("5KM") &&
					runner.name.charAt(runner.name.length()-1) == 'a' ){
				System.out.println(runner);
				licznik++;
			}
				
		}
		System.out.println("Liczba znalezionych zawodnikow = " + licznik);
	}

	private static List<Runner> getdataFromPage(URL url) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		List<Runner> list = new ArrayList<Runner>();

		// move to data in html file
		String line = null;
		while (((line = in.readLine()) != null) && !(line.trim().equals("<tbody>"))) {

		}

		// Read all data
		while (((line = in.readLine()) != null) && !(line.trim().equals("</tbody>"))) {
			int lp = getDataToInt(in);
			String name = getData(in);
			String surname = getData(in);
			String city = getData(in);
			String distance = getData(in);
			String category = getData(in);
			String payment = getData(in);
			String team = getData(in);
			String resident = getData(in);
			line = in.readLine(); // </tr>

			list.add(new Runner(lp, name, surname, city, distance, category, payment, team, resident));
		}

		in.close();
		return list;
	}

	private static String getData(BufferedReader in) throws IOException {
		String line;
		line = in.readLine().trim();
		line = line.substring(4, line.length() - 5);
		return line.trim();
	}

	private static int getDataToInt(BufferedReader in) throws IOException {
		String line;
		line = in.readLine().trim();
		line = line.substring(4, line.length() - 5);
		return Integer.parseInt(line.trim());
	}

}
