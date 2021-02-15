<%@ page import="classi.Math" %>
<%@ page import="report.*" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Report</title>
	<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">		 Report</a>
	</div>
	</nav>
	<%  Report.leggiLog();%>

<div class="container-fluid bg-light">
 
<p align="center">6.3.1 <b>ANALISI dell'UTENZA</b></p>	
   	<%
	///////////////////////////////ANAGRAFICA///////////////////////
	//1) anagrafiche utenti
    HashMap<String, HashMap<String, Integer>> anagrafica = null;	
    anagrafica = Anagrafica.infoUtenti();
    int numeroUtenti = Report.utenti.size();
    %>
            
     <table border="1" align="center">
          <tr>
              <td colspan="5" align="center"><h5>Statistiche utenti</h5></td>
          </tr>
          <tr>
              <td colspan="5" align="center"><b>Età</b></td>
          </tr>
          <tr>
              <td width="80" align="center"> < 18</td>
              <td width="80" align="center">18 - 25</td>
              <td width="80" align="center">26 - 35</td>
              <td width="80" align="center">36 - 50</td>
              <td width="80" align="center"> > 50</td>
          </tr>
          <tr>
              <td align="center"><%out.println(Math.perc(anagrafica.get("Eta").get("<18"), numeroUtenti));%></td>
              <td align="center"><%out.println(Math.perc(anagrafica.get("Eta").get("18-25"), numeroUtenti));%></td>
              <td align="center"><%out.println(Math.perc(anagrafica.get("Eta").get("26-35"), numeroUtenti));%></td>
              <td align="center"><%out.println(Math.perc(anagrafica.get("Eta").get("36-50"), numeroUtenti));%></td>
              <td align="center"><%out.println(Math.perc(anagrafica.get("Eta").get(">50"), numeroUtenti));%></td>
          </tr>

          <tr>
              <td colspan="5" align="center"><b>Genere</b></td>
          </tr>
          <tr>
              <td align="center" colspan="2">Uomo</td>
              <td align="center" colspan="3">Donna</td>
          </tr>
          <tr>
              <td align="center" colspan="2"><%out.println(Math.perc(anagrafica.get("Genere").get("uomo"), numeroUtenti));%></td>
              <td align="center" colspan="3"><%out.println(Math.perc(anagrafica.get("Genere").get("donna"), numeroUtenti));%></td>
          </tr>
          <tr>
              <td colspan="5" align="center"><b>Titolo di studio</b></td>
          </tr>
          <tr>
              <td  align="center">Diploma Scuola Superiore</td>
              <td align="center">Laurea Triennale</td>
              <td  align="center">Laurea Magistrale</td>
              <td  align="center">PhD</td>
              <td  align="center">Altro</td>
          </tr>
          <tr>
              <td align="center"><%out.print(Math.perc(anagrafica.get("Titoli di studio").get("Diploma Scuola superiore"), numeroUtenti));%></td>
              <td align="center"><%out.print(Math.perc(anagrafica.get("Titoli di studio").get("Laurea Triennale"), numeroUtenti));%></td>
              <td align="center"><%out.print(Math.perc(anagrafica.get("Titoli di studio").get("Laurea Magistrale"), numeroUtenti));%></td>
              <td align="center"><%out.print(Math.perc(anagrafica.get("Titoli di studio").get("Dottorato di Ricerca"), numeroUtenti));%></td>
              <td align="center"><%out.print(Math.perc(anagrafica.get("Titoli di studio").get("Altro"), numeroUtenti));%></td>
          </tr>

          <tr>
              <td colspan="5" align="center"><b>Uso Recommender System</b></td>
          </tr>
          <tr>
              <td align="center" colspan="3">Sì</td>
              <td align="center" colspan="2">No</td>
          </tr>
          <tr>
              <td align="center" colspan="3"><%out.print(Math.perc(anagrafica.get("Uso Rec Sys").get("si"), numeroUtenti));%></td>
              <td align="center" colspan="2"><%out.println(Math.perc(anagrafica.get("Uso Rec Sys").get("no"), numeroUtenti));%></td>
          </tr>

          <tr>
              <td colspan="5" align="center"><b>Frequenza film settimanali</b></td>
          </tr>
          <tr>
              <td align="center">0-1 volta</td>
              <td align="center" colspan="2">2-4 volte</td>
              <td align="center" colspan="2">5-7 volte</td>
          </tr>
          <tr>
              <td align="center"><%out.print(Math.perc(anagrafica.get("Frequenze uscite").get("0-1 volta"), numeroUtenti));%></td>
              <td align="center" colspan="2"><%out.print(Math.perc(anagrafica.get("Frequenze uscite").get("2-4 volte"), numeroUtenti));%></td>
              <td align="center" colspan="2"><%out.print(Math.perc(anagrafica.get("Frequenze uscite").get("5-7 volte"), numeroUtenti));%></td>
          </tr>
      </table>

     <br>
<br> 
 
