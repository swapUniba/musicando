package frontend;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

@WebServlet("/salvaValutazione2")
/* Questa servlet, salva le preferenze dell�utente in un file chiamato valutazioni2<timestamp>.txt,
L�elaborazione passa poi alla pagina result4.jsp.
*/
public class ServletSalvataggioValutazione2 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
        String tempo = request.getParameter("tempo").trim();

        Scanner report = new Scanner(new File(Configurazione.path + "temp/report" + tempo + ".txt"));
        String reportValutazione = report.nextLine();
        report.close();
        											
        String pref0 = request.getParameter("pref0");	//best suggiestion (1-2)
        String pref1 = request.getParameter("pref1");	//understand why (1-2)
        String pref2 = request.getParameter("pref2");	//more convincing (1-2)
        String pref3 = request.getParameter("pref3");	//discover more (1-2)
        String pref4 = request.getParameter("pref4");	//trust level (1-2)
        
        System.out.println(pref0 + "," + pref1 + "," + pref2 + "," + pref3 + "," + pref4);
        String output = reportValutazione + ";" + pref0 + ";" + pref1 + ";" + pref2 + ";" + pref3 + ";" + pref4 + "\n";
        Files.write(Paths.get(Configurazione.path + "valutazione2.txt"), output.getBytes(), StandardOpenOption.APPEND);
       
        String url = "pagine/results3.jsp?tempo="+ tempo + "&pref=" + pref0;		//togliere pref
 
        response.sendRedirect(url);
    }
}
