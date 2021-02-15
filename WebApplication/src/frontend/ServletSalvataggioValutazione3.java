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

@WebServlet("/salvaValutazione3")
/* Questa servlet, come le precedenti, salva le preferenze dell’utente in un file chiamato valutazioni3<timestamp>.txt,
Infine il browser reindirizza l’utente alla pagina end.jsp.
*/
public class ServletSalvataggioValutazione3 extends HttpServlet {

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
        String prec = request.getParameter("precedente").trim();
        
        System.out.println(pref0 + "," + pref1 + "," + pref2 + "," + pref3 + "," + pref4);
        String output = reportValutazione + ";" + pref0 + ";" + pref1 + ";" + pref2 + ";" + pref3 + ";" + pref4 + "\n";
        Files.write(Paths.get(Configurazione.path + "valutazione3.txt"), output.getBytes(), StandardOpenOption.APPEND);
        
        String url = "end.jsp?tempo="+ tempo;

        response.sendRedirect(url);
    }
}