<p align="center"> 6.1 <b>CONTATORI</b></p>
  
	 <p align="center">
	 	<br>
     	<b >Numero Utenti</b>: <%out.println(Report.utenti.size());%> 
     	<br>
     	<b>Numero Valutazioni 1</b>: <%out.println(Report.valutazioni1.size());%> 
     	<br>       
     	<b>Numero Valurazioni 3</b>: <%out.println(Report.valutazioni2.size());%>
     	<br>
     	<b>Numero Valutazioni 4</b>: <%out.println(Report.valutazioni3.size());%>
     	<br><br>
 	 </p>   

 		
	 <%             
     //////////////////////////CONTATORI/////////////////
     //NUMERO CONFIGURAZIONI elaborate x ogni tipo (uni, bi, unibi);
     HashMap<String, Integer> contatoriConfig = null;		
     contatoriConfig = Contatori.contatoriConfigurazioni();
     %>
     
 	  <table align="center" border=1>
         <tr>
             <td align="center" colspan="3" width="200"><h5>Contatori CONFIGURAZIONI</h5></td>
         </tr>

         <tr>
             <td align="center" width="120">
                 Numero UNIGRAMMI
             </td>
             <td align="center" width="120">
                 Numero BIGRAMMI
             </td>
             <td align="center" width="120">
                 Numero UNIBIGRAMMI
             </td >
         </tr>
         <tr>
             <td align="center" width="120">
                 <%out.println(contatoriConfig.get("unigrammi"));%>
             </td>
             <td align="center" width="120">
                 <%out.println(contatoriConfig.get("bigrammi"));%>
             </td>
             <td align="center" width="120">
                 <%out.println(contatoriConfig.get("unibigrammi"));%>
             </td >
         </tr>

      </table>
		
	 <br><br>
	
  	 
	 <%  
     //NUMERO TECNICHE ELABORATE
     HashMap<String, Integer> contatoriTecnica= null;		
     contatoriTecnica = Contatori.contatoriTenica();
     %>
 	  <table align="center" border=1>
         <tr>
             <td align="center" colspan="3" width="200"><h5>Contatori TECNICHE</h5></td>
         </tr>

         <tr>
             <td align="center" width="120">
                 Numero PMI
             </td>
             <td align="center" width="120">
                 Numero NORMALE
             </td>
         </tr>
         <tr>
             <td align="center" width="120">
                 <%out.println(contatoriTecnica.get("pmi"));%>
             </td>
             <td align="center" width="120">
                 <%out.println(contatoriTecnica.get("normale"));%>
             </td>
         </tr>

      </table>
		
	 <br><br>

    <%
        HashMap<String, Integer> cc = Contatori.contatoriCombinazioni();

    %>
    <table align="center" border=1>
        <tr>
            <td align="center" colspan="2" width="240"><h5>Contatori combinazioni</h5></td>
        </tr>

        <tr>
            <td align="center" width="120">
                Normale - Uni
            </td>
            <td align="center" width="120">
                <%out.println(cc.get("nu"));%>
            </td>
        </tr>
        <tr>
            <td align="center" width="120">
                Normale - Bi
            </td>
            <td align="center" width="120">
                <%out.println(cc.get("nb"));%>
            </td>
        </tr>
        <tr>
            <td align="center" width="120">
                Normale - UniBi
            </td>
            <td align="center" width="120">
                <%out.println(cc.get("nub"));%>
            </td>
        </tr>
        <tr>
            <td align="center" width="120">
                PMI - Uni
            </td>
            <td align="center" width="120">
                <%out.println(cc.get("pu"));%>
            </td>
        </tr>
        <tr>
            <td align="center" width="120">
                PMI - Bi
            </td>
            <td align="center" width="120">
                <%out.println(cc.get("pb"));%>
            </td>
        </tr>
        <tr>
            <td align="center" width="120">
                PMI - UniBi
            </td>
            <td align="center" width="120">
                <%out.println(cc.get("pub"));%>
            </td>
        </tr>

    </table>

    <br><br>
	
	 <%             
     //contatori NUMERO CONTESTI selezionati dagli utenti
     HashMap<Integer, Integer> contatoriContesti = 	null;		
     contatoriContesti = 	Contatori.contatoriNumeroContesti();
     %> 

      <table align="center" border=1>
          <tr>
              <td align="center" colspan="5" width="200"><h5>Contatori configurazioni</h5></td>
          </tr>

          <tr>
              <td align="center" width="120">
                  1 contesto
              </td>
              <td align="center" width="120">
                  2 contesti
              </td>
              <td align="center" width="120">
                  3 contesti
              </td>

          </tr>
          <tr>
              <td align="center" width="120">
                  <%out.println(contatoriContesti.get(1));%>
              </td>
              <td align="center" width="120">
                  <%out.println(contatoriContesti.get(2));%>
              </td>
              <td align="center" width="120">
                  <%out.println(contatoriContesti.get(3));%>
              </td >

          </tr>

      </table>

     <br><br>
				
	     
    



