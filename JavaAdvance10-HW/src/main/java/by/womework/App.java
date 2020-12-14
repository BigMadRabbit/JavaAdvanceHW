package by.womework;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import by.womework.cats.BlackCat;
import by.womework.cats.Blochable;
import by.womework.cats.Cat;
import by.womework.cats.CatYears;
import by.womework.cats.Color;
import by.womework.cats.FatCat;
import by.womework.cats.ThinyCat;
import by.womework.cats.UglyCat;


public class App 
{
    public static void main( String[] args ){
    	
    	//--------- pomParser -----------//
    	PomParser pomParser = new PomParser();
    	
    	SAXParserFactory spf = SAXParserFactory.newInstance();
    	SAXParser sp = null;
    	
    	try {
			sp = spf.newSAXParser();			
			try {
				//sp.parse(App.class.getClassLoader().getResourceAsStream("pom.xml"), pomParser);
				sp.parse("pom.xml", pomParser);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//--------- catFactory -----------//
    	
    	System.out.println("");
    	System.out.println("-- catFactory --");
    	List<Class<? extends Cat>> cats = new ArrayList<>();
		cats.add(FatCat.class);		
		cats.add(BlackCat.class);
		cats.add(UglyCat.class);
		cats.add(ThinyCat.class);
		
		for (Class<? extends Cat> cat : cats) {
			Annotation[] annotations = cat.getAnnotations();
			System.out.println("Cat : " + cat.getSimpleName());
			boolean farsh  = true;			
			for (Annotation an : annotations) {
				if (an instanceof Blochable) {
					System.out.println(cat.getSimpleName() +  "not for minced farsh because Blochable");
					farsh = false;
					break;
				} else if (an instanceof Color) {
					Color colorAnno = (Color) an;
					String catcolor = colorAnno.catcolor();
                    System.out.println("Cat color: " + catcolor);
					if (catcolor.equals("black")) {
						double random = Math.random();
						if (random < 0.5) {
							System.out.println(cat.getSimpleName() + " not for minced meat because is lucky cat");
							farsh = false;
							break;
						} else {
							System.out.println(cat.getSimpleName() + " on farsh, cat is not lucky today");
						}
					}
				} else if (an instanceof CatYears) {
					CatYears catYearsAnno = (CatYears) an;
                    int catYears = catYearsAnno.years();
                    System.out.println("Cat age: " + catYears);
					if (catYears > 2) {
						System.out.println(cat.getSimpleName() + " not for minced farsh because is cat is too old");
						farsh = false;
						break;
					}
				}
			}
			if (farsh) {
				System.out.println(cat.getSimpleName() + " suitable for minced farsh ");
			}
		}
    }
}
