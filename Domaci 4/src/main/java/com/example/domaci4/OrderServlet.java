package com.example.domaci4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "order", value = "/order")
public class OrderServlet extends HttpServlet {

    private String html;
    private ArrayList<String> ponedeljak = new ArrayList<>();
    private ArrayList<String> utorak = new ArrayList<>();
    private ArrayList<String> sreda = new ArrayList<>();
    private ArrayList<String> cetvrtak = new ArrayList<>();
    private ArrayList<String> petak = new ArrayList<>();
    public void init() {
        getPonedeljak();
        getUtorak();
        getSreda();
        getCetvrtak();
        getPetak();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String cookie = request.getSession().getId().toString();
        PrintWriter out = response.getWriter();
        out.println(renderPage());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        resp.sendRedirect("/order");
    }

    public void destroy() {
    }

    public void getPonedeljak(){
        File file = new File("G:\\RAF\\Web Programiranje\\Domaci 4\\src\\main\\resources\\ponedeljak.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                ponedeljak.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getUtorak(){
        File file = new File("G:\\RAF\\Web Programiranje\\Domaci 4\\src\\main\\resources\\utorak.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                utorak.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getSreda(){
        File file = new File("G:\\RAF\\Web Programiranje\\Domaci 4\\src\\main\\resources\\sreda.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                sreda.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getCetvrtak(){
        File file = new File("G:\\RAF\\Web Programiranje\\Domaci 4\\src\\main\\resources\\cetvrtak.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                cetvrtak.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getPetak(){
        File file = new File("G:\\RAF\\Web Programiranje\\Domaci 4\\src\\main\\resources\\petak.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                petak.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String renderPage(){
        html = "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Order</title>\n" +
                "</head>\n" +
                "<style>\n" +
                "    input[type=text], select {\n" +
                "      width: 100%;\n" +
                "      padding: 12px 20px;\n" +
                "      margin: 8px 0;\n" +
                "      display: inline-block;\n" +
                "      border: 1px solid #ccc;\n" +
                "      border-radius: 4px;\n" +
                "      box-sizing: border-box;\n" +
                "    }\n" +
                "    \n" +
                "    input[type=submit] {\n" +
                "      width: 100%;\n" +
                "      background-color: rgb(19, 141, 255);\n" +
                "      color: white;\n" +
                "      padding: 14px 20px;\n" +
                "      margin: 8px 0;\n" +
                "      border: none;\n" +
                "      border-radius: 4px;\n" +
                "      cursor: pointer;\n" +
                "    }\n" +
                "    \n" +
                "    input[type=submit]:hover {\n" +
                "      background-color: rgb(44, 153, 255);\n" +
                "    }\n" +
                "    \n" +
                "    div {\n" +
                "      border-radius: 5px;\n" +
                "      background-color: #f2f2f2;\n" +
                "      padding: 20px;\n" +
                "    }\n" +
                "    label{\n" +
                "        text-align: left;\n" +
                "    }\n" +
                "    h1{\n" +
                "      text-align: center;\n" +
                "      font-weight: bold;\n" +
                "    }\n" +
                "    h2{\n" +
                "      text-align: center;\n" +
                "    }\n" +
                "    </style>\n" +
                "<body style=\"margin: auto; width: 20%; padding: 10px;\">\n" +
                "    <h1>Choose Your Food!</h1>\n" +
                "    <h2>Odaberite vas rucak:</h2>\n" +
                "  <form method=\"POST\" action=\"/order\">\n" +
                "    <label>Ponedeljak</label>\n" +
                "    <br>\n" +
                "    <select  name=\"ponedeljak\">\n" +
                "      <option value=\""+ ponedeljak.get(0) +"\">" + ponedeljak.get(0) + "</option>\n" +
                "      <option value=\"" + ponedeljak.get(1) + "\">" + ponedeljak.get(1) +"</option>\n" +
                "      <option value=\"" + ponedeljak.get(2) +"\">" + ponedeljak.get(2) + "</option>\n" +
                "    </select>\n" +
                "    <label>Utorak</label>\n" +
                "    <br>\n" +
                "    <select  name=\"utorak\">\n" +
                "      <option value=\""+ utorak.get(0) +"\">" + utorak.get(0) + "</option>\n" +
                "      <option value=\"" + utorak.get(1) + "\">" + utorak.get(1) +"</option>\n" +
                "      <option value=\"" + utorak.get(2) +"\">" + utorak.get(2) + "</option>\n" +
                "    </select>\n" +
                "    <label>Sreda</label>\n" +
                "    <br>\n" +
                "    <select  name=\"sreda\">\n" +
                "      <option value=\""+ sreda.get(0) +"\">" + sreda.get(0) + "</option>\n" +
                "      <option value=\"" + sreda.get(1) + "\">" + sreda.get(1) +"</option>\n" +
                "      <option value=\"" + sreda.get(2) +"\">" + sreda.get(2) + "</option>\n" +
                "    </select>\n" +
                "    <label>Cetvrtak</label>\n" +
                "    <br>\n" +
                "    <select  name=\"cetvrtak\">\n" +
                "      <option value=\""+ cetvrtak.get(0) +"\">" + cetvrtak.get(0) + "</option>\n" +
                "      <option value=\"" + cetvrtak.get(1) + "\">" + cetvrtak.get(1) +"</option>\n" +
                "      <option value=\"" + cetvrtak.get(2) +"\">" + cetvrtak.get(2) + "</option>\n" +
                "    </select>\n" +
                "    <label>Petak</label>\n" +
                "    <br>\n" +
                "    <select  name=\"petak\">\n" +
                "      <option value=\""+ petak.get(0) +"\">" + petak.get(0) + "</option>\n" +
                "      <option value=\"" + petak.get(1) + "\">" + petak.get(1) +"</option>\n" +
                "      <option value=\"" + petak.get(2) +"\">" + petak.get(2) + "</option>\n" +
                "    </select>\n" +
                "    <input type=\"submit\">\n" +
                "  </form>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>";
        return html;
    }
}