<p align="center">--------------------------- <b>ESPERIMENTO 1 -----------------------------------</b></p>

 	 <%          
 	 /////////////////////////VALUTAZIONI////////////////////  
 	 //5) valutazioni METRICHE ASSOLUTE sulle spiegazioni normale - lemmi
     HashMap<String, HashMap<String, Double>>  valutazAssolC = null;
     valutazAssolC = Valutazioni.valutazioniAssoluteLemmi();
     %>

      <table align="center" border="1">
          <tr>
              <td align="center" align="center" colspan="9" width="200"><h5>Valutazioni Assolute Generali</h5></td>
          </tr>

          <tr>
              <td align="center"></td>
              <td align="center">Unigrammi</td>
              <td align="center">Bigrammi</td>
              <td align="center">Unigrammi + Bigrammi</td>
          </tr>

          <tr>
              <td align="center">Trasparenza</td>
              <td align="center"><%out.println(Math.dec(valutazAssolC.get("unigrammi").get("Trasparenza")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolC.get("bigrammi").get("Trasparenza")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolC.get("unibigrammi").get("Trasparenza")));%></td>
          </tr>
          <tr>
              <td align="center">Persuasione</td>
              <td align="center"><%out.println(Math.dec(valutazAssolC.get("unigrammi").get("Persuasione")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolC.get("bigrammi").get("Persuasione")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolC.get("unibigrammi").get("Persuasione")));%></td>
          </tr>
          <tr>
              <td align="center">Coinvolgimento</td>
              <td align="center"><%out.println(Math.dec(valutazAssolC.get("unigrammi").get("Coinvolgimento")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolC.get("bigrammi").get("Coinvolgimento")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolC.get("unibigrammi").get("Coinvolgimento")));%></td>
          </tr>
          <tr>
              <td align="center">Fiducia</td>
              <td align="center"><%out.println(Math.dec(valutazAssolC.get("unigrammi").get("Fiducia")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolC.get("bigrammi").get("Fiducia")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolC.get("unibigrammi").get("Fiducia")));%></td>
          </tr>

      </table>

     <br>
	 -->  		
	 <%          
     //valutazioni METRICHE ASSOLUTE sulle spiegazioni normali
     HashMap<String, HashMap<String, Double>> valutazAssolS = null;	
     valutazAssolS = 	Valutazioni.valutazioniAssoluteNormaleLemmi();
     %>
            
      <table align="center" border="1">
          <tr>
              <td align="center" align="center" colspan="9" width="200"><h5>Valutazioni Assolute - Normale</h5></td>
          </tr>

          <tr>
              <td align="center"></td>
              <td align="center">Unigrammi</td>
              <td align="center">Bigrammi</td>
              <td align="center">Uni-bigrammi</td>
          </tr>

          <tr>
              <td align="center">Trasparenza</td>
              <td align="center"><%out.println(Math.dec(valutazAssolS.get("unigrammi").get("Trasparenza")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolS.get("bigrammi").get("Trasparenza")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolS.get("unibigrammi").get("Trasparenza")));%></td>
          </tr>
          <tr>
              <td align="center">Persuasione</td>
              <td align="center"><%out.println(Math.dec(valutazAssolS.get("unigrammi").get("Persuasione")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolS.get("bigrammi").get("Persuasione")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolS.get("unibigrammi").get("Persuasione")));%></td>
          </tr>
          <tr>
              <td align="center">Coinvolgimento</td>
              <td align="center"><%out.println(Math.dec(valutazAssolS.get("unigrammi").get("Coinvolgimento")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolS.get("bigrammi").get("Coinvolgimento")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolS.get("unibigrammi").get("Coinvolgimento")));%></td>
          </tr>
          <tr>
              <td align="center">Fiducia</td>
              <td align="center"><%out.println(Math.dec(valutazAssolS.get("unigrammi").get("Fiducia")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolS.get("bigrammi").get("Fiducia")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolS.get("unibigrammi").get("Fiducia")));%></td>
          </tr>

      </table>

     <br> <br>
	 
	<%          
     //valutazioni METRICHE ASSOLUTE sulle spiegazioni NORMALE
     HashMap<String, HashMap<String, Double>> valutazAssolN = null;	
     valutazAssolN = 	Valutazioni.valutazioniAssolutePMILemmi();
     %>
            
      <table align="center" border="1">
          <tr>
              <td align="center" align="center" colspan="9" width="200"><h5>Valutazioni Assolute - PMI</h5></td>
          </tr>

          <tr>
              <td align="center"></td>
              <td align="center">Unigrammi</td>
              <td align="center">Bigrammi</td>
              <td align="center">Uni-bigrammi</td>
          </tr>

          <tr>
              <td align="center">Trasparenza</td>
              <td align="center"><%out.println(Math.dec(valutazAssolN.get("unigrammi").get("Trasparenza")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolN.get("bigrammi").get("Trasparenza")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolN.get("unibigrammi").get("Trasparenza")));%></td>
          </tr>
          <tr>
              <td align="center">Persuasione</td>
              <td align="center"><%out.println(Math.dec(valutazAssolN.get("unigrammi").get("Persuasione")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolN.get("bigrammi").get("Persuasione")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolN.get("unibigrammi").get("Persuasione")));%></td>
          </tr>
          <tr>
              <td align="center">Coinvolgimento</td>
              <td align="center"><%out.println(Math.dec(valutazAssolN.get("unigrammi").get("Coinvolgimento")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolN.get("bigrammi").get("Coinvolgimento")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolN.get("unibigrammi").get("Coinvolgimento")));%></td>
          </tr>
          <tr>
              <td align="center">Fiducia</td>
              <td align="center"><%out.println(Math.dec(valutazAssolN.get("unigrammi").get("Fiducia")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolN.get("bigrammi").get("Fiducia")));%></td>
              <td align="center"><%out.println(Math.dec(valutazAssolN.get("unibigrammi").get("Fiducia")));%></td>
          </tr>

      </table>

     <br>
     


     <br>
	
	
