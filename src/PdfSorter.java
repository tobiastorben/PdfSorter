import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.pdfclown.documents.Document;
import org.pdfclown.documents.Page;
import org.pdfclown.documents.Pages;
import org.pdfclown.files.SerializationModeEnum;
public class PdfSorter {

	public static void main(String[] args) throws IOException {

		Document redDoc = new org.pdfclown.files.File().getDocument();
		Document greenDoc = new org.pdfclown.files.File().getDocument();
		Document blueDoc = new org.pdfclown.files.File().getDocument();
		Document blackDoc = new org.pdfclown.files.File().getDocument();

		Document docClown = null;
		Page pageClown = null;
		String path = args[0];
		try {
			docClown = new org.pdfclown.files.File(path).getDocument();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		PDDocument docBox = null;
		try {
			docBox = PDDocument.load(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<PDPage> pages =  docBox.getDocumentCatalog().getAllPages();
		Pages pagesClown = docClown.getPages();
		BufferedImage image = null;
		PDPage page = null;
		
		int previous = 1; // r = 0, b = 1, g = 2, black = 3;

		for (int i = 0; i < ((pages.size())); i++) {
			
			page = pages.get(i);
			try {
			image =page.convertToImage();
			}
			catch (NullPointerException e) {
				e.printStackTrace();
			}
			pageClown = pagesClown.get(i);
			
			long sumr = 0, sumg = 0, sumb = 0;
			double rAvg = 0, bAvg= 0, gAvg = 0;
			for (int x = 30; x < 100 ; x++) {
				for (int y = 30; y < 130; y++) {
					Color pixel = new Color(image.getRGB(x, y));
					sumr += pixel.getRed();
					sumg += pixel.getGreen();
					sumb += pixel.getBlue();
				}
			}
			int num = 7000;
			rAvg = sumr / num;
			bAvg = sumb / num;
			gAvg = sumg / num;

			if (rAvg / bAvg > 1.1 && rAvg / gAvg > 1.1) {
				redDoc.getPages().add(pageClown.clone(redDoc));
				previous = 0;
			} else if (bAvg / rAvg > 1.1 && bAvg / gAvg > 1.1) {
				blueDoc.getPages().add(pageClown.clone(blueDoc));
				previous = 1;
			}

			else if (gAvg / rAvg > 1.2) {
				greenDoc.getPages().add(pageClown.clone(greenDoc));
				previous = 2;
			} else if (rAvg < 200 && bAvg < 200 && gAvg < 200) {
				blackDoc.getPages().add(pageClown.clone(blackDoc));
				previous = 3;
			} else {

				switch (previous) {

				case 0:
					redDoc.getPages().add(pageClown.clone(redDoc));
					break;
				case 1:
					blueDoc.getPages().add(pageClown.clone(blueDoc));
					break;
				case 2:
					greenDoc.getPages().add(pageClown.clone(greenDoc));
					break;
				case 3:
					blackDoc.getPages().add(pageClown.clone(blackDoc));
					break;
				}

			}

		}

		try {
			redDoc.getFile().save("redDoc.pdf", SerializationModeEnum.Standard);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			greenDoc.getFile().save("greenDoc.pdf",
					SerializationModeEnum.Standard);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			blueDoc.getFile().save("blueDoc.pdf",
					SerializationModeEnum.Standard);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			blackDoc.getFile().save("blackDoc.pdf",
					SerializationModeEnum.Standard);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		docBox.close();

	}

}