<br><br>
<p align="center">------------------- <b>ESPERIMENTO 2 ------------------------</b></p>

	
     <%
   	//-->preferenza tra FRAMEWORK e BASELINE;
   	HashMap<String, Double> p1 = null;
    p1 = 	Preferenze.sistemaVSbaseline1();
     %>
      
      <table border="1" align="center">
          <tr>
              <td align="center" colspan="3" width="360"><h5>Sistema vs Baseline 1</h5></td>
          </tr>
          <tr>
              <td align="center" width="120">Sistema</td>
              <td align="center" width="120">Baseline 1</td>
              <td align="center" width="120">Indifferente</td>
          </tr>
          <tr>
              <td align="center"><%out.println(Math.perc(p1.get("sistema")));%></td>
              <td align="center"><%out.println(Math.perc(p1.get("baseline1")));%></td>
              <td align="center"><%out.println(Math.perc(p1.get("indifferente")));%></td>
          </tr>
      </table>

     <br><br>

    <%
        //-->preferenza tra FRAMEWORK e BASELINE;
        HashMap<String, Double> p2 = null;
        p2 = 	Preferenze.normaleVSbaseline1();
    %>

    <table border="1" align="center">
        <tr>
            <td align="center" colspan="3" width="360"><h5>Normale vs Baseline 1</h5></td>
        </tr>
        <tr>
            <td align="center" width="120">Normale</td>
            <td align="center" width="120">Baseline 1</td>
            <td align="center" width="120">Indifferente</td>
        </tr>
        <tr>
            <td align="center"><%out.println(Math.perc(p2.get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p2.get("baseline1")));%></td>
            <td align="center"><%out.println(Math.perc(p2.get("indifferente")));%></td>
        </tr>
    </table>

    <br><br>

    <%
        //-->preferenza tra FRAMEWORK e BASELINE;
        HashMap<String, Double> p3 = null;
        p3 = 	Preferenze.pmiVSbaseline1();
    %>

    <table border="1" align="center">
        <tr>
            <td align="center" colspan="3" width="360"><h5>PMI vs Baseline 1</h5></td>
        </tr>
        <tr>
            <td align="center" width="120">PMI</td>
            <td align="center" width="120">Baseline 1</td>
            <td align="center" width="120">Indifferente</td>
        </tr>
        <tr>
            <td align="center"><%out.println(Math.perc(p3.get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p3.get("baseline1")));%></td>
            <td align="center"><%out.println(Math.perc(p3.get("indifferente")));%></td>
        </tr>
    </table>

    <br><br>

    <%
        //-->preferenza tra FRAMEWORK e BASELINE;
        HashMap<String, Double> p4 = null;
        p4 = 	Preferenze.sistemaVSbaseline2();
    %>

    <table border="1" align="center">
        <tr>
            <td align="center" colspan="3" width="360"><h5>Sistema vs Baseline 2</h5></td>
        </tr>
        <tr>
            <td align="center" width="120">Sistema</td>
            <td align="center" width="120">Baseline 2</td>
            <td align="center" width="120">Indifferente</td>
        </tr>
        <tr>
            <td align="center"><%out.println(Math.perc(p4.get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p4.get("baseline2")));%></td>
            <td align="center"><%out.println(Math.perc(p4.get("indifferente")));%></td>
        </tr>
    </table>

    <br><br>

    <%
        //-->preferenza tra FRAMEWORK e BASELINE;
        HashMap<String, Double> p5 = null;
        p5 = 	Preferenze.normaleVSbaseline2();
    %>

    <table border="1" align="center">
        <tr>
            <td align="center" colspan="3" width="360"><h5>Normale vs Baseline 2</h5></td>
        </tr>
        <tr>
            <td align="center" width="120">Normale</td>
            <td align="center" width="120">Baseline 2</td>
            <td align="center" width="120">Indifferente</td>
        </tr>
        <tr>
            <td align="center"><%out.println(Math.perc(p5.get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p5.get("baseline2")));%></td>
            <td align="center"><%out.println(Math.perc(p5.get("indifferente")));%></td>
        </tr>
    </table>

    <br><br>

    <%
        //-->preferenza tra FRAMEWORK e BASELINE;
        HashMap<String, Double> p6 = null;
        p6 = 	Preferenze.pmiVSbaseline2();
    %>

    <table border="1" align="center">
        <tr>
            <td align="center" colspan="3" width="360"><h5>PMI vs Baseline 2 </h5></td>
        </tr>
        <tr>
            <td align="center" width="120">PMI</td>
            <td align="center" width="120">Baseline 2</td>
            <td align="center" width="120">Indifferente</td>
        </tr>
        <tr>
            <td align="center"><%out.println(Math.perc(p6.get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p6.get("baseline2")));%></td>
            <td align="center"><%out.println(Math.perc(p6.get("indifferente")));%></td>
        </tr>
    </table>

    <br><br>


    <%
        //3) preferenze tra centroide e frasi singole con configurazioni di lemmi
        //-->preferenze tra FRAMEWORK e BASELINE DISTRIBUZIONALE con CONFIGURAZIONI LEMMI;
        HashMap<String, HashMap<String, Double>> p7 = null;
        p7 = Preferenze.sistemaVSbaseline1PreferenzeLemmi();
    %>
    <table align="center" border="1">
        <tr>
            <td align="center" align="center" colspan="9" width="200"><h5>Sistema vs Baseline 1
                Configurazioni</h5></td>
        </tr>

        <tr>
            <td align="center"></td>
            <td align="center">Sistema</td>
            <td align="center">Baseline 1</td>
            <td align="center">Indifferente</td>
        </tr>

        <tr>
            <td align="center">Unigrammi</td>
            <td align="center"><%out.println(Math.perc(p7.get("unigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p7.get("unigrammi").get("baseline1")));%></td>
            <td align="center"><%out.println(Math.perc(p7.get("unigrammi").get("indifferenti")));%></td>
        </tr>
        <tr>
            <td align="center">Bigrammi</td>
            <td align="center"><%out.println(Math.perc(p7.get("bigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p7.get("bigrammi").get("baseline1")));%></td>
            <td align="center"><%out.println(Math.perc(p7.get("bigrammi").get("indifferenti")));%></td>
        </tr>
        <tr>
            <td align="center">Uni-bigrammi</td>
            <td align="center"><%out.println(Math.perc(p7.get("unibigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p7.get("unibigrammi").get("baseline1")));%></td>
            <td align="center"><%out.println(Math.perc(p7.get("unibigrammi").get("indifferenti")));%></td>
        </tr>

    </table>

    <br><br>

    <%
        //3) preferenze tra centroide e frasi singole con configurazioni di lemmi
        //-->preferenze tra FRAMEWORK e BASELINE DISTRIBUZIONALE con CONFIGURAZIONI LEMMI;
        HashMap<String, HashMap<String, Double>> p8 = null;
        p8 = Preferenze.normaleVSbaseline1PreferenzeLemmi();
    %>
    <table align="center" border="1">
        <tr>
            <td align="center" align="center" colspan="9" width="200"><h5>Normale vs Baseline 1</h5></td>
        </tr>

        <tr>
            <td align="center"></td>
            <td align="center">Normale</td>
            <td align="center">Baseline 1</td>
            <td align="center">Indifferente</td>
        </tr>

        <tr>
            <td align="center">Unigrammi</td>
            <td align="center"><%out.println(Math.perc(p8.get("unigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p8.get("unigrammi").get("baseline1")));%></td>
            <td align="center"><%out.println(Math.perc(p8.get("unigrammi").get("indifferenti")));%></td>
        </tr>
        <tr>
            <td align="center">Bigrammi</td>
            <td align="center"><%out.println(Math.perc(p8.get("bigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p8.get("bigrammi").get("baseline1")));%></td>
            <td align="center"><%out.println(Math.perc(p8.get("bigrammi").get("indifferenti")));%></td>
        </tr>
        <tr>
            <td align="center">Uni-bigrammi</td>
            <td align="center"><%out.println(Math.perc(p8.get("unibigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p8.get("unibigrammi").get("baseline1")));%></td>
            <td align="center"><%out.println(Math.perc(p8.get("unibigrammi").get("indifferenti")));%></td>
        </tr>

    </table>

    <br><br>

    <%
        //3) preferenze tra centroide e frasi singole con configurazioni di lemmi
        //-->preferenze tra FRAMEWORK e BASELINE DISTRIBUZIONALE con CONFIGURAZIONI LEMMI;
        HashMap<String, HashMap<String, Double>> p9 = null;
        p9 = Preferenze.pmiVSbaseline1PreferenzeLemmi();
    %>
    <table align="center" border="1">
        <tr>
            <td align="center" align="center" colspan="9" width="200"><h5>PMI vs Baseline 1</h5></td>
        </tr>

        <tr>
            <td align="center"></td>
            <td align="center">Framework</td>
            <td align="center">Baseline 1</td>
            <td align="center">Indifferente</td>
        </tr>

        <tr>
            <td align="center">Unigrammi</td>
            <td align="center"><%out.println(Math.perc(p9.get("unigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p9.get("unigrammi").get("baseline1")));%></td>
            <td align="center"><%out.println(Math.perc(p9.get("unigrammi").get("indifferenti")));%></td>
        </tr>
        <tr>
            <td align="center">Bigrammi</td>
            <td align="center"><%out.println(Math.perc(p9.get("bigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p9.get("bigrammi").get("baseline1")));%></td>
            <td align="center"><%out.println(Math.perc(p9.get("bigrammi").get("indifferenti")));%></td>
        </tr>
        <tr>
            <td align="center">Uni-bigrammi</td>
            <td align="center"><%out.println(Math.perc(p9.get("unibigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p9.get("unibigrammi").get("baseline1")));%></td>
            <td align="center"><%out.println(Math.perc(p9.get("unibigrammi").get("indifferenti")));%></td>
        </tr>

    </table>

    <br><br>

    <%
        //3) preferenze tra centroide e frasi singole con configurazioni di lemmi
        //-->preferenze tra FRAMEWORK e BASELINE DISTRIBUZIONALE con CONFIGURAZIONI LEMMI;
        HashMap<String, HashMap<String, Double>> p10 = null;
        p10 = Preferenze.sistemaVSbaseline2PreferenzeLemmi();
    %>
    <table align="center" border="1">
        <tr>
            <td align="center" align="center" colspan="9" width="200"><h5>Sistema vs Baseline 2</h5></td>
        </tr>

        <tr>
            <td align="center"></td>
            <td align="center">Sistema</td>
            <td align="center">Baseline 2</td>
            <td align="center">Indifferente</td>
        </tr>

        <tr>
            <td align="center">Unigrammi</td>
            <td align="center"><%out.println(Math.perc(p10.get("unigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p10.get("unigrammi").get("baseline2")));%></td>
            <td align="center"><%out.println(Math.perc(p10.get("unigrammi").get("indifferenti")));%></td>
        </tr>
        <tr>
            <td align="center">Bigrammi</td>
            <td align="center"><%out.println(Math.perc(p10.get("bigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p10.get("bigrammi").get("baseline2")));%></td>
            <td align="center"><%out.println(Math.perc(p10.get("bigrammi").get("indifferenti")));%></td>
        </tr>
        <tr>
            <td align="center">Uni-bigrammi</td>
            <td align="center"><%out.println(Math.perc(p10.get("unibigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p10.get("unibigrammi").get("baseline2")));%></td>
            <td align="center"><%out.println(Math.perc(p10.get("unibigrammi").get("indifferenti")));%></td>
        </tr>

    </table>

    <br><br>

    <%
        //3) preferenze tra centroide e frasi singole con configurazioni di lemmi
        //-->preferenze tra FRAMEWORK e BASELINE DISTRIBUZIONALE con CONFIGURAZIONI LEMMI;
        HashMap<String, HashMap<String, Double>> p11 = null;
        p11 = Preferenze.normaleVSbaseline2PreferenzeLemmi();
    %>
    <table align="center" border="1">
        <tr>
            <td align="center" align="center" colspan="9" width="200"><h5>Normale vs Baseline 2</h5></td>
        </tr>

        <tr>
            <td align="center"></td>
            <td align="center">Normale</td>
            <td align="center">Baseline 2</td>
            <td align="center">Indifferente</td>
        </tr>

        <tr>
            <td align="center">Unigrammi</td>
            <td align="center"><%out.println(Math.perc(p11.get("unigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p11.get("unigrammi").get("baseline2")));%></td>
            <td align="center"><%out.println(Math.perc(p11.get("unigrammi").get("indifferenti")));%></td>
        </tr>
        <tr>
            <td align="center">Bigrammi</td>
            <td align="center"><%out.println(Math.perc(p11.get("bigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p11.get("bigrammi").get("baseline2")));%></td>
            <td align="center"><%out.println(Math.perc(p11.get("bigrammi").get("indifferenti")));%></td>
        </tr>
        <tr>
            <td align="center">Uni-bigrammi</td>
            <td align="center"><%out.println(Math.perc(p11.get("unibigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p11.get("unibigrammi").get("baseline2")));%></td>
            <td align="center"><%out.println(Math.perc(p11.get("unibigrammi").get("indifferenti")));%></td>
        </tr>

    </table>

    <br><br>

    <%
        //3) preferenze tra centroide e frasi singole con configurazioni di lemmi
        //-->preferenze tra FRAMEWORK e BASELINE DISTRIBUZIONALE con CONFIGURAZIONI LEMMI;
        HashMap<String, HashMap<String, Double>> p12 = null;
        p12 = Preferenze.pmiVSbaseline2PreferenzeLemmi();
    %>
    <table align="center" border="1">
        <tr>
            <td align="center" align="center" colspan="9" width="200"><h5>PMI vs Baseline 2</h5></td>
        </tr>

        <tr>
            <td align="center"></td>
            <td align="center">PMI</td>
            <td align="center">Baseline 2</td>
            <td align="center">Indifferente</td>
        </tr>

        <tr>
            <td align="center">Unigrammi</td>
            <td align="center"><%out.println(Math.perc(p12.get("unigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p12.get("unigrammi").get("baseline2")));%></td>
            <td align="center"><%out.println(Math.perc(p12.get("unigrammi").get("indifferenti")));%></td>
        </tr>
        <tr>
            <td align="center">Bigrammi</td>
            <td align="center"><%out.println(Math.perc(p12.get("bigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p12.get("bigrammi").get("baseline2")));%></td>
            <td align="center"><%out.println(Math.perc(p12.get("bigrammi").get("indifferenti")));%></td>
        </tr>
        <tr>
            <td align="center">Uni-bigrammi</td>
            <td align="center"><%out.println(Math.perc(p12.get("unibigrammi").get("sistema")));%></td>
            <td align="center"><%out.println(Math.perc(p12.get("unibigrammi").get("baseline2")));%></td>
            <td align="center"><%out.println(Math.perc(p12.get("unibigrammi").get("indifferenti")));%></td>
        </tr>

    </table>

    <br><br>

    <p align="center">--------------------------- <b>ESPERIMENTO 3 -----------------------------------</b></p>

    <%
        //////////////////////////CONFRONTI/////////////////
        HashMap<String, HashMap<String, HashMap<String, Double>>> c1 = null;
        c1 = Confronti.sistemaVSBaseline1MetricheLemmi();
    %>
    <table align="center" border="1">
        <tr>
            <td align="center" colspan="9" width="200"><h5>Sistema vs Baseline 1 </h5></td>
        </tr>

        <tr>
            <td align="center" width="120"></td>
            <td align="center" width="120" colspan="2">Unigrammi</td>
            <td align="center" width="120" colspan="2">Bigrammi</td>
            <td align="center" width="120" colspan="2">Uni-bigrammi</td>
        </tr>

        <tr>
            <td></td>
            <td align="center">Sistema</td>
            <td align="center">Baseline 1</td>
            <td align="center">Sistema</td>
            <td align="center">Baseline 1</td>
            <td align="center">Sistema</td>
            <td align="center">Baseline 1</td>
        </tr>

        <tr>
            <td align="center" width="120">Trasparenza</td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unigrammi").get("baseline1").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("bigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("bigrammi").get("baseline1").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unibigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unibigrammi").get("baseline1").get("Trasparenza")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Persuasione</td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unigrammi").get("baseline1").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("bigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("bigrammi").get("baseline1").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unibigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unibigrammi").get("baseline1").get("Persuasione")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Coinvolgimento</td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unigrammi").get("baseline1").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("bigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("bigrammi").get("baseline1").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unibigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unibigrammi").get("baseline1").get("Coinvolgimento")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Fiducia</td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unigrammi").get("baseline1").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("bigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("bigrammi").get("baseline1").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unibigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c1.get("unibigrammi").get("baseline1").get("Fiducia")));%></td>
        </tr>

    </table>

    <br><br>

    <%
        //////////////////////////CONFRONTI/////////////////
        HashMap<String, HashMap<String, HashMap<String, Double>>> c2 = null;
        c2 = Confronti.sistemaVSBaseline1MetricheNormaleLemmi();
    %>

    <table align="center" border="1">
        <tr>
            <td align="center" colspan="9" width="200"><h5>Normale vs Baseline 1 </h5></td>
        </tr>

        <tr>
            <td align="center" width="120"></td>
            <td align="center" width="120" colspan="2">Unigrammi</td>
            <td align="center" width="120" colspan="2">Bigrammi</td>
            <td align="center" width="120" colspan="2">Uni-bigrammi</td>
        </tr>

        <tr>
            <td></td>
            <td align="center">Normale</td>
            <td align="center">Baseline 1</td>
            <td align="center">Normale</td>
            <td align="center">Baseline 1</td>
            <td align="center">Normale</td>
            <td align="center">Baseline 1</td>
        </tr>

        <tr>
            <td align="center" width="120">Trasparenza</td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unigrammi").get("baseline1").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("bigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("bigrammi").get("baseline1").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unibigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unibigrammi").get("baseline1").get("Trasparenza")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Persuasione</td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unigrammi").get("baseline1").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("bigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("bigrammi").get("baseline1").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unibigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unibigrammi").get("baseline1").get("Persuasione")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Coinvolgimento</td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unigrammi").get("baseline1").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("bigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("bigrammi").get("baseline1").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unibigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unibigrammi").get("baseline1").get("Coinvolgimento")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Fiducia</td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unigrammi").get("baseline1").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("bigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("bigrammi").get("baseline1").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unibigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c2.get("unibigrammi").get("baseline1").get("Fiducia")));%></td>
        </tr>

    </table>

    <br><br>

    <%
        //////////////////////////CONFRONTI/////////////////
        HashMap<String, HashMap<String, HashMap<String, Double>>> c3 = null;
        c3 = Confronti.sistemaVSBaseline1MetrichePMILemmi();
    %>

    <table align="center" border="1">
        <tr>
            <td align="center" colspan="9" width="200"><h5>PMI vs Baseline 1 </h5></td>
        </tr>

        <tr>
            <td align="center" width="120"></td>
            <td align="center" width="120" colspan="2">Unigrammi</td>
            <td align="center" width="120" colspan="2">Bigrammi</td>
            <td align="center" width="120" colspan="2">Uni-bigrammi</td>
        </tr>

        <tr>
            <td></td>
            <td align="center">PMI</td>
            <td align="center">Baseline 1</td>
            <td align="center">PMI</td>
            <td align="center">Baseline 1</td>
            <td align="center">PMI</td>
            <td align="center">Baseline 1</td>
        </tr>

        <tr>
            <td align="center" width="120">Trasparenza</td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unigrammi").get("baseline1").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("bigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("bigrammi").get("baseline1").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unibigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unibigrammi").get("baseline1").get("Trasparenza")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Persuasione</td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unigrammi").get("baseline1").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("bigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("bigrammi").get("baseline1").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unibigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unibigrammi").get("baseline1").get("Persuasione")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Coinvolgimento</td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unigrammi").get("baseline1").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("bigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("bigrammi").get("baseline1").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unibigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unibigrammi").get("baseline1").get("Coinvolgimento")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Fiducia</td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unigrammi").get("baseline1").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("bigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("bigrammi").get("baseline1").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unibigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c3.get("unibigrammi").get("baseline1").get("Fiducia")));%></td>
        </tr>

    </table>

    <br><br>

    <%
        //////////////////////////CONFRONTI/////////////////
        HashMap<String, HashMap<String, HashMap<String, Double>>> c4 = null;
        c4 = Confronti.sistemaVSbaseline2MetricheLemmi();
    %>
    <table align="center" border="1">
        <tr>
            <td align="center" colspan="9" width="200"><h5>Sistema vs Baseline 2 </h5></td>
        </tr>

        <tr>
            <td align="center" width="120"></td>
            <td align="center" width="120" colspan="2">Unigrammi</td>
            <td align="center" width="120" colspan="2">Bigrammi</td>
            <td align="center" width="120" colspan="2">Uni-bigrammi</td>
        </tr>

        <tr>
            <td></td>
            <td align="center">Sistema</td>
            <td align="center">Baseline 2</td>
            <td align="center">Sistema</td>
            <td align="center">Baseline 2</td>
            <td align="center">Sistema</td>
            <td align="center">Baseline 2</td>
        </tr>

        <tr>
            <td align="center" width="120">Trasparenza</td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unigrammi").get("baseline2").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("bigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("bigrammi").get("baseline2").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unibigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unibigrammi").get("baseline2").get("Trasparenza")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Persuasione</td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unigrammi").get("baseline2").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("bigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("bigrammi").get("baseline2").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unibigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unibigrammi").get("baseline2").get("Persuasione")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Coinvolgimento</td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unigrammi").get("baseline2").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("bigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("bigrammi").get("baseline2").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unibigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unibigrammi").get("baseline2").get("Coinvolgimento")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Fiducia</td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unigrammi").get("baseline2").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("bigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("bigrammi").get("baseline2").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unibigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c4.get("unibigrammi").get("baseline2").get("Fiducia")));%></td>
        </tr>

    </table>

    <br><br>

    <%
        //////////////////////////CONFRONTI/////////////////
        HashMap<String, HashMap<String, HashMap<String, Double>>> c5 = null;
        c5 = Confronti.sistemaVSbaseline2MetricheNormaleLemmi();
    %>

    <table align="center" border="1">
        <tr>
            <td align="center" colspan="9" width="200"><h5>Normale vs Baseline 2 </h5></td>
        </tr>

        <tr>
            <td align="center" width="120"></td>
            <td align="center" width="120" colspan="2">Unigrammi</td>
            <td align="center" width="120" colspan="2">Bigrammi</td>
            <td align="center" width="120" colspan="2">Uni-bigrammi</td>
        </tr>

        <tr>
            <td></td>
            <td align="center">Normale</td>
            <td align="center">Baseline 2</td>
            <td align="center">Normale</td>
            <td align="center">Baseline 2</td>
            <td align="center">Normale</td>
            <td align="center">Baseline 2</td>
        </tr>

        <tr>
            <td align="center" width="120">Trasparenza</td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unigrammi").get("baseline2").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("bigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("bigrammi").get("baseline2").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unibigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unibigrammi").get("baseline2").get("Trasparenza")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Persuasione</td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unigrammi").get("baseline2").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("bigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("bigrammi").get("baseline2").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unibigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unibigrammi").get("baseline2").get("Persuasione")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Coinvolgimento</td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unigrammi").get("baseline2").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("bigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("bigrammi").get("baseline2").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unibigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unibigrammi").get("baseline2").get("Coinvolgimento")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Fiducia</td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unigrammi").get("baseline2").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("bigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("bigrammi").get("baseline2").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unibigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c5.get("unibigrammi").get("baseline2").get("Fiducia")));%></td>
        </tr>

    </table>

    <br><br>

    <%
        //////////////////////////CONFRONTI/////////////////
        HashMap<String, HashMap<String, HashMap<String, Double>>> c6 = null;
        c6 = Confronti.sistemaVSbaseline2MetrichePMILemmi();
    %>

    <table align="center" border="1">
        <tr>
            <td align="center" colspan="9" width="200"><h5>PMI vs Baseline 2 </h5></td>
        </tr>

        <tr>
            <td align="center" width="120"></td>
            <td align="center" width="120" colspan="2">Unigrammi</td>
            <td align="center" width="120" colspan="2">Bigrammi</td>
            <td align="center" width="120" colspan="2">Uni-bigrammi</td>
        </tr>

        <tr>
            <td></td>
            <td align="center">PMI</td>
            <td align="center">Baseline 2</td>
            <td align="center">PMI</td>
            <td align="center">Baseline 2</td>
            <td align="center">PMI</td>
            <td align="center">Baseline 2</td>
        </tr>

        <tr>
            <td align="center" width="120">Trasparenza</td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unigrammi").get("baseline2").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("bigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("bigrammi").get("baseline2").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unibigrammi").get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unibigrammi").get("baseline2").get("Trasparenza")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Persuasione</td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unigrammi").get("baseline2").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("bigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("bigrammi").get("baseline2").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unibigrammi").get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unibigrammi").get("baseline2").get("Persuasione")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Coinvolgimento</td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unigrammi").get("baseline2").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("bigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("bigrammi").get("baseline2").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unibigrammi").get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unibigrammi").get("baseline2").get("Coinvolgimento")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Fiducia</td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unigrammi").get("baseline2").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("bigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("bigrammi").get("baseline2").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unibigrammi").get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(c6.get("unibigrammi").get("baseline2").get("Fiducia")));%></td>
        </tr>

    </table>

    <br><br>

    <%
        //////////////////////////CONFRONTI/////////////////

        HashMap<String, HashMap<String, Double>> p13 = Confronti.sistemaVSBaseline1Metriche();
    %>

    <table align="center" border="1">

        <tr>
            <td align="center" colspan="4" width="200"><h5>Sistema vs Baseline 1 - Metriche</h5></td>
        </tr>

        <tr>
            <td align="center" width="120"></td>
            <td align="center" width="120" colspan="1">CA + DSMs</td>
            <td align="center" width="120" colspan="1">Baseline 1</td>
            <td align="center" width="120" colspan="1">Indifferente</td>
        </tr>

        <tr>
            <td align="center" width="120">Trasparenza</td>
            <td align="center" width="120"><%out.println(Math.perc(p13.get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p13.get("baseline1").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p13.get("indifferenti").get("Trasparenza")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Persuasione</td>
            <td align="center" width="120"><%out.println(Math.perc(p13.get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p13.get("baseline1").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p13.get("indifferenti").get("Persuasione")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Coinvolgimento</td>
            <td align="center" width="120"><%out.println(Math.perc(p13.get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p13.get("baseline1").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p13.get("indifferenti").get("Coinvolgimento")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Fiducia</td>
            <td align="center" width="120"><%out.println(Math.perc(p13.get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p13.get("baseline1").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p13.get("indifferenti").get("Fiducia")));%></td>
        </tr>

    </table>

    <br><br>

    <%
        //////////////////////////CONFRONTI/////////////////

        HashMap<String, HashMap<String, Double>> p14 = Confronti.sistemaVSBaseline2Metriche();
    %>

    <table align="center" border="1">
        <tr>
            <td align="center" colspan="4" width="200"><h5>Sistema vs Baseline 2 - Metriche</h5></td>
        </tr>

        <tr>
            <td align="center" width="120"></td>
            <td align="center" width="120" colspan="1">CA + DSMs</td>
            <td align="center" width="120" colspan="1">Baseline 2</td>
            <td align="center" width="120" colspan="1">Indifferente</td>
        </tr>

        <tr>
            <td align="center" width="120">Trasparenza</td>
            <td align="center" width="120"><%out.println(Math.perc(p14.get("sistema").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p14.get("baseline2").get("Trasparenza")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p14.get("indifferenti").get("Trasparenza")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Persuasione</td>
            <td align="center" width="120"><%out.println(Math.perc(p14.get("sistema").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p14.get("baseline2").get("Persuasione")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p14.get("indifferenti").get("Persuasione")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Coinvolgimento</td>
            <td align="center" width="120"><%out.println(Math.perc(p14.get("sistema").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p14.get("baseline2").get("Coinvolgimento")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p14.get("indifferenti").get("Coinvolgimento")));%></td>
        </tr>

        <tr>
            <td align="center" width="120">Fiducia</td>
            <td align="center" width="120"><%out.println(Math.perc(p14.get("sistema").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p14.get("baseline2").get("Fiducia")));%></td>
            <td align="center" width="120"><%out.println(Math.perc(p14.get("indifferenti").get("Fiducia")));%></td>
        </tr>

    </table>


    <br><br>

    <br><br>

    <br><br>

    <br><br>


</div>

</body>

</html>